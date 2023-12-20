package croki.api.domain.projects;

import croki.api.domain.projects.dto.CreateProjectDTO;
import croki.api.domain.projects.validations.ProjectValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService {

    @Autowired
    private List<ProjectValidations> validations;

    public void create(CreateProjectDTO data) {
        validations.forEach(v -> v.validate(data));

        // create project
    }
}
