package croki.api.domain.projects;

import croki.api.domain.clients.Client;
import croki.api.domain.projects.dto.CreateProjectDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "projects")
@Entity(name = "project")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "billing_method")
    @Enumerated(EnumType.STRING)
    private BillingMethod billingMethod;
    private boolean isActive;
    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Project(Client client, CreateProjectDTO data) {
        this.client = client;
        this.title = data.title();
        this.billingMethod = data.billingMethod();
        this.isActive = data.isActive();
        this.deadline = data.deadline();
    }

    public Project(CreateProjectDTO projectDto) {
    }
}
