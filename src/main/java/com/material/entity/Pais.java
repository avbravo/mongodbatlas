/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.material.entity;

import com.avbravo.jmoordb.anotations.Id;

/**
 *
 * @author avbravo
 */
public class Pais {
    @Id
    private String idpais;
    private String pais;

    public Pais() {
    }

    public Pais(String idpais, String pais) {
        this.idpais = idpais;
        this.pais = pais;
    }

    
    
    
    
    public String getIdpais() {
        return idpais;
    }

    public void setIdpais(String idpais) {
        this.idpais = idpais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
    
}
