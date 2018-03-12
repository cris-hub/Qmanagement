/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Entidad.Asignacion;
import Entidad.Casodeprueba;
import Entidad.Estadocaso;
import Entidad.Motivocaso;

import Facade.AsignacionFacade;
import Facade.CasodepruebaFacade;
import Facade.EstadocasoFacade;
import Facade.MotivocasoFacade;

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
@Named(value = "casosPruebaControlador")
@SessionScoped
public class DisenoCasosPruebaControlador implements Serializable {

    @EJB
    CasodepruebaFacade casodepruebaFacade;
    Casodeprueba casodepruebaNuevo = new Casodeprueba();

    @EJB
    EstadocasoFacade estadocasoFacade;
    Estadocaso estadocaso = new Estadocaso();


    @EJB
    MotivocasoFacade motivocasoFacade;
    Motivocaso motivocaso = new Motivocaso();

    @EJB
    AsignacionFacade asignacionFacade;
    Asignacion asignacion = new Asignacion();

    public CasodepruebaFacade getCasodepruebaFacade() {
        return casodepruebaFacade;
    }

    public void setCasodepruebaFacade(CasodepruebaFacade casodepruebaFacade) {
        this.casodepruebaFacade = casodepruebaFacade;
    }

    public Casodeprueba getCasodepruebaNuevo() {
        return casodepruebaNuevo;
    }

    public void setCasodepruebaNuevo(Casodeprueba casodepruebaNuevo) {
        this.casodepruebaNuevo = casodepruebaNuevo;
    }

    public EstadocasoFacade getEstadocasoFacade() {
        return estadocasoFacade;
    }

    public void setEstadocasoFacade(EstadocasoFacade estadocasoFacade) {
        this.estadocasoFacade = estadocasoFacade;
    }

    public Estadocaso getEstadocaso() {
        return estadocaso;
    }

    public void setEstadocaso(Estadocaso estadocaso) {
        this.estadocaso = estadocaso;
    }


    public MotivocasoFacade getMotivocasoFacade() {
        return motivocasoFacade;
    }

    public void setMotivocasoFacade(MotivocasoFacade motivocasoFacade) {
        this.motivocasoFacade = motivocasoFacade;
    }

    public Motivocaso getMotivocaso() {
        return motivocaso;
    }

    public void setMotivocaso(Motivocaso motivocaso) {
        this.motivocaso = motivocaso;
    }

    public AsignacionFacade getAsignacionFacade() {
        return asignacionFacade;
    }

    public void setAsignacionFacade(AsignacionFacade asignacionFacade) {
        this.asignacionFacade = asignacionFacade;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public List<Asignacion> listaAsignaciones() {
        return asignacionFacade.findAll();
    }

    public List<Estadocaso> listaEstadosCasos() {
        return estadocasoFacade.findAll();
    }

    public List<Motivocaso> listaMotivos() {
        return motivocasoFacade.findAll();
    }

    public DisenoCasosPruebaControlador() {
    }

    public String creacionCasodePrueba() {
        FacesMessage message = null;
        try {
            casodepruebaNuevo.setIdCasodePrueba(casodepruebaNuevo.getIdCasodePrueba());
            casodepruebaNuevo.setIdAsignacion(asignacionFacade.find(asignacion.getIdasignacion()));
            casodepruebaNuevo.setTipoVisibilidad(estadocasoFacade.find(estadocaso.getIdestado()));
            casodepruebaNuevo.setTipoDeCaso(casodepruebaNuevo.getTipoDeCaso());
            casodepruebaNuevo.setIdmotivo(motivocasoFacade.find(motivocaso.getIdmotivo()));
            casodepruebaNuevo.setRutaModulo(casodepruebaNuevo.getRutaModulo());
            casodepruebaNuevo.setObservaciones(casodepruebaNuevo.getRutaModulo());

            casodepruebaFacade.create(casodepruebaNuevo);

            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Diseño de caso Creado", "La Asignacion se realizo Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        casodepruebaNuevo = new Casodeprueba();

        FacesContext.getCurrentInstance().addMessage(null, message);

        return "/Paginas/DisenoCasosDePrueba/listadedisenos?faces-redirect=true";
    }

    public String eliminarDiseno(Casodeprueba capr) {
        FacesMessage message = null;
        try {
            casodepruebaFacade.remove(capr);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminacion Exitosa", "EL diseño fue Eliminado Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);

        return "/Paginas/DisenoCasosDePrueba/listadedisenos?faces-redirect=true";

    }
    
     public String seleccionarDiseno(Casodeprueba capr) {
        FacesMessage message = null;
        try {
            casodepruebaNuevo = capr;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Seleccion Correcta", "El diseño fue seleccionado Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "/Paginas/DisenoCasosDePrueba/actualizaciondiseno?faces-redirect=true";
    }

    public String editarAsignacion() {
        FacesMessage message = null;
        try {
            casodepruebaFacade.edit(casodepruebaNuevo);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Edicion Terminada", "El diseño fue Editado Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        return "/Paginas/DisenoCasosDePrueba/listadedisenos?faces-redirect=true";
    }

    public List<Casodeprueba> listaCasosDePrueba() {
        return casodepruebaFacade.findAll();
    }
}
