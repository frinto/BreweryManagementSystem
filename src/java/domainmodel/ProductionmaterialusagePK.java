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
 * @author 579957
 */
@Embeddable
public class ProductionmaterialusagePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "usage")
    private String usage;

    public ProductionmaterialusagePK() {
    }

    public ProductionmaterialusagePK(String name, String usage) {
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
        if (!(object instanceof ProductionmaterialusagePK)) {
            return false;
        }
        ProductionmaterialusagePK other = (ProductionmaterialusagePK) object;
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
        return "domainmodel.ProductionmaterialusagePK[ name=" + name + ", usage=" + usage + " ]";
    }
    
}
