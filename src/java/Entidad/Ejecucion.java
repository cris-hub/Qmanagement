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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ejecucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejecucion.findAll", query = "SELECT e FROM Ejecucion e")
    , @NamedQuery(name = "Ejecucion.findByIdEjecucion", query = "SELECT e FROM Ejecucion e WHERE e.idEjecucion = :idEjecucion")
    , @NamedQuery(name = "Ejecucion.findByRutaEjecucion", query = "SELECT e FROM Ejecucion e WHERE e.rutaEjecucion = :rutaEjecucion")})
public class Ejecucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEjecucion")
    private Integer idEjecucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "rutaEjecucion")
    private String rutaEjecucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEjecucion")
    private Collection<Incidente> incidenteCollection;
    @JoinColumn(name = "idCasoPrueba", referencedColumnName = "idCasodePrueba")
    @ManyToOne(optional = false)
    private Casodeprueba idCasoPrueba;
    @JoinColumn(name = "idEjecuciones", referencedColumnName = "idejecuciones")
    @ManyToOne(optional = false)
    private Ejecuciones idEjecuciones;

    public Ejecucion() {
    }

    public Ejecucion(Integer idEjecucion) {
        this.idEjecucion = idEjecucion;
    }

    public Ejecucion(Integer idEjecucion, String rutaEjecucion) {
        this.idEjecucion = idEjecucion;
        this.rutaEjecucion = rutaEjecucion;
    }

    public Integer getIdEjecucion() {
        return idEjecucion;
    }

    public void setIdEjecucion(Integer idEjecucion) {
        this.idEjecucion = idEjecucion;
    }

    public String getRutaEjecucion() {
        return rutaEjecucion;
    }

    public void setRutaEjecucion(String rutaEjecucion) {
        this.rutaEjecucion = rutaEjecucion;
    }

    @XmlTransient
    public Collection<Incidente> getIncidenteCollection() {
        return incidenteCollection;
    }

    public void setIncidenteCollection(Collection<Incidente> incidenteCollection) {
        this.incidenteCollection = incidenteCollection;
    }

    public Casodeprueba getIdCasoPrueba() {
        return idCasoPrueba;
    }

    public void setIdCasoPrueba(Casodeprueba idCasoPrueba) {
        this.idCasoPrueba = idCasoPrueba;
    }

    public Ejecuciones getIdEjecuciones() {
        return idEjecuciones;
    }

    public void setIdEjecuciones(Ejecuciones idEjecuciones) {
        this.idEjecuciones = idEjecuciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEjecucion != null ? idEjecucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejecucion)) {
            return false;
        }
        Ejecucion other = (Ejecucion) object;
        if ((this.idEjecucion == null && other.idEjecucion != null) || (this.idEjecucion != null && !this.idEjecucion.equals(other.idEjecucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Ejecucion[ idEjecucion=" + idEjecucion + " ]";
    }
    
}
