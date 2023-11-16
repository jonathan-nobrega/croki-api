package croki.api.controller;

import croki.api.clients.CreateClientDTO;
import croki.api.clients.ClientJPA;
import croki.api.clients.ClientRepository;
import croki.api.clients.ListClientDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientsController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid CreateClientDTO data) {
        System.out.println(data);
        repository.save(new ClientJPA(data));
    }

    @GetMapping
    public Page<ListClientDTO> list(Pageable page) {
        return repository.findAll(page).map(ListClientDTO::new);
    }
}
