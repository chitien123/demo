package com.example.demo.respone;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ProductResponse {
    Integer id;
    String name;
    String image;
    LocalDate createDate;
    Integer quantity;
    List<String> color;
    List<String> size;

    public ProductResponse() {
    }

    public ProductResponse(Integer id, String name, String image, LocalDate createDate, Integer quantity, List<String> color, List<String> size) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.createDate = createDate;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }
}
