package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetail;
import com.example.demo.exception.NotFoundException;
import com.example.demo.reponsetory.ProductDetailReponsetory;
import com.example.demo.reponsetory.ProductReponsetory;
import com.example.demo.request.ProductDetailRequet;
import com.example.demo.request.ProductRequest;
import com.example.demo.respone.ProductResponse;
import com.example.demo.service.FileManager;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductReponsetory productRepo;
    @Autowired
    ProductDetailReponsetory productDetailRepo;

    @Autowired
    FileManager fileManager;

    @GetMapping("")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> addProduct(@RequestPart("productRequest")ProductRequest productRequest,
                                             @RequestPart("file")MultipartFile file){
        File imgFile= fileManager.save(file);
        Product product = new Product(productRequest.getName(),imgFile.getName(), LocalDate.now());
        productRepo.save(product);
//        ProductDetail productDetail = new ProductDetail(productRequest.getQuantity(),
//                productRequest.getColor(),productRequest.getSize(),productRequest.getProductId());
//        productDetailRepo.save(productDetail);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable("id") Integer id){
        Product product= productRepo.getById(id);
        Integer quantity= productDetailRepo.getQuantity(product);
        List<String> colors = productDetailRepo.getColorByProductId(product);
        List<String> sizes = productDetailRepo.getSizeByProductId(product);
        return new ResponseEntity<>(new ProductResponse(
                id,product.getName(),product.getImage(),
                product.getCreateDate(),quantity,colors,sizes
        ),HttpStatus.OK);
    }

    // Cần sửa lại
    @GetMapping("/all/{id}")
    public ResponseEntity<Product> getAllById(@PathVariable("id") Integer id){
        Product product= productRepo.getById(id);
        List<ProductDetail> details = product.getProductDetails();
        return new ResponseEntity<>(new Product(product.getId(),
                product.getName(),product.getImage(),
                product.getCreateDate(),details),HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestPart("productRequest")ProductRequest productRequest,
                                         @RequestPart("file")MultipartFile file){
        Product product = productRepo.getById(productRequest.getId());
        File imgFile= fileManager.save(file);
        product.setName(productRequest.getName());
        product.setImage(imgFile.getName());
        productRepo.save(product);
        return new ResponseEntity<>("Ok",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        Product product = productRepo.getById(id);
        List<Object> productDetail = productDetailRepo.getAllDetailByProduct(product.getId());
        if (productDetail!=null){
            return new ResponseEntity<>("Không thể xóa",HttpStatus.OK);
        }

        if (product==null){
            return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
        }
        productRepo.delete(product);
        return new ResponseEntity<>("Ok",HttpStatus.OK);

    }
}
