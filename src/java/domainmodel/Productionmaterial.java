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
 * this class represents production materials used in village brewery
 * 
 * upon its creation it contains all attributes and operations for production
 * materials
 * 
 * production materials is used for raw inventory but is also accessed by other
 * classes such as database classes.
 * 
 * @author Huy Le
 */
@Entity
@Table(name = "productionmaterial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productionmaterial.findAll", query = "SELECT p FROM Productionmaterial p")
    , @NamedQuery(name = "Productionmaterial.findByName", query = "SELECT p FROM Productionmaterial p WHERE p.name = :name")
    , @NamedQuery(name = "Productionmaterial.findByQty", query = "SELECT p FROM Productionmaterial p WHERE p.qty = :qty")})
public class Productionmaterial implements Serializable {

    /**
     * Type long it represents the serial version unique identifier.
     */
    private static final long serialVersionUID = 1L;
     /**
     * Type String it represents the name of the production material.
     */
    @Id
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
      /**
     * Type Integer it represents the quantity of the production material.
     */
    @Column(name = "qty")
    private Integer qty;

    /**
     * default constructor for production material,
     * upon instantiation it will create a production material with
     * attributes set as default state.
     */
    public Productionmaterial() {
    }

    /**
     * constructor for production material
     * upon creation it will initialize the name attribute of this object.
     * @param name type String it represents the name of this object.
     */
    public Productionmaterial(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productionmaterial)) {
            return false;
        }
        Productionmaterial other = (Productionmaterial) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Productionmaterial[ name=" + name + " ]";
    }
    
}
