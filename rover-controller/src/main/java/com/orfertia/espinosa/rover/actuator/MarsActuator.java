package com.orfertia.espinosa.rover.actuator;

import java.util.ArrayList;
import java.util.List;

import com.ofertia.espinosa.rover.domain.Mars;
import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.domain.RoverMovementSequence;
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
	public MarsActuator(Mars mars) {
		this.mars = mars;
		this.roverMovementController = new RoverMovementControllerImpl();
	}
	
	/**
	 * Move rover.
	 *
	 * @param roverId the rover id
	 * @param roverMovementSequence the rover movement sequence
	 * @return the rover
	 * @throws CollisionException 
	 */
	public Rover moveRover(int roverId, RoverMovementSequence roverMovementSequence) throws CollisionException {
		Rover rover = mars.getRover(roverId);
		rover = this.getMovedRover(rover, roverMovementSequence);
		mars.getRovers().put(roverId, rover);
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
	protected Rover getMovedRover(Rover rover, RoverMovementSequence roverMovementSequence) throws CollisionException {
		
		List<Rover> restOfRovers = new ArrayList<Rover>(mars.getRovers().values()); 
		restOfRovers.remove(rover);
		Rover movedRover = roverMovementController.moveRover(rover, roverMovementSequence, mars.getPlateau());
		restOfRovers.add(movedRover);
		
		List<Rover> collisionedRovers = roverMovementController.getCollisionedRovers(restOfRovers, mars.getPlateau());
		if ( collisionedRovers != null) {
			throw new CollisionException(collisionedRovers);
		}
		return movedRover;
	}
}
