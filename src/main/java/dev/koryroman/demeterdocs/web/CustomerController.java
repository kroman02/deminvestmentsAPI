package dev.koryroman.demeterdocs.web;

import dev.koryroman.demeterdocs.data.*;
import dev.koryroman.demeterdocs.data.repos.ClientRepository;
import dev.koryroman.demeterdocs.exceptions.ClientNotFoundException;
import dev.koryroman.demeterdocs.exceptions.ResourceNotFoundException;
import dev.koryroman.demeterdocs.exceptions.StateNotFoundException;
import dev.koryroman.demeterdocs.services.CustomerService;
import dev.koryroman.demeterdocs.services.MyPolicyService;
import dev.koryroman.demeterdocs.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    StateService stateService;
    @Autowired
    MyPolicyService myPolicyService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("customers/{customerId}")
    public ResponseEntity<Customer> getOneCustomer(@PathVariable(value="customerId") Long customerId){
        Customer customer = customerService.getOneCustomer(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
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

    @PostMapping("clients/{clientId}/{stateId}/{policyId}/customers")
    public ResponseEntity<Customer> createCustomer(@PathVariable(value="clientId") Long clientId,
                                                   @PathVariable(value="stateId") Long stateId,
                                                   @PathVariable(value="policyId") Long policyId,
                                                   @RequestBody Customer requestCustomer) throws ClientNotFoundException, StateNotFoundException {


        Customer customer = clientRepository.findById(clientId).map(client -> {
            requestCustomer.setClient(client);
            Customer finalCustomer = null;
            try {
                finalCustomer = customerService.addCustomer(stateId, policyId, requestCustomer);
            } catch (StateNotFoundException | ResourceNotFoundException e) {
                e.printStackTrace();
            }
            return finalCustomer;
        }).orElseThrow(() -> new ClientNotFoundException(clientId));

        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String clientNotFoundHandler(ClientNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(StateNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String stateNotFoundHandler(StateNotFoundException ex){
        return ex.getMessage();
    }
}
