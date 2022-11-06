package dev.koryroman.demeterdocs.services;

import dev.koryroman.demeterdocs.data.MyPolicy;
import dev.koryroman.demeterdocs.data.repos.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPolicyService {

    @Autowired
    PolicyRepository policyRepository;


    public List<MyPolicy> getAllPolicies(){
        return policyRepository.findAll();
    }
}
