package com.ofertia.espinosa.rover.domain;

/**
 * The Class RoverImpl.
 */
public class RoverImpl implements Rover {

	/** The rover location. */
	private RoverLocation roverLocation;
		
	/**
	 * Instantiates a new rover impl.
	 *
	 * @param roverLocation the rover location
	 */
	public RoverImpl(RoverLocation roverLocation) {
		super();
		this.roverLocation = roverLocation;
	}

	/* (non-Javadoc)
	 * @see com.ofertia.espinosa.rover.domain.Rover#setRoverLocation(com.ofertia.espinosa.rover.domain.RoverLocation)
	 */
	public void setRoverLocation(RoverLocation roverLocation) {
		this.roverLocation = roverLocation;
		
	}
}
