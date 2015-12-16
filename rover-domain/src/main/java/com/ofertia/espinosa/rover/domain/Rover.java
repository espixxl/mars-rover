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
    public Rover(final int roverId, final RoverLocation roverLocation) {
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
        return this.roverId;
    }

    /**
     * Sets the rover id.
     *
     * @param roverId the new rover id
     */
    public void setRoverId(final int roverId) {
        this.roverId = roverId;
    }

    /**
     * Sets the rover location.
     *
     * @param roverLocation the new rover location
     */
    public void setRoverLocation(final RoverLocation roverLocation) {
        this.roverLocation = roverLocation;

    }

    /**
     * Gets the rover location.
     *
     * @return the rover location
     */
    public RoverLocation getRoverLocation() {
        return this.roverLocation;
    }

    /**
     * Gets the rover movement sequence.
     *
     * @return the rover movement sequence
     */
    public RoverMovementSequence getRoverMovementSequence() {
        return this.roverMovementSequence;
    }

    /**
     * Sets the rover movement sequence.
     *
     * @param roverMovementSequence the new rover movement sequence
     */
    public void setRoverMovementSequence(final RoverMovementSequence roverMovementSequence) {
        this.roverMovementSequence = roverMovementSequence;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Rover clone() {
        final Rover clonedRover = new Rover(this.roverId, this.roverLocation.clone());
        return clonedRover;
    }
}
