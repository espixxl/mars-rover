package com.espinosa.rover.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.espinosa.rover.domain.Mars;
import com.espinosa.rover.domain.Rover;
import com.espinosa.rover.domain.RoverLocation;
import com.espinosa.rover.domain.RoverOrientation;
import com.orfertia.espinosa.rover.utils.InputUtils;

/**
 * The Class InputUtilsTest.
 * 
 * @author David Espinosa
 */
public class InputUtilsTest {
	
	/**
	 * Initialize.
	 */
	@Before
	public void initialize() {
	}
	
	/**
	 * When two rovers are setted then mars with two rovers is created.
	 */
	@Test
	public void whenTwoRoversAreSettedThenMarsWithTwoRoversIsCreated() {
		
		String inputLine = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
		Mars mars;
		try {
			mars = InputUtils.createMarsFromInputLine(inputLine);
			assertEquals(2, mars.getRovers().values().size());
		} catch (Exception e) {
			assertTrue(false);
		}		
	}
	
	/**
	 * When exercise input is used then solution is returned.
	 */
	@Test
	public void whenExerciseInputIsUsedThenSolutionIsReturned() {
		
		Rover rover1 = new Rover(0, new RoverLocation(1, 3, RoverOrientation.NORTH));
		Rover rover2 = new Rover(1, new RoverLocation(5, 1, RoverOrientation.EAST));
		String outputLine = InputUtils.createOutputLine(Arrays.asList(rover1, rover2));
		assertEquals("1 3 N 5 1 E", outputLine);
	}
}
