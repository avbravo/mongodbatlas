/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.material.services;

import com.avbravo.jmoordbutils.JsfUtil;
import com.material.entity.Pais;
import com.material.repository.PaisRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class PaisServices implements Serializable{
    @Inject
    PaisRepository repository;
       public List<Pais> complete(String query) {
        List<Pais> suggestions = new ArrayList<>();
        try {
            suggestions = repository.complete(query);
        } catch (Exception e) {
            JsfUtil.errorDialog("complete",e.getLocalizedMessage()); 
        }

        return suggestions;
    }
}
