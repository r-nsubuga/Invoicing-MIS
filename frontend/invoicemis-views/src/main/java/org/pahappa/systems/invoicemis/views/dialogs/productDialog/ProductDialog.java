package org.pahappa.systems.invoicemis.views.dialogs.productDialog;

import org.pahappa.systems.invoicemis.core.services.ProductService;
import org.pahappa.systems.invoicemis.models.product.Product;
import org.pahappa.systems.invoicemis.security.HyperLinks;
import org.pahappa.systems.invoicemis.views.dialogs.DialogForm;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="productDialog")
@SessionScoped
public class ProductDialog extends DialogForm<Product> {

    private ProductService productService;

    @PostConstruct
    public void init(){
        productService = ApplicationContextProvider.getBean(ProductService.class);
    }

    public ProductDialog() {
        super(HyperLinks.PRODUCT_DIALOG, 700, 300);
    }

    @Override
    public void persist() throws Exception {
        this.productService.saveInstance(super.model);
    }

    public void resetModal(){
        super.resetModal();
        super.model = new Product();
    }
}
