package com.ofertia.espinosa.rover.domain;

import java.util.ArrayList;

/**
 * The Class RoverMovementSequence.
 * 
 * @author David Espinosa
 */
public class RoverMovementSequence {

	/** The rover movements. */
	private ArrayList<RoverMovement> roverMovements;

	/**
	 * Instantiates a new rover movement sequence.
	 */
	public RoverMovementSequence() {
		this.roverMovements = new ArrayList<RoverMovement>();
	}
	
	/**
	 * Adds the rover movement.
	 *
	 * @param roverMovement the rover movement
	 */
	public void addRoverMovement(RoverMovement roverMovement) {
		this.roverMovements.add(roverMovement);
	}
	
	/**
	 * Gets the rover movements.
	 *
	 * @return the rover movements
	 */
	public ArrayList<RoverMovement> getRoverMovements() {
		return roverMovements;
	}

	/**
	 * Sets the rover movements.
	 *
	 * @param roverMovements the new rover movements
	 */
	public void setRoverMovements(ArrayList<RoverMovement> roverMovements) {
		this.roverMovements = roverMovements;
	}
}
