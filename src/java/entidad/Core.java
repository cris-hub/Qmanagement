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
@Table(name = "core")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Core.findAll", query = "SELECT c FROM Core c")
    , @NamedQuery(name = "Core.findByIdCore", query = "SELECT c FROM Core c WHERE c.idCore = :idCore")
    , @NamedQuery(name = "Core.findByNombreCore", query = "SELECT c FROM Core c WHERE c.nombreCore = :nombreCore")})
public class Core implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCore")
    private Integer idCore;
    @Size(max = 255)
    @Column(name = "nombreCore")
    private String nombreCore;
    @OneToMany(mappedBy = "idCore", fetch = FetchType.EAGER)
    private List<Incidente> incidenteList;

    public Core() {
    }

    public Core(Integer idCore) {
        this.idCore = idCore;
    }

    public Integer getIdCore() {
        return idCore;
    }

    public void setIdCore(Integer idCore) {
        this.idCore = idCore;
    }

    public String getNombreCore() {
        return nombreCore;
    }

    public void setNombreCore(String nombreCore) {
        this.nombreCore = nombreCore;
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
        hash += (idCore != null ? idCore.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Core)) {
            return false;
        }
        Core other = (Core) object;
        if ((this.idCore == null && other.idCore != null) || (this.idCore != null && !this.idCore.equals(other.idCore))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Core[ idCore=" + idCore + " ]";
    }
    
}
