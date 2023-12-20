package croki.api.domain.projects.validations;

import croki.api.domain.projects.dto.CreateProjectDTO;

public interface ProjectValidations {
    public void validate(CreateProjectDTO data);
}
