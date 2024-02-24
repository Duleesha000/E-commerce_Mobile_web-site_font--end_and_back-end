package com.Product.Catalog.controller;

import com.Product.Catalog.model.Product;
import com.Product.Catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
@CrossOrigin
public class productController {

    @Autowired
    private ProductService productServices;

    @GetMapping(path = "/")
    public List<Product> getAll(){
        return productServices.getAllProducts();
    }

    @GetMapping(path = "/{id}")
    public Product getProductFromCatalogId(@PathVariable int id){
        return productServices.getProductByID(id);
    }

    @PostMapping(path = "/")
    public Product createProduct(@RequestBody Product product){
        return productServices.createProduct(product);
    }

    @PutMapping(path = "/")
    public Product updateProductDetails(@RequestBody Product product){
        return productServices.updateProductDetails(product);
    }

    @PutMapping(path = "/decrement/{id}")
    public int decrementProductQuantity(@PathVariable int id){
        return productServices.decrementProductQuantity(id);
    }

    @PutMapping(path = "/increment/{id}")
    public int incrementProductQuantity(@PathVariable int id){
        return productServices.incrementProductQuantity(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduct(@PathVariable int id){
        productServices.deleteProduct(id);
    }



}
