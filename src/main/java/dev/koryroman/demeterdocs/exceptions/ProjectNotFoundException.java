package dev.koryroman.demeterdocs.exceptions;


public class ProjectNotFoundException extends Exception{
    public ProjectNotFoundException(Long projectId){super("Could not find project with id "+projectId);}
}