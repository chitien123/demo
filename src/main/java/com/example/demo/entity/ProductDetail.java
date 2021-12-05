package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "productDetail")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer quantity;
    String color;
    String size;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
     Product product;

    public ProductDetail() {
    }

//    public ProductDetail(Integer id, Integer quantity, String color, String size, Product product) {
//        this.id = id;
//        this.quantity = quantity;
//        this.color = color;
//        this.size = size;
//        this.product = product;
//    }

    public ProductDetail(Integer id, Integer quantity, String color, String size) {
        this.id = id;
        this.quantity = quantity;
        this.color = color;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
