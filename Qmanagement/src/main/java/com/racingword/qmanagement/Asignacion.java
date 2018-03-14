/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.racingword.qmanagement;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SMEGS
 */
@Entity
@Table(name = "asignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a")
    , @NamedQuery(name = "Asignacion.findByIdasignacion", query = "SELECT a FROM Asignacion a WHERE a.idasignacion = :idasignacion")
    , @NamedQuery(name = "Asignacion.findByFechafinal", query = "SELECT a FROM Asignacion a WHERE a.fechafinal = :fechafinal")
    , @NamedQuery(name = "Asignacion.findByFechainicial", query = "SELECT a FROM Asignacion a WHERE a.fechainicial = :fechainicial")})
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasignacion")
    private Integer idasignacion;
    @Column(name = "fechafinal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinal;
    @Column(name = "fechainicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicial;
    @JoinColumn(name = "idEscenario", referencedColumnName = "idEscenario")
    @ManyToOne
    private Escenario idEscenario;
    @JoinColumn(name = "idusuario", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @JoinColumn(name = "idincidente", referencedColumnName = "idIncidentes")
    @ManyToOne(optional = false)
    private Incidente idincidente;

    public Asignacion() {
    }

    public Asignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public Integer getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public Date getFechainicial() {
        return fechainicial;
    }

    public void setFechainicial(Date fechainicial) {
        this.fechainicial = fechainicial;
    }

    public Escenario getIdEscenario() {
        return idEscenario;
    }

    public void setIdEscenario(Escenario idEscenario) {
        this.idEscenario = idEscenario;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Incidente getIdincidente() {
        return idincidente;
    }

    public void setIdincidente(Incidente idincidente) {
        this.idincidente = idincidente;
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
        return "com.racingword.qmanagement.Asignacion[ idasignacion=" + idasignacion + " ]";
    }
    
}
