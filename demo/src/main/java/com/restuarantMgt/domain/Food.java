package com.restuarantMgt.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foods")
@Entity
@Setter
@Getter
public class Food {

    // Auto-increment primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the food; required, max 100 characters
    @Column(length = 100, nullable = false)
    private String name;

    // Price with precision and scale (10,2)
    @Column(precision = 10, scale = 2, nullable = false)
    private Double price;

    // Optional URL to the food image; max 255 characters
    @Column(name = "food_image", length = 255)
    private String foodImage;

    // Many-to-One relationship: many Foods belong to one Menu.
    // This maps the 'menu_id' column in the 'foods' table.
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "menu_id", nullable = false)
//    private Menu menu;


    // Automatically set when the record is created
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Automatically updated when the record is modified
    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
