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
 * @author 740991
 */
@Entity
@Table(name = "productionmaterialusage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productionmaterialusage.findAll", query = "SELECT p FROM Productionmaterialusage p")
    , @NamedQuery(name = "Productionmaterialusage.findByMaterialQty", query = "SELECT p FROM Productionmaterialusage p WHERE p.materialQty = :materialQty")
    , @NamedQuery(name = "Productionmaterialusage.findByName", query = "SELECT p FROM Productionmaterialusage p WHERE p.productionmaterialusagePK.name = :name")
    , @NamedQuery(name = "Productionmaterialusage.findByProductionUsage", query = "SELECT p FROM Productionmaterialusage p WHERE p.productionmaterialusagePK.productionUsage = :productionUsage")})
public class Productionmaterialusage implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductionmaterialusagePK productionmaterialusagePK;
    @Column(name = "materialQty")
    private Integer materialQty;

    public Productionmaterialusage() {
    }

    public Productionmaterialusage(ProductionmaterialusagePK productionmaterialusagePK) {
        this.productionmaterialusagePK = productionmaterialusagePK;
    }
    public Productionmaterialusage(ProductionmaterialusagePK productionmaterialusagePK, int qty) {
        this.productionmaterialusagePK = productionmaterialusagePK;
        this.materialQty = qty;
    }

    public Productionmaterialusage(String name, String productionUsage) {
        this.productionmaterialusagePK = new ProductionmaterialusagePK(name, productionUsage);
    }

    public ProductionmaterialusagePK getProductionmaterialusagePK() {
        return productionmaterialusagePK;
    }

    public void setProductionmaterialusagePK(ProductionmaterialusagePK productionmaterialusagePK) {
        this.productionmaterialusagePK = productionmaterialusagePK;
    }

    public Integer getMaterialQty() {
        return materialQty;
    }

    public void setMaterialQty(Integer materialQty) {
        this.materialQty = materialQty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productionmaterialusagePK != null ? productionmaterialusagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productionmaterialusage)) {
            return false;
        }
        Productionmaterialusage other = (Productionmaterialusage) object;
        if ((this.productionmaterialusagePK == null && other.productionmaterialusagePK != null) || (this.productionmaterialusagePK != null && !this.productionmaterialusagePK.equals(other.productionmaterialusagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Productionmaterialusage[ productionmaterialusagePK=" + productionmaterialusagePK + " ]";
    }
    
}
