package dev.koryroman.demeterdocs.services;

import dev.koryroman.demeterdocs.data.Product;
import dev.koryroman.demeterdocs.data.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getOneProduct(Long productId){
        return productRepository.findById(productId).get();
    }




}
