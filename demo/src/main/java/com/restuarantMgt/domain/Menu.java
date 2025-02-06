package com.restuarantMgt.domain;
//
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data  // Lombok generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor  // Generates a default constructor
@AllArgsConstructor // Generates a constructor with all fields
@Table(name="menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Name of the menu; required, max 100 characters
    @Column(length = 100, nullable = false)
    private String name;

    // Category of the menu; required, max 50 characters
    @Column(length = 50, nullable = false)
    private String category;

    // Start date of the menu (only date portion)
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    // End date of the menu (only date portion)
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    // Automatically set when the record is created
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;


    // Automatically updated when the record is modified
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

//    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Food> foods;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
//
}
