package com.example.demo.reponsetory;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductReponsetory extends JpaRepository<Product,Integer> {
}
