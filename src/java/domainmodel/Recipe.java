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
@Table(name = "recipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.findByRecipeId", query = "SELECT r FROM Recipe r WHERE r.recipeId = :recipeId"),
    @NamedQuery(name = "Recipe.findByMashInTemp", query = "SELECT r FROM Recipe r WHERE r.mashInTemp = :mashInTemp"),
    @NamedQuery(name = "Recipe.findByMashInTime", query = "SELECT r FROM Recipe r WHERE r.mashInTime = :mashInTime"),
    @NamedQuery(name = "Recipe.findByMashWaterVolume", query = "SELECT r FROM Recipe r WHERE r.mashWaterVolume = :mashWaterVolume"),
    @NamedQuery(name = "Recipe.findByRestTime", query = "SELECT r FROM Recipe r WHERE r.restTime = :restTime"),
    @NamedQuery(name = "Recipe.findByRaiseToTemp", query = "SELECT r FROM Recipe r WHERE r.raiseToTemp = :raiseToTemp"),
    @NamedQuery(name = "Recipe.findByInTime", query = "SELECT r FROM Recipe r WHERE r.inTime = :inTime"),
    @NamedQuery(name = "Recipe.findByTotalMashTime", query = "SELECT r FROM Recipe r WHERE r.totalMashTime = :totalMashTime"),
    @NamedQuery(name = "Recipe.findByUnderletLitres", query = "SELECT r FROM Recipe r WHERE r.underletLitres = :underletLitres"),
    @NamedQuery(name = "Recipe.findByRest", query = "SELECT r FROM Recipe r WHERE r.rest = :rest"),
    @NamedQuery(name = "Recipe.findByVorlaufTime", query = "SELECT r FROM Recipe r WHERE r.vorlaufTime = :vorlaufTime"),
    @NamedQuery(name = "Recipe.findByFirstWortGrav", query = "SELECT r FROM Recipe r WHERE r.firstWortGrav = :firstWortGrav"),
    @NamedQuery(name = "Recipe.findByRunOffTime", query = "SELECT r FROM Recipe r WHERE r.runOffTime = :runOffTime"),
    @NamedQuery(name = "Recipe.findBySpargVol", query = "SELECT r FROM Recipe r WHERE r.spargVol = :spargVol"),
    @NamedQuery(name = "Recipe.findBySpargTemp", query = "SELECT r FROM Recipe r WHERE r.spargTemp = :spargTemp"),
    @NamedQuery(name = "Recipe.findByLastRunningsGrav", query = "SELECT r FROM Recipe r WHERE r.lastRunningsGrav = :lastRunningsGrav"),
    @NamedQuery(name = "Recipe.findByKettleFullVol", query = "SELECT r FROM Recipe r WHERE r.kettleFullVol = :kettleFullVol"),
    @NamedQuery(name = "Recipe.findByKettleFullGrav", query = "SELECT r FROM Recipe r WHERE r.kettleFullGrav = :kettleFullGrav"),
    @NamedQuery(name = "Recipe.findByBoilTime", query = "SELECT r FROM Recipe r WHERE r.boilTime = :boilTime"),
    @NamedQuery(name = "Recipe.findByStrikeOutVol", query = "SELECT r FROM Recipe r WHERE r.strikeOutVol = :strikeOutVol"),
    @NamedQuery(name = "Recipe.findByStrikeOutGrav", query = "SELECT r FROM Recipe r WHERE r.strikeOutGrav = :strikeOutGrav"),
    @NamedQuery(name = "Recipe.findByWhirlPoolTime", query = "SELECT r FROM Recipe r WHERE r.whirlPoolTime = :whirlPoolTime"),
    @NamedQuery(name = "Recipe.findByCoolInTemp", query = "SELECT r FROM Recipe r WHERE r.coolInTemp = :coolInTemp"),
    @NamedQuery(name = "Recipe.findByOxygenRate", query = "SELECT r FROM Recipe r WHERE r.oxygenRate = :oxygenRate"),
    @NamedQuery(name = "Recipe.findByGypsumAmt", query = "SELECT r FROM Recipe r WHERE r.gypsumAmt = :gypsumAmt"),
    @NamedQuery(name = "Recipe.findByCalciumChlorideAmt", query = "SELECT r FROM Recipe r WHERE r.calciumChlorideAmt = :calciumChlorideAmt"),
    @NamedQuery(name = "Recipe.findBySodiumChlorideAmt", query = "SELECT r FROM Recipe r WHERE r.sodiumChlorideAmt = :sodiumChlorideAmt"),
    @NamedQuery(name = "Recipe.findByPhosphAcidAmt", query = "SELECT r FROM Recipe r WHERE r.phosphAcidAmt = :phosphAcidAmt"),
    @NamedQuery(name = "Recipe.findByFirstHop", query = "SELECT r FROM Recipe r WHERE r.firstHop = :firstHop"),
    @NamedQuery(name = "Recipe.findBySecondHop", query = "SELECT r FROM Recipe r WHERE r.secondHop = :secondHop"),
    @NamedQuery(name = "Recipe.findByThirdHop", query = "SELECT r FROM Recipe r WHERE r.thirdHop = :thirdHop"),
    @NamedQuery(name = "Recipe.findByBaseMalt", query = "SELECT r FROM Recipe r WHERE r.baseMalt = :baseMalt"),
    @NamedQuery(name = "Recipe.findBySecondMalt", query = "SELECT r FROM Recipe r WHERE r.secondMalt = :secondMalt"),
    @NamedQuery(name = "Recipe.findByThirdMalt", query = "SELECT r FROM Recipe r WHERE r.thirdMalt = :thirdMalt"),
    @NamedQuery(name = "Recipe.findByFourthMalt", query = "SELECT r FROM Recipe r WHERE r.fourthMalt = :fourthMalt"),
    @NamedQuery(name = "Recipe.findByBrandId", query = "SELECT r FROM Recipe r WHERE r.brandId = :brandId")})
