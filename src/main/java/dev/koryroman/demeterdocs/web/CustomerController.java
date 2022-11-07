package dev.koryroman.demeterdocs.web;

import dev.koryroman.demeterdocs.data.Client;
import dev.koryroman.demeterdocs.data.Customer;
import dev.koryroman.demeterdocs.exceptions.ClientNotFoundException;
import dev.koryroman.demeterdocs.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/customers/byclient/{clientId}")
    public ResponseEntity<List<Customer>> getCustomersByClient(@PathVariable Long clientId) throws ClientNotFoundException {
        List<Customer> customers = customerService.getCustomersByClient(clientId);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String clientNotFoundHandler(ClientNotFoundException ex){
        return ex.getMessage();
    }
}
