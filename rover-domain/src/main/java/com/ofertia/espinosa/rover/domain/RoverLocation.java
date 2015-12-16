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
    public RoverLocation(final int xPosition, final int yPosition, final RoverOrientation roverOrientation) {
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
        return this.xPosition;
    }

    /**
     * Sets the x position.
     *
     * @param xPosition the new x position
     */
    public void setxPosition(final int xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * Gets the y position.
     *
     * @return the y position
     */
    public int getyPosition() {
        return this.yPosition;
    }

    /**
     * Sets the y position.
     *
     * @param yPosition the new y position
     */
    public void setyPosition(final int yPosition) {
        this.yPosition = yPosition;
    }

    /**
     * Gets the rover orientation.
     *
     * @return the rover orientation
     */
    public RoverOrientation getRoverOrientation() {
        return this.roverOrientation;
    }

    /**
     * Sets the rover orientation.
     *
     * @param roverOrientation the new rover orientation
     */
    public void setRoverOrientation(final RoverOrientation roverOrientation) {
        this.roverOrientation = roverOrientation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.roverOrientation == null) ? 0 : this.roverOrientation.hashCode());
        result = prime * result + this.xPosition;
        result = prime * result + this.yPosition;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final RoverLocation other = (RoverLocation) obj;
        if (this.roverOrientation != other.roverOrientation) {
            return false;
        }
        if (this.xPosition != other.xPosition) {
            return false;
        }
        if (this.yPosition != other.yPosition) {
            return false;
        }
        return true;
    }

    @Override
    public RoverLocation clone() {
        final RoverLocation roverLocation = new RoverLocation(this.getxPosition(), this.getyPosition(), this.getRoverOrientation());
        return roverLocation;
    }
}
