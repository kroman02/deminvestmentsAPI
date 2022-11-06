package dev.koryroman.demeterdocs.exceptions;

public class CarrierNotFoundException extends Exception{
    public CarrierNotFoundException(Long carrierId){super("Could not find carrier with id "+carrierId);}
}
