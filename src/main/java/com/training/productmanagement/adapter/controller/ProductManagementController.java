package com.training.productmanagement.adapter.controller;

import com.training.productmanagement.domain.Product;
import com.training.productmanagement.port.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api-pm")
public class ProductManagementController {

    @Autowired
    ProductManagementService productManagementService;

    @PostMapping(value = "/add")
    public void addProduct(@RequestBody Product product){
        productManagementService.addProduct(product);
    }

    @GetMapping(value = "/getAll")
    public Iterable<Product> getAllProducts(){
        return productManagementService.getAllProducts();
    }

    @PutMapping(value = "/update")
    public void updateProduct(@RequestBody Product product){
        productManagementService.updateProduct(product);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam String idProduct){
        productManagementService.deleteProduct(idProduct);
    }

    @GetMapping(value = "/getProductsAvailable")
    public List<Product> searchProductsAvailableForSale(){
        return productManagementService.searchProductsAvailableForSale();
    }
}
