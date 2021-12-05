package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import com.example.demo.reponsetory.ProductDetailReponsetory;
import com.example.demo.reponsetory.ProductReponsetory;
import com.example.demo.request.ProductDetailRequet;
import com.example.demo.request.UpdateProductDetailRequest;
import com.example.demo.respone.ProductDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/productDetail")
public class ProductDetailController {

    @Autowired
    ProductDetailReponsetory productDetailRepo;

    @Autowired
    ProductReponsetory productRepo;

    @GetMapping
    public ResponseEntity<List<ProductDetail>> findAll(){
        List<ProductDetail> productDetailList = productDetailRepo.findAll();
        return new ResponseEntity<>(productDetailList, HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<List<Object>> findAllDetailByProductId(@PathVariable("id") Integer id){
        Product product = productRepo.getById(id);
        List<Object> productDetail = productDetailRepo.getAllDetailByProduct(product.getId());
        return new ResponseEntity<>(productDetail,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetail> findById(@PathVariable("id") Integer id){
        ProductDetail productDetail = productDetailRepo.getById(id);
        return new ResponseEntity<>(new ProductDetail(productDetail.getId(),
                    productDetail.getQuantity(),productDetail.getColor(),
                productDetail.getSize()),HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> addDetail(@RequestBody ProductDetailRequet productDetailRequet){

        ProductDetail getProductDetail= productDetailRepo.findBySizeAndColor(productDetailRequet.getSize(),productDetailRequet.getColor());
        if (getProductDetail!=null){
            return new ResponseEntity<>("Đã tồn tại",HttpStatus.OK);
        }
        Product product = productRepo.getById(productDetailRequet.getProductId());
        ProductDetail productDetail = new ProductDetail();
        productDetail.setQuantity(productDetailRequet.getQuantity());
        productDetail.setColor(productDetailRequet.getColor());
        productDetail.setSize(productDetailRequet.getSize());
        productDetail.setProduct(product);

        productDetailRepo.save(productDetail);
        return new ResponseEntity<>("Ok",HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody UpdateProductDetailRequest productDetailRequest){
        ProductDetail productDetail = productDetailRepo.getById(productDetailRequest.getId());
        productDetail.setQuantity(productDetailRequest.getQuantity());
        productDetail.setColor(productDetailRequest.getColor());
        productDetail.setSize(productDetailRequest.getSize());
        productDetailRepo.save(productDetail);
        return new ResponseEntity<>("Ok",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        ProductDetail productDetail = productDetailRepo.getById(id);
        if (productDetail==null){
            return new ResponseEntity<>("Không tồn tại",HttpStatus.NOT_FOUND);
        }
        productDetailRepo.delete(productDetail);
        return new ResponseEntity<>("Ok",HttpStatus.OK);
    }

}
