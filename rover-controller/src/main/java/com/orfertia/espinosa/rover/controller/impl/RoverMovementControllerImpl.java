package com.orfertia.espinosa.rover.controller.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.ofertia.espinosa.rover.domain.Plateau;
import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.domain.RoverLocation;
import com.ofertia.espinosa.rover.domain.RoverMovement;
import com.ofertia.espinosa.rover.domain.RoverMovementSequence;
import com.orfertia.espinosa.rover.controller.RoverLocationController;
import com.orfertia.espinosa.rover.controller.RoverMovementController;
import com.orfertia.espinosa.rover.exception.CollisionException;

/**
 * The Class RoverMovementControllerImpl.
 * 
 * @author David Espinosa
 */
public class RoverMovementControllerImpl implements RoverMovementController {

	private RoverLocationController roverLocationController = new RoverLocationControllerImpl();
	
	/* (non-Javadoc)
	 * @see com.orfertia.espinosa.rover.controller.RoverMovementController#moveRover(com.ofertia.espinosa.rover.domain.Rover, com.ofertia.espinosa.rover.domain.RoverMovementSequence)
	 */
	@Override
	public Rover moveRover(Rover rover, RoverMovementSequence roverMovementSequence, Plateau roverPlateau) throws CollisionException {
		
		Rover appliedMovementRover = (Rover)rover.clone();	
		for (RoverMovement roverMovement: roverMovementSequence.getRoverMovements()) {
			appliedMovementRover = moveRover(appliedMovementRover, roverMovement, roverPlateau);
		}
		return appliedMovementRover;
	}

	@Override
	public Rover moveRover(Rover rover, RoverMovement roverMovement, Plateau roverPlateau) throws CollisionException {
		
		RoverLocation roverLocation = roverLocationController.applyMovement(rover.getRoverLocation(), roverMovement);
		
		if (roverLocationController.existsPlateauCollision(roverLocation, roverPlateau)) {
			throw new CollisionException(roverLocation, roverPlateau);
		}
		rover.setRoverLocation(roverLocation);
		return rover;
	}

	@Override
	public List<Rover> getCollisionedRovers(Collection<Rover> rovers, Plateau plateau) {
		
		List<Rover> collisionedRovers = null;
		Rover mapCollisions[][] = new Rover[plateau.getWidth()+1][plateau.getHeight()+1];		
		
		for (Rover rover: rovers) {
			RoverLocation roverLocation = rover.getRoverLocation();		
			Rover roverAtPosition = mapCollisions[roverLocation.getxPosition()][roverLocation.getyPosition()];
			if ( roverAtPosition != null) {
				collisionedRovers = Arrays.asList(roverAtPosition, rover);
				break;
			} else {
				mapCollisions[roverLocation.getxPosition()][roverLocation.getyPosition()] = rover;
			}
		}
		return collisionedRovers;
	}

}
