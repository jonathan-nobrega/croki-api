package croki.api.domain.clients.services;

import croki.api.domain.clients.Client;
import croki.api.domain.clients.ClientRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client checkClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ValidationException("Client doesn't exist.");
        }
        return clientRepository.getReferenceById(id);
    }
}
