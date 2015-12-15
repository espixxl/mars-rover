package com.orfertia.espinosa.rover.xml;

import com.ofertia.espinosa.rover.domain.Mars;
import com.ofertia.espinosa.rover.domain.Plateau;
import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.domain.RoverLocation;
import com.ofertia.espinosa.rover.domain.RoverMovementSequence;
import com.ofertia.espinosa.rover.domain.RoverOrientation;
import com.ofertia.espinosa.rover.jaxb.request.MarsRequest;
import com.ofertia.espinosa.rover.jaxb.response.MarsResponse;
import com.ofertia.espinosa.rover.jaxb.response.MarsResponse.RoverFinalPosition;
import com.orfertia.espinosa.rover.utils.InputUtils;

/**
 * The Class XmlUtils.
 * 
 * @author David Espinosa
 */
public class XmlUtils {

	/**
	 * Creates the mars from mars request.
	 *
	 * @param marsRequest the mars request
	 * @return the mars
	 */
	public static Mars createMarsFromMarsRequest(MarsRequest marsRequest) {
		
		Mars mars = new Mars();		
		Plateau plateau = new Plateau(marsRequest.getPlateau().getWidth(), marsRequest.getPlateau().getHeight());
		mars.setPlateau(plateau);
		MarsRequest.Rovers xmlRovers = marsRequest.getRovers();
		for (MarsRequest.Rovers.Rover xmlRover: xmlRovers.getRover()) {
			mars.addRover(createRoverFromXml(xmlRover));
		}		
		return mars;
	}
	
	/**
	 * Creates the rover from xml.
	 *
	 * @param xmlRover the xml rover
	 * @return the rover
	 */
	public static Rover createRoverFromXml(MarsRequest.Rovers.Rover xmlRover) {
		
		RoverOrientation roverOrientation = InputUtils.createRoverOrientationFromInput(xmlRover.getOrientation());
		RoverLocation roverLocation = new RoverLocation(xmlRover.getXPosition(), xmlRover.getYPosition(), roverOrientation);
		Rover rover = new Rover(xmlRover.getId(), roverLocation);
		RoverMovementSequence roverMovementSequence = InputUtils.createRoverMovementSequenceFromInput(xmlRover.getMovement());
		rover.setRoverMovementSequence(roverMovementSequence);
		
		return rover;		
	}
	
	/**
	 * Creates the xml from mars.
	 *
	 * @param mars the mars
	 * @return the mars response
	 */
	public static MarsResponse createXmlFromMars(Mars mars) {
		MarsResponse marsResponse = new MarsResponse();
		for (Rover rover: mars.getRovers().values()) {
			marsResponse.getRoverFinalPosition().add(createRoverFinalPosition(rover));
		}
		return marsResponse;
	}
	
	/**
	 * Creates the rover final position.
	 *
	 * @param rover the rover
	 * @return the rover final position
	 */
	public static RoverFinalPosition createRoverFinalPosition(Rover rover) {
		RoverFinalPosition roverFinalPosition = new RoverFinalPosition();
		roverFinalPosition.setId(rover.getRoverId());
		roverFinalPosition.setOrientation(String.valueOf(InputUtils.getOrientationChar(rover.getRoverLocation().getRoverOrientation())));
		roverFinalPosition.setXPostion(rover.getRoverLocation().getxPosition());
		roverFinalPosition.setYPosition(rover.getRoverLocation().getyPosition());
		return roverFinalPosition;
	}
}
