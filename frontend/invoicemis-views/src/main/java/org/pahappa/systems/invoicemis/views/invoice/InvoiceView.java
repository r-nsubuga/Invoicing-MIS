package org.pahappa.systems.invoicemis.views.invoice;

import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.invoicemis.core.services.InvoiceService;
import org.pahappa.systems.invoicemis.models.invoice.Invoice;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.sers.webutils.client.views.presenters.PaginatedTableView;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ManagedBean(name="invoiceView")
@SessionScoped
public class InvoiceView extends PaginatedTableView<Invoice, InvoiceView, InvoiceView> {
    private InvoiceService invoiceService;

    @PostConstruct
    public void init(){
        invoiceService = ApplicationContextProvider.getBean(InvoiceService.class);
        try {
            reloadFilterReset();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void reloadFromDB(int i, int i1, Map<String, Object> map) throws Exception {

    }

    @Override
    public List<ExcelReport> getExcelReportModels() {
        return null;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public List<Invoice> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        return null;
    }

    @Override
    public void reloadFilterReset() throws Exception {
        super.reloadFilterReset();
    }
}
