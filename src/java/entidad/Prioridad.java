/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author samuel
 */
@Entity
@Table(name = "prioridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridad.findAll", query = "SELECT p FROM Prioridad p")
    , @NamedQuery(name = "Prioridad.findByIdprioridad", query = "SELECT p FROM Prioridad p WHERE p.idprioridad = :idprioridad")
    , @NamedQuery(name = "Prioridad.findByNombrePrioridad", query = "SELECT p FROM Prioridad p WHERE p.nombrePrioridad = :nombrePrioridad")})
public class Prioridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprioridad")
    private Integer idprioridad;
    @Size(max = 255)
    @Column(name = "nombrePrioridad")
    private String nombrePrioridad;
    @OneToMany(mappedBy = "idPrioridad", fetch = FetchType.EAGER)
    private List<Incidente> incidenteList;

    public Prioridad() {
    }

    public Prioridad(Integer idprioridad) {
        this.idprioridad = idprioridad;
    }

    public Integer getIdprioridad() {
        return idprioridad;
    }

    public void setIdprioridad(Integer idprioridad) {
        this.idprioridad = idprioridad;
    }

    public String getNombrePrioridad() {
        return nombrePrioridad;
    }

    public void setNombrePrioridad(String nombrePrioridad) {
        this.nombrePrioridad = nombrePrioridad;
    }

    @XmlTransient
    public List<Incidente> getIncidenteList() {
        return incidenteList;
    }

    public void setIncidenteList(List<Incidente> incidenteList) {
        this.incidenteList = incidenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprioridad != null ? idprioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioridad)) {
            return false;
        }
        Prioridad other = (Prioridad) object;
        if ((this.idprioridad == null && other.idprioridad != null) || (this.idprioridad != null && !this.idprioridad.equals(other.idprioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Prioridad[ idprioridad=" + idprioridad + " ]";
    }
    
}
