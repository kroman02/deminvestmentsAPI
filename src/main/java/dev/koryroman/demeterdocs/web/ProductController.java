package dev.koryroman.demeterdocs.web;


import dev.koryroman.demeterdocs.data.Product;
import dev.koryroman.demeterdocs.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> customers = productService.getAllProducts();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


}
