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
 * This class implements the finished product object
 * it is responsible for creation and working with finished product which is used
 * for finished inventory
 * 
 * Upon instantiation a Finishedproduct object will be created for use inside the 
 * FinishedInventoryDB class to save this object to the database
 * 
 * Its state will be saved and all attributes that pertain to this class will be
 * saved in addition several operations can be used for working with this 
 * class including getters and setters.
 * 
 * @author Huy Le
 */
@Entity
@Table(name = "finishedproduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finishedproduct.findAll", query = "SELECT f FROM Finishedproduct f")
    , @NamedQuery(name = "Finishedproduct.findByProductName", query = "SELECT f FROM Finishedproduct f WHERE f.productName = :productName")
    , @NamedQuery(name = "Finishedproduct.findByQty", query = "SELECT f FROM Finishedproduct f WHERE f.qty = :qty")
    , @NamedQuery(name = "Finishedproduct.findByVolumePerUnit", query = "SELECT f FROM Finishedproduct f WHERE f.volumePerUnit = :volumePerUnit")})
public class Finishedproduct implements Serializable {

    /**
     * This is the serial version UID auto generated from domain model generator.
     * It is of type long.
     */
    private static final long serialVersionUID = 1L;
        /**
     * the product name of the the finished product.
     * it is of type String.
     */
    @Id
    @Basic(optional = false)
    @Column(name = "productName")
    private String productName;
        /**
     * the quantity of the finished product.
     * it is of type Integer.
     */
    @Column(name = "qty")
    private Integer qty;
     /**
     * the volume per unit of the finished product.
     * it is of type double.
     */
    @Basic(optional = false)
    @Column(name = "volumePerUnit")
    private double volumePerUnit;

    /**
     * default constructor for finished product.
     */
    public Finishedproduct() {
    }

    /**
     * upon creation this constructor will initialize the productName of this 
     * class with the value inputed in the parameter productName.
     * @param productName String type that represents the product name 
     * of this object.
     */
    public Finishedproduct(String productName) {
        this.productName = productName;
    }

    /**
     * upon creation this constructor will initialize the productName and 
     * volumePerUnit with the values specified in its arguments.
     * @param productName type String it is the product name of this class.
     * @param volumePerUnit type double represents the volume per unit 
     * value of this class.
     */
    public Finishedproduct(String productName, double volumePerUnit) {
        this.productName = productName;
        this.volumePerUnit = volumePerUnit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public double getVolumePerUnit() {
        return volumePerUnit;
    }

    public void setVolumePerUnit(double volumePerUnit) {
        this.volumePerUnit = volumePerUnit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productName != null ? productName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finishedproduct)) {
            return false;
        }
        Finishedproduct other = (Finishedproduct) object;
        if ((this.productName == null && other.productName != null) || (this.productName != null && !this.productName.equals(other.productName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Finishedproduct[ productName=" + productName + " ]";
    }
    
}
