package com.ofertia.espinosa.rover.domain;

/**
 * The Class Rover.
 * 
 * @author David Espinosa
 */
public class Rover {

	/** The rover location. */
	private RoverLocation roverLocation;
		
	/** The rover id. */
	private int roverId;
		
	/** The rover movement sequence, this field will be used for test input executions. */
	private RoverMovementSequence roverMovementSequence;
	
	/**
	 * Instantiates a new rover.
	 *
	 * @param roverId the rover id
	 * @param roverLocation the rover location
	 */
	public Rover(int roverId, RoverLocation roverLocation) {
		super();
		this.roverId = roverId;
		this.roverLocation = roverLocation;
	}

	/**
	 * Gets the rover id.
	 *
	 * @return the rover id
	 */
	public int getRoverId() {
		return roverId;
	}

	/**
	 * Sets the rover id.
	 *
	 * @param roverId the new rover id
	 */
	public void setRoverId(int roverId) {
		this.roverId = roverId;
	}

	/**
	 * Sets the rover location.
	 *
	 * @param roverLocation the new rover location
	 */
	public void setRoverLocation(RoverLocation roverLocation) {
		this.roverLocation = roverLocation;
		
	}

	/**
	 * Gets the rover location.
	 *
	 * @return the rover location
	 */
	public RoverLocation getRoverLocation() {		
		return roverLocation;
	}
	
	/**
	 * Gets the rover movement sequence.
	 *
	 * @return the rover movement sequence
	 */
	public RoverMovementSequence getRoverMovementSequence() {
		return roverMovementSequence;
	}

	/**
	 * Sets the rover movement sequence.
	 *
	 * @param roverMovementSequence the new rover movement sequence
	 */
	public void setRoverMovementSequence(RoverMovementSequence roverMovementSequence) {
		this.roverMovementSequence = roverMovementSequence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Rover clone() {
		Rover clonedRover = new Rover(roverId, roverLocation.clone());
		return clonedRover ;
	}	
}
