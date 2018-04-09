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
 * @author 553817
 */
@Entity
@Table(name = "transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t")
    , @NamedQuery(name = "Transfer.findByTransferId", query = "SELECT t FROM Transfer t WHERE t.transferId = :transferId")
    , @NamedQuery(name = "Transfer.findByDate", query = "SELECT t FROM Transfer t WHERE t.date = :date")
    , @NamedQuery(name = "Transfer.findByVolume", query = "SELECT t FROM Transfer t WHERE t.volume = :volume")
    , @NamedQuery(name = "Transfer.findByFromFv", query = "SELECT t FROM Transfer t WHERE t.fromFv = :fromFv")
    , @NamedQuery(name = "Transfer.findByToSv", query = "SELECT t FROM Transfer t WHERE t.toSv = :toSv")
    , @NamedQuery(name = "Transfer.findByBrand", query = "SELECT t FROM Transfer t WHERE t.brand = :brand")
    , @NamedQuery(name = "Transfer.findByCorrection", query = "SELECT t FROM Transfer t WHERE t.correction = :correction")
    , @NamedQuery(name = "Transfer.findByDateRange", query = "SELECT t FROM Transfer t WHERE t.date > :minDate AND t.date < :maxDate")})
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transferId")
    private Integer transferId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "volume")
    private Double volume;
    @Basic(optional = false)
    @Column(name = "fromFv")
    private int fromFv;
    @Basic(optional = false)
    @Column(name = "toSv")
    private int toSv;
    @Column(name = "brand")
    private String brand;
    @Column(name = "correction")
    private Double correction;

    public Transfer() {
    }

    public Transfer(Integer transferId) {
        this.transferId = transferId;
    }

    public Transfer(Integer transferId, int fromFv, int toSv) {
        this.transferId = transferId;
        this.fromFv = fromFv;
        this.toSv = toSv;
    }
    public Transfer(Integer transferId, Date date, String brand, int fromFv, int toSv, Double volume, Double correction) {
        this.transferId = transferId;
        this.date = date;
        this.brand = brand;
        this.fromFv = fromFv;
        this.toSv = toSv;
        this.volume = volume;
        this.correction = correction;
    }

    public Integer getTransferId() {
        return transferId;
    }

    public void setTransferId(Integer transferId) {
        this.transferId = transferId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public int getFromFv() {
        return fromFv;
    }

    public void setFromFv(int fromFv) {
        this.fromFv = fromFv;
    }

    public int getToSv() {
        return toSv;
    }

    public void setToSv(int toSv) {
        this.toSv = toSv;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getCorrection() {
        return correction;
    }

    public void setCorrection(Double correction) {
        this.correction = correction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transferId != null ? transferId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfer)) {
            return false;
        }
        Transfer other = (Transfer) object;
        if ((this.transferId == null && other.transferId != null) || (this.transferId != null && !this.transferId.equals(other.transferId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Transfer[ transferId=" + transferId + " ]";
    }
    
}
