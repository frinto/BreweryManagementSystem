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
@Table(name = "production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Production.findAll", query = "SELECT p FROM Production p")
    , @NamedQuery(name = "Production.findByProdId", query = "SELECT p FROM Production p WHERE p.prodId = :prodId")
    , @NamedQuery(name = "Production.findByQuantity", query = "SELECT p FROM Production p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Production.findByDate", query = "SELECT p FROM Production p WHERE p.date = :date")
    , @NamedQuery(name = "Production.findByEmployeeId", query = "SELECT p FROM Production p WHERE p.employeeId = :employeeId")
    , @NamedQuery(name = "Production.findBySvNum", query = "SELECT p FROM Production p WHERE p.svNum = :svNum")
    , @NamedQuery(name = "Production.findByProductionType", query = "SELECT p FROM Production p WHERE p.productionType = :productionType")
    , @NamedQuery(name = "Production.findByExpectedSvVolume", query = "SELECT p FROM Production p WHERE p.expectedSvVolume = :expectedSvVolume")
    , @NamedQuery(name = "Production.findByFinishedSvVolume", query = "SELECT p FROM Production p WHERE p.finishedSvVolume = :finishedSvVolume")
    , @NamedQuery(name = "Production.findByGainLoss", query = "SELECT p FROM Production p WHERE p.gainLoss = :gainLoss")
    , @NamedQuery(name = "Production.findByDateRange", query = "SELECT p FROM Production p WHERE p.date > :minDate AND p.date < :maxDate")})
public class Production implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prodId")
    private Integer prodId;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(name = "employeeId")
    private int employeeId;
    @Basic(optional = false)
    @Column(name = "svNum")
    private int svNum;
    @Basic(optional = false)
    @Column(name = "productionType")
    private String productionType;
    @Basic(optional = false)
    @Column(name = "expectedSvVolume")
    private double expectedSvVolume;
    @Basic(optional = false)
    @Column(name = "finishedSvVolume")
    private double finishedSvVolume;
    @Basic(optional = false)
    @Column(name = "gainLoss")
    private double gainLoss;

    public Production() {
    }

    public Production(Integer prodId) {
        this.prodId = prodId;
    }

    public Production(Integer prodId, int quantity, Date date, int employeeId, int svNum, String productionType, double expectedSvVolume, double finishedSvVolume, double gainLoss) {
        this.prodId = prodId;
        this.quantity = quantity;
        this.date = date;
        this.employeeId = employeeId;
        this.svNum = svNum;
        this.productionType = productionType;
        this.expectedSvVolume = expectedSvVolume;
        this.finishedSvVolume = finishedSvVolume;
        this.gainLoss = gainLoss;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSvNum() {
        return svNum;
    }

    public void setSvNum(int svNum) {
        this.svNum = svNum;
    }

    public String getProductionType() {
        return productionType;
    }

    public void setProductionType(String productionType) {
        this.productionType = productionType;
    }

    public double getExpectedSvVolume() {
        return expectedSvVolume;
    }

    public void setExpectedSvVolume(double expectedSvVolume) {
        this.expectedSvVolume = expectedSvVolume;
    }

    public double getFinishedSvVolume() {
        return finishedSvVolume;
    }

    public void setFinishedSvVolume(double finishedSvVolume) {
        this.finishedSvVolume = finishedSvVolume;
    }

    public double getGainLoss() {
        return gainLoss;
    }

    public void setGainLoss(double gainLoss) {
        this.gainLoss = gainLoss;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodId != null ? prodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Production)) {
            return false;
        }
        Production other = (Production) object;
        if ((this.prodId == null && other.prodId != null) || (this.prodId != null && !this.prodId.equals(other.prodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Production[ prodId=" + prodId + " ]";
    }
    
}
