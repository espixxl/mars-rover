package com.espinosa.rover.jaxb.request;

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
 *         &lt;element name="Plateau">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;sequence>
 *           &lt;element name="Rovers">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="Rover" maxOccurs="unbounded">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                             &lt;attribute name="xPosition" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                             &lt;attribute name="yPosition" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                             &lt;attribute name="orientation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                             &lt;attribute name="movement" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
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
    "plateau",
    "rovers"
})
@XmlRootElement(name = "MarsRequest")
public class MarsRequest {

    @XmlElement(name = "Plateau", required = true)
    protected MarsRequest.Plateau plateau;
    @XmlElement(name = "Rovers", required = true)
    protected MarsRequest.Rovers rovers;

    /**
     * Obtiene el valor de la propiedad plateau.
     * 
     * @return
     *     possible object is
     *     {@link MarsRequest.Plateau }
     *     
     */
    public MarsRequest.Plateau getPlateau() {
        return plateau;
    }

    /**
     * Define el valor de la propiedad plateau.
     * 
     * @param value
     *     allowed object is
     *     {@link MarsRequest.Plateau }
     *     
     */
    public void setPlateau(MarsRequest.Plateau value) {
        this.plateau = value;
    }

    /**
     * Obtiene el valor de la propiedad rovers.
     * 
     * @return
     *     possible object is
     *     {@link MarsRequest.Rovers }
     *     
     */
    public MarsRequest.Rovers getRovers() {
        return rovers;
    }

    /**
     * Define el valor de la propiedad rovers.
     * 
     * @param value
     *     allowed object is
     *     {@link MarsRequest.Rovers }
     *     
     */
    public void setRovers(MarsRequest.Rovers value) {
        this.rovers = value;
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
     *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Plateau {

        @XmlAttribute(name = "width")
        protected Integer width;
        @XmlAttribute(name = "height")
        protected Integer height;

        /**
         * Obtiene el valor de la propiedad width.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getWidth() {
            return width;
        }

        /**
         * Define el valor de la propiedad width.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setWidth(Integer value) {
            this.width = value;
        }

        /**
         * Obtiene el valor de la propiedad height.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getHeight() {
            return height;
        }

        /**
         * Define el valor de la propiedad height.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setHeight(Integer value) {
            this.height = value;
        }

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
     *       &lt;sequence>
     *         &lt;element name="Rover" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="xPosition" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="yPosition" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="orientation" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="movement" type="{http://www.w3.org/2001/XMLSchema}string" />
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
        "rover"
    })
    public static class Rovers {

        @XmlElement(name = "Rover", required = true)
        protected List<MarsRequest.Rovers.Rover> rover;

        /**
         * Gets the value of the rover property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rover property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRover().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MarsRequest.Rovers.Rover }
         * 
         * 
         */
        public List<MarsRequest.Rovers.Rover> getRover() {
            if (rover == null) {
                rover = new ArrayList<MarsRequest.Rovers.Rover>();
            }
            return this.rover;
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
         *       &lt;attribute name="xPosition" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="yPosition" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="orientation" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="movement" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Rover {

            @XmlAttribute(name = "id")
            protected Integer id;
            @XmlAttribute(name = "xPosition")
            protected Integer xPosition;
            @XmlAttribute(name = "yPosition")
            protected Integer yPosition;
            @XmlAttribute(name = "orientation")
            protected String orientation;
            @XmlAttribute(name = "movement")
            protected String movement;

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
             * Obtiene el valor de la propiedad xPosition.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getXPosition() {
                return xPosition;
            }

            /**
             * Define el valor de la propiedad xPosition.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setXPosition(Integer value) {
                this.xPosition = value;
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

            /**
             * Obtiene el valor de la propiedad movement.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMovement() {
                return movement;
            }

            /**
             * Define el valor de la propiedad movement.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMovement(String value) {
                this.movement = value;
            }

        }

    }

}
