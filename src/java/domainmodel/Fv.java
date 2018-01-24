/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 553817
 */
@Entity
@Table(name = "fv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fv.findAll", query = "SELECT f FROM Fv f")
    , @NamedQuery(name = "Fv.findByFvId", query = "SELECT f FROM Fv f WHERE f.fvId = :fvId")
    , @NamedQuery(name = "Fv.findByVolume", query = "SELECT f FROM Fv f WHERE f.volume = :volume")
    , @NamedQuery(name = "Fv.findByStatus", query = "SELECT f FROM Fv f WHERE f.status = :status")})
public class Fv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "fvId")
    private Integer fvId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "volume")
    private Double volume;
    @Column(name = "status")
    private Character status;

    public Fv() {
    }

    public Fv(Integer fvId) {
        this.fvId = fvId;
    }

    public Integer getFvId() {
        return fvId;
    }

    public void setFvId(Integer fvId) {
        this.fvId = fvId;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fvId != null ? fvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fv)) {
            return false;
        }
        Fv other = (Fv) object;
        if ((this.fvId == null && other.fvId != null) || (this.fvId != null && !this.fvId.equals(other.fvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Fv[ fvId=" + fvId + " ]";
    }
    
}
