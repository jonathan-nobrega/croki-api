package croki.api.domain.projects.dto;

import croki.api.domain.projects.BillingMethod;
import croki.api.domain.projects.Project;

import java.time.LocalDateTime;

public record ProjectDetailingDTO(
        Long id,
        Long clientId,
        String title,
        BillingMethod billingMethod,
        Boolean isActive,
        LocalDateTime deadline
) {
    public ProjectDetailingDTO(Project project) {
        this(
                project.getId(),
                project.getClient().getId(),
                project.getTitle(),
                project.getBillingMethod(),
                project.isActive(),
                project.getDeadline()
        );
    }
}
