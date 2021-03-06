package com.espinosa.rover.controller;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

import com.espinosa.rover.domain.RoverLocation;
import com.espinosa.rover.domain.RoverMovement;
import com.espinosa.rover.domain.RoverOrientation;
import com.espinosa.rover.domain.RoverRotation;
import com.orfertia.espinosa.rover.controller.RoverLocationController;
import com.orfertia.espinosa.rover.controller.impl.RoverLocationControllerImpl;

/**
 * The Class RoverLocationControllerTest.
 * 
 * @author David Espinosa
 */
public class RoverLocationControllerTest {

	/** The rover location controller. */
	private RoverLocationController roverLocationController;
	
	/** The rover orientation. */
	private RoverOrientation roverOrientation;
	
	/** The rover location. */
	private RoverLocation roverLocation;
	
	/**
	 * Initialize.
	 */
	@Before
	public void initialize() {
		this.roverLocationController = new RoverLocationControllerImpl();
		roverOrientation = RoverOrientation.EAST;
	}
	
	/**
	 * When rover orientation is east and is applied a right movement then south orientation is returned.
	 */
	@Test
	public void whenRoverOrientationIsEastAndIsAppliedARightMovementThenSouthOrientationIsReturned() {
		roverOrientation = RoverOrientation.EAST;
		roverOrientation = roverLocationController.applyRoverRotation(roverOrientation, Arrays.asList(RoverRotation.RIGHT));
		assertSame(roverOrientation, RoverOrientation.SOUTH);
	}
	
	/**
	 * When rover orientation is south and is applied a right movement then west orientation is returned.
	 */
	@Test
	public void whenRoverOrientationIsSouthAndIsAppliedARightMovementThenWestOrientationIsReturned() {
		roverOrientation = RoverOrientation.SOUTH;
		roverOrientation = roverLocationController.applyRoverRotation(roverOrientation, Arrays.asList(RoverRotation.RIGHT));
		assertSame(roverOrientation, RoverOrientation.WEST);
	}
	
	/**
	 * When rover location is zero zero with east orientation and straight movement is applied then rover location one zero is returned.
	 */
	@Test
	public void whenRoverLocationIsZeroZeroWithEastOrientationAndStraightMovementIsAppliedThenRoverLocationOneZeroIsReturned() {
		roverLocation = new RoverLocation(0, 0, RoverOrientation.EAST);
		RoverMovement roverMovement = new RoverMovement();
		roverLocation = roverLocationController.applyMovement(roverLocation, roverMovement);
		assertEquals(new RoverLocation(1, 0, RoverOrientation.EAST), roverLocation);
	}
	
	/**
	 * When rover location is zero zero with east orientation and leftt movent is applied then rover location zero one is returned.
	 */
	@Test
	public void whenRoverLocationIsZeroZeroWithEastOrientationAndLefttMoventIsAppliedThenRoverLocationZeroOneIsReturned() {
		roverLocation = new RoverLocation(0, 0, RoverOrientation.EAST);
		RoverMovement roverMovement = new RoverMovement(Arrays.asList(RoverRotation.LEFT));
		roverLocation = roverLocationController.applyMovement(roverLocation, roverMovement);
		assertEquals(new RoverLocation(0, 1, RoverOrientation.NORTH), roverLocation);
	}
}
