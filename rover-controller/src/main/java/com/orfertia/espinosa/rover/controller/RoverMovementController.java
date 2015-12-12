package com.orfertia.espinosa.rover.controller;

import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.domain.RoverMovement;
import com.ofertia.espinosa.rover.domain.RoverMovementSequence;
import com.ofertia.espinosa.rover.domain.Plateau;

/**
 * The Interface RoverMovementController.
 * 
 * @author David Espinosa
 */
public interface RoverMovementController {

	/**
	 * Move rover.
	 *
	 * @param rover the rover
	 * @param roverMovementSequence the rover movement sequence
	 * @param roverPlateau the rover plateau
	 * @return the rover
	 */
	public Rover moveRover(Rover rover, RoverMovementSequence roverMovementSequence, Plateau roverPlateau);
	
	/**
	 * Move rover.
	 *
	 * @param rover the rover
	 * @param roverMovement the rover movement
	 * @param roverPlateau the rover plateau
	 * @return the rover
	 */
	public Rover moveRover(Rover rover, RoverMovement roverMovement, Plateau roverPlateau);
	
	
}
