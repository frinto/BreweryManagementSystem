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
 *
 * @author root
 */
@Entity
@Table(name = "delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d"),
    @NamedQuery(name = "Delivery.findByDeliveryId", query = "SELECT d FROM Delivery d WHERE d.deliveryId = :deliveryId"),
    @NamedQuery(name = "Delivery.findByDate", query = "SELECT d FROM Delivery d WHERE d.date = :date"),
    @NamedQuery(name = "Delivery.findByAccountId", query = "SELECT d FROM Delivery d WHERE d.accountId = :accountId"),
    @NamedQuery(name = "Delivery.findByEmpId", query = "SELECT d FROM Delivery d WHERE d.empId = :empId"),
    @NamedQuery(name = "Delivery.findByFinishedProductId", query = "SELECT d FROM Delivery d WHERE d.finishedProductId = :finishedProductId")})
public class Delivery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deliveryId")
    private Integer deliveryId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "accountId")
    private int accountId;
    @Basic(optional = false)
    @Column(name = "empId")
    private int empId;
    @Basic(optional = false)
    @Column(name = "finishedProductId")
    private int finishedProductId;

    public Delivery() {
    }

    public Delivery(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Delivery(Integer deliveryId, int accountId, int empId, int finishedProductId) {
        this.deliveryId = deliveryId;
        this.accountId = accountId;
        this.empId = empId;
        this.finishedProductId = finishedProductId;
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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getFinishedProductId() {
        return finishedProductId;
    }

    public void setFinishedProductId(int finishedProductId) {
        this.finishedProductId = finishedProductId;
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
