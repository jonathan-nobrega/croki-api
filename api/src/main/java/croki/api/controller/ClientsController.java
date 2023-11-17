package croki.api.controller;

import croki.api.clients.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public Page<ListClientDTO> findAll(
            @PageableDefault(size = 20, sort = {"name"})
            Pageable page
    ) {
        return repository.findAll(page).map(ListClientDTO::new);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Optional<ClientJPA> findOne(@PathVariable long id) {
        return repository.findById(id);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateClientDTO data) {
        var client = repository.getReferenceById((data.id()));
        client.updateData(data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        System.out.println("Deleting Client ID " + id);
        repository.deleteById(id);
    }
}
