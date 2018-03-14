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
@Table(name = "ejecuciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlEjecucion.findAll", query = "SELECT c FROM ControlEjecucion c")
    , @NamedQuery(name = "ControlEjecucion.findByIdejecuciones", query = "SELECT c FROM ControlEjecucion c WHERE c.idejecuciones = :idejecuciones")
    , @NamedQuery(name = "ControlEjecucion.findByResultadosNombre", query = "SELECT c FROM ControlEjecucion c WHERE c.resultadosNombre = :resultadosNombre")})
public class ControlEjecucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idejecuciones")
    private Integer idejecuciones;
    @Size(max = 255)
    @Column(name = "resultadosNombre")
    private String resultadosNombre;
    @OneToMany(mappedBy = "idEjecuciones")
    private Collection<Ejecucion> ejecucionCollection;

    public ControlEjecucion() {
    }

    public ControlEjecucion(Integer idejecuciones) {
        this.idejecuciones = idejecuciones;
    }

    public Integer getIdejecuciones() {
        return idejecuciones;
    }

    public void setIdejecuciones(Integer idejecuciones) {
        this.idejecuciones = idejecuciones;
    }

    public String getResultadosNombre() {
        return resultadosNombre;
    }

    public void setResultadosNombre(String resultadosNombre) {
        this.resultadosNombre = resultadosNombre;
    }

    @XmlTransient
    public Collection<Ejecucion> getEjecucionCollection() {
        return ejecucionCollection;
    }

    public void setEjecucionCollection(Collection<Ejecucion> ejecucionCollection) {
        this.ejecucionCollection = ejecucionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idejecuciones != null ? idejecuciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlEjecucion)) {
            return false;
        }
        ControlEjecucion other = (ControlEjecucion) object;
        if ((this.idejecuciones == null && other.idejecuciones != null) || (this.idejecuciones != null && !this.idejecuciones.equals(other.idejecuciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.racingword.qmanagement.ControlEjecucion[ idejecuciones=" + idejecuciones + " ]";
    }
    
}
