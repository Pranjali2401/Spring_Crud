package com.spring_crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_crud.demo.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}
