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
 *
 * @author 553817
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByCompanyName", query = "SELECT a FROM Account a WHERE a.accountPK.companyName = :companyName")
    , @NamedQuery(name = "Account.findByPhoneNumber", query = "SELECT a FROM Account a WHERE a.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Account.findByAddress", query = "SELECT a FROM Account a WHERE a.accountPK.address = :address")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccountPK accountPK;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public Account() {
    }

    public Account(AccountPK accountPK) {
        this.accountPK = accountPK;
    }

    public Account(String companyName, String address) {
        this.accountPK = new AccountPK(companyName, address);
    }

    public AccountPK getAccountPK() {
        return accountPK;
    }

    public void setAccountPK(AccountPK accountPK) {
        this.accountPK = accountPK;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getCompanyName() {
        return accountPK.getCompanyName();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountPK != null ? accountPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountPK == null && other.accountPK != null) || (this.accountPK != null && !this.accountPK.equals(other.accountPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Account[ accountPK=" + accountPK + " ]";
    }
    
}
