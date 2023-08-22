package org.pahappa.systems.invoicemis.views.person;

import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.pahappa.systems.invoicemis.core.services.PersonService;
import org.pahappa.systems.invoicemis.models.practice.Person;
import org.pahappa.systems.invoicemis.security.UiUtils;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.sers.webutils.client.views.presenters.PaginatedTableView;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;

import com.googlecode.genericdao.search.Search;

@ManagedBean(name="personView")
@SessionScoped
//@ViewPath(path = Hyperlinks.NAME_VIEW)
public class PersonView extends PaginatedTableView<Person, PersonView, PersonView> {

    private PersonService personService;
    private Search search;

    @Override
    public List<ExcelReport> getExcelReportModels() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getExcelReportModels'");
    }

    @Override
    public String getFileName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFileName'");
    }

    @Override
    public void reloadFromDB(int offset, int limit, Map<String, Object> filters) throws Exception {
        super.setDataModels(personService.getInstances(null, offset,limit));
    }

    @Override
    public List<Person> load(int arg0, int arg1, Map<String, SortMeta> arg2, Map<String, FilterMeta> filterBy) {
       return getDataModels();
    }

    @Override
    public void reloadFilterReset(){
        super.setTotalRecords(personService.countInstances(null));
    }

    @PostConstruct
    public void init(){
        personService = ApplicationContextProvider.getBean(PersonService.class);
        this.reloadFilterReset();
    }

    public void deleteName(Person person){
        try{
            personService.deleteInstance(person);
            UiUtils.showMessageBox("Action successful","Name has been deleted");
        }
        catch (OperationFailedException ex){
            // UiUtils.ComposeFailure("Action successful",ex.getLocalizedMessage()");
            // Logger.getLogger(PersonView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
}
