package com.ofertia.espinosa.rover.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mars {

	private Map<Integer, Rover> rovers = Collections.synchronizedMap(new HashMap<Integer, Rover>());
	
	private Plateau plateau;
	
	public Mars(int plateauWidth, int plateauHeight) {
		this.plateau = new Plateau(plateauWidth, plateauHeight);
	}
	
	public int addRover(Rover rover) {
		int roverId = rovers.size();
		rovers.put(roverId, rover);
		return roverId;
	}
	
	public void moveRover(int roverId, RoverMovementSequence roverMovementSequence) {
		
		Rover rover = getRover(roverId);
		
	}
	
	
	private Rover getRover(int roverId) {
		Rover rover = null;
		
		if (rovers.size()>=roverId) {
			rover = rovers.get(roverId);
		}
		
		return rover;
	}
	
}
