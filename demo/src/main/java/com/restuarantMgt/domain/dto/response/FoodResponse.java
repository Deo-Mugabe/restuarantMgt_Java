package com.restuarantMgt.domain.dto.response;

import com.restuarantMgt.domain.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponse {

    // Unique auto-generated identifier of the Food
    private Long id;

    // Name of the food item
    private String name;

    // Price of the food item
    private BigDecimal price;

    // URL to the food image (optional)
    private String foodImage;

    // The ID of the associated Menu (foreign key reference)
    private Long menuId;

    // Timestamp when the Food record was created
    private LocalDateTime createdAt;

    // Timestamp when the Food record was last updated
    private LocalDateTime updatedAt;

public static FoodResponse from(Food food){
    FoodResponse response = new FoodResponse();
    response.name = food.getName();
    response.price = food.getPrice();
    response.foodImage = food.getFoodImage();
    response.menuId = food.getMenu().getId();
    response.createdAt = food.getCreatedAt();
    response.updatedAt = food.getUpdatedAt();


    return response;
    }
}
