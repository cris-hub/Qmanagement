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
@Table(name = "ejecuciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ejecuciones.findAll", query = "SELECT e FROM Ejecuciones e")
    , @NamedQuery(name = "Ejecuciones.findByIdejecuciones", query = "SELECT e FROM Ejecuciones e WHERE e.idejecuciones = :idejecuciones")
    , @NamedQuery(name = "Ejecuciones.findByResultadosNombre", query = "SELECT e FROM Ejecuciones e WHERE e.resultadosNombre = :resultadosNombre")})
public class Ejecuciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idejecuciones")
    private Integer idejecuciones;
    @Size(max = 255)
    @Column(name = "resultadosNombre")
    private String resultadosNombre;
    @OneToMany(mappedBy = "idEjecuciones", fetch = FetchType.EAGER)
    private List<Ejecucion> ejecucionList;

    public Ejecuciones() {
    }

    public Ejecuciones(Integer idejecuciones) {
        this.idejecuciones = idejecuciones;
    }

    public Integer getIdejecuciones() {
        return idejecuciones;
    }

    public void setIdejecuciones(Integer idejecuciones) {
        this.idejecuciones = idejecuciones;
    }

    public String getResultadosNombre() {
        return resultadosNombre;
    }

    public void setResultadosNombre(String resultadosNombre) {
        this.resultadosNombre = resultadosNombre;
    }

    @XmlTransient
    public List<Ejecucion> getEjecucionList() {
        return ejecucionList;
    }

    public void setEjecucionList(List<Ejecucion> ejecucionList) {
        this.ejecucionList = ejecucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idejecuciones != null ? idejecuciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejecuciones)) {
            return false;
        }
        Ejecuciones other = (Ejecuciones) object;
        if ((this.idejecuciones == null && other.idejecuciones != null) || (this.idejecuciones != null && !this.idejecuciones.equals(other.idejecuciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Ejecuciones[ idejecuciones=" + idejecuciones + " ]";
    }
    
}
