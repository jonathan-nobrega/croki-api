package croki.api.controller;

import croki.api.domain.clients.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clients")
public class ClientsController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ClientDetailingDTO> create(@RequestBody @Valid CreateClientDTO data, UriComponentsBuilder uriBuilder) {
        var newClient = new ClientJPA(data);
        repository.save(newClient);

        var uri = uriBuilder.path("/clients/{id}").buildAndExpand(newClient.getId()).toUri();
        System.out.println(uri);

        return ResponseEntity.created(uri).body(new ClientDetailingDTO(newClient));
    }

    @GetMapping
    public ResponseEntity<Page<ClientDetailingDTO>> findAll(
            @PageableDefault(size = 20, sort = {"name"})
            Pageable page
    ) {
        var result = repository.findAll(page).map(ClientDetailingDTO::new);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<ClientDetailingDTO> findOne(@PathVariable long id) {
        var client = repository.getReferenceById(id);
        return ResponseEntity.ok(new ClientDetailingDTO(client));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ClientDetailingDTO> update(@RequestBody @Valid UpdateClientDTO data) {
        var client = repository.getReferenceById((data.id()));
        client.updateData(data);
        return ResponseEntity.ok(new ClientDetailingDTO(client));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        System.out.println("Deleting Client ID " + id);
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
