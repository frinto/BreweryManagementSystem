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
 * @author 553817
 */
@Entity
@Table(name = "productionschedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productionschedule.findAll", query = "SELECT p FROM Productionschedule p")
    , @NamedQuery(name = "Productionschedule.findByDate", query = "SELECT p FROM Productionschedule p WHERE p.date = :date")
    , @NamedQuery(name = "Productionschedule.findByBrew1", query = "SELECT p FROM Productionschedule p WHERE p.brew1 = :brew1")
    , @NamedQuery(name = "Productionschedule.findByBrew2", query = "SELECT p FROM Productionschedule p WHERE p.brew2 = :brew2")
    , @NamedQuery(name = "Productionschedule.findByBrew3", query = "SELECT p FROM Productionschedule p WHERE p.brew3 = :brew3")
    , @NamedQuery(name = "Productionschedule.findByTransfer", query = "SELECT p FROM Productionschedule p WHERE p.transfer = :transfer")
    , @NamedQuery(name = "Productionschedule.findByProductionDetail", query = "SELECT p FROM Productionschedule p WHERE p.productionDetail = :productionDetail")})
public class Productionschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "brew1")
    private String brew1;
    @Column(name = "brew2")
    private String brew2;
    @Column(name = "brew3")
    private String brew3;
    @Column(name = "transfer")
    private String transfer;
    @Column(name = "productionDetail")
    private String productionDetail;

    public Productionschedule() {
    }

    public Productionschedule(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBrew1() {
        return brew1;
    }

    public void setBrew1(String brew1) {
        this.brew1 = brew1;
    }

    public String getBrew2() {
        return brew2;
    }

    public void setBrew2(String brew2) {
        this.brew2 = brew2;
    }

    public String getBrew3() {
        return brew3;
    }

    public void setBrew3(String brew3) {
        this.brew3 = brew3;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getProductionDetail() {
        return productionDetail;
    }

    public void setProductionDetail(String productionDetail) {
        this.productionDetail = productionDetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (date != null ? date.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productionschedule)) {
            return false;
        }
        Productionschedule other = (Productionschedule) object;
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Productionschedule[ date=" + date + " ]";
    }
    
}
