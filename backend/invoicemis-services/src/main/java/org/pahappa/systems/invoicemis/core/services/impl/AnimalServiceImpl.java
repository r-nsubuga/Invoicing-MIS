package org.pahappa.systems.invoicemis.core.services.impl;

import org.pahappa.systems.invoicemis.core.services.AnimalService;
import org.pahappa.systems.invoicemis.models.practice.Animal;
import org.pahappa.systems.invoicemis.utils.Validate;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.model.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnimalServiceImpl extends GenericServiceImpl<Animal> implements AnimalService {
    @Override
    public Animal saveInstance(Animal entityInstance) throws ValidationFailedException, OperationFailedException {
        Validate.notNull(entityInstance, "Missing entity instance");
        return save(entityInstance);
    }

    @Override
    public boolean isDeletable(Animal instance) throws OperationFailedException {
        return true;
    }


}
