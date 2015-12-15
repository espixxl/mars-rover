package com.ofertia.espinosa.rover.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ofertia.espinosa.rover.domain.Mars;
import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.jaxb.MarsUnmarshaller;
import com.ofertia.espinosa.rover.jaxb.request.MarsRequest;
import com.ofertia.espinosa.rover.jaxb.response.MarsResponse;
import com.orfertia.espinosa.rover.actuator.MarsActuator;
import com.orfertia.espinosa.rover.exception.CollisionException;
import com.orfertia.espinosa.rover.xml.XmlUtils;


/**
 * The Class RestServer.
 * 
 * @author David Espinosa
 */
public class RestServer extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new rest server.
     *
     * @see HttpServlet#HttpServlet()
     */
    public RestServer() {
        super();
    }

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MarsRequest marsRequest = MarsUnmarshaller.unmarshalXMLData(request.getInputStream());
			MarsResponse marsResponse = createResponse(marsRequest);
			String xmlResponse = MarsUnmarshaller.marshalMarsResponse(marsResponse);
			response.getWriter().append(xmlResponse);
		} catch (Exception e) {

		}
	}

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MarsRequest marsRequest = MarsUnmarshaller.unmarshalXMLData(request.getInputStream());
			MarsResponse marsResponse = createResponse(marsRequest);
			String xmlResponse = MarsUnmarshaller.marshalMarsResponse(marsResponse);
			response.getWriter().append(xmlResponse);
		} catch (Exception e) {

		}
	}

	/**
	 * Creates the response.
	 *
	 * @param marsRequest the mars request
	 * @return the mars response
	 * @throws CollisionException the collision exception
	 */
	private MarsResponse createResponse(MarsRequest marsRequest) throws CollisionException {
		Mars mars = XmlUtils.createMarsFromMarsRequest(marsRequest);
		MarsActuator marsActuator = new MarsActuator(mars);
		for (Rover rover: mars.getRovers().values()) {
			marsActuator.moveRover(rover.getRoverId(), rover.getRoverMovementSequence());
		}
		
		MarsResponse marsResponse = XmlUtils.createXmlFromMars(marsActuator.getMars());
		return marsResponse;
	}
}
