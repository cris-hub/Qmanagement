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
@Table(name = "casodeprueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casodeprueba.findAll", query = "SELECT c FROM Casodeprueba c")
    , @NamedQuery(name = "Casodeprueba.findByIdCasodePrueba", query = "SELECT c FROM Casodeprueba c WHERE c.idCasodePrueba = :idCasodePrueba")
    , @NamedQuery(name = "Casodeprueba.findByTipoDeCaso", query = "SELECT c FROM Casodeprueba c WHERE c.tipoDeCaso = :tipoDeCaso")
    , @NamedQuery(name = "Casodeprueba.findByRutaModulo", query = "SELECT c FROM Casodeprueba c WHERE c.rutaModulo = :rutaModulo")
    , @NamedQuery(name = "Casodeprueba.findByObservaciones", query = "SELECT c FROM Casodeprueba c WHERE c.observaciones = :observaciones")})
public class Casodeprueba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCasodePrueba")
    private Integer idCasodePrueba;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "tipoDeCaso")
    private String tipoDeCaso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "rutaModulo")
    private String rutaModulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idAsignacion", referencedColumnName = "idasignacion")
    @ManyToOne(optional = false)
    private Asignacion idAsignacion;
    @JoinColumn(name = "idmotivo", referencedColumnName = "idmotivo")
    @ManyToOne(optional = false)
    private Motivocaso idmotivo;
    @JoinColumn(name = "tipoVisibilidad", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estadocaso tipoVisibilidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCasoPrueba")
    private Collection<Ejecucion> ejecucionCollection;

    public Casodeprueba() {
    }

    public Casodeprueba(Integer idCasodePrueba) {
        this.idCasodePrueba = idCasodePrueba;
    }

    public Casodeprueba(Integer idCasodePrueba, String tipoDeCaso, String rutaModulo, String observaciones) {
        this.idCasodePrueba = idCasodePrueba;
        this.tipoDeCaso = tipoDeCaso;
        this.rutaModulo = rutaModulo;
        this.observaciones = observaciones;
    }

    public Integer getIdCasodePrueba() {
        return idCasodePrueba;
    }

    public void setIdCasodePrueba(Integer idCasodePrueba) {
        this.idCasodePrueba = idCasodePrueba;
    }

    public String getTipoDeCaso() {
        return tipoDeCaso;
    }

    public void setTipoDeCaso(String tipoDeCaso) {
        this.tipoDeCaso = tipoDeCaso;
    }

    public String getRutaModulo() {
        return rutaModulo;
    }

    public void setRutaModulo(String rutaModulo) {
        this.rutaModulo = rutaModulo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Asignacion getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Asignacion idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Motivocaso getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Motivocaso idmotivo) {
        this.idmotivo = idmotivo;
    }

    public Estadocaso getTipoVisibilidad() {
        return tipoVisibilidad;
    }

    public void setTipoVisibilidad(Estadocaso tipoVisibilidad) {
        this.tipoVisibilidad = tipoVisibilidad;
    }

    @XmlTransient
    public Collection<Ejecucion> getEjecucionCollection() {
        return ejecucionCollection;
    }

    public void setEjecucionCollection(Collection<Ejecucion> ejecucionCollection) {
        this.ejecucionCollection = ejecucionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCasodePrueba != null ? idCasodePrueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Casodeprueba)) {
            return false;
        }
        Casodeprueba other = (Casodeprueba) object;
        if ((this.idCasodePrueba == null && other.idCasodePrueba != null) || (this.idCasodePrueba != null && !this.idCasodePrueba.equals(other.idCasodePrueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidad.Casodeprueba[ idCasodePrueba=" + idCasodePrueba + " ]";
    }
    
}
