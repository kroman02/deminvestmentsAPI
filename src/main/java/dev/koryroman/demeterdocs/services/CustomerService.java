package dev.koryroman.demeterdocs.services;

import dev.koryroman.demeterdocs.data.Client;
import dev.koryroman.demeterdocs.data.Customer;
import dev.koryroman.demeterdocs.data.repos.CustomerRepository;
import dev.koryroman.demeterdocs.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getOneCustomer(Long customerId){
        return customerRepository.findById(customerId).get();
    }



    public List<Customer> getCustomersByName(String name) {
        List<Customer> customersFound = new ArrayList<>();
        customerRepository.findAll()
                .stream()
                .filter(c -> c.getFullName().toLowerCase().contains(name.toLowerCase())).forEach(customersFound::add);
        return customersFound;


    }
}
