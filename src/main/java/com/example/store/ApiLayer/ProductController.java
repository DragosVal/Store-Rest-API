package com.example.store.ApiLayer;

import com.example.store.BusinessLayer.AddressService;
import com.example.store.BusinessLayer.ProductService;
import com.example.store.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/AllProducts")
    public List<Product> getAllProducts(){
       return this.productService.getAllProducts();
    }

    @GetMapping("/GetSpecificProduct/{id}")
    public Product getSpecificProduct(@PathVariable Long id){
        return this.productService.getSpecificProduct(id);
    }
}
