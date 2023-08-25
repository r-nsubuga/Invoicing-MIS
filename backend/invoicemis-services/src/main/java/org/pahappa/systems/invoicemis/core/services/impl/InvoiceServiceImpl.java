package org.pahappa.systems.invoicemis.core.services.impl;

import org.pahappa.systems.invoicemis.core.services.InvoiceService;
import org.pahappa.systems.invoicemis.models.invoice.Invoice;
import org.pahappa.systems.invoicemis.utils.Validate;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.model.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceServiceImpl extends GenericServiceImpl<Invoice> implements InvoiceService {
    @Override
    public Invoice saveInstance(Invoice entityInstance) throws ValidationFailedException, OperationFailedException {
        Validate.notNull(entityInstance, "Invoice is not saved");
        return entityInstance;
    }

    @Override
    public void deleteInstance(Invoice instance) throws OperationFailedException {

    }

    @Override
    public boolean isDeletable(Invoice instance) throws OperationFailedException {
        return false;
    }
}