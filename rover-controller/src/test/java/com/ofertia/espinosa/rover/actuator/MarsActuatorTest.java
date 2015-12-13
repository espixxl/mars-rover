package com.ofertia.espinosa.rover.actuator;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.ofertia.espinosa.rover.domain.Mars;
import com.ofertia.espinosa.rover.domain.Plateau;
import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.domain.RoverLocation;
import com.ofertia.espinosa.rover.domain.RoverMovement;
import com.ofertia.espinosa.rover.domain.RoverRotation;
import com.ofertia.espinosa.rover.domain.RoverMovementSequence;
import com.ofertia.espinosa.rover.domain.RoverOrientation;
import com.orfertia.espinosa.rover.actuator.MarsActuator;
import com.orfertia.espinosa.rover.exception.CollisionException;

/**
 * The Class MarsActuatorTest.
 */
public class MarsActuatorTest extends MarsActuator {
	
	/**
	 * Initialize.
	 */
	@Before
	public void initialize() {
		
		Plateau plateau = new Plateau(5, 5);		
		Rover rover1 = new Rover(1, new RoverLocation(1, 2, RoverOrientation.NORTH));
		Rover rover2 = new Rover(2, new RoverLocation(3, 3, RoverOrientation.EAST));
		
		mars = new Mars();
		mars.setPlateau(plateau);
		mars.addRovers(rover1, rover2);
	}
	
	/**
	 * When rover moves to another rover position a collision exception is throwed.
	 *
	 * @throws CollisionException the collision exception
	 */
	@Test(expected = CollisionException.class)
	public void whenRoverMovesToAnotherRoverPositionACollisionExceptionIsThrowed() throws CollisionException {
		RoverMovementSequence roverMovementSequence = new RoverMovementSequence();
		
		//M RM M
		roverMovementSequence.addRoverMovement(new RoverMovement());
		roverMovementSequence.addRoverMovement(new RoverMovement(Arrays.asList(RoverRotation.RIGHT)));
		roverMovementSequence.addRoverMovement(new RoverMovement());
		this.moveRover(1, roverMovementSequence);
	}
	
}
