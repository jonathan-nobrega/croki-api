package croki.api.domain.projects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("""
            SELECT p FROM project p
            WHERE p.client.id = :clientId
            ORDER BY RAND()
            LIMIT 1
            """)
    Project chooseRandomProjectFromClient(@Param("clientId") Long clientId);

}
