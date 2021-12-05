package com.example.demo.request;

public class UpdateProductDetailRequest {
    Integer id;
    Integer quantity;
    String color;
    String size;

    public UpdateProductDetailRequest() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }
}
