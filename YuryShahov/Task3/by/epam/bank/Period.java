//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.15 at 06:55:06 PM FET 
//


package by.epam.bank;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Period complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Period">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="profitability" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="time-type" type="{http://www.epam.by/bank}TimeType"/>
 *         &lt;element name="time-min" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="time-max" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Period", propOrder = {
    "profitability",
    "timeType",
    "timeMin",
    "timeMax"
})
public class Period {

    protected double profitability;
    @XmlElement(name = "time-type", required = true, defaultValue = "month")
    protected String timeType;
    @XmlElement(name = "time-min", type = Long.class)
    @XmlSchemaType(name = "unsignedInt")
    protected List<Long> timeMin;
    @XmlElement(name = "time-max", type = Long.class)
    @XmlSchemaType(name = "unsignedInt")
    protected List<Long> timeMax;

    /**
     * Gets the value of the profitability property.
     * 
     */
    public double getProfitability() {
        return profitability;
    }

    /**
     * Sets the value of the profitability property.
     * 
     */
    public void setProfitability(double value) {
        this.profitability = value;
    }

    /**
     * Gets the value of the timeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeType() {
        return timeType;
    }

    /**
     * Sets the value of the timeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeType(String value) {
        this.timeType = value;
    }

    /**
     * Gets the value of the timeMin property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeMin property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeMin().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getTimeMin() {
        if (timeMin == null) {
            timeMin = new ArrayList<Long>();
        }
        return this.timeMin;
    }

    /**
     * Gets the value of the timeMax property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeMax property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeMax().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getTimeMax() {
        if (timeMax == null) {
            timeMax = new ArrayList<Long>();
        }
        return this.timeMax;
    }

}