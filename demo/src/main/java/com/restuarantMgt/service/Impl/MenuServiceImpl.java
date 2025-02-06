package com.restuarantMgt.service.Impl;

import com.restuarantMgt.domain.Food;
import com.restuarantMgt.domain.Menu;
import com.restuarantMgt.domain.dto.request.MenuRequest;
import com.restuarantMgt.domain.dto.response.MenuResponse;
import com.restuarantMgt.exception.NotFoundException;
import com.restuarantMgt.repository.FoodRepository;
import com.restuarantMgt.repository.MenuRepository;
import com.restuarantMgt.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final FoodRepository foodRepository;

    public MenuServiceImpl(MenuRepository menuRepository, FoodRepository foodRepository) {
        this.menuRepository = menuRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public List<MenuResponse> getAllMenus() {
        return menuRepository.findAll()
                .stream()
                .map(MenuResponse::from)
                .toList();
    }

    @Override
    public MenuResponse getMenuById(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Menu not Found"));
        return MenuResponse.from(menu);
    }

    @Override
    public void createMenu(MenuRequest request) {
        saveMenu(request);
    }

    private void saveMenu(MenuRequest request) {
        // Create a new Menu entity
        Menu menu = new Menu();
        menu.setName(request.getName());
        menu.setCategory(request.getCategory());
        menu.setStartDate(request.getStartDate());
        menu.setEndDate(request.getEndDate());

        // Save the menu entity
        menuRepository.save(menu);

        // Optionally, associate food items if foodIds are passed in the request
        if (request.getFoodIds() != null) {
            for (Long foodId : request.getFoodIds()) {
                Food food = foodRepository.findById(foodId)
                        .orElseThrow(() -> new NotFoundException("Food not found with id: " + foodId));
                food.setMenu(menu);  // Associate the food item with this menu
                foodRepository.save(food);  // Update the food entity to associate it with the new menu
            }
        }
    }

}
