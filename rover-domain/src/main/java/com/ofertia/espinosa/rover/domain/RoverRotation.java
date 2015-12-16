package com.ofertia.espinosa.rover.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * The Enum RoverRotation.
 * 
 * @author David Espinosa
 */
public enum RoverRotation {

    /** The left. */
    LEFT(-1),

    /** The right. */
    RIGHT(1),

    /** The none. */
    STRAIGHT(0);

    /** The value. */
    private final int value;

    /** The Constant map. */
    private static final Map<Integer, RoverRotation> map = new HashMap<Integer, RoverRotation>();

    /**
     * Instantiates a new rover movement rotation.
     *
     * @param value the value
     */
    RoverRotation(final int value) {
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
        for (final RoverRotation roverMovementRotation : RoverRotation.values()) {
            map.put(roverMovementRotation.getValue(), roverMovementRotation);
        }
    }

    /**
     * Value of.
     *
     * @param value the value
     * @return the rover rotation
     */
    public static RoverRotation valueOf(final int value) {
        return map.get(value);
    }
}
