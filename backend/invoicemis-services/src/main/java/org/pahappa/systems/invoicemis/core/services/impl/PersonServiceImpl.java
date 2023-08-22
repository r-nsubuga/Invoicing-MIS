package org.pahappa.systems.invoicemis.core.services.impl;


import org.pahappa.systems.invoicemis.core.services.PersonService;
import org.pahappa.systems.invoicemis.models.practice.Person;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.model.exception.ValidationFailedException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonServiceImpl extends GenericServiceImpl<Person> implements PersonService {

    @Override
    public Person saveInstance(Person entityInstance) throws ValidationFailedException, OperationFailedException {
        if(entityInstance != null){

        }
        return save(entityInstance);
    }

    @Override
    public boolean isDeletable(Person instance) throws OperationFailedException {
        return true;
    }
}
