package croki.api.domain.projects;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateProjectDTO(
        Long id,

        @NotNull
        Long clientId,

        @NotNull
        String title,

        @NotNull
        BillingMethod billingMethod,

        @NotNull
        Boolean isActive,

        @NotNull
        @Future
        @JsonFormat
        LocalDateTime deadline
) {
}
