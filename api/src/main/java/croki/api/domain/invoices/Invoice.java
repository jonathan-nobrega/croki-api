package croki.api.domain.invoices;

import croki.api.domain.clients.Client;
import croki.api.domain.invoices.dto.CreateInvoiceDTO;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    private Long invoiceNumber;
    private String description;
    private BigDecimal amount;
    private LocalDate dueDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    public Invoice(Client client, Project project, CreateInvoiceDTO data) {
        this.client = client;
        this.project = project;
        this.invoiceNumber = data.invoiceNumber();
        this.description = data.description();
        this.amount = data.amount();
        this.dueDate = data.dueDate();
        this.status = data.status();
    }

    public Invoice(CreateInvoiceDTO invoiceDto) {

    }
}
