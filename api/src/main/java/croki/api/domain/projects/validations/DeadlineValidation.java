package croki.api.domain.projects.validations;

import croki.api.domain.projects.dto.CreateProjectDTO;
import org.springframework.stereotype.Component;

@Component
public class DeadlineValidation implements ProjectValidations {

    public void validate(CreateProjectDTO data) {
        // if (data.deadline() == null) {
        //    data.deadline() = LocalDateTime.from(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00")));
        // }
    }
}
