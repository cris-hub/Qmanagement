/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Qmanagement.controllers;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author SMEGS
 */
@Named(value = "loginController")
@RequestScoped
public class loginController {

    private String nombre;

    @PostConstruct
    public void init(){
    decide();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String decide() {

       
            return "ok";

        

    }
    

}
