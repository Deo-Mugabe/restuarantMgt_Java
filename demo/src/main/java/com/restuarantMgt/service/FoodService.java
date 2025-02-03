package com.restuarantMgt.service;

import com.restuarantMgt.domain.dto.response.FoodResponse;

import java.util.List;

public interface FoodService {
    List<FoodResponse> getAllFoods();

    FoodResponse getFoodById(Long id);
}
