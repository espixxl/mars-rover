package com.orfertia.espinosa.rover.controller;

import java.util.Collection;
import java.util.List;

import com.ofertia.espinosa.rover.domain.Plateau;
import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.domain.RoverMovement;
import com.ofertia.espinosa.rover.domain.RoverMovementSequence;
import com.orfertia.espinosa.rover.exception.CollisionException;

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
	 * @param plateau the rover plateau
	 * @return the rover
	 */
	public Rover moveRover(Rover rover, RoverMovementSequence roverMovementSequence, Plateau plateau) throws CollisionException;
	
	/**
	 * Move rover.
	 *
	 * @param rover the rover
	 * @param roverMovement the rover movement
	 * @param plateau the rover plateau
	 * @return the rover
	 */
	public Rover moveRover(Rover rover, RoverMovement roverMovement, Plateau plateau) throws CollisionException;
	
	/**
	 * Check collisions.
	 *
	 * @param rovers the rovers
	 * @param plateau the plateau
	 * @return true, if successful
	 */
	public List<Rover> getCollisionedRovers(Collection<Rover> rovers, Plateau plateau);
}
