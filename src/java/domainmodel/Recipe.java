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
@Table(name = "recipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r")
    , @NamedQuery(name = "Recipe.findByRecipeName", query = "SELECT r FROM Recipe r WHERE r.recipeName = :recipeName")
    , @NamedQuery(name = "Recipe.findByDateModified", query = "SELECT r FROM Recipe r WHERE r.dateModified = :dateModified")
    , @NamedQuery(name = "Recipe.findByMashInTemp", query = "SELECT r FROM Recipe r WHERE r.mashInTemp = :mashInTemp")
    , @NamedQuery(name = "Recipe.findByMashInTime", query = "SELECT r FROM Recipe r WHERE r.mashInTime = :mashInTime")
    , @NamedQuery(name = "Recipe.findByMashWaterVolume", query = "SELECT r FROM Recipe r WHERE r.mashWaterVolume = :mashWaterVolume")
    , @NamedQuery(name = "Recipe.findByRestTime", query = "SELECT r FROM Recipe r WHERE r.restTime = :restTime")
    , @NamedQuery(name = "Recipe.findByRaiseToTemp", query = "SELECT r FROM Recipe r WHERE r.raiseToTemp = :raiseToTemp")
    , @NamedQuery(name = "Recipe.findByInTime", query = "SELECT r FROM Recipe r WHERE r.inTime = :inTime")
    , @NamedQuery(name = "Recipe.findByTotalMashTime", query = "SELECT r FROM Recipe r WHERE r.totalMashTime = :totalMashTime")
    , @NamedQuery(name = "Recipe.findByUnderletLitres", query = "SELECT r FROM Recipe r WHERE r.underletLitres = :underletLitres")
    , @NamedQuery(name = "Recipe.findByRest", query = "SELECT r FROM Recipe r WHERE r.rest = :rest")
    , @NamedQuery(name = "Recipe.findByVorlaufTime", query = "SELECT r FROM Recipe r WHERE r.vorlaufTime = :vorlaufTime")
    , @NamedQuery(name = "Recipe.findByFirstWortGrav", query = "SELECT r FROM Recipe r WHERE r.firstWortGrav = :firstWortGrav")
    , @NamedQuery(name = "Recipe.findByRunOffTime", query = "SELECT r FROM Recipe r WHERE r.runOffTime = :runOffTime")
    , @NamedQuery(name = "Recipe.findBySpargVol", query = "SELECT r FROM Recipe r WHERE r.spargVol = :spargVol")
    , @NamedQuery(name = "Recipe.findBySpargTemp", query = "SELECT r FROM Recipe r WHERE r.spargTemp = :spargTemp")
    , @NamedQuery(name = "Recipe.findByLastRunningsGrav", query = "SELECT r FROM Recipe r WHERE r.lastRunningsGrav = :lastRunningsGrav")
    , @NamedQuery(name = "Recipe.findByKettleFullVol", query = "SELECT r FROM Recipe r WHERE r.kettleFullVol = :kettleFullVol")
    , @NamedQuery(name = "Recipe.findByKettleFullGrav", query = "SELECT r FROM Recipe r WHERE r.kettleFullGrav = :kettleFullGrav")
    , @NamedQuery(name = "Recipe.findByBoilTime", query = "SELECT r FROM Recipe r WHERE r.boilTime = :boilTime")
    , @NamedQuery(name = "Recipe.findByStrikeOutVol", query = "SELECT r FROM Recipe r WHERE r.strikeOutVol = :strikeOutVol")
    , @NamedQuery(name = "Recipe.findByStrikeOutGrav", query = "SELECT r FROM Recipe r WHERE r.strikeOutGrav = :strikeOutGrav")
    , @NamedQuery(name = "Recipe.findByWhirlPoolTime", query = "SELECT r FROM Recipe r WHERE r.whirlPoolTime = :whirlPoolTime")
    , @NamedQuery(name = "Recipe.findByCoolInTemp", query = "SELECT r FROM Recipe r WHERE r.coolInTemp = :coolInTemp")
    , @NamedQuery(name = "Recipe.findByOxygenRate", query = "SELECT r FROM Recipe r WHERE r.oxygenRate = :oxygenRate")
    , @NamedQuery(name = "Recipe.findByGypsumAmt", query = "SELECT r FROM Recipe r WHERE r.gypsumAmt = :gypsumAmt")
    , @NamedQuery(name = "Recipe.findByCalciumChlorideAmt", query = "SELECT r FROM Recipe r WHERE r.calciumChlorideAmt = :calciumChlorideAmt")
    , @NamedQuery(name = "Recipe.findBySodiumChlorideAmt", query = "SELECT r FROM Recipe r WHERE r.sodiumChlorideAmt = :sodiumChlorideAmt")
    , @NamedQuery(name = "Recipe.findByPhosphAcidAmt", query = "SELECT r FROM Recipe r WHERE r.phosphAcidAmt = :phosphAcidAmt")
    , @NamedQuery(name = "Recipe.findByFirstHop", query = "SELECT r FROM Recipe r WHERE r.firstHop = :firstHop")
    , @NamedQuery(name = "Recipe.findByFirstHopAmt", query = "SELECT r FROM Recipe r WHERE r.firstHopAmt = :firstHopAmt")
    , @NamedQuery(name = "Recipe.findBySecondHop", query = "SELECT r FROM Recipe r WHERE r.secondHop = :secondHop")
    , @NamedQuery(name = "Recipe.findBySecondHopAmt", query = "SELECT r FROM Recipe r WHERE r.secondHopAmt = :secondHopAmt")
    , @NamedQuery(name = "Recipe.findByThirdHop", query = "SELECT r FROM Recipe r WHERE r.thirdHop = :thirdHop")
    , @NamedQuery(name = "Recipe.findByThirdHopAmt", query = "SELECT r FROM Recipe r WHERE r.thirdHopAmt = :thirdHopAmt")
    , @NamedQuery(name = "Recipe.findByBaseMalt", query = "SELECT r FROM Recipe r WHERE r.baseMalt = :baseMalt")
    , @NamedQuery(name = "Recipe.findByBaseMaltAmt", query = "SELECT r FROM Recipe r WHERE r.baseMaltAmt = :baseMaltAmt")
    , @NamedQuery(name = "Recipe.findBySecondMalt", query = "SELECT r FROM Recipe r WHERE r.secondMalt = :secondMalt")
    , @NamedQuery(name = "Recipe.findBySecondMaltAmt", query = "SELECT r FROM Recipe r WHERE r.secondMaltAmt = :secondMaltAmt")
    , @NamedQuery(name = "Recipe.findByThirdMalt", query = "SELECT r FROM Recipe r WHERE r.thirdMalt = :thirdMalt")
    , @NamedQuery(name = "Recipe.findByThirdMaltAmt", query = "SELECT r FROM Recipe r WHERE r.thirdMaltAmt = :thirdMaltAmt")
    , @NamedQuery(name = "Recipe.findByFourthMalt", query = "SELECT r FROM Recipe r WHERE r.fourthMalt = :fourthMalt")
    , @NamedQuery(name = "Recipe.findByFourthMaltAmt", query = "SELECT r FROM Recipe r WHERE r.fourthMaltAmt = :fourthMaltAmt")})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "recipeName")
    private String recipeName;
    @Column(name = "dateModified")
    @Temporal(TemporalType.DATE)
    private Date dateModified;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mashInTemp")
    private Float mashInTemp;
    @Column(name = "mashInTime")
    private Float mashInTime;
    @Column(name = "mashWaterVolume")
    private Integer mashWaterVolume;
    @Column(name = "restTime")
    private Long restTime;
    @Column(name = "raiseToTemp")
    private Integer raiseToTemp;
    @Column(name = "inTime")
    private Long inTime;
    @Column(name = "totalMashTime")
    private Long totalMashTime;
    @Column(name = "underletLitres")
    private Integer underletLitres;
    @Column(name = "rest")
    private Long rest;
    @Column(name = "vorlaufTime")
    private Long vorlaufTime;
    @Column(name = "firstWortGrav")
    private Float firstWortGrav;
    @Column(name = "runOffTime")
    private Long runOffTime;
    @Column(name = "spargVol")
    private Long spargVol;
    @Column(name = "spargTemp")
    private Float spargTemp;
    @Column(name = "lastRunningsGrav")
    private Float lastRunningsGrav;
    @Column(name = "kettleFullVol")
    private Long kettleFullVol;
    @Column(name = "kettleFullGrav")
    private Float kettleFullGrav;
    @Column(name = "boilTime")
    private Long boilTime;
    @Column(name = "strikeOutVol")
    private Long strikeOutVol;
    @Column(name = "strikeOutGrav")
    private Float strikeOutGrav;
    @Column(name = "whirlPoolTime")
    private Long whirlPoolTime;
    @Column(name = "coolInTemp")
    private Float coolInTemp;
    @Column(name = "oxygenRate")
    private Float oxygenRate;
    @Column(name = "gypsumAmt")
    private Float gypsumAmt;
    @Column(name = "calciumChlorideAmt")
    private Float calciumChlorideAmt;
    @Column(name = "sodiumChlorideAmt")
    private Float sodiumChlorideAmt;
    @Column(name = "phosphAcidAmt")
    private Float phosphAcidAmt;
    @Column(name = "firstHop")
    private String firstHop;
    @Column(name = "firstHopAmt")
    private Float firstHopAmt;
    @Column(name = "secondHop")
    private String secondHop;
    @Column(name = "secondHopAmt")
    private Float secondHopAmt;
    @Column(name = "thirdHop")
    private String thirdHop;
    @Column(name = "thirdHopAmt")
    private Float thirdHopAmt;
    @Column(name = "baseMalt")
    private String baseMalt;
    @Column(name = "baseMaltAmt")
    private Float baseMaltAmt;
    @Column(name = "secondMalt")
    private String secondMalt;
    @Column(name = "secondMaltAmt")
    private Float secondMaltAmt;
    @Column(name = "thirdMalt")
    private String thirdMalt;
    @Column(name = "thirdMaltAmt")
    private Float thirdMaltAmt;
    @Column(name = "fourthMalt")
    private String fourthMalt;
    @Column(name = "fourthMaltAmt")
    private Float fourthMaltAmt;

    public Recipe() {
    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Float getMashInTemp() {
        return mashInTemp;
    }

    public void setMashInTemp(Float mashInTemp) {
        this.mashInTemp = mashInTemp;
    }

    public Float getMashInTime() {
        return mashInTime;
    }

    public void setMashInTime(Float mashInTime) {
        this.mashInTime = mashInTime;
    }

    public Integer getMashWaterVolume() {
        return mashWaterVolume;
    }

    public void setMashWaterVolume(Integer mashWaterVolume) {
        this.mashWaterVolume = mashWaterVolume;
    }

    public Long getRestTime() {
        return restTime;
    }

    public void setRestTime(Long restTime) {
        this.restTime = restTime;
    }

    public Integer getRaiseToTemp() {
        return raiseToTemp;
    }

    public void setRaiseToTemp(Integer raiseToTemp) {
        this.raiseToTemp = raiseToTemp;
    }

    public Long getInTime() {
        return inTime;
    }

    public void setInTime(Long inTime) {
        this.inTime = inTime;
    }

    public Long getTotalMashTime() {
        return totalMashTime;
    }

    public void setTotalMashTime(Long totalMashTime) {
        this.totalMashTime = totalMashTime;
    }

    public Integer getUnderletLitres() {
        return underletLitres;
    }

    public void setUnderletLitres(Integer underletLitres) {
        this.underletLitres = underletLitres;
    }

    public Long getRest() {
        return rest;
    }

    public void setRest(Long rest) {
        this.rest = rest;
    }

    public Long getVorlaufTime() {
        return vorlaufTime;
    }

    public void setVorlaufTime(Long vorlaufTime) {
        this.vorlaufTime = vorlaufTime;
    }

    public Float getFirstWortGrav() {
        return firstWortGrav;
    }

    public void setFirstWortGrav(Float firstWortGrav) {
        this.firstWortGrav = firstWortGrav;
    }

    public Long getRunOffTime() {
        return runOffTime;
    }

    public void setRunOffTime(Long runOffTime) {
        this.runOffTime = runOffTime;
    }

    public Long getSpargVol() {
        return spargVol;
    }

    public void setSpargVol(Long spargVol) {
        this.spargVol = spargVol;
    }

    public Float getSpargTemp() {
        return spargTemp;
    }

    public void setSpargTemp(Float spargTemp) {
        this.spargTemp = spargTemp;
    }

    public Float getLastRunningsGrav() {
        return lastRunningsGrav;
    }

    public void setLastRunningsGrav(Float lastRunningsGrav) {
        this.lastRunningsGrav = lastRunningsGrav;
    }

    public Long getKettleFullVol() {
        return kettleFullVol;
    }

    public void setKettleFullVol(Long kettleFullVol) {
        this.kettleFullVol = kettleFullVol;
    }

    public Float getKettleFullGrav() {
        return kettleFullGrav;
    }

    public void setKettleFullGrav(Float kettleFullGrav) {
        this.kettleFullGrav = kettleFullGrav;
    }

    public Long getBoilTime() {
        return boilTime;
    }

    public void setBoilTime(Long boilTime) {
        this.boilTime = boilTime;
    }

    public Long getStrikeOutVol() {
        return strikeOutVol;
    }

    public void setStrikeOutVol(Long strikeOutVol) {
        this.strikeOutVol = strikeOutVol;
    }

    public Float getStrikeOutGrav() {
        return strikeOutGrav;
    }

    public void setStrikeOutGrav(Float strikeOutGrav) {
        this.strikeOutGrav = strikeOutGrav;
    }

    public Long getWhirlPoolTime() {
        return whirlPoolTime;
    }

    public void setWhirlPoolTime(Long whirlPoolTime) {
        this.whirlPoolTime = whirlPoolTime;
    }

    public Float getCoolInTemp() {
        return coolInTemp;
    }

    public void setCoolInTemp(Float coolInTemp) {
        this.coolInTemp = coolInTemp;
    }

    public Float getOxygenRate() {
        return oxygenRate;
    }

    public void setOxygenRate(Float oxygenRate) {
        this.oxygenRate = oxygenRate;
    }

    public Float getGypsumAmt() {
        return gypsumAmt;
    }

    public void setGypsumAmt(Float gypsumAmt) {
        this.gypsumAmt = gypsumAmt;
    }

    public Float getCalciumChlorideAmt() {
        return calciumChlorideAmt;
    }

    public void setCalciumChlorideAmt(Float calciumChlorideAmt) {
        this.calciumChlorideAmt = calciumChlorideAmt;
    }

    public Float getSodiumChlorideAmt() {
        return sodiumChlorideAmt;
    }

    public void setSodiumChlorideAmt(Float sodiumChlorideAmt) {
        this.sodiumChlorideAmt = sodiumChlorideAmt;
    }

    public Float getPhosphAcidAmt() {
        return phosphAcidAmt;
    }

    public void setPhosphAcidAmt(Float phosphAcidAmt) {
        this.phosphAcidAmt = phosphAcidAmt;
    }

    public String getFirstHop() {
        return firstHop;
    }

    public void setFirstHop(String firstHop) {
        this.firstHop = firstHop;
    }

    public Float getFirstHopAmt() {
        return firstHopAmt;
    }

    public void setFirstHopAmt(Float firstHopAmt) {
        this.firstHopAmt = firstHopAmt;
    }

    public String getSecondHop() {
        return secondHop;
    }

    public void setSecondHop(String secondHop) {
        this.secondHop = secondHop;
    }

    public Float getSecondHopAmt() {
        return secondHopAmt;
    }

    public void setSecondHopAmt(Float secondHopAmt) {
        this.secondHopAmt = secondHopAmt;
    }

    public String getThirdHop() {
        return thirdHop;
    }

    public void setThirdHop(String thirdHop) {
        this.thirdHop = thirdHop;
    }

    public Float getThirdHopAmt() {
        return thirdHopAmt;
    }

    public void setThirdHopAmt(Float thirdHopAmt) {
        this.thirdHopAmt = thirdHopAmt;
    }

    public String getBaseMalt() {
        return baseMalt;
    }

    public void setBaseMalt(String baseMalt) {
        this.baseMalt = baseMalt;
    }

    public Float getBaseMaltAmt() {
        return baseMaltAmt;
    }

    public void setBaseMaltAmt(Float baseMaltAmt) {
        this.baseMaltAmt = baseMaltAmt;
    }

    public String getSecondMalt() {
        return secondMalt;
    }

    public void setSecondMalt(String secondMalt) {
        this.secondMalt = secondMalt;
    }

    public Float getSecondMaltAmt() {
        return secondMaltAmt;
    }

    public void setSecondMaltAmt(Float secondMaltAmt) {
        this.secondMaltAmt = secondMaltAmt;
    }

    public String getThirdMalt() {
        return thirdMalt;
    }

    public void setThirdMalt(String thirdMalt) {
        this.thirdMalt = thirdMalt;
    }

    public Float getThirdMaltAmt() {
        return thirdMaltAmt;
    }

    public void setThirdMaltAmt(Float thirdMaltAmt) {
        this.thirdMaltAmt = thirdMaltAmt;
    }

    public String getFourthMalt() {
        return fourthMalt;
    }

    public void setFourthMalt(String fourthMalt) {
        this.fourthMalt = fourthMalt;
    }

    public Float getFourthMaltAmt() {
        return fourthMaltAmt;
    }

    public void setFourthMaltAmt(Float fourthMaltAmt) {
        this.fourthMaltAmt = fourthMaltAmt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeName != null ? recipeName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.recipeName == null && other.recipeName != null) || (this.recipeName != null && !this.recipeName.equals(other.recipeName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Recipe[ recipeName=" + recipeName + " ]";
    }
    
}
