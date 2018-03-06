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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "sv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sv.findAll", query = "SELECT s FROM Sv s")
    , @NamedQuery(name = "Sv.findBySvId", query = "SELECT s FROM Sv s WHERE s.svId = :svId")
    , @NamedQuery(name = "Sv.findByCapacity", query = "SELECT s FROM Sv s WHERE s.capacity = :capacity")
    , @NamedQuery(name = "Sv.findByVolume", query = "SELECT s FROM Sv s WHERE s.volume = :volume")
    , @NamedQuery(name = "Sv.findByBrew1", query = "SELECT s FROM Sv s WHERE s.brew1 = :brew1")
    , @NamedQuery(name = "Sv.findByBrew2", query = "SELECT s FROM Sv s WHERE s.brew2 = :brew2")
    , @NamedQuery(name = "Sv.findByBrew3", query = "SELECT s FROM Sv s WHERE s.brew3 = :brew3")
    , @NamedQuery(name = "Sv.findByBrand", query = "SELECT s FROM Sv s WHERE s.brand = :brand")
    , @NamedQuery(name = "Sv.findByStatus", query = "SELECT s FROM Sv s WHERE s.status = :status")})
public class Sv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "svId")
    private Integer svId;
    @Basic(optional = false)
    @Column(name = "capacity")
    private int capacity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "volume")
    private Double volume;
    @Column(name = "brew1")
    private Integer brew1;
    @Column(name = "brew2")
    private Integer brew2;
    @Column(name = "brew3")
    private Integer brew3;
    @Column(name = "brand")
    private String brand;
    @Column(name = "status")
    private Character status;

    public Sv() {
    }

    public Sv(Integer svId) {
        this.svId = svId;
    }

    public Sv(Integer svId, int capacity) {
        this.svId = svId;
        this.capacity = capacity;
    }

    public Integer getSvId() {
        return svId;
    }

    public void setSvId(Integer svId) {
        this.svId = svId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Integer getBrew1() {
        return brew1;
    }

    public void setBrew1(Integer brew1) {
        this.brew1 = brew1;
    }

    public Integer getBrew2() {
        return brew2;
    }

    public void setBrew2(Integer brew2) {
        this.brew2 = brew2;
    }

    public Integer getBrew3() {
        return brew3;
    }

    public void setBrew3(Integer brew3) {
        this.brew3 = brew3;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
