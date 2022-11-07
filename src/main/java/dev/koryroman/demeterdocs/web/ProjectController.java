package dev.koryroman.demeterdocs.web;


import dev.koryroman.demeterdocs.data.repos.ClientRepository;
import dev.koryroman.demeterdocs.data.Project;
import dev.koryroman.demeterdocs.data.repos.ProjectRepository;
import dev.koryroman.demeterdocs.exceptions.ClientNotFoundException;
import dev.koryroman.demeterdocs.exceptions.ProjectNotFoundException;
import dev.koryroman.demeterdocs.services.ClientService;
import dev.koryroman.demeterdocs.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProjectService projectService;

    @Autowired
    ClientService clientService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {

        List<Project> projects = new ArrayList<>(projectRepository.findAll());
        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);

    }
    @GetMapping("projects/{projectId}")
    public ResponseEntity<Project> getOneProject(@PathVariable Long projectId) throws ProjectNotFoundException {
        Project project = projectService.getOneProject(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping("clients/{clientId}/projects")
    public ResponseEntity<Project> createProject(@PathVariable(value="clientId") Long clientId, @RequestBody Project requestProject) throws ClientNotFoundException {

        Project project = clientRepository.findById(clientId).map(client -> {
            requestProject.setClient(client);
            return projectRepository.save(requestProject);
        }).orElseThrow(() -> new ClientNotFoundException(clientId));

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/projects/put/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long id, @RequestBody Project projectRequest) throws ProjectNotFoundException {
        Project project = projectService.getOneProject(id);
        project.setContent(projectRequest);
        Project updatedProject = projectRepository.save(project);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") Long id) {
        projectRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String clientNotFoundHandler(ClientNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String projectNotFoundHandler(ProjectNotFoundException ex){
        return ex.getMessage();
    }

}

