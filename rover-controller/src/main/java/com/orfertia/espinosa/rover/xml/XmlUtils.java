package com.orfertia.espinosa.rover.xml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ofertia.espinosa.rover.domain.Mars;
import com.ofertia.espinosa.rover.domain.Plateau;
import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.domain.RoverLocation;
import com.ofertia.espinosa.rover.domain.RoverMovementSequence;
import com.ofertia.espinosa.rover.domain.RoverOrientation;
import com.ofertia.espinosa.rover.jaxb.request.MarsRequest;
import com.ofertia.espinosa.rover.jaxb.request.MarsRequest.Rovers;
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
    public static Mars createMarsFromMarsRequest(final MarsRequest marsRequest) {

        final Mars mars = new Mars();
        final Plateau plateau = new Plateau(marsRequest.getPlateau().getWidth(), marsRequest.getPlateau().getHeight());
        mars.setPlateau(plateau);
        final MarsRequest.Rovers xmlRovers = marsRequest.getRovers();
        for (final MarsRequest.Rovers.Rover xmlRover : xmlRovers.getRover()) {
            mars.addRover(createRoverFromXml(xmlRover));
        }
        return mars;
    }  
    
    /**
     * Creates the mars request from input line.
     *
     * @param inputLine the input line
     * @return the mars request
     * @throws Exception the exception
     */
    public static MarsRequest createMarsRequestFromInputLine(final String inputLine) throws Exception {
        final MarsRequest mars = new MarsRequest();
        final String inputTokens[] = inputLine.split(" ");

        final int plateauWidth = Integer.valueOf(inputTokens[0]);
        final int plateauHeigth = Integer.valueOf(inputTokens[1]);

        final com.ofertia.espinosa.rover.jaxb.request.MarsRequest.Plateau xmlPlateau = new com.ofertia.espinosa.rover.jaxb.request.MarsRequest.Plateau();
    	xmlPlateau.setWidth(plateauWidth);
    	xmlPlateau.setHeight(plateauHeigth);
    	
        final Rovers rovers = createXmlRoversFromInput(Arrays.copyOfRange(inputTokens, 2, inputTokens.length));

        mars.setPlateau(xmlPlateau);
        mars.setRovers(rovers);

        return mars;
    }   
    
    /**
     * Creates the xml rovers from input.
     *
     * @param message the message
     * @return the list
     */
    public static Rovers createXmlRoversFromInput(final String message[]) {
    	
    	final Rovers xmlRovers = new Rovers();
        for (final com.ofertia.espinosa.rover.jaxb.request.MarsRequest.Rovers.Rover xmlRover : createXmlRoversFromInput(0, message)) {
        	xmlRovers.getRover().add(xmlRover);
        }
        return xmlRovers;
    }

    /**
     * Creates the xml rovers from input.
     *
     * @param initialRoverId the initial rover id
     * @param message the message
     * @return the list
     */
    public static List<com.ofertia.espinosa.rover.jaxb.request.MarsRequest.Rovers.Rover> createXmlRoversFromInput(final int initialRoverId, final String message[]) {

        final List<com.ofertia.espinosa.rover.jaxb.request.MarsRequest.Rovers.Rover> xmlRovers = new ArrayList<com.ofertia.espinosa.rover.jaxb.request.MarsRequest.Rovers.Rover>();

        final int roverXPosition = Integer.valueOf(message[0]);
        final int roverYPosition = Integer.valueOf(message[1]);
        
        com.ofertia.espinosa.rover.jaxb.request.MarsRequest.Rovers.Rover xmlRover = new com.ofertia.espinosa.rover.jaxb.request.MarsRequest.Rovers.Rover();
        xmlRover.setId(initialRoverId);
        xmlRover.setOrientation(message[2]);
        xmlRover.setMovement(message[3]);
        xmlRover.setXPosition(roverXPosition);
        xmlRover.setYPosition(roverYPosition);
        
        xmlRovers.add(xmlRover);

        if (message.length > 4) {
        	xmlRovers.addAll(createXmlRoversFromInput(initialRoverId + 1, Arrays.copyOfRange(message, 4, message.length)));
        }
        return xmlRovers;
    }
    
    /**
     * Creates the rover from xml.
     *
     * @param xmlRover the xml rover
     * @return the rover
     */
    public static Rover createRoverFromXml(final MarsRequest.Rovers.Rover xmlRover) {

        final RoverOrientation roverOrientation = InputUtils.createRoverOrientationFromInput(xmlRover.getOrientation());
        final RoverLocation roverLocation = new RoverLocation(xmlRover.getXPosition(), xmlRover.getYPosition(), roverOrientation);
        final Rover rover = new Rover(xmlRover.getId(), roverLocation);
        final RoverMovementSequence roverMovementSequence = InputUtils.createRoverMovementSequenceFromInput(xmlRover.getMovement());
        rover.setRoverMovementSequence(roverMovementSequence);

        return rover;
    }

    /**
     * Creates the xml from mars.
     *
     * @param mars the mars
     * @return the mars response
     */
    public static MarsResponse createXmlFromMars(final Mars mars) {
        final MarsResponse marsResponse = new MarsResponse();
        for (final Rover rover : mars.getRovers().values()) {
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
    public static RoverFinalPosition createRoverFinalPosition(final Rover rover) {

        final RoverFinalPosition roverFinalPosition = new RoverFinalPosition();
        roverFinalPosition.setId(rover.getRoverId());
        roverFinalPosition.setOrientation(String.valueOf(InputUtils.getOrientationChar(rover.getRoverLocation().getRoverOrientation())));
        roverFinalPosition.setXPostion(rover.getRoverLocation().getxPosition());
        roverFinalPosition.setYPosition(rover.getRoverLocation().getyPosition());
        return roverFinalPosition;
    }
    
    /**
     * Creates the rover final position.
     *
     * @param roverFromRoverFinalPosition the rover from rover final position
     * @return the rover final position
     */
    public static Rover createRoverFromRoverFinalPosition(final RoverFinalPosition roverFromRoverFinalPosition) {

    	final RoverLocation roverLocation = new RoverLocation(roverFromRoverFinalPosition.getXPostion(), roverFromRoverFinalPosition.getYPosition(), InputUtils.createRoverOrientationFromInput(roverFromRoverFinalPosition.getOrientation()));
    	final Rover rover = new Rover(roverFromRoverFinalPosition.getId(), roverLocation);
        return rover;
    }
    
    /**
     * Creates the rovers from mars response.
     *
     * @param marsResponse the mars response
     * @return the list
     */
    public static List<Rover> createRoversFromMarsResponse(MarsResponse marsResponse) {
    	
    	List<Rover> rovers = new ArrayList<Rover>();
    	for(RoverFinalPosition roverFinalPosition: marsResponse.getRoverFinalPosition()) {
    		rovers.add(createRoverFromRoverFinalPosition(roverFinalPosition));
    	}
    	return rovers;
    }
}
