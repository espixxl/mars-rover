package com.ofertia.espinosa.rover;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.ofertia.espinosa.rover.domain.Mars;
import com.ofertia.espinosa.rover.domain.Rover;
import com.orfertia.espinosa.rover.actuator.MarsActuator;
import com.orfertia.espinosa.rover.utils.InputUtils;

public class MainTest {
	
	private static final String INPUT_TEST_LINE = "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM";
	private static final String OUTPUT_TEST_LINE = "1 3 N 5 1 E";
	
	@Test
	public void mainTest() {
		try {
			Mars mars = InputUtils.createMarsFromInputLine(INPUT_TEST_LINE);
			MarsActuator marsActuator = new MarsActuator(mars);
			for (Rover rover: mars.getRovers().values()) {
				marsActuator.moveRover(rover.getRoverId(), rover.getRoverMovementSequence());
			}
			assertEquals(OUTPUT_TEST_LINE, InputUtils.createOutputLine(new ArrayList<Rover>(mars.getRovers().values())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
