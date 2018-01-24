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
    , @NamedQuery(name = "Production.findByBrandId", query = "SELECT p FROM Production p WHERE p.brandId = :brandId")
    , @NamedQuery(name = "Production.findBySvNum", query = "SELECT p FROM Production p WHERE p.svNum = :svNum")
    , @NamedQuery(name = "Production.findByProductionType", query = "SELECT p FROM Production p WHERE p.productionType = :productionType")})
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
    @Column(name = "brandId")
    private int brandId;
    @Basic(optional = false)
    @Column(name = "svNum")
    private int svNum;
    @Basic(optional = false)
    @Column(name = "productionType")
    private String productionType;

    public Production() {
    }

    public Production(Integer prodId) {
        this.prodId = prodId;
    }

    public Production(Integer prodId, int quantity, Date date, int employeeId, int brandId, int svNum, String productionType) {
        this.prodId = prodId;
        this.quantity = quantity;
        this.date = date;
        this.employeeId = employeeId;
        this.brandId = brandId;
        this.svNum = svNum;
        this.productionType = productionType;
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

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
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
