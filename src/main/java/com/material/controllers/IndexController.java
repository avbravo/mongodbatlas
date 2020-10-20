/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.material.controllers;

import com.avbravo.jmoordb.configuration.JmoordbConnection;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author  
 */
@Named
@ApplicationScoped
public class IndexController implements Serializable{
@Inject
    private Config config;

@Inject
    @ConfigProperty(name="mongodbsrv", defaultValue="")
    private String mongodbsrv;

    
     @PostConstruct
    public void init() {
      

        //Configuracion de la base de datos
        JmoordbConnection jmc = new JmoordbConnection.Builder()                
                .withUri(mongodbsrv)
                .build();
        
//        JmoordbConnection jmc = new JmoordbConnection.Builder()                
//                .withUri("mongodb+srv://avbravo:denver16@cluster0.myzbr.mongodb.net/test?retryWrites=true&w=majority")
//                .build();
        

         System.out.println("invocando conexion");
    }
    
    public String go(String pathPage) {
        return pathPage;
    }

}
