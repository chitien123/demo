package com.example.demo.respone;

public class ProductDetailResponse {
    Integer id;
    Integer quantity;
    String color;
    String size;
    Integer product_id;

    public ProductDetailResponse() {
    }

    public ProductDetailResponse(Integer id, Integer quantity, String color, String size, Integer product_id) {
        this.id = id;
        this.quantity = quantity;
        this.color = color;
        this.size = size;
        this.product_id = product_id;
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

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}
