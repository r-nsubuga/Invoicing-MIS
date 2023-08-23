package org.pahappa.systems.invoicemis.core.services.impl;

import org.pahappa.systems.invoicemis.core.services.ProductService;
import org.pahappa.systems.invoicemis.models.product.Product;
import org.pahappa.systems.invoicemis.utils.Validate;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.model.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl extends GenericServiceImpl<Product> implements ProductService {
    @Override
    public Product saveInstance(Product entityInstance) throws ValidationFailedException, OperationFailedException {
        Validate.notNull(entityInstance, "Missing entity instance");
        return save(entityInstance);
    }

    @Override
    public boolean isDeletable(Product instance) throws OperationFailedException {
        return false;
    }
}
