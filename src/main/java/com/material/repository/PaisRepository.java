/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.material.repository;

import com.avbravo.jmoordb.mongodb.repository.Repository;
import com.material.entity.Pais;
import javax.ejb.Stateless;

/**
 *
 * @author avbravo
 */
@Stateless
public class PaisRepository extends Repository<Pais>{

    public PaisRepository() {
        super(Pais.class, "jconfperu", "pais");
    }

    
}
