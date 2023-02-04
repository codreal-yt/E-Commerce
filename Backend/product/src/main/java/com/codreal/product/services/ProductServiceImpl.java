package com.codreal.product.services;

import com.codreal.product.exceptions.NoProductExistInRepository;
import com.codreal.product.models.Product;
import com.codreal.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() throws NoProductExistInRepository {
        List<Product> all = productRepository.findAll();

        if (all.isEmpty()) {
            throw new NoProductExistInRepository();
        } else {
            return all;
        }
    }

    @Override
    public Product getById(Long pid) throws NoProductExistInRepository {
        Optional<Product> product = productRepository.findById(pid);
        if(product.isEmpty()){
            throw new NoProductExistInRepository();
        }else{
            return product.get();
        }
    }

    @Override
    public Product add1(Product product) {
        return productRepository.save(product);
    }


}
