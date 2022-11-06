package dev.koryroman.demeterdocs.web;

import dev.koryroman.demeterdocs.data.Client;
import dev.koryroman.demeterdocs.data.Customer;
import dev.koryroman.demeterdocs.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customers/byname")
    public ResponseEntity<List<Customer>> getCustomersByName(@RequestParam(name="name") String name){
        List<Customer> customers = customerService.getCustomersByName(name);
        return new ResponseEntity<>(customers, HttpStatus.OK);

    }
}
