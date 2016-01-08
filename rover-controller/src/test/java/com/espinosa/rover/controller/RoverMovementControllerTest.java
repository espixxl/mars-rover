package com.espinosa.rover.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.espinosa.rover.domain.Plateau;
import com.espinosa.rover.domain.Rover;
import com.espinosa.rover.domain.RoverLocation;
import com.espinosa.rover.domain.RoverMovement;
import com.espinosa.rover.domain.RoverOrientation;
import com.orfertia.espinosa.rover.controller.RoverMovementController;
import com.orfertia.espinosa.rover.controller.impl.RoverMovementControllerImpl;
import com.orfertia.espinosa.rover.exception.CollisionException;

/**
 * The Class RoverMovementControllerTest.
 * 
 * @author David Espinosa
 */
public class RoverMovementControllerTest {

	/** The Constant PLATEAU_WIDTH. */
	private final static int PLATEAU_WIDTH = 4;
	
	/** The Constant PLATEAU_HEIGTH. */
	private final static int PLATEAU_HEIGTH = 4;
	
	/** The rover movement controller. */
	private RoverMovementController roverMovementController;
	
	/** The plateau. */
	private Plateau plateau;
	
	/**
	 * Initialize.
	 */
	@Before
	public void initialize() {
		roverMovementController = new RoverMovementControllerImpl();
		plateau = new Plateau(PLATEAU_WIDTH, PLATEAU_HEIGTH);
	}
	
	/**
	 * When two rovers exists in same position collision is detected.
	 */
	@Test
	public void whenTwoRoversExistsInSamePositionCollisionIsDetected() {
		
		RoverLocation roverLocation = new RoverLocation(1, 1, RoverOrientation.EAST);
		Rover existingRover = new Rover(1, roverLocation);
		Rover collisionRover = new Rover(2, roverLocation);
		List<Rover> collisionedRovers = roverMovementController.getCollisionedRovers(Arrays.asList(existingRover, collisionRover), plateau);
		assertNotNull("Collision correctly detected", collisionedRovers);				
	}
	
	/**
	 * When two rovers have different positions collision is not detected.
	 */
	@Test
	public void whenTwoRoversHaveDifferentPositionsCollisionIsNotDetected() {
		
		RoverLocation roverLocation = new RoverLocation(1, 1, RoverOrientation.EAST);
		RoverLocation roverLocation2 = new RoverLocation(1, 2, RoverOrientation.EAST);
		Rover existingRover = new Rover(1, roverLocation);
		Rover collisionRover = new Rover(2, roverLocation2);
		List<Rover> collisionedRovers = roverMovementController.getCollisionedRovers(Arrays.asList(existingRover, collisionRover), plateau);
		assertNull("Not collision state correctly detected", collisionedRovers);		
	}
	
	/**
	 * When rover collisions with plateau border a collision exception is throwed.
	 *
	 * @throws CollisionException the collision exception
	 */
	@Test(expected = CollisionException.class)
	public void whenRoverCollisionsWithPlateauBorderACollisionExceptionIsThrowed() throws CollisionException {
		
		RoverLocation roverLocation = new RoverLocation(4, 4, RoverOrientation.EAST);
		Rover rover = new Rover(1, roverLocation);		
		RoverMovement roverMovement = new RoverMovement();
		roverMovementController.moveRover(rover, roverMovement, plateau);;
	}
}
