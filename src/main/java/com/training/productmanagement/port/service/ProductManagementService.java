package com.training.productmanagement.port.service;

import com.training.productmanagement.adapter.repository.ProductManagementRepository;
import com.training.productmanagement.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class ProductManagementService {

    private ProductManagementService(){}

    @Autowired
    ProductManagementRepository productManagementRepository;

    public void addProduct(Product product){
        productManagementRepository.save(product);
    }

    public Iterable<Product> getAllProducts(){
        return productManagementRepository.findAll();
    }

    public void updateProduct(Product product){
        productManagementRepository.save(product);
    }

    public void deleteProduct(String idProduct){
        productManagementRepository.deleteById(idProduct);
    }

    public List<Product> searchProductsAvailableForSale(){
        List<Product> products = getProductInstance();
        productManagementRepository.findAll().forEach(products::add);
        return products.stream().filter(p -> !p.isLogicErased() && p.isVisibleForSale()).collect(Collectors.toList());
    }

    protected List<Product> getProductInstance(){
        return new ArrayList<Product>();
    }

}