public class Recipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "recipeId")
    private Integer recipeId;
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
    @Column(name = "secondHop")
    private String secondHop;
    @Column(name = "thirdHop")
    private String thirdHop;
    @Column(name = "baseMalt")
    private String baseMalt;
    @Column(name = "secondMalt")
    private String secondMalt;
    @Column(name = "thirdMalt")
    private String thirdMalt;
    @Column(name = "fourthMalt")
    private String fourthMalt;
    @Basic(optional = false)
    @Column(name = "brandId")
    private int brandId;

    public Recipe() {
    }

    public Recipe(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Recipe(Integer recipeId, int brandId) {
        this.recipeId = recipeId;
        this.brandId = brandId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
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

    public String getSecondHop() {
        return secondHop;
    }

    public void setSecondHop(String secondHop) {
        this.secondHop = secondHop;
    }

    public String getThirdHop() {
        return thirdHop;
    }

    public void setThirdHop(String thirdHop) {
        this.thirdHop = thirdHop;
    }

    public String getBaseMalt() {
        return baseMalt;
    }

    public void setBaseMalt(String baseMalt) {
        this.baseMalt = baseMalt;
    }

    public String getSecondMalt() {
        return secondMalt;
    }

    public void setSecondMalt(String secondMalt) {
        this.secondMalt = secondMalt;
    }

    public String getThirdMalt() {
        return thirdMalt;
    }

    public void setThirdMalt(String thirdMalt) {
        this.thirdMalt = thirdMalt;
    }

    public String getFourthMalt() {
        return fourthMalt;
    }

    public void setFourthMalt(String fourthMalt) {
        this.fourthMalt = fourthMalt;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeId != null ? recipeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.recipeId == null && other.recipeId != null) || (this.recipeId != null && !this.recipeId.equals(other.recipeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Recipe[ recipeId=" + recipeId + " ]";
    }
    
}
