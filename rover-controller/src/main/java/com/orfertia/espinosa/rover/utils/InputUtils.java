package com.orfertia.espinosa.rover.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ofertia.espinosa.rover.domain.Mars;
import com.ofertia.espinosa.rover.domain.Plateau;
import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.domain.RoverLocation;
import com.ofertia.espinosa.rover.domain.RoverMovement;
import com.ofertia.espinosa.rover.domain.RoverMovementSequence;
import com.ofertia.espinosa.rover.domain.RoverOrientation;
import com.ofertia.espinosa.rover.domain.RoverRotation;

/**
 * The Class InputUtils.
 */
public class InputUtils {

	/**
	 * Creates the mars from input line.
	 *
	 * @param inputLine the input line
	 * @return the mars
	 * @throws Exception the exception
	 */
	public static Mars createMarsFromInputLine(String inputLine) throws Exception {
		Mars mars = new Mars();
		String inputTokens[] = inputLine.split(" ");
		
		//first two elements corresponds to plateuau dimensions
		int plateauWidth = Integer.valueOf(inputTokens[0]);
		int plateauHeigth = Integer.valueOf(inputTokens[1]);
		Plateau plateau = new Plateau(plateauWidth, plateauHeigth);
		
		Map<Integer, Rover> rovers = createRoversFromInput(Arrays.copyOfRange(inputTokens, 2, inputTokens.length));
		
		mars.setPlateau(plateau);
		mars.setRovers(rovers);
		
		return mars;
	}	
	
	/**
	 * Creates the rovers from input.
	 *
	 * @param message the message
	 * @return the hash map
	 */
	public static HashMap<Integer, Rover> createRoversFromInput(String message[]) {
		
		HashMap<Integer, Rover> rovers = new HashMap<Integer, Rover>();
		for (Rover rover: createRoversFromInput(0, message)) {
			rovers.put(rover.getRoverId(), rover);
		}
		
		return rovers;
	}
	
	/**
	 * Creates the rovers from input.
	 *
	 * @param initialRoverId the initial rover id
	 * @param message the message
	 * @return the list
	 */
	public static List<Rover> createRoversFromInput(int initialRoverId, String message[]) {
		
		List<Rover> rovers = new ArrayList<Rover>();
		
		int roverXPosition = Integer.valueOf(message[0]);
		int roverYPosition = Integer.valueOf(message[1]);		
		RoverOrientation roverOrientation = createRoverOrientationFromInput(message[2]);
		RoverLocation roverLocation = new RoverLocation(roverXPosition, roverYPosition, roverOrientation);
		Rover rover = new Rover(initialRoverId, roverLocation);
				
		RoverMovementSequence roverMovementSequence = createRoverMovementSequenceFromInput(message[3]);
		rover.setRoverMovementSequence(roverMovementSequence);
		rovers.add(rover);
		
		if (message.length>4) {
			rovers.addAll(createRoversFromInput(initialRoverId+1, Arrays.copyOfRange(message, 4, message.length)));
		}
		return rovers;
	}
	
	/**
	 * Creates the rover orientation from input.
	 *
	 * @param message the message
	 * @return the rover orientation
	 */
	public static RoverOrientation createRoverOrientationFromInput(String message) {
		
		RoverOrientation roverOrientation;
		switch (message) {
		case "N":
			roverOrientation = RoverOrientation.NORTH;
			break;
		case "E":
			roverOrientation = RoverOrientation.EAST;
			break;
		case "S":
			roverOrientation = RoverOrientation.SOUTH;
			break;
		default:
			roverOrientation = RoverOrientation.WEST;
			break;
		}
		return roverOrientation;
	}
		
	/**
	 * Creates the rover movement sequence from input.
	 * Although it's not indicated into the exercise wording, I take for granted that the sequence of movements 
	 * will never be ended by a L or R.
	 * 
	 * @param message the message
	 * @return the rover movement sequence
	 */
	public static RoverMovementSequence createRoverMovementSequenceFromInput(String message) {
		RoverMovementSequence roverMovementSequence = new RoverMovementSequence();
		String movements[] = message.split("(?<=M)");
		
		for (String movement: movements) {
			roverMovementSequence.addRoverMovement(createRoverMovementFromInput(movement));	
		}
		return roverMovementSequence;
	}
		
	/**
	 * Creates the rover movement from input.
	 *
	 * @param message the message
	 * @return the rover movement
	 */
	public static RoverMovement createRoverMovementFromInput(String message) {
		RoverMovement roverMovement = new RoverMovement();
		
		for(char charachter: message.toCharArray()) {
			if (charachter == 'M') {
				break;
			} else if (charachter == 'L') {
				roverMovement.addRoverRotation(RoverRotation.LEFT);
			} else if (charachter == 'R') {
				roverMovement.addRoverRotation(RoverRotation.RIGHT);
			}
		}
		return roverMovement;
	}
		
	/**
	 * Creates the output line.
	 *
	 * @param rovers the rovers
	 * @return the string
	 */
	public static String createOutputLine(List<Rover> rovers) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i=0; i<rovers.size();i++) {
			Rover rover = rovers.get(i);
			if (i>0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(rover.getRoverLocation().getxPosition() + " " + rover.getRoverLocation().getyPosition() +" " + getOrientationChar(rover.getRoverLocation().getRoverOrientation()));
		}
		return stringBuilder.toString();
	}	
	
	/**
	 * Gets the orientation char.
	 *
	 * @param roverOrientation the rover orientation
	 * @return the orientation char
	 */
	public static char getOrientationChar(RoverOrientation roverOrientation) {
		
		char charachter;
		switch (roverOrientation) {
		case EAST:
			charachter = 'E';
			break;
		case WEST:
			charachter = 'W';
			break;
		case SOUTH:
			charachter = 'S';
			break;
		default:
			charachter = 'N';
			break;
		}
		return charachter;
	}
}
