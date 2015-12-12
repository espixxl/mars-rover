package com.ofertia.espinosa.rover.domain;


/**
 * The Class RoverMovement.
 * 
 * @author David Espinosa
 */
public class RoverMovement {

	/** The rover movement rotation. */
	private RoverMovementRotation roverMovementRotation;
	
	/**
	 * Instantiates a new rover movement.
	 */
	public RoverMovement() {
		super();
		this.roverMovementRotation = RoverMovementRotation.STRAIGHT;
	}

	/**
	 * Instantiates a new rover movement.
	 *
	 * @param roverMovementRotation the rover movement rotation
	 */
	public RoverMovement(RoverMovementRotation roverMovementRotation) {
		super();
		this.roverMovementRotation = roverMovementRotation;
	}

	/**
	 * Gets the rover movement rotation.
	 *
	 * @return the rover movement rotation
	 */
	public RoverMovementRotation getRoverMovementRotation() {
		return roverMovementRotation;
	}

	/**
	 * Sets the rover movement rotation.
	 *
	 * @param roverMovementRotation the new rover movement rotation
	 */
	public void setRoverMovementRotation(RoverMovementRotation roverMovementRotation) {
		this.roverMovementRotation = roverMovementRotation;
	}
	
	
}
