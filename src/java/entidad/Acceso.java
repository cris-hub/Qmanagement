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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author samuel
 */
@Entity
@Table(name = "acceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acceso.findAll", query = "SELECT a FROM Acceso a")
    , @NamedQuery(name = "Acceso.findByIdAccesos", query = "SELECT a FROM Acceso a WHERE a.idAccesos = :idAccesos")
    , @NamedQuery(name = "Acceso.findByDescripcion", query = "SELECT a FROM Acceso a WHERE a.descripcion = :descripcion")})
public class Acceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAccesos")
    private Integer idAccesos;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "accesosroles", joinColumns = {
        @JoinColumn(name = "idAccesos", referencedColumnName = "idAccesos")}, inverseJoinColumns = {
        @JoinColumn(name = "idRoles", referencedColumnName = "idRoles")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Roles> rolesList;

    public Acceso() {
    }

    public Acceso(Integer idAccesos) {
        this.idAccesos = idAccesos;
    }

    public Integer getIdAccesos() {
        return idAccesos;
    }

    public void setIdAccesos(Integer idAccesos) {
        this.idAccesos = idAccesos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccesos != null ? idAccesos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acceso)) {
            return false;
        }
        Acceso other = (Acceso) object;
        if ((this.idAccesos == null && other.idAccesos != null) || (this.idAccesos != null && !this.idAccesos.equals(other.idAccesos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Acceso[ idAccesos=" + idAccesos + " ]";
    }
    
}
