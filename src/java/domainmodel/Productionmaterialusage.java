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
 * This class represents the production materials and what they are composed of, 
 * 
 * This uses the PK as well as the production materials table
 *
 * @author Keegan Evans
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

    
    /**
     * Type long it represents the serial version unique identifier.
     */
    
    private static final long serialVersionUID = 1L;
    
    /**
     * This is the PK which is composed of the String name and the String productionUsage 
     */
    @EmbeddedId
    protected ProductionmaterialusagePK productionmaterialusagePK;
    
    /**
     * This is the int representing the quantity of the material being used for that production
     */
    @Column(name = "materialQty")
    private Integer materialQty;

    /**
     * default constructor for productionmaterialusage,
     * upon instantiation it will create a productionmaterialusage with
     * attributes set as default state.
     */
    public Productionmaterialusage() {
    }

    /**
     * This is a constructor made up of just the primary key
     * @param productionmaterialusagePK This is the PK which is composed of the String name and the String productionUsage 
     */
    public Productionmaterialusage(ProductionmaterialusagePK productionmaterialusagePK) {
        this.productionmaterialusagePK = productionmaterialusagePK;
    }
    
    /**
     * This is a constructor made up of the PK as well as the qty 
     * @param productionmaterialusagePK This is the PK which is composed of the String name and the String productionUsage 
     * @param qty This is an int representing the quantity of the material being used for that production
     */
    public Productionmaterialusage(ProductionmaterialusagePK productionmaterialusagePK, int qty) {
        this.productionmaterialusagePK = productionmaterialusagePK;
        this.materialQty = qty;
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
