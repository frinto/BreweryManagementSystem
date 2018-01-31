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
 * @author root
 */
@Embeddable
public class ProductionMaterialUsagePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "usage")
    private String usage;

    public ProductionMaterialUsagePK() {
    }

    public ProductionMaterialUsagePK(String name, String usage) {
        this.name = name;
        this.usage = usage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        hash += (usage != null ? usage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductionMaterialUsagePK)) {
            return false;
        }
        ProductionMaterialUsagePK other = (ProductionMaterialUsagePK) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        if ((this.usage == null && other.usage != null) || (this.usage != null && !this.usage.equals(other.usage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.ProductionMaterialUsagePK[ name=" + name + ", usage=" + usage + " ]";
    }
    
}
