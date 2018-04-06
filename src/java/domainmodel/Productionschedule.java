/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is the production schedule which is used
 * for managing and tracking information for everything in production
 * 
 * upon creation of this class it will contain all attributes and
 * operations used for production schedule including getters and setters.
 *
 * @author Huy Le
 */
@Entity
@Table(name = "productionschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productionschedule.findAll", query = "SELECT p FROM Productionschedule p"),
    @NamedQuery(name = "Productionschedule.findByDate", query = "SELECT p FROM Productionschedule p WHERE p.date = :date"),
    @NamedQuery(name = "Productionschedule.findByBrew", query = "SELECT p FROM Productionschedule p WHERE p.brew = :brew"),
    @NamedQuery(name = "Productionschedule.findByFv", query = "SELECT p FROM Productionschedule p WHERE p.fv = :fv"),
    @NamedQuery(name = "Productionschedule.findByYst", query = "SELECT p FROM Productionschedule p WHERE p.yst = :yst"),
    @NamedQuery(name = "Productionschedule.findByTransfer", query = "SELECT p FROM Productionschedule p WHERE p.transfer = :transfer"),
    @NamedQuery(name = "Productionschedule.findByFuge", query = "SELECT p FROM Productionschedule p WHERE p.fuge = :fuge"),
    @NamedQuery(name = "Productionschedule.findByClean", query = "SELECT p FROM Productionschedule p WHERE p.clean = :clean"),
    @NamedQuery(name = "Productionschedule.findByKeg", query = "SELECT p FROM Productionschedule p WHERE p.keg = :keg"),
    @NamedQuery(name = "Productionschedule.findByBottle", query = "SELECT p FROM Productionschedule p WHERE p.bottle = :bottle"),
    @NamedQuery(name = "Productionschedule.findByCan", query = "SELECT p FROM Productionschedule p WHERE p.can = :can")})
public class Productionschedule implements Serializable {

    /**
     * type long it represents the serial version unique identifier.
     */
    private static final long serialVersionUID = 1L;
    /**
     * type Date it represents the date of the production scehdule.
     */
    @Id
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    /**
     * type String it tracks information about brew.
     */
    @Column(name = "brew")
    private String brew;
    /**
     * type String it tracks information about fv.
     */
    @Column(name = "fv")
    private String fv;
    /**
     * type String it tracks information about yeast.
     */
    @Column(name = "yst")
    private String yst;
    /**
     * type String it tracks information about transfer.
     */
    @Column(name = "transfer")
    private String transfer;
       /**
     * type String it tracks information about fuge.
     */
    @Column(name = "fuge")
    private String fuge;
     /**
     * type String it tracks information about clean.
     */
    @Column(name = "clean")
    private String clean;
    /**
     * type String it tracks information about keg.
     */
    @Column(name = "keg")
    private String keg;
     /**
     * type String it tracks information about bottles.
     */
    @Column(name = "bottle")
    private String bottle;
     /**
     * type String it tracks information about can.
     */
    @Column(name = "can")
    private String can;

    /**
     * default constructor for production schedule
     * upon creation it will set all attributes to default values.
     */
    public Productionschedule() {
    }

    /**
     * constructor for production schedule upon creation it will
     * initialize the date attribute of this object.
     * @param date type Date it represents the date of the production schedule.
     */
    public Productionschedule(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBrew() {
        return brew;
    }

    public void setBrew(String brew) {
        this.brew = brew;
    }

    public String getFv() {
        return fv;
    }

    public void setFv(String fv) {
        this.fv = fv;
    }

    public String getYst() {
        return yst;
    }

    public void setYst(String yst) {
        this.yst = yst;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getFuge() {
        return fuge;
    }

    public void setFuge(String fuge) {
        this.fuge = fuge;
    }

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }

    public String getKeg() {
        return keg;
    }

    public void setKeg(String keg) {
        this.keg = keg;
    }

    public String getBottle() {
        return bottle;
    }

    public String getDayOfWeek() {
        String dayOfWeekString;
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        int dayOfWeekIndex = c.get(Calendar.DAY_OF_WEEK);
        
        if(dayOfWeekIndex == 1)
        {
            dayOfWeekString = "sunday";
            return dayOfWeekString;
        }else if(dayOfWeekIndex == 2){
            dayOfWeekString = "monday";
            return dayOfWeekString;
        }else if(dayOfWeekIndex == 3){
            dayOfWeekString = "tuesday";
            return dayOfWeekString;
        }else if(dayOfWeekIndex == 4){
            dayOfWeekString = "wednesday";
            return dayOfWeekString;
        }else if(dayOfWeekIndex == 5){
            dayOfWeekString = "thursday";
            return dayOfWeekString;
        }else if(dayOfWeekIndex == 6){
            dayOfWeekString = "friday";
            return dayOfWeekString;
        }else if(dayOfWeekIndex == 7){
            dayOfWeekString = "saturday";
            return dayOfWeekString;
        }
        else{
            return null;
        }
    }

    public void setBottle(String bottle) {
        this.bottle = bottle;
    }

    public String getCan() {
        return can;
    }

    public void setCan(String can) {
        this.can = can;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date != null ? date.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productionschedule)) {
            return false;
        }
        Productionschedule other = (Productionschedule) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Productionschedule[ date=" + date + " ]";
    }

}
