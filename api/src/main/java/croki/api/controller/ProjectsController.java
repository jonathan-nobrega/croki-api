package croki.api.controller;

import croki.api.domain.projects.ProjectRepository;
import croki.api.domain.projects.dto.CreateProjectDTO;
import croki.api.domain.projects.dto.ProjectDetailingDTO;
import croki.api.domain.projects.dto.UpdateProjectDTO;
import croki.api.domain.projects.services.ProjectService;
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
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<Page<ProjectDetailingDTO>> findList(
            @PageableDefault(size = 20, sort = {"title"})
            Pageable page
    ) {
        var result = projectRepository.findAll(page).map(ProjectDetailingDTO::new);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDetailingDTO> findOne(@PathVariable Long id) {
        var project = projectRepository.getReferenceById(id);
        return ResponseEntity.ok().body(new ProjectDetailingDTO(project));
    }

    @GetMapping("/perClient/{id}")
    public ResponseEntity<ProjectDetailingDTO> pickFromClient(@PathVariable Long id) {
        var project = projectRepository.chooseRandomProjectFromClient(id);
        return ResponseEntity.ok(new ProjectDetailingDTO(project));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProjectDetailingDTO> create(@RequestBody @Valid CreateProjectDTO data, UriComponentsBuilder uriBuilder) {
        var newProject = projectService.create(data);
        var uri = uriBuilder.path("/projects/{id}").buildAndExpand(newProject.id()).toUri();

        return ResponseEntity.created(uri).body(newProject);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ProjectDetailingDTO> update(@RequestBody @Valid UpdateProjectDTO data) {
        var project = projectService.update(data);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseEntity.BodyBuilder> delete(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}




