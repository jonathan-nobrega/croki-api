package croki.api.domain.projects.services;

import croki.api.domain.clients.services.ClientService;
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
    private ClientService clientService;

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public ProjectDetailingDTO create(CreateProjectDTO data) {
        var client = clientService.checkClient(data.clientId());
        var newProject = new Project(client, data);

        projectRepository.save(newProject);
        return new ProjectDetailingDTO(newProject);
    }

    @Transactional
    public ProjectDetailingDTO update(UpdateProjectDTO data) {
        var client = clientService.checkClient(data.clientId());
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

    public Project checkProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ValidationException("Project doesn't exist");
        }
        return projectRepository.getReferenceById(id);
    }
}
