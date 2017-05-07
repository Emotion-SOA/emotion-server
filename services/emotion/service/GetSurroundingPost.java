
package emotion.api.client.services.emotion.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSurroundingPost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSurroundingPost"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSurroundingPost", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class GetSurroundingPost {

    protected float arg0;
    protected float arg1;
    protected float arg2;

    /**
     * Gets the value of the arg0 property.
     * 
     */
    public float getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     */
    public void setArg0(float value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     */
    public float getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     */
    public void setArg1(float value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     */
    public float getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     */
    public void setArg2(float value) {
        this.arg2 = value;
    }

}
