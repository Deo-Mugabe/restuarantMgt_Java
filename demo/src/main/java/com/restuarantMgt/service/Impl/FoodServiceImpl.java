package com.restuarantMgt.service.Impl;

import com.restuarantMgt.domain.Food;
import com.restuarantMgt.domain.dto.response.FoodResponse;
import com.restuarantMgt.exception.NotFoundException;
import com.restuarantMgt.repository.FoodRepository;
import com.restuarantMgt.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@RequiredArgsConstructor
@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
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
}
