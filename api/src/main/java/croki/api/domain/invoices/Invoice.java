package croki.api.domain.invoices;

import croki.api.domain.invoices.dto.CreateInvoiceDTO;
import croki.api.domain.invoices.dto.InvoiceStatus;
import croki.api.domain.invoices.dto.UpdateInvoiceDTO;
import croki.api.domain.projects.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "invoices")
@Entity(name = "invoice")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long invoiceNumber;
    private String description;
    private BigDecimal amount;
    private LocalDate dueDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    public Invoice(Project project, CreateInvoiceDTO data) {
        this.project = project;
        this.invoiceNumber = data.invoiceNumber();
        this.description = data.description();
        this.amount = data.amount();
        this.dueDate = data.dueDate();
        this.status = data.status();
    }

    public void updateInvoice(Project project, UpdateInvoiceDTO data) {
        if (project != null) this.project = project;
        if (data.invoiceNumber() != null) this.invoiceNumber = data.invoiceNumber();
        if (data.description() != null) this.description = data.description();
        if (data.amount() != null) this.amount = data.amount();
        if (data.dueDate() != null) this.dueDate = data.dueDate();
        if (data.status() != null) this.status = data.status();
    }

    //public void updateData(UpdateInvoiceDTO data) {
    //    if (data.projectId() != null) {
    //        this.project.updateData(data.projectId());
    //    }
    //    if (data. != null) this. = data.getInvoiceNumber();
    //    if (data. != null) this. = data.getDescription();
    //    if (data. != null) this. = data.getAmount();
    //    if (data. != null) this. = data.getDueDate();
    //    if (data. != null) this. = data.getStatus();
    //}
}
