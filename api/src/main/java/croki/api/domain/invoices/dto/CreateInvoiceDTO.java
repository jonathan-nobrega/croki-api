package croki.api.domain.invoices.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateInvoiceDTO(
        Long clientId,
        Long projectId,
        Long invoiceNumber,
        String description,
        BigDecimal amount,
        LocalDate dueDate,
        InvoiceStatus status
) {
}
