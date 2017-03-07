
package com.sise.supplier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for supplierType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="supplierType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suptypeid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="suptypename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "supplierType", propOrder = {
    "remark",
    "suptypeid",
    "suptypename"
})
public class SupplierType {

    protected String remark;
    protected String suptypeid;
    protected String suptypename;

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the suptypeid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuptypeid() {
        return suptypeid;
    }

    /**
     * Sets the value of the suptypeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuptypeid(String value) {
        this.suptypeid = value;
    }

    /**
     * Gets the value of the suptypename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuptypename() {
        return suptypename;
    }

    /**
     * Sets the value of the suptypename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuptypename(String value) {
        this.suptypename = value;
    }

}
