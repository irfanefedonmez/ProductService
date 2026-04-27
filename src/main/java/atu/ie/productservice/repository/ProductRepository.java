package atu.ie.productservice.repository;

import atu.ie.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryIgnoreCase(String category);

    List<Product> findByBrandIgnoreCase(String brand);

    List<Product> findByStockQuantityGreaterThan(int stockQuantity);
}