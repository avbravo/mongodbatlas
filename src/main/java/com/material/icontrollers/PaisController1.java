/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.material.icontrollers;

import com.avbravo.jmoordb.configuration.JmoordbControllerEnvironment;
import com.avbravo.jmoordb.interfaces.IController;
import com.avbravo.jmoordbutils.JsfUtil;
import com.material.datamodel.PaisDataModel;
import com.material.entity.Pais;
import com.material.repository.PaisRepository;
import com.material.services.PaisServices;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Getter
@Setter
public class PaisController1 implements Serializable , IController {
 private static final long serialVersionUID = 1L;

    private Boolean writable = false;
    Integer page = 1;
    Integer rowPage = 25;
    List<Integer> pages = new ArrayList<>();
     private PaisDataModel paisDataModel;
         //Entity
    Pais pais = new Pais();
    Pais paisSelected;
    Pais paisSearch = new Pais();
     
    @Inject
    PaisRepository paisRepository;

   //List
    List<Pais> paisList = new ArrayList<>();
    List<Pais> paisListSelected = new ArrayList<>();

    @Inject
    PaisServices paisServices;

    // <editor-fold defaultstate="collapsed" desc="getter/setter">
    public List<Integer> getPages() {
        return paisRepository.listOfPage(rowPage);
    }

    // </editor-fold>
   

    /**
     * Creates a new instance of PaisController
     */
    public PaisController1() {
    }
    
    // <editor-fold defaultstate="collapsed" desc="init">
    @PostConstruct
    public void init() {
        try {

            /*
            configurar el ambiente del controller
             */
            HashMap parameters = new HashMap();
     
            //    parameters.put("P_EMPRESA", jmoordb_user.getEmpresa().getDescripcion());

            JmoordbControllerEnvironment jmc = new JmoordbControllerEnvironment.Builder()
                    .withController(this)
                    .withRepository(paisRepository)
                    .withEntity(pais)
                    .withService(paisServices)
                    .withNameFieldOfPage("page")
                    .withNameFieldOfRowPage("rowPage")
                    .withTypeKey("primary")
                    .withSearchLowerCase(false)
                    .withPathReportDetail("/resources/reportes/pais/details.jasper")
                    .withPathReportAll("/resources/reportes/pais/all.jasper")
                    .withparameters(parameters)
                     .withResetInSave(true)
                   .withAction("golist")
                    .build();

            start();

        } catch (Exception e) {
          
        }
    }// </editor-fold>


 @Override
    public String save(){
        save();
        System.out.println("----- voy a save");
        return "";
    }

    @Override
    public void move(Integer arg0) {
         try {
 
       
            this.page = page;
            paisDataModel = new PaisDataModel(paisList);
            Document doc;

            switch (getSearch()) {
                case "_init":
                case "_autocomplete":
                    paisList = paisRepository.findPagination(page, rowPage);
                    break;

                case "idpais":
                    if (getValueSearch() != null) {
                        paisSearch.setIdpais(getValueSearch().toString());
                        doc = new Document("idpais", paisSearch.getIdpais());
                        paisList = paisRepository.findPagination(doc, page, rowPage, new Document("idpais", -1));
                    } else {
                        paisList = paisRepository.findPagination(page, rowPage);
                    }

                    break;
                case "pais":
                    if (getValueSearch() != null) {
                        paisSearch.setPais(getValueSearch().toString());
                        doc = new Document("activo", paisSearch.getPais());
                        paisList = paisRepository.findPagination(doc, page, rowPage, new Document("idpais", -1));
                    } else {
                        paisList = paisRepository.findPagination(page, rowPage);
                    }
                    break;

                default:
                    paisList = paisRepository.findPagination(page, rowPage);
                    break;
            }

            paisDataModel = new PaisDataModel(paisList);

        } catch (Exception e) {
          JsfUtil.errorDialog("movw()" , e.getLocalizedMessage().toString());

        }

    }
}
