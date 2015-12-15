//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.12.15 a las 08:06:53 PM CET 
//


package com.ofertia.espinosa.rover.jaxb.request;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ofertia.espinosa.rover.jaxb.request package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ofertia.espinosa.rover.jaxb.request
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MarsRequest }
     * 
     */
    public MarsRequest createMarsRequest() {
        return new MarsRequest();
    }

    /**
     * Create an instance of {@link MarsRequest.Rovers }
     * 
     */
    public MarsRequest.Rovers createMarsRequestRovers() {
        return new MarsRequest.Rovers();
    }

    /**
     * Create an instance of {@link MarsRequest.Plateau }
     * 
     */
    public MarsRequest.Plateau createMarsRequestPlateau() {
        return new MarsRequest.Plateau();
    }

    /**
     * Create an instance of {@link MarsRequest.Rovers.Rover }
     * 
     */
    public MarsRequest.Rovers.Rover createMarsRequestRoversRover() {
        return new MarsRequest.Rovers.Rover();
    }

}
