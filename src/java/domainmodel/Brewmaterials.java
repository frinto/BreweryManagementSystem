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
 * @author 553817
 */
@Entity
@Table(name = "brewmaterials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brewmaterials.findAll", query = "SELECT b FROM Brewmaterials b")
    , @NamedQuery(name = "Brewmaterials.findByName", query = "SELECT b FROM Brewmaterials b WHERE b.name = :name")
    , @NamedQuery(name = "Brewmaterials.findByQty", query = "SELECT b FROM Brewmaterials b WHERE b.qty = :qty")
    , @NamedQuery(name = "Brewmaterials.findByUnits", query = "SELECT b FROM Brewmaterials b WHERE b.units = :units")
    , @NamedQuery(name = "Brewmaterials.findByType", query = "SELECT b FROM Brewmaterials b WHERE b.type = :type")})
public class Brewmaterials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "qty")
    private Double qty;
    @Column(name = "units")
    private String units;
    @Column(name = "type")
    private String type;

    public Brewmaterials() {
    }

    public Brewmaterials(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }
    
    public void useMaterial(double usage)
    {
        double qty = this.getQty();
        double newQty = qty - usage;
        this.setQty(newQty);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brewmaterials)) {
            return false;
        }
        Brewmaterials other = (Brewmaterials) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domainmodel.Brewmaterials[ name=" + name + " ]";
    }
    
}
