package croki.api.domain.projects.validations;

import croki.api.domain.projects.CreateProjectDTO;

public interface ProjectValidations {
    public void validate(CreateProjectDTO data);
}
