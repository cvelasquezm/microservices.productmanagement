package com.training.productmanagement.adapter.repository;

import com.training.productmanagement.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductManagementRepository extends CrudRepository<Product, String> {

}
