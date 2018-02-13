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
@Table(name = "brew")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brew.findAll", query = "SELECT b FROM Brew b")
    , @NamedQuery(name = "Brew.findByBrewId", query = "SELECT b FROM Brew b WHERE b.brewId = :brewId")
    , @NamedQuery(name = "Brew.findByMashInTime", query = "SELECT b FROM Brew b WHERE b.mashInTime = :mashInTime")
    , @NamedQuery(name = "Brew.findByRestTime", query = "SELECT b FROM Brew b WHERE b.restTime = :restTime")
    , @NamedQuery(name = "Brew.findByInTime", query = "SELECT b FROM Brew b WHERE b.inTime = :inTime")
    , @NamedQuery(name = "Brew.findByUnderletTime", query = "SELECT b FROM Brew b WHERE b.underletTime = :underletTime")
    , @NamedQuery(name = "Brew.findByLauterRestTime", query = "SELECT b FROM Brew b WHERE b.lauterRestTime = :lauterRestTime")
    , @NamedQuery(name = "Brew.findByVorlaufTime", query = "SELECT b FROM Brew b WHERE b.vorlaufTime = :vorlaufTime")
    , @NamedQuery(name = "Brew.findByFirstWortGravity", query = "SELECT b FROM Brew b WHERE b.firstWortGravity = :firstWortGravity")
    , @NamedQuery(name = "Brew.findByRunOffTime", query = "SELECT b FROM Brew b WHERE b.runOffTime = :runOffTime")
    , @NamedQuery(name = "Brew.findByLastRunningsGravity", query = "SELECT b FROM Brew b WHERE b.lastRunningsGravity = :lastRunningsGravity")
    , @NamedQuery(name = "Brew.findByKettleFullVol", query = "SELECT b FROM Brew b WHERE b.kettleFullVol = :kettleFullVol")
    , @NamedQuery(name = "Brew.findByKettleFullGravity", query = "SELECT b FROM Brew b WHERE b.kettleFullGravity = :kettleFullGravity")
    , @NamedQuery(name = "Brew.findByKettleStrikeOutVol", query = "SELECT b FROM Brew b WHERE b.kettleStrikeOutVol = :kettleStrikeOutVol")
    , @NamedQuery(name = "Brew.findByKettleStrikeOutGravity", query = "SELECT b FROM Brew b WHERE b.kettleStrikeOutGravity = :kettleStrikeOutGravity")
    , @NamedQuery(name = "Brew.findByEmpId", query = "SELECT b FROM Brew b WHERE b.empId = :empId")
    , @NamedQuery(name = "Brew.findByFvId", query = "SELECT b FROM Brew b WHERE b.fvId = :fvId")
    , @NamedQuery(name = "Brew.findByRecipeName", query = "SELECT b FROM Brew b WHERE b.recipeName = :recipeName")})
public class Brew implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "brewId")
    private Integer brewId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mashInTime")
    private Float mashInTime;
    @Column(name = "restTime")
    private Float restTime;
    @Column(name = "inTime")
    private Float inTime;
    @Column(name = "underletTime")
    private Float underletTime;
    @Column(name = "lauterRestTime")
    private Float lauterRestTime;
    @Column(name = "vorlaufTime")
    private Float vorlaufTime;
    @Column(name = "firstWortGravity")
    private Float firstWortGravity;
    @Column(name = "runOffTime")
    private Float runOffTime;
    @Column(name = "lastRunningsGravity")
    private Float lastRunningsGravity;
    @Column(name = "kettleFullVol")
    private Float kettleFullVol;
    @Column(name = "kettleFullGravity")
    private Float kettleFullGravity;
    @Column(name = "kettleStrikeOutVol")
    private Float kettleStrikeOutVol;
    @Column(name = "kettleStrikeOutGravity")
    private Float kettleStrikeOutGravity;
    @Basic(optional = false)
    @Column(name = "empId")
    private int empId;
    @Basic(optional = false)
    @Column(name = "fvId")
    private int fvId;
    @Basic(optional = false)
    @Column(name = "recipeName")
    private String recipeName;

    public Brew() {
    }

    public Brew(Integer brewId) {
        this.brewId = brewId;
    }

    public Brew(Integer brewId, int empId, int fvId, String recipeName) {
        this.brewId = brewId;
        this.empId = empId;
        this.fvId = fvId;
        this.recipeName = recipeName;
    }

    public Integer getBrewId() {
        return brewId;
    }

    public void setBrewId(Integer brewId) {
        this.brewId = brewId;
    }

    public Float getMashInTime() {
        return mashInTime;
    }

    public void setMashInTime(Float mashInTime) {
        this.mashInTime = mashInTime;
    }

    public Float getRestTime() {
        return restTime;
    }

    public void setRestTime(Float restTime) {
        this.restTime = restTime;
    }

    public Float getInTime() {
        return inTime;
    }

    public void setInTime(Float inTime) {
        this.inTime = inTime;
    }

    public Float getUnderletTime() {
        return underletTime;
    }

    public void setUnderletTime(Float underletTime) {
        this.underletTime = underletTime;
    }

    public Float getLauterRestTime() {
        return lauterRestTime;
    }

    public void setLauterRestTime(Float lauterRestTime) {
        this.lauterRestTime = lauterRestTime;
    }

    public Float getVorlaufTime() {
        return vorlaufTime;
    }

    public void setVorlaufTime(Float vorlaufTime) {
        this.vorlaufTime = vorlaufTime;
    }

    public Float getFirstWortGravity() {
        return firstWortGravity;
    }

    public void setFirstWortGravity(Float firstWortGravity) {
        this.firstWortGravity = firstWortGravity;
    }

    public Float getRunOffTime() {
        return runOffTime;
    }

    public void setRunOffTime(Float runOffTime) {
        this.runOffTime = runOffTime;
    }

    public Float getLastRunningsGravity() {
        return lastRunningsGravity;
    }

    public void setLastRunningsGravity(Float lastRunningsGravity) {
        this.lastRunningsGravity = lastRunningsGravity;
    }

    public Float getKettleFullVol() {
        return kettleFullVol;
    }

    public void setKettleFullVol(Float kettleFullVol) {
        this.kettleFullVol = kettleFullVol;
    }

    public Float getKettleFullGravity() {
        return kettleFullGravity;
    }

    public void setKettleFullGravity(Float kettleFullGravity) {
        this.kettleFullGravity = kettleFullGravity;
    }

    public Float getKettleStrikeOutVol() {
        return kettleStrikeOutVol;
    }

    public void setKettleStrikeOutVol(Float kettleStrikeOutVol) {
        this.kettleStrikeOutVol = kettleStrikeOutVol;
    }

    public Float getKettleStrikeOutGravity() {
        return kettleStrikeOutGravity;
    }

    public void setKettleStrikeOutGravity(Float kettleStrikeOutGravity) {
        this.kettleStrikeOutGravity = kettleStrikeOutGravity;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getFvId() {
        return fvId;
    }

    public void setFvId(int fvId) {
        this.fvId = fvId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brewId != null ? brewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brew)) {
            return false;
        }
        Brew other = (Brew) object;
        if ((this.brewId == null && other.brewId != null) || (this.brewId != null && !this.brewId.equals(other.brewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Brew[ brewId=" + brewId + " ]";
    }
    
}
