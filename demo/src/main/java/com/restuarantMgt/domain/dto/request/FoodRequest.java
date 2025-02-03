package com.restuarantMgt.domain.dto.request;

import com.restuarantMgt.domain.Food;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FoodRequest {

    // The name of the food; must be provided and not blank.
    @NotBlank(message = "Food name is required")
    private String name;

    // The price of the food; must be provided.
    @NotNull(message = "Price is required")
    private Double price;

    // Optional URL to the food image.
    private String foodImage;


//    // The associated menu's identifier; using Long to reference the Menu entity.
//    @NotNull(message = "Menu ID is required")
//    private Long menuId;

}
