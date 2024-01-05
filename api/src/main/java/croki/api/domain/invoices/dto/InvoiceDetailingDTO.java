package croki.api.domain.invoices.dto;

import croki.api.domain.invoices.Invoice;
import croki.api.domain.invoices.InvoiceStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InvoiceDetailingDTO(
        Long id,
        Long clientId,
        Long projectId,
        Long invoiceNumber,
        String description,
        BigDecimal amount,
        LocalDate dueDate,
        InvoiceStatus status
) {

    public InvoiceDetailingDTO(Invoice invoice) {
        this(
                invoice.getId(),
                invoice.getClient().getId(),
                invoice.getProject().getId(),
                invoice.getInvoiceNumber(),
                invoice.getDescription(),
                invoice.getAmount(),
                invoice.getDueDate(),
                invoice.getStatus()
        );
    }
}
