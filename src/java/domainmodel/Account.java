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
 * this class represents all accounts for deliveries
 * 
 * it contains the phone number, name and address for the account
 * 
 * It is only used for deliveries
 * 
 * @author Keegan Evans
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

    /**
     * Type long it represents the serial version unique identifier.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * This is the primary key for the account and this contains the String company name and String address
     */
    @EmbeddedId
    protected AccountPK accountPK;
    
    /**
     * This is the company phone number in the format XXX-XXX-XXXX
     */
    @Column(name = "phoneNumber")
    private String phoneNumber;

    /**
     * default constructor for Account,
     * upon instantiation it will create an Account with
     * attributes set as default state.
     */
    public Account() {
    }
    /**
     * This is a constructor for Account
     * upon creation it will initialize the name attribute of this object.
     * @param accountPK this is the primary key composed of the String company name and the String address
     */
    public Account(AccountPK accountPK) {
        this.accountPK = accountPK;
    }
    
    /**
     * This is a constructor for Account
     * upon creation it will initialize the name attribute of this object.
     * This is the same as creating it through the PK and was just for ease of use during testing
     * @param companyName This is a String composed representing the name of the company
     * @param address This is the address for that company location, needed since there could me multiple of the same company with different addresses
     */
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
