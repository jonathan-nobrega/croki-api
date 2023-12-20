package croki.api.domain.projects.dto;

import croki.api.domain.projects.BillingMethod;

import java.time.LocalDateTime;

public record ProjectQueryDTO(
        Long id,
        Long client_id,
        Boolean is_active,
        String title,
        BillingMethod billing_method,
        LocalDateTime deadline
) {
}
