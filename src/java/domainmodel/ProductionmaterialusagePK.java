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
 * This class represents the productionmaterialusagePK and which is used to make a productionmaterialusage object
 *
 * @author Keegan Evans
 */
@Embeddable
public class ProductionmaterialusagePK implements Serializable {

    /**
     * This is a String representing the name of the productionmaterialusage object
     */
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    
    /**
     * This a String usage this is an object from production material that the usage object is composed of
     */
    @Basic(optional = false)
    @Column(name = "ProductionUsage")
    private String productionUsage;

    /**
     * default constructor for productionmaterialusagePK,
     * upon instantiation it will create a productionmaterialusagePK with
     * attributes set as default state.
     */
    public ProductionmaterialusagePK() {
    }

    /**
     * This is a constructor for productionmaterialusagePK that is composed of name and usage
     * @param name This a String usage this is an object from production material that the usage object is composed of
     * @param productionUsage This is a String representing the name of the productionmaterialusage object
     */
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
