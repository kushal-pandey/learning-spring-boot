package com.learning.springboot.service;

import com.learning.springboot.Repository.ProductRepository;
import com.learning.springboot.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);

    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
        product.setName(productDetails.getName());
        product.setDescription(product.getDescription());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);

    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not Found"));
        productRepository.delete(product);
    }


}
