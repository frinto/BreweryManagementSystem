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
    /**
     * name of the brew material
     */
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    /**
     * amount of a brew material
     */
    @Column(name = "qty")
    private Double qty;
    /**
     * unit of weight of the brew material
     */
    @Column(name = "units")
    private String units;
    /**
     * type of brew material
     */
    @Column(name = "type")
    private String type;
    /**
     * Default constructor
     */
    public Brewmaterials() {
    }
    /**
     * Constructs a brew material with a name
     * @param name name of the brew material
     */
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
