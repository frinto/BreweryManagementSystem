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
 * This entity class represents an fv or "fermenting vessel".  This is the vessel that holds
 * fermenting beer after it has been brewed 
 * @author 553817
 */
@Entity
@Table(name = "fv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fv.findAll", query = "SELECT f FROM Fv f")
    , @NamedQuery(name = "Fv.findByFvId", query = "SELECT f FROM Fv f WHERE f.fvId = :fvId")
    , @NamedQuery(name = "Fv.findByCapacity", query = "SELECT f FROM Fv f WHERE f.capacity = :capacity")
    , @NamedQuery(name = "Fv.findByVolume", query = "SELECT f FROM Fv f WHERE f.volume = :volume")
    , @NamedQuery(name = "Fv.findByBrew1", query = "SELECT f FROM Fv f WHERE f.brew1 = :brew1")
    , @NamedQuery(name = "Fv.findByBrew2", query = "SELECT f FROM Fv f WHERE f.brew2 = :brew2")
    , @NamedQuery(name = "Fv.findByBrew3", query = "SELECT f FROM Fv f WHERE f.brew3 = :brew3")
    , @NamedQuery(name = "Fv.findByBrand", query = "SELECT f FROM Fv f WHERE f.brand = :brand")
    , @NamedQuery(name = "Fv.findByStatus", query = "SELECT f FROM Fv f WHERE f.status = :status")})
public class Fv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    /**
     * The id of the fermenter
     */
    @Column(name = "fvId")
    private Integer fvId;
    @Basic(optional = false)
    /**
     * The capactity in litres for the fermenter
     */
    @Column(name = "capacity")
    private int capacity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    /**
     * The volume of beer that is currently in a fermenter
     */
    @Column(name = "volume")
    private Double volume;
    /**
     * Brew 1 of 3 potential brews in a fermenter
     */
    @Column(name = "brew1")
    private Integer brew1;
    /**
     * brew 2 of 3 potential brews in a fermenter
     */
    @Column(name = "brew2")
    private Integer brew2;
    /**
     * brew 3 of 3 potential brews in a fermenter
     */
    @Column(name = "brew3")
    private Integer brew3;
    /**
     * The brand (recipe name) of the current beer occupying a fermenter
     */
    @Column(name = "brand")
    private String brand;
    /**
     * The current status of the fermenter
     */
    @Column(name = "status")
    private Character status;

    public Fv() {
    }

    public Fv(Integer fvId) {
        this.fvId = fvId;
    }

    /**
     * 
     * @param fvId The identification number for a specific fermenting vessel.  A fermenting vessel
     * is the vessel to which wort is put into after a brew so that it can ferment to make beer.
     * @param capacity The volume capacity of a specific fermenting vessel
     */
    public Fv(Integer fvId, int capacity) {
        this.fvId = fvId;
        this.capacity = capacity;
    }

    public Integer getFvId() {
        return fvId;
    }

    public void setFvId(Integer fvId) {
        this.fvId = fvId;
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
