package com.ofertia.espinosa.rover.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum RoverMovementRotation.
 */
public enum RoverMovementRotation {

	/** The left. */
	LEFT (-1),
	
	/** The rigth. */
	RIGTH (1),
	
	/** The none. */
	STRAIGHT (0);
	
	/** The value. */
	private final int value;
	
	/**
	 * Instantiates a new rover movement rotation.
	 *
	 * @param value the value
	 */
	RoverMovementRotation(final int value) {
		this.value = value;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	private static final Map<Integer, RoverMovementRotation> map = new HashMap<Integer, RoverMovementRotation>();
	
	static {
		for (RoverMovementRotation roverMovementRotation : RoverMovementRotation.values()) {
			map.put(roverMovementRotation.getValue(), roverMovementRotation);
		}
	}
	
	public static RoverMovementRotation valueOf(int value) {
		return map.get(value);
	}
}
