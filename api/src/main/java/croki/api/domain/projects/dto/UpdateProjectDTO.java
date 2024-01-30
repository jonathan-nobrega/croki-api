package croki.api.domain.projects.dto;

import croki.api.domain.projects.BillingMethod;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UpdateProjectDTO(
        @NotNull
        Long id,
        Long clientId,
        String title,
        BillingMethod billingMethod,
        Boolean isActive,
        @Future
        LocalDateTime deadline
) {
}
