package com.ofertia.espinosa.rover.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class RoverMovement.
 * 
 * @author David Espinosa
 */
public class RoverMovement {

	/** The rover movement rotation. */
	private List<RoverRotation> roverRotations;
	
	/**
	 * Instantiates a new rover movement.
	 */
	public RoverMovement() {
		super();
		this.roverRotations = new ArrayList<RoverRotation>();
	}

	/**
	 * Instantiates a new rover movement.
	 *
	 * @param roverMovementRotation the rover movement rotation
	 */
	public RoverMovement(List<RoverRotation> roverRotations) {
		super();
		this.roverRotations = roverRotations;
	}
	
	/**
	 * Adds the rover movement rotation.
	 *
	 * @param roverMovementRotation the rover movement rotation
	 */
	public void addRoverRotation(RoverRotation roverMovementRotation) {
		this.roverRotations.add(roverMovementRotation);
	}
	
	/**
	 * Gets the rover movement rotation.
	 *
	 * @return the rover movement rotation
	 */
	public List<RoverRotation> getRoverRotations() {
		return roverRotations;
	}

	/**
	 * Sets the rover movement rotation.
	 *
	 * @param roverMovementRotation the new rover movement rotation
	 */
	public void setRoverRotation(List<RoverRotation> roverRotations) {
		this.roverRotations = roverRotations;
	}
}
