package com.ofertia.espinosa.rover.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class MarsImpl.
 */
public class Mars {

	/** The rovers. */
	private Map<Integer, Rover> rovers = Collections.synchronizedMap(new HashMap<Integer, Rover>());
		
	/** The plateau. */
	private Plateau plateau;
	
//	/** The instance. */
//	private static Mars instance;
	
//	/**
//	 * Gets the single instance of MarsImpl.
//	 *
//	 * @return single instance of MarsImpl
//	 */
//	public static synchronized Mars getInstance() {
//		if (instance == null) {
//			instance = new Mars();			
//		}
//		return instance;
//	}

	/**
	 * Initialize plateau.
	 *
	 * @param plateauWidth the plateau width
	 * @param plateauHeight the plateau height
	 */
	public void initializePlateau(int plateauWidth, int plateauHeight) {
		this.plateau = new Plateau(plateauWidth, plateauHeight);
	}


	/**
	 * Adds the rover.
	 *
	 * @param rover the rover
	 */
	public void addRover(Rover rover) {		
		rovers.put(rover.getRoverId(), rover);
	}
	
	/**
	 * Adds the rovers.
	 *
	 * @param rovers the rovers
	 */
	public void addRovers(Rover...rovers) {
		
		for (Rover rover: rovers) {
			this.addRover(rover);
		}
	}
		 
	/**
	 * Gets the rover.
	 *
	 * @param roverId the rover id
	 * @return the rover
	 */
	public Rover getRover(int roverId) {
		Rover rover = null;
		
		if (rovers.size()>=roverId) {
			rover = rovers.get(roverId);
		}
		
		return rover;
	}


	/**
	 * Gets the rovers.
	 *
	 * @return the rovers
	 */
	public Map<Integer, Rover> getRovers() {
		return rovers;
	}


	/**
	 * Sets the rovers.
	 *
	 * @param rovers the rovers
	 */
	public void setRovers(Map<Integer, Rover> rovers) {
		this.rovers = rovers;
	}

	/**
	 * Gets the plateau.
	 *
	 * @return the plateau
	 */
	public Plateau getPlateau() {
		return plateau;
	}

	/**
	 * Sets the plateau.
	 *
	 * @param plateau the new plateau
	 */
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	
}
