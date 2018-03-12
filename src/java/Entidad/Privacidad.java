/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "privacidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privacidad.findAll", query = "SELECT p FROM Privacidad p")
    , @NamedQuery(name = "Privacidad.findByIdvisibilidad", query = "SELECT p FROM Privacidad p WHERE p.idvisibilidad = :idvisibilidad")
    , @NamedQuery(name = "Privacidad.findByVisibilidadTipo", query = "SELECT p FROM Privacidad p WHERE p.visibilidadTipo = :visibilidadTipo")})
public class Privacidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvisibilidad")
    private Integer idvisibilidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "visibilidadTipo")
    private String visibilidadTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprivacidad")
    private Collection<Escenario> escenarioCollection;

    public Privacidad() {
    }

    public Privacidad(Integer idvisibilidad) {
        this.idvisibilidad = idvisibilidad;
    }

    public Privacidad(Integer idvisibilidad, String visibilidadTipo) {
        this.idvisibilidad = idvisibilidad;
        this.visibilidadTipo = visibilidadTipo;
    }

    public Integer getIdvisibilidad() {
        return idvisibilidad;
    }

    public void setIdvisibilidad(Integer idvisibilidad) {
        this.idvisibilidad = idvisibilidad;
    }

    public String getVisibilidadTipo() {
        return visibilidadTipo;
    }

    public void setVisibilidadTipo(String visibilidadTipo) {
        this.visibilidadTipo = visibilidadTipo;
    }

    @XmlTransient
    public Collection<Escenario> getEscenarioCollection() {
        return escenarioCollection;
    }

    public void setEscenarioCollection(Collection<Escenario> escenarioCollection) {
        this.escenarioCollection = escenarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvisibilidad != null ? idvisibilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privacidad)) {
            return false;
        }
        Privacidad other = (Privacidad) object;
        if ((this.idvisibilidad == null && other.idvisibilidad != null) || (this.idvisibilidad != null && !this.idvisibilidad.equals(other.idvisibilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Privacidad[ idvisibilidad=" + idvisibilidad + " ]";
    }
    
}
