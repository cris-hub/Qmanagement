/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "incidente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidente.findAll", query = "SELECT i FROM Incidente i")
    , @NamedQuery(name = "Incidente.findByIdIncidentes", query = "SELECT i FROM Incidente i WHERE i.idIncidentes = :idIncidentes")
    , @NamedQuery(name = "Incidente.findByDescripcion", query = "SELECT i FROM Incidente i WHERE i.descripcion = :descripcion")})
public class Incidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIncidentes")
    private Integer idIncidentes;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToMany(mappedBy = "incidenteList", fetch = FetchType.EAGER)
    private List<Casodeprueba> casodepruebaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idincidente", fetch = FetchType.EAGER)
    private List<Asignacion> asignacionList;
    @JoinColumn(name = "idCore", referencedColumnName = "idCore")
    @ManyToOne(fetch = FetchType.EAGER)
    private Core idCore;
    @JoinColumn(name = "idPrioridad", referencedColumnName = "idprioridad")
    @ManyToOne(fetch = FetchType.EAGER)
    private Prioridad idPrioridad;
    @JoinColumn(name = "naturaleza", referencedColumnName = "idNaturaleza")
    @ManyToOne(fetch = FetchType.EAGER)
    private Naturaleza naturaleza;
    @JoinColumn(name = "severidad", referencedColumnName = "idseveridad")
    @ManyToOne(fetch = FetchType.EAGER)
    private Severidad severidad;
    @JoinColumn(name = "tipo", referencedColumnName = "idtipo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Tipo tipo;

    public Incidente() {
    }

    public Incidente(Integer idIncidentes) {
        this.idIncidentes = idIncidentes;
    }

    public Integer getIdIncidentes() {
        return idIncidentes;
    }

    public void setIdIncidentes(Integer idIncidentes) {
        this.idIncidentes = idIncidentes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Casodeprueba> getCasodepruebaList() {
        return casodepruebaList;
    }

    public void setCasodepruebaList(List<Casodeprueba> casodepruebaList) {
        this.casodepruebaList = casodepruebaList;
    }

    @XmlTransient
    public List<Asignacion> getAsignacionList() {
        return asignacionList;
    }

    public void setAsignacionList(List<Asignacion> asignacionList) {
        this.asignacionList = asignacionList;
    }

    public Core getIdCore() {
        return idCore;
    }

    public void setIdCore(Core idCore) {
        this.idCore = idCore;
    }

    public Prioridad getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Prioridad idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public Naturaleza getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(Naturaleza naturaleza) {
        this.naturaleza = naturaleza;
    }

    public Severidad getSeveridad() {
        return severidad;
    }

    public void setSeveridad(Severidad severidad) {
        this.severidad = severidad;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIncidentes != null ? idIncidentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidente)) {
            return false;
        }
        Incidente other = (Incidente) object;
        if ((this.idIncidentes == null && other.idIncidentes != null) || (this.idIncidentes != null && !this.idIncidentes.equals(other.idIncidentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Incidente[ idIncidentes=" + idIncidentes + " ]";
    }
    
}
