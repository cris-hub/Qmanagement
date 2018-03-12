/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Casodeprueba;
import Entidad.Ejecucion;
import Entidad.Ejecuciones;

import Facade.CasodepruebaFacade;
import Facade.EjecucionFacade;
import Facade.EjecucionesFacade;

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
@Named(value = "ejecucionCasosPrueba")
@SessionScoped
public class EjecucionCasosPrueba implements Serializable {

    @EJB
    EjecucionFacade ejecucionFacade;
    Ejecucion ejecucionNueva = new Ejecucion();

    @EJB
    EjecucionesFacade ejecucionesFacade;
    Ejecuciones ejecuciones = new Ejecuciones();

    @EJB
    CasodepruebaFacade casodepruebaFacade;
    Casodeprueba casodeprueba = new Casodeprueba();

    public EjecucionCasosPrueba() {
    }

    public EjecucionFacade getEjecucionFacade() {
        return ejecucionFacade;
    }

    public void setEjecucionFacade(EjecucionFacade ejecucionFacade) {
        this.ejecucionFacade = ejecucionFacade;
    }

    public Ejecucion getEjecucionNueva() {
        return ejecucionNueva;
    }

    public void setEjecucionNueva(Ejecucion ejecucionNueva) {
        this.ejecucionNueva = ejecucionNueva;
    }

    public EjecucionesFacade getEjecucionesFacade() {
        return ejecucionesFacade;
    }

    public void setEjecucionesFacade(EjecucionesFacade ejecucionesFacade) {
        this.ejecucionesFacade = ejecucionesFacade;
    }

    public Ejecuciones getEjecuciones() {
        return ejecuciones;
    }

    public void setEjecuciones(Ejecuciones ejecuciones) {
        this.ejecuciones = ejecuciones;
    }


    public CasodepruebaFacade getCasodepruebaFacade() {
        return casodepruebaFacade;
    }

    public void setCasodepruebaFacade(CasodepruebaFacade casodepruebaFacade) {
        this.casodepruebaFacade = casodepruebaFacade;
    }

    public Casodeprueba getCasodeprueba() {
        return casodeprueba;
    }

    public void setCasodeprueba(Casodeprueba casodeprueba) {
        this.casodeprueba = casodeprueba;
    }

    public List<Casodeprueba> listaCasosdePrueba() {
        return casodepruebaFacade.findAll();
    }

    public List<Ejecuciones> listaEjecuciones() {
        return ejecucionesFacade.findAll();
    }
    
    public String crearEjecucion(){
           FacesMessage message = null;
        try {
        ejecucionNueva.setIdEjecucion(ejecucionNueva.getIdEjecucion());
        ejecucionNueva.setIdCasoPrueba(casodepruebaFacade.find(casodeprueba.getIdCasodePrueba()));
        ejecucionNueva.setIdEjecuciones(ejecucionesFacade.find(ejecuciones.getIdejecuciones()));
        ejecucionNueva.setRutaEjecucion(ejecucionNueva.getRutaEjecucion());
        
        ejecucionFacade.create(ejecucionNueva);
         message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignacion Exitosa", "La Asignacion se realizo Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        } 
        ejecucionNueva = new Ejecucion();

        FacesContext.getCurrentInstance().addMessage(null, message);

        return"/Paginas/EjecucionCasosDePrueba/listaejecucionesdeprueba?faces-redirect=true";
    }
    
    public List<Ejecucion> listaEjecucionesCasos(){
        return ejecucionFacade.findAll();
    }
    
public String eliminarEjecucion(Ejecucion aj) {
        FacesMessage message = null;
        try {
            ejecucionFacade.remove(aj);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminacion Exitosa", "La Asignacion fue Eliminado Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
       return"/Paginas/EjecucionCasosDePrueba/listaejecucionesdeprueba?faces-redirect=true";
    }

    public String seleccionarEjecucion(Ejecucion ej) {
        FacesMessage message = null;
        try {
            ejecucionNueva = ej;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Seleccion Correcta", "El Escenario fue seleccionado Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
     return"/Paginas/EjecucionCasosDePrueba/actualizacionejecucion?faces-redirect=true";
    }

    public String editarEjecucion() {
        FacesMessage message = null;
        try {
            ejecucionFacade.edit(ejecucionNueva);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Edicion Terminada", "La Asignacion fue Editada Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
       return"/Paginas/EjecucionCasosDePrueba/listaejecucionesdeprueba?faces-redirect=true";
    }

}

