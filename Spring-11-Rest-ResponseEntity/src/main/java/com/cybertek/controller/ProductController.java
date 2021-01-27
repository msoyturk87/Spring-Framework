package com.cybertek.controller;


import com.cybertek.entity.Product;
import com.cybertek.entity.ResponseWrapper;
import com.cybertek.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id){

        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public  ResponseEntity<List<Product>> getProducts(){
        // 1.HTTP Headers
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version","Cybertek.v1");
        responseHttpHeaders.set("Operation","Get List");

        return ResponseEntity
                .ok() // status 200
                .headers(responseHttpHeaders)
                .body(productService.getProducts());
    }

    @PostMapping
    public  ResponseEntity<List<Product>> createProduct(@RequestBody Product product){

        List<Product> set=productService.createProduct(product);

        // 3. ResponseEntity header
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version","Cybertek.v1")
                .header("Operation","Create")
                .body(set);

    }
    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") long id){
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version","Cybertek.v1");
        responseHttpHeaders.set("Operation","Delete");

        return ResponseEntity
                .ok() // status 200
                .headers(responseHttpHeaders)
                .body(productService.delete(id));

    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<List<Product>> updateProduct(@PathVariable("id") long id,@RequestBody Product product){
        // 2. MultiValueMap

        MultiValueMap<String,String> map=new LinkedMultiValueMap<>();
        map.add("Version","CybertekV1");
        map.add("operation","update");

        List<Product> list=productService.updateProduct(id,product);

        return new ResponseEntity<>(list,map,HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts(){
        // Custom Response with ResponseWrapper
        return ResponseEntity
                .ok(new ResponseWrapper("products successfully retrieved",productService.getProducts()));
    }

}







