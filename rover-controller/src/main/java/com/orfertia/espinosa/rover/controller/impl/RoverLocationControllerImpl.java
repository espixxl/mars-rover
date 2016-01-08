package com.orfertia.espinosa.rover.controller.impl;

import java.util.List;

import com.espinosa.rover.domain.Plateau;
import com.espinosa.rover.domain.RoverLocation;
import com.espinosa.rover.domain.RoverMovement;
import com.espinosa.rover.domain.RoverOrientation;
import com.espinosa.rover.domain.RoverRotation;
import com.orfertia.espinosa.rover.controller.RoverLocationController;

/**
 * The Class RoverLocationControllerImpl.
 * 
 * @author David Espinosa
 */
public class RoverLocationControllerImpl implements RoverLocationController {

    /*
     * (non-Javadoc)
     * 
     * @see com.orfertia.espinosa.rover.controller.RoverLocationController#isApplicable(com.espinosa.rover.domain.RoverLocation,
     * com.espinosa.rover.domain.RoverMovement, com.espinosa.rover.domain.RoverPlateau)
     */
    @Override
    public boolean isApplicable(final RoverLocation roverLocation, final RoverMovement roverMovement, final Plateau roverPlateau) {
        final boolean isApplicable = false;

        return isApplicable;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.orfertia.espinosa.rover.controller.RoverLocationController#applyMovement(com.espinosa.rover.domain.RoverLocation,
     * com.espinosa.rover.domain.RoverMovement)
     */
    @Override
    public RoverLocation applyMovement(final RoverLocation roverLocation, final RoverMovement roverMovement) {

        final RoverOrientation newRoverOrientation = this.applyRoverRotation(roverLocation.getRoverOrientation(),
                roverMovement.getRoverRotations());
        roverLocation.setRoverOrientation(newRoverOrientation);
        switch (newRoverOrientation) {
            case WEST:

                roverLocation.setxPosition(roverLocation.getxPosition() - 1);
                break;
            case EAST:
                roverLocation.setxPosition(roverLocation.getxPosition() + 1);
                break;
            case NORTH:
                roverLocation.setyPosition(roverLocation.getyPosition() + 1);
                break;
            case SOUTH:
                roverLocation.setyPosition(roverLocation.getyPosition() - 1);
                break;
            default:
                break;
        }
        return roverLocation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.orfertia.espinosa.rover.controller.RoverLocationController#applyRoverRotation(com.espinosa.rover.domain.RoverOrientation,
     * com.espinosa.rover.domain.RoverMovementRotation)
     */
    @Override
    public RoverOrientation applyRoverRotation(final RoverOrientation roverOrientation, final List<RoverRotation> roverMovementRotations) {

        RoverOrientation addaptedRoverOrientation = roverOrientation;
        for (final RoverRotation roverMovementRotation : roverMovementRotations) {
            int newOrientationValue = addaptedRoverOrientation.getValue() + roverMovementRotation.getValue();
            if (newOrientationValue < 0) {
                newOrientationValue += RoverOrientation.values().length;
            }
            addaptedRoverOrientation = RoverOrientation.valueOf(newOrientationValue % RoverOrientation.values().length);
        }
        return addaptedRoverOrientation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.orfertia.espinosa.rover.controller.RoverLocationController#existsPlateauCollision(com.espinosa.rover.domain.RoverLocation
     * , com.espinosa.rover.domain.Plateau)
     */
    @Override
    public boolean existsPlateauCollision(final RoverLocation roverLocation, final Plateau roverPlateau) {
        boolean checkPlateau = false;

        if ((roverLocation.getxPosition() > roverPlateau.getWidth()) || (roverLocation.getyPosition() > roverPlateau.getHeight())) {
            checkPlateau = true;
        }
        return checkPlateau;
    }

}
