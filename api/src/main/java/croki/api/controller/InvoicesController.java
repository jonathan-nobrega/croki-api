package croki.api.controller;

import croki.api.domain.clients.ClientRepository;
import croki.api.domain.invoices.InvoiceRepository;
import croki.api.domain.invoices.dto.InvoiceDetailingDTO;
import croki.api.domain.projects.ProjectRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("invoices")
@SecurityRequirement(name = "bearer-key")
public class InvoicesController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    //@PostMapping
    //@Transactional
    //public ResponseEntity<Object> create(
    //        @RequestBody @Valid CreateInvoiceDTO data, UriComponentsBuilder uriBuilder
    //) {
    //    var client = clientRepository.getReferenceById(data.clientId());
    //    var project = projectRepository.getReferenceById(data.projectId());
    //    System.out.println("client: " + client);
    //    System.out.println(project);
    //    return ResponseEntity.ok().build();
    //}

    @GetMapping
    public ResponseEntity<Page<InvoiceDetailingDTO>> findAll(
            @PageableDefault(size = 20, sort = {"id"})
            Pageable page
    ) {
        var result = invoiceRepository.findAll(page).map(InvoiceDetailingDTO::new);
        return ResponseEntity.ok(result);
    }
}
