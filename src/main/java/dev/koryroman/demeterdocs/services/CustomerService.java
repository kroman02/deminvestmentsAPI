package dev.koryroman.demeterdocs.services;

import dev.koryroman.demeterdocs.data.Client;
import dev.koryroman.demeterdocs.data.Customer;
import dev.koryroman.demeterdocs.data.MyPolicy;
import dev.koryroman.demeterdocs.data.State;
import dev.koryroman.demeterdocs.data.repos.ClientRepository;
import dev.koryroman.demeterdocs.data.repos.CustomerRepository;
import dev.koryroman.demeterdocs.data.repos.PolicyRepository;
import dev.koryroman.demeterdocs.data.repos.StateRepository;
import dev.koryroman.demeterdocs.exceptions.ClientNotFoundException;
import dev.koryroman.demeterdocs.exceptions.ResourceNotFoundException;
import dev.koryroman.demeterdocs.exceptions.StateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    StateService stateService;
    @Autowired
    MyPolicyService myPolicyService;


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

    public List<Customer> getCustomersByClient(Long clientId) throws ClientNotFoundException {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId));
        return customerRepository.findCustomersByClient(client);
    }

    public Customer addCustomer(Long stateId, Long policyId, Customer customer) throws StateNotFoundException, ResourceNotFoundException {

        State state = stateService.getOneState(stateId);
        MyPolicy policy = null;
        if(myPolicyService.policyExists(policyId)){
            policy = myPolicyService.getOnePolicy(policyId);
        }
        return customerRepository.save(customer);
    }
}
