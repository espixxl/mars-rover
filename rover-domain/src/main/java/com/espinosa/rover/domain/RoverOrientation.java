package com.espinosa.rover.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum RoverOrientation.
 * 
 * @author David Espinosa
 */
public enum RoverOrientation {

    /** The north. */
    NORTH(1),

    /** The south. */
    SOUTH(3),

    /** The east. */
    EAST(2),

    /** The west. */
    WEST(0);

    /** The Constant map. */
    private static final Map<Integer, RoverOrientation> map = new HashMap<Integer, RoverOrientation>();

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
        return this.value;
    }

    static {
        for (final RoverOrientation roverOrientation : RoverOrientation.values()) {
            map.put(roverOrientation.getValue(), roverOrientation);
        }
    }

    /**
     * Value of integer.
     *
     * @param value the value
     * @return the rover orientation
     */
    public static RoverOrientation valueOf(final int value) {
        return map.get(value);
    }
}
