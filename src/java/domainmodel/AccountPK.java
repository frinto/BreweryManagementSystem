/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * this class represents the primary key needed to create an account object
 * 
 * it contains the name and address for the account
 * 
 * It is only used by Account
 * 
 * @author Keegan Evans
 */
@Embeddable
public class AccountPK implements Serializable {

    /**
     * This is a String representing the name of the company
     */
    @Basic(optional = false)
    @Column(name = "companyName")
    private String companyName;
    
    /**
     * This is a String representing the address for the company
     */
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    
    /**
     * default constructor for AccountPK,
     * upon instantiation it will create an AccountPK with
     * attributes set as default state.
     */
    public AccountPK() {
    }
/**
     * This is a constructor for AccountPK
     * upon creation it will initialize the name attribute of this object.
     * This is the same as creating it through the PK and was just for ease of use during testing
     * @param companyName This is a String composed representing the name of the company
     * @param address This is the address for that company location, needed since there could me multiple of the same company with different addresses
     */
 
    public AccountPK(String companyName, String address) {
        this.companyName = companyName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyName != null ? companyName.hashCode() : 0);
        hash += (address != null ? address.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountPK)) {
            return false;
        }
        AccountPK other = (AccountPK) object;
        if ((this.companyName == null && other.companyName != null) || (this.companyName != null && !this.companyName.equals(other.companyName))) {
            return false;
        }
        if ((this.address == null && other.address != null) || (this.address != null && !this.address.equals(other.address))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.AccountPK[ companyName=" + companyName + ", address=" + address + " ]";
    }
    
}
