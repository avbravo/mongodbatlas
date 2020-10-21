/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.material.controllers;

import com.avbravo.jmoordbutils.JsfUtil;
import com.material.entity.Pais;
import com.material.repository.PaisRepository;
import com.material.services.PaisServices;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@Named(value = "paisController")
@ViewScoped
public class PaisController implements Serializable {

    @Inject
    PaisRepository paisRepository;
    Pais pais = new Pais();
    List<Pais> listPais = new ArrayList<Pais>();

    @Inject
    PaisServices paisServices;

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

    public List<Pais> getListPais() {
        listPais = paisRepository.findAll();
        return listPais;
    }

    public void setListPais(List<Pais> listPais) {
        this.listPais = listPais;
    }

    /**
     * Creates a new instance of PaisController
     */
    public PaisController() {
    }

    public String save() {
        try {

            if (paisRepository.save(pais)) {
                JsfUtil.infoDialog("save", "Guardado exitosamente");
            } else {
                JsfUtil.errorDialog("save", paisRepository.getException().toString());
            }

        } catch (Exception e) {
            JsfUtil.infoDialog("error", "Guardado exitosamente");
        }
        return "";
    }
}
