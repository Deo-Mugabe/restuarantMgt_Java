package com.restuarantMgt.service.Impl;

import com.restuarantMgt.domain.Food;
import com.restuarantMgt.domain.Menu;
import com.restuarantMgt.domain.dto.request.FoodRequest;
import com.restuarantMgt.domain.dto.response.FoodResponse;
import com.restuarantMgt.exception.NotFoundException;
import com.restuarantMgt.repository.FoodRepository;
import com.restuarantMgt.repository.MenuRepository;
import com.restuarantMgt.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final MenuRepository menuRepository;

    public FoodServiceImpl(FoodRepository foodRepository, MenuRepository menuRepository) {
        this.foodRepository = foodRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<FoodResponse> getAllFoods() {
        return foodRepository.findAll().
                stream()
                .map(FoodResponse::from)
                .toList();
    }

    @Override
    public FoodResponse getFoodById(Long id) {
        Food food =  foodRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Food not Found"));

            return FoodResponse.from(food) ;

    }

    @Override
    public void createFood(FoodRequest request) {
        saveFood(request);
    }

    private void saveFood(FoodRequest request) {
        // Find the Menu entity by menuId
        Menu menu = menuRepository.findById(request.getMenuId())
                .orElseThrow(() -> new NotFoundException("Menu not found with id: " + request.getMenuId()));

        // Create a new Food entity
        Food food = new Food();
        food.setFoodImage(request.getFoodImage());
        food.setName(request.getName());
        food.setPrice(request.getPrice());
        food.setMenu(menu);  // Associate the food item with the menu

        // Save the food entity
        foodRepository.save(food);
    }

}
