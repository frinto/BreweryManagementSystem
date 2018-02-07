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
@Table(name = "finishedProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinishedProduct.findAll", query = "SELECT f FROM FinishedProduct f"),
    @NamedQuery(name = "FinishedProduct.findByProductName", query = "SELECT f FROM FinishedProduct f WHERE f.productName = :productName"),
    @NamedQuery(name = "FinishedProduct.findByQty", query = "SELECT f FROM FinishedProduct f WHERE f.qty = :qty")})
public class FinishedProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "productName")
    private String productName;
    @Column(name = "qty")
    private Integer qty;

    public FinishedProduct() {
    }

    public FinishedProduct(String productName) {
        this.productName = productName;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productName != null ? productName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinishedProduct)) {
            return false;
        }
        FinishedProduct other = (FinishedProduct) object;
        if ((this.productName == null && other.productName != null) || (this.productName != null && !this.productName.equals(other.productName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.FinishedProduct[ productName=" + productName + " ]";
    }
    
}
