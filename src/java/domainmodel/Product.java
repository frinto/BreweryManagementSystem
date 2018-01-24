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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
    , @NamedQuery(name = "Product.findByFinishedProductId", query = "SELECT p FROM Product p WHERE p.finishedProductId = :finishedProductId")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @Column(name = "finishedProductId")
    private Integer finishedProductId;

    public Product() {
    }

    public Product(Integer finishedProductId) {
        this.finishedProductId = finishedProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFinishedProductId() {
        return finishedProductId;
    }

    public void setFinishedProductId(Integer finishedProductId) {
        this.finishedProductId = finishedProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finishedProductId != null ? finishedProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.finishedProductId == null && other.finishedProductId != null) || (this.finishedProductId != null && !this.finishedProductId.equals(other.finishedProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Product[ finishedProductId=" + finishedProductId + " ]";
    }
    
}
