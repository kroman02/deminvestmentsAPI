package dev.koryroman.demeterdocs.exceptions;

public class StateNotFoundException extends Exception{
    public StateNotFoundException(Long stateId){super("Could not find state with id "+stateId);}
}
