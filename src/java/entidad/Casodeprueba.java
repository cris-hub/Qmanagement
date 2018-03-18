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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "casodeprueba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Casodeprueba.findAll", query = "SELECT c FROM Casodeprueba c")
    , @NamedQuery(name = "Casodeprueba.findByIdCasodePrueba", query = "SELECT c FROM Casodeprueba c WHERE c.idCasodePrueba = :idCasodePrueba")
    , @NamedQuery(name = "Casodeprueba.findByObservaciones", query = "SELECT c FROM Casodeprueba c WHERE c.observaciones = :observaciones")
    , @NamedQuery(name = "Casodeprueba.findByRutaModulo", query = "SELECT c FROM Casodeprueba c WHERE c.rutaModulo = :rutaModulo")
    , @NamedQuery(name = "Casodeprueba.findByTipoDeCaso", query = "SELECT c FROM Casodeprueba c WHERE c.tipoDeCaso = :tipoDeCaso")})
public class Casodeprueba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCasodePrueba")
    private Integer idCasodePrueba;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 255)
    @Column(name = "rutaModulo")
    private String rutaModulo;
    @Size(max = 255)
    @Column(name = "tipoDeCaso")
    private String tipoDeCaso;
    @JoinTable(name = "casoprueba_incidente", joinColumns = {
        @JoinColumn(name = "idcasoprueba", referencedColumnName = "idCasodePrueba")}, inverseJoinColumns = {
        @JoinColumn(name = "idincidente", referencedColumnName = "idIncidentes")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Incidente> incidenteList;
    @JoinColumn(name = "idmotivo", referencedColumnName = "idmotivo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Motivocaso idmotivo;
    @JoinColumn(name = "tipoVisibilidad", referencedColumnName = "idestado")
    @ManyToOne(fetch = FetchType.EAGER)
    private Estadocaso tipoVisibilidad;
    @OneToMany(mappedBy = "idCasoPrueba", fetch = FetchType.EAGER)
    private List<Ejecucion> ejecucionList;

    public Casodeprueba() {
    }

    public Casodeprueba(Integer idCasodePrueba) {
        this.idCasodePrueba = idCasodePrueba;
    }

    public Integer getIdCasodePrueba() {
        return idCasodePrueba;
    }

    public void setIdCasodePrueba(Integer idCasodePrueba) {
        this.idCasodePrueba = idCasodePrueba;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRutaModulo() {
        return rutaModulo;
    }

    public void setRutaModulo(String rutaModulo) {
        this.rutaModulo = rutaModulo;
    }

    public String getTipoDeCaso() {
        return tipoDeCaso;
    }

    public void setTipoDeCaso(String tipoDeCaso) {
        this.tipoDeCaso = tipoDeCaso;
    }

    @XmlTransient
    public List<Incidente> getIncidenteList() {
        return incidenteList;
    }

    public void setIncidenteList(List<Incidente> incidenteList) {
        this.incidenteList = incidenteList;
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
    public List<Ejecucion> getEjecucionList() {
        return ejecucionList;
    }

    public void setEjecucionList(List<Ejecucion> ejecucionList) {
        this.ejecucionList = ejecucionList;
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
        return "dao.Casodeprueba[ idCasodePrueba=" + idCasodePrueba + " ]";
    }
    
}
