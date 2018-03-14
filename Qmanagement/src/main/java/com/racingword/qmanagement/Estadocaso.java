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
@Table(name = "estadocaso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadocaso.findAll", query = "SELECT e FROM Estadocaso e")
    , @NamedQuery(name = "Estadocaso.findByIdestado", query = "SELECT e FROM Estadocaso e WHERE e.idestado = :idestado")
    , @NamedQuery(name = "Estadocaso.findByEstadoCaso", query = "SELECT e FROM Estadocaso e WHERE e.estadoCaso = :estadoCaso")})
public class Estadocaso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestado")
    private Integer idestado;
    @Size(max = 255)
    @Column(name = "estadoCaso")
    private String estadoCaso;
    @OneToMany(mappedBy = "tipoVisibilidad")
    private Collection<Casodeprueba> casodepruebaCollection;

    public Estadocaso() {
    }

    public Estadocaso(Integer idestado) {
        this.idestado = idestado;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public String getEstadoCaso() {
        return estadoCaso;
    }

    public void setEstadoCaso(String estadoCaso) {
        this.estadoCaso = estadoCaso;
    }

    @XmlTransient
    public Collection<Casodeprueba> getCasodepruebaCollection() {
        return casodepruebaCollection;
    }

    public void setCasodepruebaCollection(Collection<Casodeprueba> casodepruebaCollection) {
        this.casodepruebaCollection = casodepruebaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestado != null ? idestado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocaso)) {
            return false;
        }
        Estadocaso other = (Estadocaso) object;
        if ((this.idestado == null && other.idestado != null) || (this.idestado != null && !this.idestado.equals(other.idestado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.racingword.qmanagement.Estadocaso[ idestado=" + idestado + " ]";
    }
    
}
