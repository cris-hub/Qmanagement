/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "asignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a")
    , @NamedQuery(name = "Asignacion.findByIdasignacion", query = "SELECT a FROM Asignacion a WHERE a.idasignacion = :idasignacion")
    , @NamedQuery(name = "Asignacion.findByFechainicial", query = "SELECT a FROM Asignacion a WHERE a.fechainicial = :fechainicial")
    , @NamedQuery(name = "Asignacion.findByFechafinal", query = "SELECT a FROM Asignacion a WHERE a.fechafinal = :fechafinal")})
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasignacion")
    private Integer idasignacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechainicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinal;
    @JoinColumn(name = "idCore", referencedColumnName = "idCore")
    @ManyToOne(optional = false)
    private Core idCore;
    @JoinColumn(name = "idEscenario", referencedColumnName = "idEscenario")
    @ManyToOne(optional = false)
    private Escenario idEscenario;
    @JoinColumn(name = "analistadecalidad", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuario analistadecalidad;
    @JoinColumn(name = "desarrollo", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuario desarrollo;
    @JoinColumn(name = "analistadeprueba", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuario analistadeprueba;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsignacion")
    private Collection<Casodeprueba> casodepruebaCollection;

    public Asignacion() {
    }

    public Asignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public Asignacion(Integer idasignacion, Date fechainicial, Date fechafinal) {
        this.idasignacion = idasignacion;
        this.fechainicial = fechainicial;
        this.fechafinal = fechafinal;
    }

    public Integer getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Core getIdCore() {
        return idCore;
    }

    public void setIdCore(Core idCore) {
        this.idCore = idCore;
    }

    public Escenario getIdEscenario() {
        return idEscenario;
    }

    public void setIdEscenario(Escenario idEscenario) {
        this.idEscenario = idEscenario;
    }

    public Usuario getAnalistadecalidad() {
        return analistadecalidad;
    }

    public void setAnalistadecalidad(Usuario analistadecalidad) {
        this.analistadecalidad = analistadecalidad;
    }

    public Usuario getDesarrollo() {
        return desarrollo;
    }

    public void setDesarrollo(Usuario desarrollo) {
        this.desarrollo = desarrollo;
    }

    public Usuario getAnalistadeprueba() {
        return analistadeprueba;
    }

    public void setAnalistadeprueba(Usuario analistadeprueba) {
        this.analistadeprueba = analistadeprueba;
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
        hash += (idasignacion != null ? idasignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.idasignacion == null && other.idasignacion != null) || (this.idasignacion != null && !this.idasignacion.equals(other.idasignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Asignacion[ idasignacion=" + idasignacion + " ]";
    }
    
}
