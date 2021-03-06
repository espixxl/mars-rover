package com.orfertia.espinosa.rover.controller;

import java.util.List;

import com.espinosa.rover.domain.Plateau;
import com.espinosa.rover.domain.RoverLocation;
import com.espinosa.rover.domain.RoverMovement;
import com.espinosa.rover.domain.RoverOrientation;
import com.espinosa.rover.domain.RoverRotation;

/**
 * The Interface RoverLocationController.
 * 
 * @author David Espinosa
 */
public interface RoverLocationController {

    /**
     * Checks if is applicable.
     *
     * @param roverLocation the rover location
     * @param roverMovement the rover movement
     * @param roverPlateau the rover plateau
     * @return true, if is applicable
     */
    public boolean isApplicable(RoverLocation roverLocation, RoverMovement roverMovement, Plateau roverPlateau);

    /**
     * Apply movement.
     *
     * @param roverLocation the rover location
     * @param roverMovement the rover movement
     * @return the rover location
     */
    public RoverLocation applyMovement(RoverLocation roverLocation, RoverMovement roverMovement);

    /**
     * Apply rover rotation.
     *
     * @param roverOrientation the rover orientation
     * @param roverMovementRotation the rover movement rotation
     * @return the rover orientation
     */
    public RoverOrientation applyRoverRotation(RoverOrientation roverOrientation, List<RoverRotation> roverMovementRotations);

    /**
     * Exists plateau collision.
     *
     * @param roverLocation the rover location
     * @param roverPlateau the rover plateau
     * @return true, if successful
     */
    boolean existsPlateauCollision(RoverLocation roverLocation, Plateau roverPlateau);
}
