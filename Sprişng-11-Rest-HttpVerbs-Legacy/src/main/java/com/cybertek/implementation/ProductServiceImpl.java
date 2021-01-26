package com.cybertek.implementation;

import com.cybertek.entity.Product;
import com.cybertek.repository.ProductRepository;
import com.cybertek.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductService productService, ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }


    @Override
    public List<Product> delete(long id) {
       productRepository.deleteById(id);
       return productRepository.findAll();

    }

    @Override
    public List<Product> updateProduct(long id, Product product) {

        Product obj = productRepository.findById(id).get();
        obj.setName(product.getName());
        productRepository.save(obj);
        return productRepository.findAll();
    }

    @Override
    public List<Product> createProduct(Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) throws Exception {
        return productRepository.findById(id).orElseThrow(()->new Exception("This product not available"));
    }
}
