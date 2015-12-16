package com.ofertia.espinosa.rover.jaxb.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoverFinalPosition" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="yPosition" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="xPostion" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="orientation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "roverFinalPosition"
})
@XmlRootElement(name = "MarsResponse")
public class MarsResponse {

    @XmlElement(name = "RoverFinalPosition", required = true)
    protected List<MarsResponse.RoverFinalPosition> roverFinalPosition;

    /**
     * Gets the value of the roverFinalPosition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roverFinalPosition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoverFinalPosition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MarsResponse.RoverFinalPosition }
     * 
     * 
     */
    public List<MarsResponse.RoverFinalPosition> getRoverFinalPosition() {
        if (roverFinalPosition == null) {
            roverFinalPosition = new ArrayList<MarsResponse.RoverFinalPosition>();
        }
        return this.roverFinalPosition;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="yPosition" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="xPostion" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="orientation" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RoverFinalPosition {

        @XmlAttribute(name = "id")
        protected Integer id;
        @XmlAttribute(name = "yPosition")
        protected Integer yPosition;
        @XmlAttribute(name = "xPostion")
        protected Integer xPostion;
        @XmlAttribute(name = "orientation")
        protected String orientation;

        /**
         * Obtiene el valor de la propiedad id.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getId() {
            return id;
        }

        /**
         * Define el valor de la propiedad id.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setId(Integer value) {
            this.id = value;
        }

        /**
         * Obtiene el valor de la propiedad yPosition.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getYPosition() {
            return yPosition;
        }

        /**
         * Define el valor de la propiedad yPosition.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setYPosition(Integer value) {
            this.yPosition = value;
        }

        /**
         * Obtiene el valor de la propiedad xPostion.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getXPostion() {
            return xPostion;
        }

        /**
         * Define el valor de la propiedad xPostion.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setXPostion(Integer value) {
            this.xPostion = value;
        }

        /**
         * Obtiene el valor de la propiedad orientation.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrientation() {
            return orientation;
        }

        /**
         * Define el valor de la propiedad orientation.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrientation(String value) {
            this.orientation = value;
        }

    }

}
