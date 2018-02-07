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
@Table(name = "purchaseorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchaseorder.findAll", query = "SELECT p FROM Purchaseorder p"),
    @NamedQuery(name = "Purchaseorder.findByPurchaseOrderId", query = "SELECT p FROM Purchaseorder p WHERE p.purchaseOrderId = :purchaseOrderId"),
    @NamedQuery(name = "Purchaseorder.findByMaterialId", query = "SELECT p FROM Purchaseorder p WHERE p.materialId = :materialId"),
    @NamedQuery(name = "Purchaseorder.findByQty", query = "SELECT p FROM Purchaseorder p WHERE p.qty = :qty"),
    @NamedQuery(name = "Purchaseorder.findByEmpId", query = "SELECT p FROM Purchaseorder p WHERE p.empId = :empId"),
    @NamedQuery(name = "Purchaseorder.findBySupplierId", query = "SELECT p FROM Purchaseorder p WHERE p.supplierId = :supplierId"),
    @NamedQuery(name = "Purchaseorder.findByDateArrived", query = "SELECT p FROM Purchaseorder p WHERE p.dateArrived = :dateArrived")})
public class Purchaseorder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "purchaseOrderId")
    private Integer purchaseOrderId;
    @Column(name = "materialId")
    private Integer materialId;
    @Column(name = "qty")
    private Integer qty;
    @Basic(optional = false)
    @Column(name = "empId")
    private int empId;
    @Basic(optional = false)
    @Column(name = "supplierId")
    private int supplierId;
    @Column(name = "dateArrived")
    @Temporal(TemporalType.DATE)
    private Date dateArrived;

    public Purchaseorder() {
    }

    public Purchaseorder(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Purchaseorder(Integer purchaseOrderId, int empId, int supplierId) {
        this.purchaseOrderId = purchaseOrderId;
        this.empId = empId;
        this.supplierId = supplierId;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public Date getDateArrived() {
        return dateArrived;
    }

    public void setDateArrived(Date dateArrived) {
        this.dateArrived = dateArrived;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderId != null ? purchaseOrderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchaseorder)) {
            return false;
        }
        Purchaseorder other = (Purchaseorder) object;
        if ((this.purchaseOrderId == null && other.purchaseOrderId != null) || (this.purchaseOrderId != null && !this.purchaseOrderId.equals(other.purchaseOrderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Purchaseorder[ purchaseOrderId=" + purchaseOrderId + " ]";
    }
    
}
