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
 * @author root
 */
@Entity
@Table(name = "sV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sv.findAll", query = "SELECT s FROM Sv s"),
    @NamedQuery(name = "Sv.findBySvId", query = "SELECT s FROM Sv s WHERE s.svId = :svId"),
    @NamedQuery(name = "Sv.findByVolume", query = "SELECT s FROM Sv s WHERE s.volume = :volume"),
    @NamedQuery(name = "Sv.findByStatus", query = "SELECT s FROM Sv s WHERE s.status = :status")})
public class Sv implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "svId")
    private Integer svId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "volume")
    private Double volume;
    @Column(name = "status")
    private Character status;

    public Sv() {
    }

    public Sv(Integer svId) {
        this.svId = svId;
    }

    public Integer getSvId() {
        return svId;
    }

    public void setSvId(Integer svId) {
        this.svId = svId;
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
        hash += (svId != null ? svId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sv)) {
            return false;
        }
        Sv other = (Sv) object;
        if ((this.svId == null && other.svId != null) || (this.svId != null && !this.svId.equals(other.svId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Sv[ svId=" + svId + " ]";
    }
    
}
