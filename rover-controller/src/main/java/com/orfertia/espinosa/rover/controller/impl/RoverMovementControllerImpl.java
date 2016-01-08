package com.orfertia.espinosa.rover.controller.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.espinosa.rover.domain.Plateau;
import com.espinosa.rover.domain.Rover;
import com.espinosa.rover.domain.RoverLocation;
import com.espinosa.rover.domain.RoverMovement;
import com.espinosa.rover.domain.RoverMovementSequence;
import com.orfertia.espinosa.rover.controller.RoverLocationController;
import com.orfertia.espinosa.rover.controller.RoverMovementController;
import com.orfertia.espinosa.rover.exception.CollisionException;

/**
 * The Class RoverMovementControllerImpl.
 * 
 * @author David Espinosa
 */
public class RoverMovementControllerImpl implements RoverMovementController {

    /** The rover location controller. */
    private final RoverLocationController roverLocationController = new RoverLocationControllerImpl();

    /*
     * (non-Javadoc)
     * 
     * @see com.orfertia.espinosa.rover.controller.RoverMovementController#moveRover(com.espinosa.rover.domain.Rover,
     * com.espinosa.rover.domain.RoverMovementSequence)
     */
    @Override
    public Rover moveRover(final Rover rover, final RoverMovementSequence roverMovementSequence, final Plateau roverPlateau)
            throws CollisionException {

        Rover appliedMovementRover = rover.clone();
        for (final RoverMovement roverMovement : roverMovementSequence.getRoverMovements()) {
            appliedMovementRover = this.moveRover(appliedMovementRover, roverMovement, roverPlateau);
        }
        return appliedMovementRover;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.orfertia.espinosa.rover.controller.RoverMovementController#moveRover(com.espinosa.rover.domain.Rover,
     * com.espinosa.rover.domain.RoverMovement, com.espinosa.rover.domain.Plateau)
     */
    @Override
    public Rover moveRover(final Rover rover, final RoverMovement roverMovement, final Plateau roverPlateau) throws CollisionException {

        final RoverLocation roverLocation = this.roverLocationController.applyMovement(rover.getRoverLocation(), roverMovement);

        if (this.roverLocationController.existsPlateauCollision(roverLocation, roverPlateau)) {
            throw new CollisionException(roverLocation, roverPlateau);
        }
        rover.setRoverLocation(roverLocation);
        return rover;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.orfertia.espinosa.rover.controller.RoverMovementController#getCollisionedRovers(java.util.Collection,
     * com.espinosa.rover.domain.Plateau)
     */
    @Override
    public List<Rover> getCollisionedRovers(final Collection<Rover> rovers, final Plateau plateau) {

        List<Rover> collisionedRovers = null;
        final Rover mapCollisions[][] = new Rover[plateau.getWidth() + 1][plateau.getHeight() + 1];

        for (final Rover rover : rovers) {
            final RoverLocation roverLocation = rover.getRoverLocation();
            final Rover roverAtPosition = mapCollisions[roverLocation.getxPosition()][roverLocation.getyPosition()];
            if (roverAtPosition != null) {
                collisionedRovers = Arrays.asList(roverAtPosition, rover);
                break;
            } else {
                mapCollisions[roverLocation.getxPosition()][roverLocation.getyPosition()] = rover;
            }
        }
        return collisionedRovers;
    }

}
