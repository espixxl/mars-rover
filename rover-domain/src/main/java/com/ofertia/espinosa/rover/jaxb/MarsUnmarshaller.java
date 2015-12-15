package com.ofertia.espinosa.rover.jaxb;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.ofertia.espinosa.rover.jaxb.request.MarsRequest;
import com.ofertia.espinosa.rover.jaxb.response.MarsResponse;

/**
 * The Class MarsUnmarshaller.
 */
public class MarsUnmarshaller {

	/**
	 * Unmarshal xml data.
	 *
	 * @param is the is
	 * @return the mars request
	 * @throws Exception the exception
	 */
	public static MarsRequest unmarshalXMLData(InputStream is) throws Exception{
	 
	    JAXBContext jContext = JAXBContext.newInstance(MarsRequest.class);
	    MarsRequest mars = (MarsRequest)jContext.createUnmarshaller().unmarshal(is);
	    return mars;	 
	}
	
	/**
	 * Marshal mars response.
	 *
	 * @param marsResponse the mars response
	 * @param outputStream the output stream
	 * @throws JAXBException the JAXB exception
	 */
	public static void marshalMarsResponse(MarsResponse marsResponse, OutputStream outputStream) throws JAXBException {
		
		JAXBContext jContext = JAXBContext.newInstance(MarsResponse.class); 
		Marshaller marshaller = jContext.createMarshaller();		
		marshaller.marshal(marsResponse,outputStream);
	}
	
	/**
	 * Marshal mars response.
	 *
	 * @param marsResponse the mars response
	 * @return the string
	 * @throws JAXBException the JAXB exception
	 */
	public static String marshalMarsResponse(MarsResponse marsResponse) throws JAXBException {
		
		JAXBContext jContext = JAXBContext.newInstance(MarsResponse.class); 
		Marshaller marshaller = jContext.createMarshaller();
		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(marsResponse,stringWriter);
		return stringWriter.toString();
	}
}
