/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author 740991
 */
@Embeddable
public class ProductionmaterialusagePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "ProductionUsage")
    private String productionUsage;

    public ProductionmaterialusagePK() {
    }

    public ProductionmaterialusagePK(String name, String productionUsage) {
        this.name = name;
        this.productionUsage = productionUsage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductionUsage() {
        return productionUsage;
    }

    public void setProductionUsage(String productionUsage) {
        this.productionUsage = productionUsage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        hash += (productionUsage != null ? productionUsage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductionmaterialusagePK)) {
            return false;
        }
        ProductionmaterialusagePK other = (ProductionmaterialusagePK) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        if ((this.productionUsage == null && other.productionUsage != null) || (this.productionUsage != null && !this.productionUsage.equals(other.productionUsage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.ProductionmaterialusagePK[ name=" + name + ", productionUsage=" + productionUsage + " ]";
    }
    
}
