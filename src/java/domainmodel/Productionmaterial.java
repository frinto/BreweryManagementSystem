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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "productionmaterial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productionmaterial.findAll", query = "SELECT p FROM Productionmaterial p"),
    @NamedQuery(name = "Productionmaterial.findByName", query = "SELECT p FROM Productionmaterial p WHERE p.name = :name"),
    @NamedQuery(name = "Productionmaterial.findByQty", query = "SELECT p FROM Productionmaterial p WHERE p.qty = :qty")})
public class Productionmaterial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "qty")
    private Integer qty;

    public Productionmaterial() {
    }

    public Productionmaterial(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productionmaterial)) {
            return false;
        }
        Productionmaterial other = (Productionmaterial) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Productionmaterial[ name=" + name + " ]";
    }
    
}
