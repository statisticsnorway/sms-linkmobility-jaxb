//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.09 at 10:33:07 AM CET 
//


package no.ssb.linkmobility.jaxb.statusupdate.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "ref",
    "rcv",
    "state",
    "deliverytime"
})
@XmlRootElement(name = "MSG")
public class MSG {

    @XmlElement(name = "ID", required = true)
    protected String id;
    @XmlElement(name = "REF", required = true)
    protected String ref;
    @XmlElement(name = "RCV", required = true)
    protected String rcv;
    @XmlElement(name = "STATE", required = true)
    protected String state;
    @XmlElement(name = "DELIVERYTIME")
    protected String deliverytime;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREF() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREF(String value) {
        this.ref = value;
    }

    /**
     * Gets the value of the rcv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRCV() {
        return rcv;
    }

    /**
     * Sets the value of the rcv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRCV(String value) {
        this.rcv = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATE() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATE(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the deliverytime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERYTIME() {
        return deliverytime;
    }

    /**
     * Sets the value of the deliverytime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERYTIME(String value) {
        this.deliverytime = value;
    }

}
