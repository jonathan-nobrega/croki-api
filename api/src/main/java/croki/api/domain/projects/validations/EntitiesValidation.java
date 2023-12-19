package croki.api.domain.projects.validations;

import croki.api.domain.clients.ClientRepository;
import croki.api.domain.projects.CreateProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntitiesValidation implements ProjectValidations {

    @Autowired
    private ClientRepository clientRepository;

    public void validate(CreateProjectDTO data) {

        var client = clientRepository.existsById(data.clientId());

        if (!client) {
            throw new RuntimeException("Client doesn't exist.");
        }
    }
}
