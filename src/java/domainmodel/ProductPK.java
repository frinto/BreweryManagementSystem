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
 *
 * @author reare
 */
@Embeddable
public class ProductPK implements Serializable
{

    @Basic(optional = false)
    @Column(name = "productName")
    private String productName;
    @Basic(optional = false)
    @Column(name = "deliveryId")
    private int deliveryId;

    public ProductPK()
    {
    }

    public ProductPK(String productName, int deliveryId)
    {
        this.productName = productName;
        this.deliveryId = deliveryId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public int getDeliveryId()
    {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (productName != null ? productName.hashCode() : 0);
        hash += (int) deliveryId;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductPK))
        {
            return false;
        }
        ProductPK other = (ProductPK) object;
        if ((this.productName == null && other.productName != null) || (this.productName != null && !this.productName.equals(other.productName)))
        {
            return false;
        }
        if (this.deliveryId != other.deliveryId)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "domainmodel.ProductPK[ productName=" + productName + ", deliveryId=" + deliveryId + " ]";
    }
    
}
