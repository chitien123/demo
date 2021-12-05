package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String image;
    LocalDate createDate;

    public Product() {
    }

    public Product( String name, String image, LocalDate createDate) {
        this.name = name;
        this.image = image;
        this.createDate = createDate;
    }

    public Product(Integer id, String name, String image, LocalDate createDate, List<ProductDetail> productDetails) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.createDate = createDate;
        this.productDetails = productDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public List<ProductDetail> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetail> productDetails) {
        this.productDetails = productDetails;
    }

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    List<ProductDetail> productDetails;

}
