package com.restuarantMgt.domain.dto.response;

import com.restuarantMgt.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse {
    // Unique auto-generated identifier of the Menu
    private Long id;

    // Name of the menu
    private String name;

    // Category of the menu (e.g., Breakfast, Lunch, Dinner)
    private String category;

    // Date when the menu becomes active
    private LocalDate startDate;

    // Date when the menu is no longer active
    private LocalDate endDate;

    // Timestamp when the Menu record was created
    private LocalDateTime createdAt;

    // Timestamp when the Menu record was last updated
    private LocalDateTime updatedAt;

    // List of Food items associated with this Menu, using FoodResponse to keep the response structure clear
 //   private List<FoodResponse> foods;

    public static MenuResponse from(Menu menu) {
        MenuResponse response = new MenuResponse();

        response.name = menu.getName();
        response.category = menu.getCategory();
        response.startDate = menu.getStartDate();
        response.endDate = menu.getEndDate();
        response.createdAt = menu.getCreatedAt();
        response.updatedAt = menu.getUpdatedAt();
//        response.setId(menu.getId());
//        response.setName(menu.getName());
//        response.setCategory(menu.getCategory());
//        response.setStartDate(menu.getStartDate());
//        response.setEndDate(menu.getEndDate());
//        response.setCreatedAt(menu.getCreatedAt());
//        response.setUpdatedAt(menu.getUpdatedAt());

//         Convert the list of Food entities to a list of FoodResponse DTOs
//        if (menu.getFoods() != null && !menu.getFoods().isEmpty()) {
//            List<FoodResponse> foodResponses = menu.getFoods().stream()
//                    .map(FoodResponse::from)
//                    .collect(Collectors.toList());
//            response.setFoods(foodResponses);
//        }

        return response;
    }
}
