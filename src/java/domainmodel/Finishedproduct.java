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
    , @NamedQuery(name = "Finishedproduct.findByProductId", query = "SELECT f FROM Finishedproduct f WHERE f.productId = :productId")
    , @NamedQuery(name = "Finishedproduct.findByQty", query = "SELECT f FROM Finishedproduct f WHERE f.qty = :qty")})
public class Finishedproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "qty")
    private Integer qty;

    public Finishedproduct() {
    }

    public Finishedproduct(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finishedproduct)) {
            return false;
        }
        Finishedproduct other = (Finishedproduct) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Finishedproduct[ productId=" + productId + " ]";
    }
    
}
