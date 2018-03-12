/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Entidad.Core;
import Entidad.Ejecucion;
import Entidad.Incidente;
import Entidad.Naturaleza;
import Entidad.Prioridad;
import Entidad.Severidad;
import Entidad.Tipo;
import Entidad.Usuario;
import Facade.CoreFacade;
import Facade.EjecucionFacade;
import Facade.IncidenteFacade;
import Facade.NaturalezaFacade;
import Facade.PrioridadFacade;
import Facade.SeveridadFacade;
import Facade.TipoFacade;
import Facade.UsuarioFacade;
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
@Named(value = "incidentesControlador")
@SessionScoped
public class IncidentesControlador implements Serializable {
    
    @EJB
    IncidenteFacade incidenteFacade;
    Incidente incidente = new Incidente();
    
    @EJB
    NaturalezaFacade naturalezaFacade;
    Naturaleza naturaleza = new Naturaleza();
    
    @EJB
    TipoFacade tipoFacade;
    Tipo tipo = new Tipo();
    
    @EJB
    SeveridadFacade severidadFacade;
    Severidad severidad = new Severidad();
    
    @EJB
    CoreFacade coreFacade;
    Core core = new Core();
    
    @EJB
    PrioridadFacade prioridadFacade;
    Prioridad prioridad = new Prioridad();
    
    @EJB 
    UsuarioFacade usuarioFacade;
    Usuario usuario = new Usuario();
    
    @EJB
    EjecucionFacade ejecucionFacade ;
    Ejecucion ejecucion = new Ejecucion();
    
    
    public IncidentesControlador() {
    }

    public IncidenteFacade getIncidenteFacade() {
        return incidenteFacade;
    }

    public void setIncidenteFacade(IncidenteFacade incidenteFacade) {
        this.incidenteFacade = incidenteFacade;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public NaturalezaFacade getNaturalezaFacade() {
        return naturalezaFacade;
    }

    public void setNaturalezaFacade(NaturalezaFacade naturalezaFacade) {
        this.naturalezaFacade = naturalezaFacade;
    }

    public Naturaleza getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(Naturaleza naturaleza) {
        this.naturaleza = naturaleza;
    }

    public TipoFacade getTipoFacade() {
        return tipoFacade;
    }

    public void setTipoFacade(TipoFacade tipoFacade) {
        this.tipoFacade = tipoFacade;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public SeveridadFacade getSeveridadFacade() {
        return severidadFacade;
    }

    public void setSeveridadFacade(SeveridadFacade severidadFacade) {
        this.severidadFacade = severidadFacade;
    }

    public Severidad getSeveridad() {
        return severidad;
    }

    public void setSeveridad(Severidad severidad) {
        this.severidad = severidad;
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

    public PrioridadFacade getPrioridadFacade() {
        return prioridadFacade;
    }

    public void setPrioridadFacade(PrioridadFacade prioridadFacade) {
        this.prioridadFacade = prioridadFacade;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public UsuarioFacade getUsuarioFacade() {
        return usuarioFacade;
    }

    public void setUsuarioFacade(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EjecucionFacade getEjecucionFacade() {
        return ejecucionFacade;
    }

    public void setEjecucionFacade(EjecucionFacade ejecucionFacade) {
        this.ejecucionFacade = ejecucionFacade;
    }

    public Ejecucion getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(Ejecucion ejecucion) {
        this.ejecucion = ejecucion;
    }
    public List<Usuario> listadeUsuarios(){
        return usuarioFacade.findAll();
    }
    
    public List<Tipo> listaTipos(){
        return tipoFacade.findAll();
    }
    public List<Prioridad> listaPrioridades(){
        return prioridadFacade.findAll();
    }
 
     public String ingresarIncidente(){
           FacesMessage message = null;
        try {
       incidente.setIdIncidentes(incidente.getIdIncidentes());
       incidente.setNaturaleza(naturalezaFacade.find(naturaleza.getIdNaturaleza()));
       incidente.setTipo(tipoFacade.find(tipo.getIdtipo()));
       incidente.setSeveridad(severidadFacade.find(severidad.getIdseveridad()));
       incidente.setIdCore(coreFacade.find(core.getIdCore()));
       incidente.setDescripcion(incidente.getDescripcion());
       incidente.setIdPrioridad(prioridadFacade.find(prioridad.getIdprioridad()));
       incidente.setIdUsuarios(usuarioFacade.find(usuario.getIdUsuarios()));
       incidente.setIdEjecucion(ejecucionFacade.find(ejecucion.getIdEjecucion()));
       
       incidenteFacade.create(incidente);
        
        
         message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignacion Exitosa", "La Asignacion se realizo Correctamente.");

        } catch (Exception e) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
        } 
        incidente = new Incidente();

        FacesContext.getCurrentInstance().addMessage(null, message);

        return"/Paginas/EjecucionCasosDePrueba/listaejecucionesdeprueba?faces-redirect=true";
    }
    
     public List<Incidente> listadeIncidentes(){
         return incidenteFacade.findAll();
     }
}
