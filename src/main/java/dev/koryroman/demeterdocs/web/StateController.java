package dev.koryroman.demeterdocs.web;

import dev.koryroman.demeterdocs.data.State;
import dev.koryroman.demeterdocs.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StateController {


    @Autowired
    StateService stateService;

    @GetMapping("/states")
    public ResponseEntity<List<State>> getAllStates(){
        List<State> states = stateService.getAllStates();
        return new ResponseEntity<>(states, HttpStatus.OK);
    }

}
