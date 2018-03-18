/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entidad.Escenario;
import entidad.Estado;
import entidad.Privacidad;

import facade.EscenarioFacade;
import facade.EstadoFacade;
import facade.PrivacidadFacade;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author dell
 */
@Named(value = "escenarioControlador")
@SessionScoped
public class EscenarioControlador implements Serializable {



    @EJB
    EscenarioFacade escenarioFacade;
    Escenario escenarioNuevo = new Escenario();
    
     @EJB
    EstadoFacade estadoFacade;
    Estado estado = new Estado();
    @EJB
    PrivacidadFacade privacidadFacade;
    Privacidad privacidad = new Privacidad();

    public EscenarioControlador() {
    }

    public EscenarioFacade getEscenarioFacade() {
        return escenarioFacade;
    }

    public void setEscenarioFacade(EscenarioFacade escenarioFacade) {
        this.escenarioFacade = escenarioFacade;
    }

    public Escenario getEscenarioNuevo() {
        return escenarioNuevo;
    }

    public void setEscenarioNuevo(Escenario escenarioNuevo) {
        this.escenarioNuevo = escenarioNuevo;
    }

    public EstadoFacade getEstadoFacade() {
        return estadoFacade;
    }

    public void setEstadoFacade(EstadoFacade estadoFacade) {
        this.estadoFacade = estadoFacade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public PrivacidadFacade getPrivacidadFacade() {
        return privacidadFacade;
    }

    public void setPrivacidadFacade(PrivacidadFacade privacidadFacade) {
        this.privacidadFacade = privacidadFacade;
    }

    public Privacidad getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(Privacidad privacidad) {
        this.privacidad = privacidad;
    }
 public String crearEscenario() {
        FacesMessage message;
        try {
            escenarioNuevo.setIdEscenario(escenarioNuevo.getIdEscenario());
            escenarioNuevo.setProyecto(escenarioNuevo.getProyecto());
            escenarioNuevo.setIdestado(estadoFacade.find(estado.getIdEstado()));
            escenarioNuevo.setIdprivacidad(privacidadFacade.find(privacidad.getIdvisibilidad()));
            escenarioNuevo.setEspecificaciondeProyecto(escenarioNuevo.getEspecificaciondeProyecto());
            escenarioNuevo.setRutaArchivos(escenarioNuevo.getRutaArchivos());

            escenarioFacade.create(escenarioNuevo);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingreso correcto", "El Escenario fue creado correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
         escenarioNuevo = new Escenario();
        FacesContext.getCurrentInstance().addMessage(null, message);
       
        return "/Paginas/CreacionEscenarios/listaescenarios?faces-redirect=true";
    }

    public String eliminarEscenario(Escenario es) {
        FacesMessage message = null;
        try {
            escenarioFacade.remove(es);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminacion Exitosa", "El Escenario fue Eliminado Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
         return "/Paginas/CreacionEscenarios/listaescenarios?faces-redirect=true";
    }

    public String seleccionarEscenario(Escenario es){
        FacesMessage message = null;
        try {
        escenarioNuevo = es;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Seleccion Correcta", "El Escenario fue seleccionado Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "/Paginas/CreacionEscenarios/actualizacionescenario?faces-redirect=true";
    }
        public String editarEscenario(){
              FacesMessage message = null;
        try {
            escenarioFacade.edit(escenarioNuevo);
             message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Edicion Terminada", "El Escenario fue Editado Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
            return "/Paginas/CreacionEscenarios/listaescenarios?faces-redirect=true";
        }
        
    
    public List<Escenario> listaEscenarios() {
        return escenarioFacade.findAll();
    }


    public List<Privacidad> listaVisibilidad() {
        return privacidadFacade.findAll();
    }

    public List<Estado> listaEstados() {
        return estadoFacade.findAll();
    }
}


