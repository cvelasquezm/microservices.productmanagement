package com.training.productmanagement.port.service;

import com.training.productmanagement.adapter.repository.ProductManagementRepository;
import com.training.productmanagement.domain.Product;
import org.hibernate.service.spi.InjectService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories( basePackageClasses = ProductManagementRepository.class )
public class ProductManagementServiceTest {

    @SpyBean
    ProductManagementService productManagementService;

    @MockBean
    ProductManagementRepository productManagementRepository;

    @Mock
    Product product;

    @Test
    public void addProductTest(){
        Mockito.doNothing().when(productManagementService).addProduct(product);

        productManagementService.addProduct(product);

        Mockito.verify(productManagementService, times(1)).addProduct(product);
    }

    @Test
    public void getAllProductTest(){
        List<Product> products = new ArrayList<>();
        products.add(product);
        Mockito.doReturn(products).when(productManagementService).getAllProducts();

        List<Product> listProduct = (List<Product>) productManagementService.getAllProducts();

        Mockito.verify(productManagementService, times(1)).getAllProducts();
        Assert.assertTrue(listProduct == products);
    }

    @Test
    public void updateProductTest(){
        Mockito.doNothing().when(productManagementService).updateProduct(product);

        productManagementService.updateProduct(product);

        Mockito.verify(productManagementService, times(1)).updateProduct(product);
    }

    @Test
    public void deleteProductTest(){
        String idProduct = "idProduct";
        Mockito.doNothing().when(productManagementService).deleteProduct(idProduct);

        productManagementService.deleteProduct(idProduct);

        Mockito.verify(productManagementService, times(1)).deleteProduct(idProduct);
    }

    @Test
    public void searchProductsAvailableForSale(){
        List<Product> products = productsBuilder();
        Mockito.doReturn(products).when(productManagementRepository).findAll();

        List<Product> expectedProducts = productManagementService.searchProductsAvailableForSale();

        Mockito.verify(productManagementRepository, times(1)).findAll();
        Mockito.verify(productManagementService, times(1)).searchProductsAvailableForSale();
        Assert.assertTrue(expectedProducts.size() == 1);
    }

    public List<Product> productsBuilder(){
        Product product1 = new Product("p1", "name1");
        Product product2 = new Product("p2", "name2");
        Product product3 = new Product("p3", "name3");
        List<Product> products = new ArrayList<>();

        product1.setVisibleForSale(true);
        product1.setLogicErased(false);

        product2.setVisibleForSale(false);
        product2.setLogicErased(true);

        product3.setVisibleForSale(false);
        product3.setLogicErased(false);

        products.add(product1);
        products.add(product2);
        products.add(product3);

        return products;
    }

}
