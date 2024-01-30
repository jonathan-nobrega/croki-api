package croki.api.domain.invoices.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateInvoiceDTO(
        @NotNull
        Long id,
        Long projectId,
        Long invoiceNumber,
        String description,
        BigDecimal amount,
        LocalDate dueDate,
        InvoiceStatus status
) {
}
