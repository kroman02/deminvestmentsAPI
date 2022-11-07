package dev.koryroman.demeterdocs.exceptions;

    public class ResourceNotFoundException extends Exception{
        public ResourceNotFoundException(Long policyId){
            super("Could not find resource with id "+policyId);
        }
    }

