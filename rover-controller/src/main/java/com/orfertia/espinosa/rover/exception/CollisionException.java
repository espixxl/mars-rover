package com.orfertia.espinosa.rover.exception;

import java.util.List;

import com.espinosa.rover.domain.Plateau;
import com.espinosa.rover.domain.Rover;
import com.espinosa.rover.domain.RoverLocation;

/**
 * The Class Collision Exception.
 * 
 * @author David Espinosa
 */
public class CollisionException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new collision.
     *
     * @param message the message
     */
    public CollisionException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new collision exception.
     *
     * @param roverLocation the rover location
     * @param plateau the plateau
     */
    public CollisionException(final RoverLocation roverLocation, final Plateau plateau) {
        super("Collision with plateau border detected at location [" + roverLocation.getxPosition() + ", " + roverLocation.getyPosition()
                + "] into a plateau (" + plateau.getWidth() + ", " + plateau.getHeight() + ")");
    }

    /**
     * Instantiates a new collision exception.
     *
     * @param exisitingRover the exisiting rover
     * @param collisionRover the collision rover
     */
    public CollisionException(final List<Rover> collisionedRovers) {
        super(getCollisionedRoversMessage(collisionedRovers));
    }

    /**
     * Gets the collisioned rovers message.
     *
     * @param collisionedRovers the collisioned rovers
     * @return the collisioned rovers message
     */
    private static String getCollisionedRoversMessage(final List<Rover> collisionedRovers) {
        final StringBuilder stringBuilder = new StringBuilder("Collision between rovers: ");
        for (final Rover rover : collisionedRovers) {
            stringBuilder.append(" Rover with id: " + rover.getRoverId() + " and location: (" + rover.getRoverLocation().getxPosition()
                    + ", " + rover.getRoverLocation().getyPosition() + ")");
        }
        return stringBuilder.toString();
    }

}
