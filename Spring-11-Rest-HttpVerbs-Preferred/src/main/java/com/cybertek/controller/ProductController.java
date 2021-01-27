package com.cybertek.controller;


import com.cybertek.entity.Product;
import com.cybertek.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public  Product getProduct(@PathVariable("id") long id){
        return productService.getProduct(id);
    }

    @RequestMapping
    public  List<Product> getProducts(){
        return productService.getProducts();
    }


    @RequestMapping(method = RequestMethod.POST)
    public  List<Product> createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public  List<Product> deleteProduct(@PathVariable("id") long id){
        return productService.delete(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public  List<Product> updateProduct(@PathVariable("id") long id,@RequestBody Product product){
        return productService.updateProduct(id, product);
    }

}
