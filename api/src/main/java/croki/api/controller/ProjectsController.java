package croki.api.controller;

import croki.api.domain.projects.CreateProjectDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("projects")
public class ProjectsController {

    //@Autowired
    //private ProjectRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> create(@RequestBody @Valid CreateProjectDTO data, UriComponentsBuilder uriBuilder) {

        return ResponseEntity.ok(new CreateProjectDTO(
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                )
        );

    }
}
