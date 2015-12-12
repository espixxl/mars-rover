package com.ofertia.espinosa.rover.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum RoverOrientation.
 */
public enum RoverOrientation {
	
	/** The north. */
	NORTH (1),
	
	/** The south. */
	SOUTH (3),
	
	/** The east. */
	EAST (2),
	
	/** The west. */
	WEST (0);
	
	/** The value. */
	private final int value;
	
	/**
	 * Instantiates a new rover orientation.
	 *
	 * @param value the value
	 */
	RoverOrientation(final int value) {
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
	
	private static final Map<Integer, RoverOrientation> map = new HashMap<Integer, RoverOrientation>();
	
	static {
		for (RoverOrientation roverOrientation : RoverOrientation.values()) {
			map.put(roverOrientation.getValue(), roverOrientation);
		}
	}
	
	public static RoverOrientation valueOf(int value) {
		return map.get(value);
	}
}
