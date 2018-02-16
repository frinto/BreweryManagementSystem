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
@Table(name = "transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t"),
    @NamedQuery(name = "Transfer.findByTransferId", query = "SELECT t FROM Transfer t WHERE t.transferId = :transferId"),
    @NamedQuery(name = "Transfer.findByDate", query = "SELECT t FROM Transfer t WHERE t.date = :date"),
    @NamedQuery(name = "Transfer.findByVolume", query = "SELECT t FROM Transfer t WHERE t.volume = :volume"),
    @NamedQuery(name = "Transfer.findByFromFv", query = "SELECT t FROM Transfer t WHERE t.fromFv = :fromFv"),
    @NamedQuery(name = "Transfer.findByToSv", query = "SELECT t FROM Transfer t WHERE t.toSv = :toSv")})
public class Transfer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "transferId")
    private Integer transferId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "volume")
    private Long volume;
    @Basic(optional = false)
    @Column(name = "fromFv")
    private int fromFv;
    @Basic(optional = false)
    @Column(name = "toSv")
    private int toSv;

    public Transfer() {
    }

    public Transfer(Integer transferId) {
        this.transferId = transferId;
    }

    public Transfer(Integer transferId, Date date, int fromFv, int toSv, Long volume) {
        this.transferId = transferId;
        this.date = date;
        this.fromFv = fromFv;
        this.toSv = toSv;
        this.volume = volume;
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

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
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
