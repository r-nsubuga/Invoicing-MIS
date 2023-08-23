package org.pahappa.systems.invoicemis.views.dialogs.clientDialog;

import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.invoicemis.core.services.ClientService;
import org.pahappa.systems.invoicemis.models.client.Client;
import org.pahappa.systems.invoicemis.security.HyperLinks;
import org.pahappa.systems.invoicemis.views.dialogs.DialogForm;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="clientDialog")
@SessionScoped
@Setter
@Getter
public class ClientDialog extends DialogForm<Client> {

    private ClientService clientService;

    public ClientDialog() {
        super(HyperLinks.CLIENT_DIALOG, 700, 500);
    }

    @PostConstruct
    public void init(){
        clientService= ApplicationContextProvider.getBean(ClientService.class);
    }
    @Override
    public void persist() throws Exception {
        this.clientService.saveInstance(super.model);
    }

    public void resetModal(){
        super.resetModal();
        super.model = new Client();
    }
}
