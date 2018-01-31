/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "productionMaterialUsage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductionMaterialUsage.findAll", query = "SELECT p FROM ProductionMaterialUsage p"),
    @NamedQuery(name = "ProductionMaterialUsage.findByMaterialQty", query = "SELECT p FROM ProductionMaterialUsage p WHERE p.materialQty = :materialQty"),
    @NamedQuery(name = "ProductionMaterialUsage.findByName", query = "SELECT p FROM ProductionMaterialUsage p WHERE p.productionMaterialUsagePK.name = :name"),
    @NamedQuery(name = "ProductionMaterialUsage.findByUsage", query = "SELECT p FROM ProductionMaterialUsage p WHERE p.productionMaterialUsagePK.usage = :usage")})
public class ProductionMaterialUsage implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductionMaterialUsagePK productionMaterialUsagePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "materialQty")
    private Double materialQty;

    public ProductionMaterialUsage() {
    }

    public ProductionMaterialUsage(ProductionMaterialUsagePK productionMaterialUsagePK) {
        this.productionMaterialUsagePK = productionMaterialUsagePK;
    }

    public ProductionMaterialUsage(String name, String usage) {
        this.productionMaterialUsagePK = new ProductionMaterialUsagePK(name, usage);
    }

    public ProductionMaterialUsagePK getProductionMaterialUsagePK() {
        return productionMaterialUsagePK;
    }

    public void setProductionMaterialUsagePK(ProductionMaterialUsagePK productionMaterialUsagePK) {
        this.productionMaterialUsagePK = productionMaterialUsagePK;
    }

    public Double getMaterialQty() {
        return materialQty;
    }

    public void setMaterialQty(Double materialQty) {
        this.materialQty = materialQty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productionMaterialUsagePK != null ? productionMaterialUsagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductionMaterialUsage)) {
            return false;
        }
        ProductionMaterialUsage other = (ProductionMaterialUsage) object;
        if ((this.productionMaterialUsagePK == null && other.productionMaterialUsagePK != null) || (this.productionMaterialUsagePK != null && !this.productionMaterialUsagePK.equals(other.productionMaterialUsagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.ProductionMaterialUsage[ productionMaterialUsagePK=" + productionMaterialUsagePK + " ]";
    }
    
}
