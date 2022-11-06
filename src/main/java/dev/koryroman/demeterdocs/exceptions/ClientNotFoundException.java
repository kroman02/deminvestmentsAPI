package dev.koryroman.demeterdocs.exceptions;

public class ClientNotFoundException extends Exception{
    public ClientNotFoundException(Long clientId){super("Could not find client with id "+clientId);}
}
