/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    , @NamedQuery(name = "Brew.findByDate", query = "SELECT b FROM Brew b WHERE b.date = :date")
    , @NamedQuery(name = "Brew.findByMashInTime", query = "SELECT b FROM Brew b WHERE b.mashInTime = :mashInTime")
    , @NamedQuery(name = "Brew.findByRestTime", query = "SELECT b FROM Brew b WHERE b.restTime = :restTime")
    , @NamedQuery(name = "Brew.findByInTime", query = "SELECT b FROM Brew b WHERE b.inTime = :inTime")
    , @NamedQuery(name = "Brew.findByTotalMashTime", query = "SELECT b FROM Brew b WHERE b.totalMashTime = :totalMashTime")
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
    , @NamedQuery(name = "Brew.findByAllInVolume", query = "SELECT b FROM Brew b WHERE b.allInVolume = :allInVolume")
    , @NamedQuery(name = "Brew.findByEmpId", query = "SELECT b FROM Brew b WHERE b.empId = :empId")
    , @NamedQuery(name = "Brew.findByFvId", query = "SELECT b FROM Brew b WHERE b.fvId = :fvId")
    , @NamedQuery(name = "Brew.findByRecipeName", query = "SELECT b FROM Brew b WHERE b.recipeName = :recipeName")
    , @NamedQuery(name = "Brew.findByDateRange", query = "SELECT p FROM Brew p WHERE p.date > :minDate AND p.date < :maxDate")
//    , @NamedQuery(name = "Brew.findMonthVolumeByRecipe", query = "SELECT SUM(b.allInVolume) FROM Brew b WHERE b.recipeName = :recipeName AND MONTH(date) = :monthNum AND YEAR(date) = :yearNum")
})

public class Brew implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)

    @Column(name = "brewId")
    /**
     *Identification number for brew (unique)
     */
    private Integer brewId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    /**
     * date that the beer was brewed on
     */
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mashInTime")
    /**
     * The time it took to mash in. 
     * Mashing in is the process of getting the required barley for a single brew
     * into the first vessel along with hot water.
     */
    private Float mashInTime;
    @Column(name = "restTime")
    /**
     * rest time in minutes.  The rest is neccesary in the brew to wait for the starches in the
     * grain to be converted to sugar for fermentation.
     */
    private Float restTime;
    @Column(name = "inTime")
    private Float inTime;
    @Column(name = "totalMashTime")
    /**
     * total mash time is the total time it took to complete the mash. 
     */
    private Float totalMashTime;
    @Column(name = "underletTime")
    /**
     * underlet time in minutes.  This is the process where a brewer will "punch up"
     * the mash in the mash tun vessel in order to loosen the grain from the bottom of the
     * vessel
     */
    private Float underletTime;
    @Column(name = "lauterRestTime")
    /**
     * rest time in minutes after the underlet and before the vorlauf
     */
    private Float lauterRestTime;
    @Column(name = "vorlaufTime")
    /**
     * Time in minutes that the vorlauf occurs.  Vorlauf is the process of 
     * clarifying the wort being drawn out of the mash tun.
     */
    private Float vorlaufTime;
    @Column(name = "firstWortGravity")
    /**
     * The first measurement of the gravity of the wort.  Gravity is a measurement of the 
     * comparison in density to that of water.  
     */
    private Float firstWortGravity;
    @Column(name = "runOffTime")
    /**
     * The time in minutes it takes to 
     */
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
    @Column(name = "allInVolume")
    private Float allInVolume;
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
    /**
     * 
     * 
     * @param brewId - Number representing the current brew for the year
     * @param date - Date the beer was brewed on
     * @param mashInTime - The time it took to completely mash in.  A mash in consists of mixing the grain 
     * with hot water in the mash tun vessel.
     * @param restTime - The rest time after the mash in.  This is used to let the grain rest
     * and let the starches in the grain convert to sugar
     * @param inTime - 
     * @param totalMashTime - Total time for whole mash to take place
     * @param underletTime - Time it took to perform underlet.  An underlet frees up the mash bed in the
     * mash tun by pumping water underneath the grain bed.
     * 
     * @param lauterRestTime - Time in minutes of rest after lautering
     * @param vorlaufTime - Time it took to vorlauf beer. A vorlauf is the process of clarifying the wort
     * being drawn out of the mash tun.
     * @param firstWortGravity First gravity reading of the wort.  Gravity measures the comparison of the wort
     * density to the density of water
     * @param runOffTime - total time it took to fill the kettle with the wort extract from the 
     * mash tun.
     * @param lastRunningsGravity - the gravity measurement of the last bit of wort that is headed
     * to the kettle
     * @param kettleFullVol The volume of wort in the kettle after run off.
     * @param kettleFullGravity The gravity of the wort after run off.
     * @param kettleStrikeOutVol The volume after the boil that is being siphoned to a fermenting vessel
     * @param kettleStrikeOutGravity The gravity of the wort that is being siphoned to a fermenting vessel
     * @param allInVolume Total volume that has been transfered to a fermenting vessel
     * @param empId id of the employee who completed the brew
     * @param fvId the fermenting vessel number to which the brew has been transfered into
     * @param recipeName the name of the recipe that has been brewed
     */
     public Brew(Integer brewId,Date date, float mashInTime,
            float restTime, float inTime, float totalMashTime,
            float underletTime, float lauterRestTime,
            float vorlaufTime, float firstWortGravity,
            float runOffTime, float lastRunningsGravity,
            float kettleFullVol, float kettleFullGravity,
            float kettleStrikeOutVol,float kettleStrikeOutGravity, float allInVolume,int empId, int fvId, String recipeName) {
        this.brewId = brewId;
        this.date = date;
        this.mashInTime = mashInTime;
        this.restTime = restTime;
        this.inTime = inTime;
        this.totalMashTime = totalMashTime;
        this.underletTime = underletTime;
        this.lauterRestTime = lauterRestTime;
        this.vorlaufTime = vorlaufTime;
        this.firstWortGravity = firstWortGravity;
        this.runOffTime = runOffTime;
        this.lastRunningsGravity = lastRunningsGravity;
        this.kettleFullVol = kettleFullVol;
        this.kettleFullGravity = kettleFullGravity;
        this.kettleStrikeOutVol = kettleStrikeOutVol;
        this.kettleStrikeOutGravity = kettleStrikeOutGravity;
        this.allInVolume = allInVolume;
        this.empId = empId;
        this.fvId = fvId;
        this.recipeName = recipeName;    }

    public Integer getBrewId() {
        return brewId;
    }

    public void setBrewId(Integer brewId) {
        this.brewId = brewId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Float getTotalMashTime() {
        return totalMashTime;
    }

    public void setTotalMashTime(Float totalMashTime) {
        this.totalMashTime = totalMashTime;
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

    public Float getAllInVolume() {
        return allInVolume;
    }

    public void setAllInVolume(Float allInVolume) {
        this.allInVolume = allInVolume;
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
