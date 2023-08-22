package org.pahappa.systems.invoicemis.views.animal;

import com.googlecode.genericdao.search.Search;
import lombok.Getter;
import lombok.Setter;
import org.pahappa.systems.invoicemis.security.UiUtils;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.SortMeta;
import org.sers.webutils.client.views.presenters.PaginatedTableView;
import org.sers.webutils.model.RecordStatus;
import org.sers.webutils.model.exception.OperationFailedException;
import org.sers.webutils.server.core.service.excel.reports.ExcelReport;

import org.pahappa.systems.invoicemis.models.practice.Animal;
import org.pahappa.systems.invoicemis.core.services.AnimalService;
import org.sers.webutils.server.core.utils.ApplicationContextProvider;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ManagedBean(name="animalView")
@SessionScoped
public class AnimalView extends PaginatedTableView<Animal, AnimalView, AnimalView> {
    private AnimalService animalService;

    @PostConstruct
    public void init(){
        animalService= ApplicationContextProvider.getBean(AnimalService.class);
        reloadFilterReset();
    }
    @Override
    public void reloadFromDB(int i, int i1, Map<String, Object> map) throws Exception {
        super.setDataModels(animalService.getInstances(new Search().addFilterEqual("recordStatus", RecordStatus.ACTIVE), i, i1));
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
    public List<Animal> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        return getDataModels();
    }

    @Override
    public void reloadFilterReset(){
        super.setTotalRecords(animalService.countInstances(new Search()));
        System.out.println("Total Records: " + getTotalRecords());
        try{
            super.reloadFilterReset();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAnimal(Animal animal){
        try {
            animalService.deleteInstance(animal);
            reloadFilterReset();
            UiUtils.showMessageBox("Delete Message", "The animal has been deleted");
        } catch (OperationFailedException e) {
            throw new RuntimeException(e);
        }
    }
}
