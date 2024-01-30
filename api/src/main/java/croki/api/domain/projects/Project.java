package croki.api.domain.projects;

import croki.api.domain.clients.Client;
import croki.api.domain.projects.dto.CreateProjectDTO;
import croki.api.domain.projects.dto.UpdateProjectDTO;
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
    private boolean isActive;
    private LocalDateTime deadline;

    @Column(name = "billing_method")
    @Enumerated(EnumType.STRING)
    private BillingMethod billingMethod;

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

    public void updateProject(Client client, UpdateProjectDTO data) {
        if (client != null) this.client = client;
        if (data.title() != null) this.title = data.title();
        if (data.billingMethod() != null) this.billingMethod = data.billingMethod();
        if (data.isActive() != null) this.isActive = data.isActive();
        if (data.deadline() != null) this.deadline = data.deadline();
    }
}
