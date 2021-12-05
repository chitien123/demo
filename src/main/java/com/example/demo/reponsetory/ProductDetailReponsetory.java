package com.example.demo.reponsetory;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import com.example.demo.respone.ProductDetailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailReponsetory extends JpaRepository<ProductDetail,Integer> {
    @Query(value = "select distinct p.color from ProductDetail p where p.product = ?1")
    List<String> getColorByProductId(Product productId);

    @Query(value = "select distinct p.size from ProductDetail p where p.product = ?1")
    List<String> getSizeByProductId(Product productId);

    @Query(value = "select distinct quantity from  ProductDetail where product=?1")
    Integer getQuantity(Product productId);

    ProductDetail findBySizeAndColor(String size,String color);

    @Query(value = "select * from demo2.product_detail where product_id =?1",nativeQuery = true)
    List<Object> getAllDetailByProduct(Integer productId);


}
