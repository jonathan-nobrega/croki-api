package croki.api.controller;

import croki.api.domain.invoices.InvoiceRepository;
import croki.api.domain.invoices.dto.CreateInvoiceDTO;
import croki.api.domain.invoices.dto.InvoiceDetailingDTO;
import croki.api.domain.invoices.dto.UpdateInvoiceDTO;
import croki.api.domain.invoices.services.InvoiceService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@RequestMapping("invoices")
@SecurityRequirement(name = "bearer-key")
public class InvoicesController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<Page<InvoiceDetailingDTO>> findAll(
            @PageableDefault(size = 20, sort = {"id"})
            Pageable page
    ) {
        var result = invoiceRepository.findAll(page).map(InvoiceDetailingDTO::new);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<InvoiceDetailingDTO> findOne(@PathVariable long id) {
        var invoice = invoiceRepository.getReferenceById(id);
        return ResponseEntity.ok(new InvoiceDetailingDTO(invoice));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<InvoiceDetailingDTO> create(@RequestBody @Valid CreateInvoiceDTO data, UriComponentsBuilder uriBuilder) {
        var newInvoice = invoiceService.create(data);
        var uri = uriBuilder.path("/invoices/{id}").buildAndExpand(newInvoice.id()).toUri();

        return ResponseEntity.created(uri).body(newInvoice);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<InvoiceDetailingDTO> update(@RequestBody @Valid UpdateInvoiceDTO data) {
        var invoice = invoiceService.update(data);
        return ResponseEntity.ok(invoice);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ResponseEntity.BodyBuilder> delete(@PathVariable Long id) {
        invoiceService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
