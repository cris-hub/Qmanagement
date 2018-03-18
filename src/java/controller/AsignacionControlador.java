package controller;

import entidad.Asignacion;
import entidad.Core;
import entidad.Escenario;
import entidad.Usuario;
import facade.AsignacionFacade;
import facade.CoreFacade;
import facade.EscenarioFacade;
import facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "asignacionControlador")
@SessionScoped
public class AsignacionControlador implements Serializable {

    @EJB
    AsignacionFacade asignacionFacade;
    Asignacion asignacionNueva = new Asignacion();

    @EJB
    EscenarioFacade escenarioFacade;
    Escenario escenario = new Escenario();

    @EJB
    CoreFacade coreFacade;
    Core core = new Core();

    @EJB
    UsuarioFacade calidadFacade;
    Usuario calidad = new Usuario();

    @EJB
    UsuarioFacade pruebaFacade;
    Usuario prueba = new Usuario();

    @EJB
    UsuarioFacade desarrolloFacade;
    Usuario desarrollo = new Usuario();

    public AsignacionControlador() {
    }

    public AsignacionFacade getAsignacionFacade() {
        return asignacionFacade;
    }

    public void setAsignacionFacade(AsignacionFacade asignacionFacade) {
        this.asignacionFacade = asignacionFacade;
    }

    public Asignacion getAsignacionNueva() {
        return asignacionNueva;
    }

    public void setAsignacionNueva(Asignacion asignacionNueva) {
        this.asignacionNueva = asignacionNueva;
    }

    public EscenarioFacade getEscenarioFacade() {
        return escenarioFacade;
    }

    public void setEscenarioFacade(EscenarioFacade escenarioFacade) {
        this.escenarioFacade = escenarioFacade;
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }

    public CoreFacade getCoreFacade() {
        return coreFacade;
    }

    public void setCoreFacade(CoreFacade coreFacade) {
        this.coreFacade = coreFacade;
    }

    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }

    public UsuarioFacade getCalidadFacade() {
        return calidadFacade;
    }

    public void setCalidadFacade(UsuarioFacade calidadFacade) {
        this.calidadFacade = calidadFacade;
    }

    public Usuario getCalidad() {
        return calidad;
    }

    public void setCalidad(Usuario calidad) {
        this.calidad = calidad;
    }

    public UsuarioFacade getPruebaFacade() {
        return pruebaFacade;
    }

    public void setPruebaFacade(UsuarioFacade pruebaFacade) {
        this.pruebaFacade = pruebaFacade;
    }

    public Usuario getPrueba() {
        return prueba;
    }

    public void setPrueba(Usuario prueba) {
        this.prueba = prueba;
    }

    public UsuarioFacade getDesarrolloFacade() {
        return desarrolloFacade;
    }

    public void setDesarrolloFacade(UsuarioFacade desarrolloFacade) {
        this.desarrolloFacade = desarrolloFacade;
    }

    public Usuario getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(Usuario desarrollo) {
        this.desarrollo = desarrollo;
    }

    public List<Escenario> listaEscenarios() {
        return escenarioFacade.findAll();
    }

    public List<Core> listaCores() {
        return coreFacade.findAll();
    }

    public List<Usuario> listaCalidadUsuarios() {
        return calidadFacade.findAll();
    }

    public List<Usuario> listaPruebaUsuarios() {
        return pruebaFacade.findAll();
    }

    public List<Usuario> listaDesarrolloUsuarios() {
        return desarrolloFacade.findAll();
    }
//METODO PARA LA CREACION DE UN ESCENARIO DE UN PROYECTO
    public String crearAsignacion() {
        FacesMessage message = null;
        try {
            asignacionNueva.setIdasignacion(asignacionNueva.getIdasignacion());
            asignacionNueva.setFechainicial(asignacionNueva.getFechainicial());
            asignacionNueva.setFechafinal(asignacionNueva.getFechafinal());
            

            asignacionFacade.create(asignacionNueva);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignacion Exitosa", "La Asignacion se realizo Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        asignacionNueva = new Asignacion();

        FacesContext.getCurrentInstance().addMessage(null, message);

        return "/Paginas/AsignacionProyectos/listaasignaciones?faces-redirect=true";
    }

    public List<Asignacion> listaAsignaciones() {
        return asignacionFacade.findAll();
    }

    public String eliminarAsignacion(Asignacion as) {
        FacesMessage message = null;
        try {
            asignacionFacade.remove(as);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminacion Exitosa", "La Asignacion fue Eliminado Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "/Paginas/AsignacionProyectos/listaasignaciones?faces-redirect=true";
    }

    public String seleccionarAsignacion(Asignacion as) {
        FacesMessage message = null;
        try {
            asignacionNueva = as;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Seleccion Correcta", "El Escenario fue seleccionado Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "/Paginas/AsignacionProyectos/actualizacionasignacion?faces-redirect=true";
    }

    public String editarAsignacion() {
        FacesMessage message = null;
        try {
            asignacionFacade.edit(asignacionNueva);
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Edicion Terminada", "La Asignacion fue Editada Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "/Paginas/AsignacionProyectos/listaasignaciones?faces-redirect=true";
    }

}
