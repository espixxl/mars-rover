package com.orfertia.espinosa.rover.actuator;

import java.util.ArrayList;
import java.util.List;

import com.espinosa.rover.domain.Mars;
import com.espinosa.rover.domain.Rover;
import com.espinosa.rover.domain.RoverMovementSequence;
import com.orfertia.espinosa.rover.controller.RoverMovementController;
import com.orfertia.espinosa.rover.controller.impl.RoverMovementControllerImpl;
import com.orfertia.espinosa.rover.exception.CollisionException;

/**
 * The Class MarsActuator.
 * 
 * @author David Espinosa
 */
public class MarsActuator {

    /** The mars. */
    protected Mars mars;

    /** The rover movement controller. */
    protected RoverMovementController roverMovementController;

    /**
     * Instantiates a new mars actuator for test purposes.
     */
    protected MarsActuator() {
        this.roverMovementController = new RoverMovementControllerImpl();
    }

    /**
     * Instantiates a new mars actuator.
     *
     * @param mars the mars
     */
    public MarsActuator(final Mars mars) {
        this.mars = mars;
        this.roverMovementController = new RoverMovementControllerImpl();
    }

    /**
     * Move rover.
     *
     * @param roverId the rover id
     * @param roverMovementSequence the rover movement sequence
     * @return the rover
     * @throws CollisionException the collision exception
     */
    public Rover moveRover(final int roverId, final RoverMovementSequence roverMovementSequence) throws CollisionException {
        Rover rover = this.mars.getRover(roverId);
        rover = this.getMovedRover(rover, roverMovementSequence);
        this.mars.getRovers().put(roverId, rover);
        return rover;
    }

    /**
     * Apply movement to rover.
     *
     * @param rover the rover
     * @param roverMovementSequence the rover movement sequence
     * @return the rover location
     * @throws CollisionException the collision exception
     */
    protected Rover getMovedRover(final Rover rover, final RoverMovementSequence roverMovementSequence) throws CollisionException {

        final List<Rover> restOfRovers = new ArrayList<Rover>(this.mars.getRovers().values());
        restOfRovers.remove(rover);
        final Rover movedRover = this.roverMovementController.moveRover(rover, roverMovementSequence, this.mars.getPlateau());
        restOfRovers.add(movedRover);

        final List<Rover> collisionedRovers = this.roverMovementController.getCollisionedRovers(restOfRovers, this.mars.getPlateau());
        if (collisionedRovers != null) {
            throw new CollisionException(collisionedRovers);
        }
        return movedRover;
    }

    /**
     * Gets the mars.
     *
     * @return the mars
     */
    public Mars getMars() {
        return this.mars;
    }
}
