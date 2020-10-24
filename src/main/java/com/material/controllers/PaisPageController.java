/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.material.controllers;

import com.avbravo.jmoordb.configuration.JmoordbControllerEnvironment;
import com.avbravo.jmoordb.interfaces.IController;
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
public class PaisPageController implements Serializable, IController {
    // <editor-fold defaultstate="collapsed" desc="fields()">
       private static final long serialVersionUID = 1L;
       //paginacion
           Integer page = 1;
    Integer rowPage = 25;
    List<Integer> pages = new ArrayList<>();

    Pais pais = new Pais();
    Pais paisSelected = new Pais();
    Pais paisSearch = new Pais();
    List<Pais> paisList = new ArrayList<Pais>();


    private Boolean writable = false;

    @Inject
    PaisServices paisServices;

   @Inject
    PaisRepository paisRepository;
    
    // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="set/get()">
      public List<Pais> getPaisList() {
        paisList = paisRepository.findAll();
        return paisList;
    }

        // </editor-fold>

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

     
  
}
