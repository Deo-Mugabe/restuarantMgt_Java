package com.restuarantMgt.controller;

import com.restuarantMgt.domain.dto.response.FoodResponse;
import com.restuarantMgt.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/foods")
public class FoodController {


    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


    @GetMapping
    public ResponseEntity<List<FoodResponse>> getAllFoods(){
        List<FoodResponse> responses = foodService.getAllFoods();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{food_id}")
    public ResponseEntity<FoodResponse> getFoodById(@PathVariable("food_id") Long id){
        FoodResponse response = foodService.getFoodById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
