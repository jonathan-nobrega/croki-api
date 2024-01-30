package croki.api.domain.invoices.services;

import croki.api.domain.invoices.Invoice;
import croki.api.domain.invoices.InvoiceRepository;
import croki.api.domain.invoices.dto.CreateInvoiceDTO;
import croki.api.domain.invoices.dto.InvoiceDetailingDTO;
import croki.api.domain.invoices.dto.UpdateInvoiceDTO;
import croki.api.domain.projects.Project;
import croki.api.domain.projects.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Transactional
    public InvoiceDetailingDTO create(CreateInvoiceDTO data) {
        var project = checkProject(data.projectId());
        var newInvoice = new Invoice(project, data);

        invoiceRepository.save(newInvoice);
        return new InvoiceDetailingDTO(newInvoice);
    }

    @Transactional
    public InvoiceDetailingDTO update(UpdateInvoiceDTO data) {
        var project = checkProject(data.projectId());
        var invoice = invoiceRepository.getReferenceById(data.id());

        invoice.updateInvoice(project, data);
        return new InvoiceDetailingDTO(invoice);
    }

    @Transactional
    public void delete(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new EntityNotFoundException("Invoice doesn't exist.");
        }
        invoiceRepository.delete(invoiceRepository.getReferenceById(id));
    }

    private Project checkProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ValidationException("Project doesn't exist");
        }
        return projectRepository.getReferenceById(id);
    }

    //public InvoiceDetailingDTO update(UpdateInvoiceDTO data) {
    //    if (!projectRepository.existsById(data.projectId())) {
    //        throw new EntityNotFoundException("Project doesn't exist.");
    //    }
//
    //    var project = projectRepository.getReferenceById(data.projectId());
    //    var invoice = invoiceRepository.getReferenceById(data.id());
    //    invoice.up
    //}
}
