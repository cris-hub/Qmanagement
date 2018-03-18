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
@Table(name = "severidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Severidad.findAll", query = "SELECT s FROM Severidad s")
    , @NamedQuery(name = "Severidad.findByIdseveridad", query = "SELECT s FROM Severidad s WHERE s.idseveridad = :idseveridad")
    , @NamedQuery(name = "Severidad.findBySeveridadnombre", query = "SELECT s FROM Severidad s WHERE s.severidadnombre = :severidadnombre")})
public class Severidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idseveridad")
    private Integer idseveridad;
    @Size(max = 255)
    @Column(name = "severidadnombre")
    private String severidadnombre;
    @OneToMany(mappedBy = "severidad", fetch = FetchType.EAGER)
    private List<Incidente> incidenteList;

    public Severidad() {
    }

    public Severidad(Integer idseveridad) {
        this.idseveridad = idseveridad;
    }

    public Integer getIdseveridad() {
        return idseveridad;
    }

    public void setIdseveridad(Integer idseveridad) {
        this.idseveridad = idseveridad;
    }

    public String getSeveridadnombre() {
        return severidadnombre;
    }

    public void setSeveridadnombre(String severidadnombre) {
        this.severidadnombre = severidadnombre;
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
        hash += (idseveridad != null ? idseveridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Severidad)) {
            return false;
        }
        Severidad other = (Severidad) object;
        if ((this.idseveridad == null && other.idseveridad != null) || (this.idseveridad != null && !this.idseveridad.equals(other.idseveridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Severidad[ idseveridad=" + idseveridad + " ]";
    }
    
}
