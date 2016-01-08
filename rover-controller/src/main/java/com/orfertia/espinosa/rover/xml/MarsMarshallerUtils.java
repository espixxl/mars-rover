package com.orfertia.espinosa.rover.xml;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.espinosa.rover.jaxb.request.MarsRequest;
import com.espinosa.rover.jaxb.response.MarsResponse;

/**
 * The Class MarsUnmarshaller.
 * 
 * @author David Espinosa
 */
public class MarsMarshallerUtils {

    /**
     * Unmarshal xml data.
     *
     * @param is the is
     * @return the mars request
     * @throws Exception the exception
     */
    public static MarsRequest unmarshalXMLData(final InputStream is) throws Exception {

        final JAXBContext jContext = JAXBContext.newInstance(MarsRequest.class);
        final MarsRequest mars = (MarsRequest) jContext.createUnmarshaller().unmarshal(is);
        return mars;
    }

    /**
     * Marshal mars response.
     *
     * @param marsResponse the mars response
     * @param outputStream the output stream
     * @throws JAXBException the JAXB exception
     */
    public static void marshalMarsResponse(final MarsResponse marsResponse, final OutputStream outputStream) throws JAXBException {

        final JAXBContext jContext = JAXBContext.newInstance(MarsResponse.class);
        final Marshaller marshaller = jContext.createMarshaller();
        marshaller.marshal(marsResponse, outputStream);
    }
    
    /**
     * Unmarshal mars response.
     *
     * @param inputStream the input stream
     * @return the mars response
     * @throws JAXBException the JAXB exception
     */
    public static MarsResponse unmarshalMarsResponse(final InputStream inputStream) throws JAXBException {
    	final JAXBContext jContext = JAXBContext.newInstance(MarsResponse.class);
    	final MarsResponse marsResponse = (MarsResponse) jContext.createUnmarshaller().unmarshal(inputStream);
    	return marsResponse;    	
    }

    /**
     * Marshal mars response.
     *
     * @param marsResponse the mars response
     * @return the string
     * @throws JAXBException the JAXB exception
     */
    public static String marshalMarsResponse(final MarsResponse marsResponse) throws JAXBException {

        final JAXBContext jContext = JAXBContext.newInstance(MarsResponse.class);
        final Marshaller marshaller = jContext.createMarshaller();
        final StringWriter stringWriter = new StringWriter();
        marshaller.marshal(marsResponse, stringWriter);
        return stringWriter.toString();
    }
    
    /**
     * Marshal mars request.
     *
     * @param mars the mars
     * @return the string
     * @throws JAXBException the JAXB exception
     */
    public static String marshalMarsRequest(final MarsRequest mars) throws JAXBException {

        final JAXBContext jContext = JAXBContext.newInstance(MarsRequest.class);
        final Marshaller marshaller = jContext.createMarshaller();
        final StringWriter stringWriter = new StringWriter();
        marshaller.marshal(mars, stringWriter);
        return stringWriter.toString();
    }
}
