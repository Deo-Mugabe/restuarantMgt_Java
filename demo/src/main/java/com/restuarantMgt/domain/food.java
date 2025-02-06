package com.restuarantMgt.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "foods")
public class Food {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false)
  private String name;

  @Column(precision = 10, scale = 2, nullable = false)
  private BigDecimal price;

  @Column(name = "food_image", length = 255)
  private String foodImage;

////  @Column(name = "food_id", length = 50, nullable = false, unique = true)
////  private String foodId;
//
//  // Many-to-One relationship: multiple Foods belong to one Menu
////  @ManyToOne(optional = false)
////  @JoinColumn(name = "menu_id", nullable = false)
////  private Menu menu;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  // Getters and Setters
  public String getName() {
      return name;
  }

    public BigDecimal  getPrice() {
        return price;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

//  public String getFoodId() {
//    return foodId;
//  }
//
//  public void setFoodId(String foodId) {
//    this.foodId = foodId;
//  }
//
//  public Menu getMenu() {
//    return menu;
//  }
//
//  public void setMenu(Menu menu) {
//    this.menu = menu;
//  }
}