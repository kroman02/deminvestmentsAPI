package dev.koryroman.demeterdocs.services;

import dev.koryroman.demeterdocs.data.State;
import dev.koryroman.demeterdocs.data.repos.StateRepository;
import dev.koryroman.demeterdocs.exceptions.StateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    StateRepository stateRepository;

    public List<State> getAllStates(){
        return stateRepository.findAll();
    }

    public State getOneState(Long stateId) throws StateNotFoundException {
        return stateRepository.findById(stateId).orElseThrow(()-> new StateNotFoundException(stateId));
    }

}
