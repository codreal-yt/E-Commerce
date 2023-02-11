package com.codreal.product.services;

import com.codreal.product.exceptions.NoProductExistInRepository;
import com.codreal.product.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll() throws NoProductExistInRepository;

    Product getById(int pid) throws NoProductExistInRepository;

    Product add1(Product product);
}
