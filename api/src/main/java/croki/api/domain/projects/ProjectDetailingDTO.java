package croki.api.domain.projects;

import java.time.LocalDateTime;

public record ProjectDetailingDTO(
        Long id,
        Long clientId,
        String title,
        BillingMethod billingMethod,
        Boolean isActive,
        LocalDateTime deadline
) {
    public ProjectDetailingDTO(ProjectJPA project) {
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
