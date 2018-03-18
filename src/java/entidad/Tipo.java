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
@Table(name = "tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t")
    , @NamedQuery(name = "Tipo.findByIdtipo", query = "SELECT t FROM Tipo t WHERE t.idtipo = :idtipo")
    , @NamedQuery(name = "Tipo.findByTipo", query = "SELECT t FROM Tipo t WHERE t.tipo = :tipo")})
public class Tipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo")
    private Integer idtipo;
    @Size(max = 255)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(mappedBy = "tipo", fetch = FetchType.EAGER)
    private List<Incidente> incidenteList;

    public Tipo() {
    }

    public Tipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo)) {
            return false;
        }
        Tipo other = (Tipo) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Tipo[ idtipo=" + idtipo + " ]";
    }
    
}
