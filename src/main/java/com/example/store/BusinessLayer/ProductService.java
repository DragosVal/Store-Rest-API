package com.example.store.BusinessLayer;

import com.example.store.Entity.Product;
import com.example.store.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getSpecificProduct(Long id) {
        if(!productRepository.existsById(id))
            throw new IllegalStateException("Cant find product!");
        return productRepository.findById(id).get();
    }

}
