
package emotion.api.client.services.emotion.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Post complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Post"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="latitude" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="longtitude" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="postID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="publishTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Post", propOrder = {
    "latitude",
    "longtitude",
    "postID",
    "publishTime",
    "text",
    "userID"
})
public class Post {

    protected float latitude;
    protected float longtitude;
    protected int postID;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar publishTime;
    protected String text;
    protected int userID;

    /**
     * Gets the value of the latitude property.
     * 
     */
    public float getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     */
    public void setLatitude(float value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longtitude property.
     * 
     */
    public float getLongtitude() {
        return longtitude;
    }

    /**
     * Sets the value of the longtitude property.
     * 
     */
    public void setLongtitude(float value) {
        this.longtitude = value;
    }

    /**
     * Gets the value of the postID property.
     * 
     */
    public int getPostID() {
        return postID;
    }

    /**
     * Sets the value of the postID property.
     * 
     */
    public void setPostID(int value) {
        this.postID = value;
    }

    /**
     * Gets the value of the publishTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPublishTime() {
        return publishTime;
    }

    /**
     * Sets the value of the publishTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPublishTime(XMLGregorianCalendar value) {
        this.publishTime = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     */
    public void setUserID(int value) {
        this.userID = value;
    }

}
