package org.pahappa.systems.invoicemis.views.dialogs;

import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.invoicemis.core.services.AnimalService;
import org.pahappa.systems.invoicemis.models.practice.Animal;
import org.pahappa.systems.invoicemis.security.HyperLinks;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Getter
@Setter
@ManagedBean(name="animalDialog")
@SessionScoped
public class AnimalDialog extends DialogForm<Animal>{

    private AnimalService animalService;
    @PostConstruct
    public void init(){
        animalService= ApplicationContextProvider.getBean(AnimalService.class);
    }

    public AnimalDialog() {
        super(HyperLinks.ANIMAL_DIALOG, 700, 300);
    }


    @Override
    public void persist() throws Exception {
        this.animalService.saveInstance(super.model);
    }

    public void resetModal(){
        super.resetModal();
        super.model = new Animal();
    }
}
