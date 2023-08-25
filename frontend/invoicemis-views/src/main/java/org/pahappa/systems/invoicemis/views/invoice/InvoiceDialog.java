package org.pahappa.systems.invoicemis.views.invoice;

import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.invoicemis.core.services.AnimalService;
import org.pahappa.systems.invoicemis.core.services.InvoiceService;
import org.pahappa.systems.invoicemis.models.invoice.Invoice;
import org.pahappa.systems.invoicemis.models.practice.Animal;
import org.pahappa.systems.invoicemis.security.HyperLinks;
import org.pahappa.systems.invoicemis.views.dialogs.DialogForm;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Getter
@Setter
@SessionScoped
@ManagedBean(name="invoiceDialog")
public class InvoiceDialog extends DialogForm<Invoice> {

    private InvoiceService invoiceService;
    @PostConstruct
    public void init(){
        invoiceService= ApplicationContextProvider.getBean(InvoiceService.class);
    }

    public InvoiceDialog() {
        super(HyperLinks.INVOICE_DIALOG, 600, 600);
    }

    @Override
    public void persist() throws Exception {
        this.invoiceService.saveInstance(super.model);
    }

    public void resetModal(){
        super.resetModal();
        super.model = new Invoice();
    }


}
