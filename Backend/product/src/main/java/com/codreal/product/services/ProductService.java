package com.codreal.product.services;

import com.codreal.product.exceptions.NoProductExistInRepository;
import com.codreal.product.exceptions.ProvideProperFileDetailException;
import com.codreal.product.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getAll() throws NoProductExistInRepository;

    Product getById(Long pid) throws NoProductExistInRepository;

    Product add1(Product product);
}
