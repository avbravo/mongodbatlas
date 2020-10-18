/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.material.controllers;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author IsraelHenry
 */
@Named(value = "formularioController")
@ViewScoped
public class FormularioController implements Serializable{

    /**
     * Creates a new instance of FormularioController
     */
    public FormularioController() {
    }
    public String clicBoton(){
        return "";
    }
    
}
