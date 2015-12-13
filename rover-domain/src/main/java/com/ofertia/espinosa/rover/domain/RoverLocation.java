package com.ofertia.espinosa.rover.domain;

/**
 * The Class RoverLocation.
 */
public class RoverLocation implements Cloneable {

	/** The x position. */
	private int xPosition;
	
	/** The y position. */
	private int yPosition;
	
	/** The rover orientation. */
	private RoverOrientation roverOrientation;

	/**
	 * Instantiates a new rover location.
	 *
	 * @param xPosition the x position
	 * @param yPosition the y position
	 * @param roverOrientation the rover orientation
	 */
	public RoverLocation(int xPosition, int yPosition, RoverOrientation roverOrientation) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.roverOrientation = roverOrientation;
	}

	/**
	 * Gets the x position.
	 *
	 * @return the x position
	 */
	public int getxPosition() {
		return xPosition;
	}

	/**
	 * Sets the x position.
	 *
	 * @param xPosition the new x position
	 */
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * Gets the y position.
	 *
	 * @return the y position
	 */
	public int getyPosition() {
		return yPosition;
	}

	/**
	 * Sets the y position.
	 *
	 * @param yPosition the new y position
	 */
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * Gets the rover orientation.
	 *
	 * @return the rover orientation
	 */
	public RoverOrientation getRoverOrientation() {
		return roverOrientation;
	}

	/**
	 * Sets the rover orientation.
	 *
	 * @param roverOrientation the new rover orientation
	 */
	public void setRoverOrientation(RoverOrientation roverOrientation) {
		this.roverOrientation = roverOrientation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roverOrientation == null) ? 0 : roverOrientation.hashCode());
		result = prime * result + xPosition;
		result = prime * result + yPosition;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoverLocation other = (RoverLocation) obj;
		if (roverOrientation != other.roverOrientation)
			return false;
		if (xPosition != other.xPosition)
			return false;
		if (yPosition != other.yPosition)
			return false;
		return true;
	}

	public RoverLocation clone() {
		RoverLocation roverLocation = new RoverLocation(this.getxPosition(), this.getyPosition(), this.getRoverOrientation());
		return roverLocation;
	}
}
