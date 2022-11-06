package dev.koryroman.demeterdocs.services;


import dev.koryroman.demeterdocs.data.Project;
import dev.koryroman.demeterdocs.data.repos.ProjectRepository;
import dev.koryroman.demeterdocs.exceptions.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public Project getOneProject(Long projectId) throws ProjectNotFoundException {
        return projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId));
    }
}
