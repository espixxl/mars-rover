package com.ofertia.espinosa.rover.domain;

import java.util.ArrayList;

/**
 * The Class RoverMovementSequence.
 */
public class RoverMovementSequence {

	/** The rover movements. */
	private ArrayList<RoverMovement> roverMovements;

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
