package com.ofertia.espinosa.rover.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.ofertia.espinosa.rover.domain.Mars;
import com.ofertia.espinosa.rover.domain.Rover;
import com.ofertia.espinosa.rover.domain.RoverLocation;
import com.ofertia.espinosa.rover.domain.RoverOrientation;
import com.orfertia.espinosa.rover.utils.InputUtils;

public class InputUtilsTest {
	
	@Before
	public void initialize() {
	}
	
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
	
	@Test
	public void whenExerciseInputIsUsedThenSolutionIsReturned() {
		
		Rover rover1 = new Rover(0, new RoverLocation(1, 3, RoverOrientation.NORTH));
		Rover rover2 = new Rover(1, new RoverLocation(5, 1, RoverOrientation.EAST));
		String outputLine = InputUtils.createOutputLine(Arrays.asList(rover1, rover2));
		assertEquals("1 3 N 5 1 E", outputLine);
	}
}
