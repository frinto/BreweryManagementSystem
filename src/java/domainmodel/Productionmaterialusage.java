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
 * @author 579957
 */
@Entity
@Table(name = "productionmaterialusage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productionmaterialusage.findAll", query = "SELECT p FROM Productionmaterialusage p")
    , @NamedQuery(name = "Productionmaterialusage.findByMaterialQty", query = "SELECT p FROM Productionmaterialusage p WHERE p.materialQty = :materialQty")
    , @NamedQuery(name = "Productionmaterialusage.findByName", query = "SELECT p FROM Productionmaterialusage p WHERE p.productionmaterialusagePK.name = :name")
    , @NamedQuery(name = "Productionmaterialusage.findByUsage", query = "SELECT p FROM Productionmaterialusage p WHERE p.productionmaterialusagePK.usage = :usage")
    , @NamedQuery(name = "Productionmaterialusage.findByVolumePerOne", query = "SELECT p FROM Productionmaterialusage p WHERE p.volumePerOne = :volumePerOne")})
public class Productionmaterialusage implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductionmaterialusagePK productionmaterialusagePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "materialQty")
    private Double materialQty;
    @Column(name = "volumePerOne")
    private Double volumePerOne;

    public Productionmaterialusage() {
    }

    public Productionmaterialusage(ProductionmaterialusagePK productionmaterialusagePK) {
        this.productionmaterialusagePK = productionmaterialusagePK;
    }

    public Productionmaterialusage(String name, String usage) {
        this.productionmaterialusagePK = new ProductionmaterialusagePK(name, usage);
    }

    public ProductionmaterialusagePK getProductionmaterialusagePK() {
        return productionmaterialusagePK;
    }

    public void setProductionmaterialusagePK(ProductionmaterialusagePK productionmaterialusagePK) {
        this.productionmaterialusagePK = productionmaterialusagePK;
    }

    public Double getMaterialQty() {
        return materialQty;
    }

    public void setMaterialQty(Double materialQty) {
        this.materialQty = materialQty;
    }

    public Double getVolumePerOne() {
        return volumePerOne;
    }

    public void setVolumePerOne(Double volumePerOne) {
        this.volumePerOne = volumePerOne;
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
