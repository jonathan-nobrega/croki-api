package croki.api.domain.projects.services;

import croki.api.domain.clients.Client;
import croki.api.domain.clients.ClientRepository;
import croki.api.domain.projects.Project;
import croki.api.domain.projects.ProjectRepository;
import croki.api.domain.projects.dto.CreateProjectDTO;
import croki.api.domain.projects.dto.ProjectDetailingDTO;
import croki.api.domain.projects.dto.UpdateProjectDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public ProjectDetailingDTO create(CreateProjectDTO data) {
        var client = checkClient(data.clientId());
        var newProject = new Project(client, data);
        projectRepository.save(newProject);

        return new ProjectDetailingDTO(newProject);
    }

    @Transactional
    public ProjectDetailingDTO update(UpdateProjectDTO data) {
        var client = checkClient(data.clientId());
        var project = projectRepository.getReferenceById(data.id());
        project.updateProject(client, data);

        return new ProjectDetailingDTO(project);
    }

    @Transactional
    public void delete(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Project doesn't exist.");
        }
        projectRepository.delete(projectRepository.getReferenceById(id));
    }

    private Client checkClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ValidationException("Client doesn't exist.");
        }
        return clientRepository.getReferenceById(id);
    }
}
