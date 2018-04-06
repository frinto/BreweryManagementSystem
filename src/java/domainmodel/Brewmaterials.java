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
 * This class represents the brew materials 
 * 
 * Upon instantiation this class will contain all attributes and 
 * operations used for brew materials
 * 
 * brew materials is used in raw inventory to keep track of all counts
 * of brew materials in the inventory
 * 
 * it is used by other classes as well that will update its quantity.
 * 
 * @author Huy Le
 */
@Entity
@Table(name = "brewmaterials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brewmaterials.findAll", query = "SELECT b FROM Brewmaterials b")
    , @NamedQuery(name = "Brewmaterials.findByName", query = "SELECT b FROM Brewmaterials b WHERE b.name = :name")
    , @NamedQuery(name = "Brewmaterials.findByQty", query = "SELECT b FROM Brewmaterials b WHERE b.qty = :qty")
    , @NamedQuery(name = "Brewmaterials.findByUnits", query = "SELECT b FROM Brewmaterials b WHERE b.units = :units")
    , @NamedQuery(name = "Brewmaterials.findByType", query = "SELECT b FROM Brewmaterials b WHERE b.type = :type")})
public class Brewmaterials implements Serializable {

    /**
     * this represents the serial version unique identifier
     * It is of type long.
     */
    private static final long serialVersionUID = 1L;
     /**
     * this represents the name of the brew materials
     * it is of type String.
     */
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
     /**
     * this represents the quantity of the brew materials
     * It is of type Double.
     */
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
     /**
     * this represents the unit of measurement for this brew material
     * it is of type String.
     */
    @Column(name = "units")
    private String units;
        /**
     * this represents the type of brew materials
     * It is of type String.
     */
    @Column(name = "type")
    private String type;

    
    /**
     * default constructor for brew materials.
     */
    public Brewmaterials() {
    }

    /**
     * constructor that initializes the name
     * @param name type String it represents the name of the brew material.
     */
    public Brewmaterials(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        if (!(object instanceof Brewmaterials)) {
            return false;
        }
        Brewmaterials other = (Brewmaterials) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Brewmaterials[ name=" + name + " ]";
    }
    
}
