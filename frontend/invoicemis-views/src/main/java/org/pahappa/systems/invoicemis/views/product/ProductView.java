package org.pahappa.systems.invoicemis.views.product;

import com.googlecode.genericdao.search.Search;
import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.invoicemis.core.services.ProductService;
import org.pahappa.systems.invoicemis.models.product.Product;
import org.pahappa.systems.invoicemis.utils.GeneralSearchUtils;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.sers.webutils.client.views.presenters.PaginatedTableView;
import org.sers.webutils.model.utils.SearchField;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "productView")
@SessionScoped
@Getter
@Setter

public class ProductView extends PaginatedTableView<Product, ProductView, ProductView> {
    private ProductService productService;
    private Search search;
    private String searchTerm;
    private List<SearchField> searchFields, selectedSearchFields;
    private Date createdFrom, createdTo;

    @PostConstruct
    public void init(){
        productService= ApplicationContextProvider.getBean(ProductService.class);
        reloadFilterReset();
    }

    @Override
    public void reloadFromDB(int offset, int limit, Map<String, Object> map) throws Exception {
        super.setDataModels(productService.getInstances(GeneralSearchUtils.composeUsersSearchForAll(searchFields, searchTerm,null,createdFrom , createdTo), offset, limit));
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
    public List<Product> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        return getDataModels();
    }

    public void reloadFilterReset(){
        this.searchFields = Arrays.asList(
                new SearchField("Product Name", "productName"),
                new SearchField("Product Description", "productDescription")
        );
        this.search = GeneralSearchUtils.composeUsersSearchForAll(searchFields, searchTerm, null, createdFrom, createdTo);

        super.setTotalRecords(productService.countInstances(this.search));

        try{
            super.reloadFilterReset();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
