package croki.api.controller;

import croki.api.clients.ClientDTO;
import croki.api.clients.ClientJPA;
import croki.api.clients.ClientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientsController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid ClientDTO data) {
        System.out.println(data);
        repository.save(new ClientJPA(data));

    }
}
