/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.racingword.qmanagement;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SMEGS
 */
@Entity
@Table(name = "escenario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escenario.findAll", query = "SELECT e FROM Escenario e")
    , @NamedQuery(name = "Escenario.findByIdEscenario", query = "SELECT e FROM Escenario e WHERE e.idEscenario = :idEscenario")
    , @NamedQuery(name = "Escenario.findByEspecificaciondeProyecto", query = "SELECT e FROM Escenario e WHERE e.especificaciondeProyecto = :especificaciondeProyecto")
    , @NamedQuery(name = "Escenario.findByProyecto", query = "SELECT e FROM Escenario e WHERE e.proyecto = :proyecto")
    , @NamedQuery(name = "Escenario.findByRutaArchivos", query = "SELECT e FROM Escenario e WHERE e.rutaArchivos = :rutaArchivos")})
public class Escenario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEscenario")
    private Integer idEscenario;
    @Size(max = 255)
    @Column(name = "especificaciondeProyecto")
    private String especificaciondeProyecto;
    @Size(max = 255)
    @Column(name = "proyecto")
    private String proyecto;
    @Size(max = 255)
    @Column(name = "rutaArchivos")
    private String rutaArchivos;
    @OneToMany(mappedBy = "idEscenario")
    private Collection<Asignacion> asignacionCollection;
    @JoinColumn(name = "idestado", referencedColumnName = "idEstado")
    @ManyToOne
    private Estado idestado;
    @JoinColumn(name = "idprivacidad", referencedColumnName = "idvisibilidad")
    @ManyToOne
    private Privacidad idprivacidad;

    public Escenario() {
    }

    public Escenario(Integer idEscenario) {
        this.idEscenario = idEscenario;
    }

    public Integer getIdEscenario() {
        return idEscenario;
    }

    public void setIdEscenario(Integer idEscenario) {
        this.idEscenario = idEscenario;
    }

    public String getEspecificaciondeProyecto() {
        return especificaciondeProyecto;
    }

    public void setEspecificaciondeProyecto(String especificaciondeProyecto) {
        this.especificaciondeProyecto = especificaciondeProyecto;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getRutaArchivos() {
        return rutaArchivos;
    }

    public void setRutaArchivos(String rutaArchivos) {
        this.rutaArchivos = rutaArchivos;
    }

    @XmlTransient
    public Collection<Asignacion> getAsignacionCollection() {
        return asignacionCollection;
    }

    public void setAsignacionCollection(Collection<Asignacion> asignacionCollection) {
        this.asignacionCollection = asignacionCollection;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
    }

    public Privacidad getIdprivacidad() {
        return idprivacidad;
    }

    public void setIdprivacidad(Privacidad idprivacidad) {
        this.idprivacidad = idprivacidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscenario != null ? idEscenario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escenario)) {
            return false;
        }
        Escenario other = (Escenario) object;
        if ((this.idEscenario == null && other.idEscenario != null) || (this.idEscenario != null && !this.idEscenario.equals(other.idEscenario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.racingword.qmanagement.Escenario[ idEscenario=" + idEscenario + " ]";
    }
    
}
