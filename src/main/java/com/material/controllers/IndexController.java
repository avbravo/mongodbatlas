/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.material.controllers;

import com.avbravo.jmoordb.configuration.JmoordbConnection;
import com.mongodb.MongoClientURI;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author IsraelHenry
 */
@Named
@SessionScoped
public class IndexController implements Serializable{

    
     @PostConstruct
    public void init() {
      

        //Configuracion de la base de datos
        JmoordbConnection jmc = new JmoordbConnection.Builder()                
                .withUri("mongodb+srv://avbravo:denver16@cluster0.myzbr.mongodb.net/test?retryWrites=true&w=majority")
                .build();
        

         System.out.println("invocando conexion");
    }
    
    public String go(String pathPage) {
        return pathPage;
    }

}
