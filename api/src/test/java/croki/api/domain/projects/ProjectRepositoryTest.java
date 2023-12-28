package croki.api.domain.projects;

import croki.api.domain.address.AddressDTO;
import croki.api.domain.clients.Client;
import croki.api.domain.clients.dto.CreateClientDTO;
import croki.api.domain.projects.dto.CreateProjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test") // from application-test.properties
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("""
            Should bring a random and unique project from 'test client 1'
            """)
    void chooseRandomProjectFromClientScenario1() {
        var client = createClient();
        var project = createProject(client);

        var randomProject = projectRepository.chooseRandomProjectFromClient(client.getId());
        assertThat(randomProject).isEqualTo(project);
    }

    private Client createClient() {
        var clientDto = new CreateClientDTO(
                true,
                "random client name",
                "random company name",
                "test@email.com",
                "+1 999-999-9999",
                addressSample()
        );
        var client = new Client(clientDto);

        em.persist(client);
        return client;
    }

    private Project createProject(Client client) {
        var projectDto = new CreateProjectDTO(
                client.getId(),
                "project title example",
                BillingMethod.BASED_ON_PROJECT_HOURS,
                true,
                LocalDateTime.parse("2023-12-21T11:00:00")
        );
        var project = new Project(client, projectDto);

        em.persist(project);
        return project;
    }

    private AddressDTO addressSample() {
        return new AddressDTO(
                "line 1 address example",
                "line 2 address example",
                "city example",
                "state example",
                27123
        );
    }
}