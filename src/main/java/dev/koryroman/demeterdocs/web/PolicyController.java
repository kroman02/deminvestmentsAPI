package dev.koryroman.demeterdocs.web;


import dev.koryroman.demeterdocs.data.MyPolicy;
import dev.koryroman.demeterdocs.exceptions.ClientNotFoundException;
import dev.koryroman.demeterdocs.exceptions.ResourceNotFoundException;
import dev.koryroman.demeterdocs.services.MyPolicyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PolicyController {

    @Autowired
    MyPolicyService myPolicyService;


    @GetMapping("/policies")
    public ResponseEntity<List<MyPolicy>> getAllPolicies(){
        List<MyPolicy> policies = myPolicyService.getAllPolicies();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resourceNotFoundHandler(ResourceNotFoundException ex){
        return ex.getMessage();
    }


}
