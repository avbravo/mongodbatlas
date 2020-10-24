/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.material.controllers;

import com.avbravo.jmoordb.configuration.JmoordbControllerEnvironment;
import com.avbravo.jmoordb.interfaces.IController;
import com.avbravo.jmoordbutils.JsfUtil;
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

/**
 *
 * @author avbravo
 */
@Named
@ViewScoped
@Getter
@Setter
public class PaisPageController implements Serializable ,IController{

    @Inject
    PaisRepository paisRepository;
    Pais pais = new Pais();
    Pais paisSelected = new Pais();
    Pais paisSearch = new Pais();
    List<Pais> paisList = new ArrayList<Pais>();
     Integer page = 1;
    Integer rowPage = 25;
    List<Integer> pages = new ArrayList<>();

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRowPage() {
        return rowPage;
    }

    public void setRowPage(Integer rowPage) {
        this.rowPage = rowPage;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }
    private static final long serialVersionUID = 1L;

    private Boolean writable = false;
    

    @Inject
    PaisServices paisServices;

    
    
    
    
    public Pais getPaisSearch() {
        return paisSearch;
    }

    public void setPaisSearch(Pais paisSearch) {
        this.paisSearch = paisSearch;
    }

    
    
    
    public Pais getPaisSelected() {
        return paisSelected;
    }

    public void setPaisSelected(Pais paisSelected) {
        this.paisSelected = paisSelected;
    }

    
    
    
    
    public Boolean getWritable() {
        return writable;
    }

    public void setWritable(Boolean writable) {
        this.writable = writable;
    }

    public PaisServices getPaisServices() {
        return paisServices;
    }

    public void setPaisServices(PaisServices paisServices) {
        this.paisServices = paisServices;
    }
    
    
    

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public PaisRepository getPaisRepository() {
        return paisRepository;
    }

    public void setPaisRepository(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<Pais> getPaisList() {
        paisList = paisRepository.findAll();
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    

    /**
     * Creates a new instance of PaisController
     */
    public PaisPageController() {
    }


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
    public void move(Integer page) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
