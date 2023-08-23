package org.pahappa.systems.invoicemis.views.client;

import com.googlecode.genericdao.search.Search;
import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.invoicemis.core.services.ClientService;
import org.pahappa.systems.invoicemis.models.client.Client;
import org.pahappa.systems.invoicemis.security.UiUtils;
import org.pahappa.systems.invoicemis.utils.GeneralSearchUtils;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.sers.webutils.client.views.presenters.PaginatedTableView;
import org.sers.webutils.model.Gender;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;
import org.sers.webutils.model.utils.SearchField;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.*;

@ManagedBean(name = "clientView")
@Getter
@Setter
public class ClientView extends PaginatedTableView<Client, ClientView, ClientView> {

    private ClientService clientService;

    private String searchTerm;
    private List<SearchField> searchFields, selectedSearchFields;
    private Search search;
    private Date createdFrom, createdTo;

    private List<Gender> genders= new ArrayList<>();

    private Gender selectedGender;

    @PostConstruct
    public void init(){
        clientService= ApplicationContextProvider.getBean(ClientService.class);
        this.genders = Arrays.asList(Gender.values());
        reloadFilterReset();
    }

    @Override
    public void reloadFromDB(int offset, int limit, Map<String, Object> map) throws Exception {
        super.setDataModels(clientService.getInstances(GeneralSearchUtils.composeUsersSearchForAll(searchFields, searchTerm,null, createdFrom, createdTo), offset, limit));
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
    public List<Client> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        return getDataModels();
    }

    public void deleteClient(Client client) {
        try {
            clientService.deleteInstance(client);
            super.reloadFilterReset();
            UiUtils.showMessageBox("Action Successful", "Client deleted successfully");
        } catch (Exception e) {
            UiUtils.showMessageBox("Action Failed", "Failed to delete client");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void reloadFilterReset(){
        this.searchFields = Arrays.asList(new SearchField("FirstName", "firstName"), new SearchField("LastName", "lastName"),new SearchField("Email", "clientEmail"), new SearchField("Phone", "clientContact"));
        this.search = GeneralSearchUtils.composeUsersSearchForAll(searchFields, searchTerm, null, createdFrom, createdTo);

        super.setTotalRecords(clientService.countInstances(this.search));

        try{
            super.reloadFilterReset();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
