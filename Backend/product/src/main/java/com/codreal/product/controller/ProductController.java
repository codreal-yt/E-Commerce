package com.codreal.product.controller;

import com.codreal.product.exceptions.NoProductExistInRepository;
import com.codreal.product.models.Product;
import com.codreal.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/check")
    public String check(){
        return "Working...!";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        try{
            return new ResponseEntity<List<Product>>(productService.getAll(), HttpStatus.OK);
        }catch (NoProductExistInRepository e){
            return new ResponseEntity("List Not Found", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/add")
    public ResponseEntity<Product> add1(@RequestBody Product product)  throws IOException {
        Product user=productService.add1(product);
        return new ResponseEntity<Product>(user,HttpStatus.OK);
    }

    @GetMapping("/get/by/pid/{pid}")
    public ResponseEntity<Product> getById(@PathVariable Long pid){
        try {
            return new ResponseEntity<Product>(productService.getById(pid), HttpStatus.OK);
        }catch (NoProductExistInRepository e) {
            return new ResponseEntity("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
