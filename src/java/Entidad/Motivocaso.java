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
@Table(name = "motivocaso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivocaso.findAll", query = "SELECT m FROM Motivocaso m")
    , @NamedQuery(name = "Motivocaso.findByIdmotivo", query = "SELECT m FROM Motivocaso m WHERE m.idmotivo = :idmotivo")
    , @NamedQuery(name = "Motivocaso.findByMotivoNombre", query = "SELECT m FROM Motivocaso m WHERE m.motivoNombre = :motivoNombre")})
public class Motivocaso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotivo")
    private Integer idmotivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "motivoNombre")
    private String motivoNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmotivo")
    private Collection<Casodeprueba> casodepruebaCollection;

    public Motivocaso() {
    }

    public Motivocaso(Integer idmotivo) {
        this.idmotivo = idmotivo;
    }

    public Motivocaso(Integer idmotivo, String motivoNombre) {
        this.idmotivo = idmotivo;
        this.motivoNombre = motivoNombre;
    }

    public Integer getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Integer idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getMotivoNombre() {
        return motivoNombre;
    }

    public void setMotivoNombre(String motivoNombre) {
        this.motivoNombre = motivoNombre;
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
        hash += (idmotivo != null ? idmotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motivocaso)) {
            return false;
        }
        Motivocaso other = (Motivocaso) object;
        if ((this.idmotivo == null && other.idmotivo != null) || (this.idmotivo != null && !this.idmotivo.equals(other.idmotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Motivocaso[ idmotivo=" + idmotivo + " ]";
    }
    
}
