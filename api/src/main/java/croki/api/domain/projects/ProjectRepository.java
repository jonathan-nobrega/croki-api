package croki.api.domain.projects;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectJPA, Long> {

    //@Query("""
    //        SELECT p FROM ProjectJPA p
    //        WHERE
    //        p.ClientJPA.id = :clientId
    //        order by rand()
    //        limit 1
    //        """)
    //ProjectJPA chooseRandomProjectFromClient(Long clientId);
}
