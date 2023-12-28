package croki.api.controller;

import croki.api.domain.clients.ClientRepository;
import croki.api.domain.projects.Project;
import croki.api.domain.projects.ProjectRepository;
import croki.api.domain.projects.dto.CreateProjectDTO;
import croki.api.domain.projects.dto.ProjectDetailingDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        var newProject = new Project(client, data);

        //projectRepository.save(newProject);

        var uri = uriBuilder.path("/projects/{id}").buildAndExpand(newProject.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProjectDetailingDTO(newProject));
    }

    @GetMapping
    public ResponseEntity<Page<ProjectDetailingDTO>> findAll(
            @PageableDefault(size = 20, sort = {"title"})
            Pageable page
    ) {
        var result = projectRepository.findAll(page).map(ProjectDetailingDTO::new);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/perClient/{id}")
    public ResponseEntity<ProjectDetailingDTO> pickFromClient(@PathVariable Long id) {
        System.out.println("aqui esta: " + id);
        var project = projectRepository.chooseRandomProjectFromClient(id);
        System.out.println("aquiiiiiiiiiiiiiiiiiiii");
        System.out.println(project.toString());
        return ResponseEntity.ok(new ProjectDetailingDTO(project));
    }


}
