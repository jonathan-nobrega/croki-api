package croki.api.domain.projects;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectJPA, Long> {

    //@Query("""
//            SELECT * FROM projects p
//            WHERE
//            p.clientId = :clientId
//            ORDER BY RAND()
//            LIMIT 1
//            """)
    //ProjectJPA chooseRandomProjectFromClient(Long clientId);
}
