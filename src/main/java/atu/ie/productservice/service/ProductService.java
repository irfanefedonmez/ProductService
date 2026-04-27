package atu.ie.productservice.service;

import atu.ie.productservice.exception.ProductNotFoundException;
import atu.ie.productservice.model.Product;
import atu.ie.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category);
    }

    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrandIgnoreCase(brand);
    }

    public List<Product> getInStockProducts() {
        return productRepository.findByStockQuantityGreaterThan(0);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);

        existing.setName(updatedProduct.getName());
        existing.setCategory(updatedProduct.getCategory());
        existing.setBrand(updatedProduct.getBrand());
        existing.setCompatibleCarModel(updatedProduct.getCompatibleCarModel());
        existing.setPrice(updatedProduct.getPrice());
        existing.setStockQuantity(updatedProduct.getStockQuantity());
        existing.setDescription(updatedProduct.getDescription());

        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}