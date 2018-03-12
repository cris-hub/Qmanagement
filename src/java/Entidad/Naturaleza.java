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
@Table(name = "naturaleza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Naturaleza.findAll", query = "SELECT n FROM Naturaleza n")
    , @NamedQuery(name = "Naturaleza.findByIdNaturaleza", query = "SELECT n FROM Naturaleza n WHERE n.idNaturaleza = :idNaturaleza")
    , @NamedQuery(name = "Naturaleza.findByNaturalezaNombre", query = "SELECT n FROM Naturaleza n WHERE n.naturalezaNombre = :naturalezaNombre")})
public class Naturaleza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNaturaleza")
    private Integer idNaturaleza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "naturalezaNombre")
    private String naturalezaNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "naturaleza")
    private Collection<Incidente> incidenteCollection;

    public Naturaleza() {
    }

    public Naturaleza(Integer idNaturaleza) {
        this.idNaturaleza = idNaturaleza;
    }

    public Naturaleza(Integer idNaturaleza, String naturalezaNombre) {
        this.idNaturaleza = idNaturaleza;
        this.naturalezaNombre = naturalezaNombre;
    }

    public Integer getIdNaturaleza() {
        return idNaturaleza;
    }

    public void setIdNaturaleza(Integer idNaturaleza) {
        this.idNaturaleza = idNaturaleza;
    }

    public String getNaturalezaNombre() {
        return naturalezaNombre;
    }

    public void setNaturalezaNombre(String naturalezaNombre) {
        this.naturalezaNombre = naturalezaNombre;
    }

    @XmlTransient
    public Collection<Incidente> getIncidenteCollection() {
        return incidenteCollection;
    }

    public void setIncidenteCollection(Collection<Incidente> incidenteCollection) {
        this.incidenteCollection = incidenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNaturaleza != null ? idNaturaleza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Naturaleza)) {
            return false;
        }
        Naturaleza other = (Naturaleza) object;
        if ((this.idNaturaleza == null && other.idNaturaleza != null) || (this.idNaturaleza != null && !this.idNaturaleza.equals(other.idNaturaleza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Naturaleza[ idNaturaleza=" + idNaturaleza + " ]";
    }
    
}
