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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * this class deals with all information with employees within
 * the company
 * 
 * it is used to keep information about employees and
 * upon instantiation of this object it will contain
 * all attributes and operations for employees.
 * 
 * @author Huy Le
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmpId", query = "SELECT e FROM Employee e WHERE e.empId = :empId")
    , @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByRoleId", query = "SELECT e FROM Employee e WHERE e.roleId = :roleId")
    , @NamedQuery(name = "Employee.findByIsActive", query = "SELECT e FROM Employee e WHERE e.isActive = :isActive")
    , @NamedQuery(name = "Employee.findByResetPasswordUUID", query = "SELECT e FROM Employee e WHERE e.resetPasswordUUID = :resetPasswordUUID")})
public class Employee implements Serializable {

    /**
     * type long it represents the serial version unique identifier.
     */
    private static final long serialVersionUID = 1L;
    /**
     * type Integer it represents the employee id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empId")
    private Integer empId;
    /**
     * type String it represents the first name of the employee.
     */
    @Column(name = "firstName")
    private String firstName;
    /**
     * type String it represents the last name of the employee.
     */
    @Column(name = "lastName")
    private String lastName;
    /**
     * type String it represents the password of the employee.
     */
    @Column(name = "password")
    private String password;
    /**
     * type String it represents the email of the employee.
     */
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    /**
     * type int it represents the role id of the employee.
     */
    @Basic(optional = false)
    @Column(name = "roleId")
    private int roleId;
    /**
     * type short it represents a number 0 for inactive and 1 for active
     * setting this value sets if the employee is allowed to login or not.
     */
    @Basic(optional = false)
    @Column(name = "isActive")
    private short isActive;
    /**
     * type String
     * represents the reset unique identifier used for resetting the password
     * of the employee.
     */
    @Column(name = "resetPasswordUUID")
    private String resetPasswordUUID;

    /**
     * default constructor for employee
     * upon creation it will set all attributes to its default values.
     */
    public Employee() {
    }

    /**
     * constructor for employee it will initialize the employee id.
     * @param empId type Integer it represents the employee id.
     */
    public Employee(Integer empId) {
        this.empId = empId;
    }

    /**
     * constructor for employee it will initialize employee id
     * email, role id, and sets their active status.
     * @param empId type Integer represents the employee id.
     * @param email type String it represents the email of the employee.
     * @param roleId type int it represents the role ID of the employee.
     * @param isActive  type short it is 0 if the employee isnt active and 1
     * if the employee is active.
     */
    public Employee(Integer empId, String email, int roleId, short isActive) {
        this.empId = empId;
        this.email = email;
        this.roleId = roleId;
        this.isActive = isActive;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public String getResetPasswordUUID() {
        return resetPasswordUUID;
    }

    public void setResetPasswordUUID(String resetPasswordUUID) {
        this.resetPasswordUUID = resetPasswordUUID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Employee[ empId=" + empId + " ]";
    }
    
}
