package croki.api.domain.projects;

import croki.api.domain.clients.ClientJPA;
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
public class ProjectJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private BillingMethod billingMethod;
    private Boolean isActive;
    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientJPA client;

    // public ProjectJPA(CreateProjectDTO data) {
//         this.title = data.title();
//         this.billingMethod = data.billingMethod();
//         this.isActive = data.isActive();
//         this.client = data.clientId();
    // this.deadline = data.deadline();
    // }
}
