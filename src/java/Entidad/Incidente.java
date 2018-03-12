/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "incidente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidente.findAll", query = "SELECT i FROM Incidente i")
    , @NamedQuery(name = "Incidente.findByIdIncidentes", query = "SELECT i FROM Incidente i WHERE i.idIncidentes = :idIncidentes")
    , @NamedQuery(name = "Incidente.findByDescripcion", query = "SELECT i FROM Incidente i WHERE i.descripcion = :descripcion")})
public class Incidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIncidentes")
    private Integer idIncidentes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "tipo", referencedColumnName = "idtipo")
    @ManyToOne(optional = false)
    private Tipo tipo;
    @JoinColumn(name = "idPrioridad", referencedColumnName = "idprioridad")
    @ManyToOne(optional = false)
    private Prioridad idPrioridad;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuario idUsuarios;
    @JoinColumn(name = "idEjecucion", referencedColumnName = "idEjecucion")
    @ManyToOne(optional = false)
    private Ejecucion idEjecucion;
    @JoinColumn(name = "naturaleza", referencedColumnName = "idNaturaleza")
    @ManyToOne(optional = false)
    private Naturaleza naturaleza;
    @JoinColumn(name = "severidad", referencedColumnName = "idseveridad")
    @ManyToOne(optional = false)
    private Severidad severidad;
    @JoinColumn(name = "idCore", referencedColumnName = "idCore")
    @ManyToOne(optional = false)
    private Core idCore;

    public Incidente() {
    }

    public Incidente(Integer idIncidentes) {
        this.idIncidentes = idIncidentes;
    }

    public Incidente(Integer idIncidentes, String descripcion) {
        this.idIncidentes = idIncidentes;
        this.descripcion = descripcion;
    }

    public Integer getIdIncidentes() {
        return idIncidentes;
    }

    public void setIdIncidentes(Integer idIncidentes) {
        this.idIncidentes = idIncidentes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Prioridad getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Prioridad idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public Usuario getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuario idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Ejecucion getIdEjecucion() {
        return idEjecucion;
    }

    public void setIdEjecucion(Ejecucion idEjecucion) {
        this.idEjecucion = idEjecucion;
    }

    public Naturaleza getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(Naturaleza naturaleza) {
        this.naturaleza = naturaleza;
    }

    public Severidad getSeveridad() {
        return severidad;
    }

    public void setSeveridad(Severidad severidad) {
        this.severidad = severidad;
    }

    public Core getIdCore() {
        return idCore;
    }

    public void setIdCore(Core idCore) {
        this.idCore = idCore;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIncidentes != null ? idIncidentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidente)) {
            return false;
        }
        Incidente other = (Incidente) object;
        if ((this.idIncidentes == null && other.idIncidentes != null) || (this.idIncidentes != null && !this.idIncidentes.equals(other.idIncidentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Incidente[ idIncidentes=" + idIncidentes + " ]";
    }
    
}
