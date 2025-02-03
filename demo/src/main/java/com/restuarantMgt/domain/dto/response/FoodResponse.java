package com.restuarantMgt.domain.dto.response;

import com.restuarantMgt.domain.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Double price;

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
        response.setId(food.getId());
        response.setName(food.getName());
        response.setPrice(food.getPrice());
        response.setFoodImage(food.getFoodImage());


//        // Set the menuId if the Food has an associated Menu
//        if (food.getMenu() != null) {
//            response.setMenuId(food.getMenu().getId());
//        }

        response.setCreatedAt(food.getCreatedAt());
        response.setUpdatedAt(food.getUpdatedAt());


        return response;
    }
}
