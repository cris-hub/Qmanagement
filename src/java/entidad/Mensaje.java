/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author samuel
 */
@Entity
@Table(name = "mensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m")
    , @NamedQuery(name = "Mensaje.findByIdmensaje", query = "SELECT m FROM Mensaje m WHERE m.idmensaje = :idmensaje")
    , @NamedQuery(name = "Mensaje.findByAsunto", query = "SELECT m FROM Mensaje m WHERE m.asunto = :asunto")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmensaje")
    private Integer idmensaje;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "mensaje")
    private String mensaje;
    @Size(max = 45)
    @Column(name = "asunto")
    private String asunto;
    @JoinColumn(name = "usuario_idUsuarios", referencedColumnName = "idUsuarios")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuarioidUsuarios;

    public Mensaje() {
    }

    public Mensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public Integer getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(Integer idmensaje) {
        this.idmensaje = idmensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Usuario getUsuarioidUsuarios() {
        return usuarioidUsuarios;
    }

    public void setUsuarioidUsuarios(Usuario usuarioidUsuarios) {
        this.usuarioidUsuarios = usuarioidUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmensaje != null ? idmensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idmensaje == null && other.idmensaje != null) || (this.idmensaje != null && !this.idmensaje.equals(other.idmensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Mensaje[ idmensaje=" + idmensaje + " ]";
    }
    
}
