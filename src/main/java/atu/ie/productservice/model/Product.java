package atu.ie.productservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Compatible car model is required")
    private String compatibleCarModel;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    @Min(value = 0, message = "Stock quantity cannot be negative")
    private int stockQuantity;

    @NotBlank(message = "Description is required")
    private String description;

    public Product() {
    }

    public Product(Long id, String name, String category, String brand,
                   String compatibleCarModel, double price, int stockQuantity, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.compatibleCarModel = compatibleCarModel;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
    }

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCompatibleCarModel() {
        return compatibleCarModel;
    }

    public void setCompatibleCarModel(String compatibleCarModel) {
        this.compatibleCarModel = compatibleCarModel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}