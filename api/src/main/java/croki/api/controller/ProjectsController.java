package croki.api.controller;

import croki.api.domain.clients.ClientRepository;
import croki.api.domain.projects.CreateProjectDTO;
import croki.api.domain.projects.ProjectDetailingDTO;
import croki.api.domain.projects.ProjectJPA;
import croki.api.domain.projects.ProjectRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("projects")
@SecurityRequirement(name = "bearer-key")
public class ProjectsController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ProjectDetailingDTO> create(@RequestBody @Valid CreateProjectDTO data, UriComponentsBuilder uriBuilder) {
        var client = clientRepository.getReferenceById(data.clientId());
        var newProject = new ProjectJPA(data, client);
        
        projectRepository.save(newProject);

        var uri = uriBuilder.path("/projects/{id}").buildAndExpand(newProject.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProjectDetailingDTO(newProject));
    }
}
