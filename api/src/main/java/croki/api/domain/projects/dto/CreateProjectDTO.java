package croki.api.domain.projects.dto;

import croki.api.domain.projects.BillingMethod;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateProjectDTO(
        @NotNull
        Long clientId,
        @NotNull
        String title,
        @NotNull
        BillingMethod billingMethod,
        @NotNull
        Boolean isActive,
        @Future
        LocalDateTime deadline
) {
}
