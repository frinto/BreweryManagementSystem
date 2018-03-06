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
@Table(name = "finishedproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finishedproduct.findAll", query = "SELECT f FROM Finishedproduct f")
    , @NamedQuery(name = "Finishedproduct.findByProductName", query = "SELECT f FROM Finishedproduct f WHERE f.productName = :productName")
    , @NamedQuery(name = "Finishedproduct.findByQty", query = "SELECT f FROM Finishedproduct f WHERE f.qty = :qty")
    , @NamedQuery(name = "Finishedproduct.findByVolumePerUnit", query = "SELECT f FROM Finishedproduct f WHERE f.volumePerUnit = :volumePerUnit")})
public class Finishedproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "productName")
    private String productName;
    @Column(name = "qty")
    private Integer qty;
    @Basic(optional = false)
    @Column(name = "volumePerUnit")
    private double volumePerUnit;

    public Finishedproduct() {
    }

    public Finishedproduct(String productName) {
        this.productName = productName;
    }

    public Finishedproduct(String productName, double volumePerUnit) {
        this.productName = productName;
        this.volumePerUnit = volumePerUnit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public double getVolumePerUnit() {
        return volumePerUnit;
    }

    public void setVolumePerUnit(double volumePerUnit) {
        this.volumePerUnit = volumePerUnit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productName != null ? productName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finishedproduct)) {
            return false;
        }
        Finishedproduct other = (Finishedproduct) object;
        if ((this.productName == null && other.productName != null) || (this.productName != null && !this.productName.equals(other.productName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Finishedproduct[ productName=" + productName + " ]";
    }
    
}
