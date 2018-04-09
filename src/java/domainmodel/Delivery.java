/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * this class represents Deliveries being exported from village brewery
 * 
 * upon its creation it contains all attributes and operations for delivery
 * 
 * This class is only used by the view delivery and uses account, and employee 
 * 
 * @author Keegan Evans
 */
@Entity
@Table(name = "delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d")
    , @NamedQuery(name = "Delivery.findByDeliveryId", query = "SELECT d FROM Delivery d WHERE d.deliveryId = :deliveryId")
    , @NamedQuery(name = "Delivery.findByDate", query = "SELECT d FROM Delivery d WHERE d.date = :date")
    , @NamedQuery(name = "Delivery.findByCompanyName", query = "SELECT d FROM Delivery d WHERE d.companyName = :companyName")
    , @NamedQuery(name = "Delivery.findByEmpId", query = "SELECT d FROM Delivery d WHERE d.empId = :empId")})
public class Delivery implements Serializable {
    
    /**
     * Type long it represents the serial version unique identifier.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * This is a int number representing the delivery, it is a unique int used as an identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deliveryId")
    private Integer deliveryId;
    
    /**
     * This is a date for when the delivery will be sent it is in the format YYYY-MM-DD
     */
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    /**
     * This String is the name of the company that it will be sent to, this should have the same value as a row in Account
     */
    @Basic(optional = false)
    @Column(name = "companyName")
    private String companyName;
    
    /**
     * This is a int representing an employees unique id number this should have the same value as a row in employee
     */
    @Basic(optional = false)
    @Column(name = "empId")
    private int empId;

    /**
     * default constructor for Delivery,
     * upon instantiation it will create an Delivery with
     * attributes set as default state.
     */
    public Delivery() {
    }
    
    
    /**
     * This constructor creates a delivery with all values specified
     * @param deliveryId This is a unique int representing the delivery
     * @param companyName This is a String with representing the name of the company,  this has a common row in Account
     * @param empId This is a int that represents the employee who creates this, this has a common row in employee
     * @param date  This is a date variable in the format YYYY-MM-DD that represents the date for the delivery
     */
    public Delivery(Integer deliveryId, String companyName, int empId, Date date)
    {
        this.deliveryId = deliveryId;
        this.companyName = companyName;
        this.empId = empId;
        this.date = date;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryId != null ? deliveryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.deliveryId == null && other.deliveryId != null) || (this.deliveryId != null && !this.deliveryId.equals(other.deliveryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Delivery[ deliveryId=" + deliveryId + " ]";
    }
    
}
