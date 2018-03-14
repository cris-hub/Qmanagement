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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SMEGS
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByIdRoles", query = "SELECT r FROM Rol r WHERE r.idRoles = :idRoles")
    , @NamedQuery(name = "Rol.findByDescripcion", query = "SELECT r FROM Rol r WHERE r.descripcion = :descripcion")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRoles")
    private Integer idRoles;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "roles_usuarios", joinColumns = {
        @JoinColumn(name = "idrol", referencedColumnName = "idRoles")}, inverseJoinColumns = {
        @JoinColumn(name = "idusuario", referencedColumnName = "idUsuarios")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    @ManyToMany(mappedBy = "rolCollection")
    private Collection<Acceso> accesoCollection;

    public Rol() {
    }

    public Rol(Integer idRoles) {
        this.idRoles = idRoles;
    }

    public Integer getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(Integer idRoles) {
        this.idRoles = idRoles;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Acceso> getAccesoCollection() {
        return accesoCollection;
    }

    public void setAccesoCollection(Collection<Acceso> accesoCollection) {
        this.accesoCollection = accesoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoles != null ? idRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRoles == null && other.idRoles != null) || (this.idRoles != null && !this.idRoles.equals(other.idRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.racingword.qmanagement.Rol[ idRoles=" + idRoles + " ]";
    }
    
}
