package com.ofertia.espinosa.rover.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class MarsImpl.
 */
public class Mars {

    /** The rovers. */
    private Map<Integer, Rover> rovers = Collections.synchronizedMap(new HashMap<Integer, Rover>());

    /** The plateau. */
    private Plateau plateau;

    /**
     * Initialize plateau.
     *
     * @param plateauWidth the plateau width
     * @param plateauHeight the plateau height
     */
    public void initializePlateau(final int plateauWidth, final int plateauHeight) {
        this.plateau = new Plateau(plateauWidth, plateauHeight);
    }

    /**
     * Adds the rover.
     *
     * @param rover the rover
     */
    public void addRover(final Rover rover) {
        this.rovers.put(rover.getRoverId(), rover);
    }

    /**
     * Adds the rovers.
     *
     * @param rovers the rovers
     */
    public void addRovers(final Rover... rovers) {

        for (final Rover rover : rovers) {
            this.addRover(rover);
        }
    }

    /**
     * Gets the rover.
     *
     * @param roverId the rover id
     * @return the rover
     */
    public Rover getRover(final int roverId) {
        Rover rover = null;

        if (this.rovers.size() >= roverId) {
            rover = this.rovers.get(roverId);
        }

        return rover;
    }

    /**
     * Gets the rovers.
     *
     * @return the rovers
     */
    public Map<Integer, Rover> getRovers() {
        return this.rovers;
    }

    /**
     * Sets the rovers.
     *
     * @param rovers the rovers
     */
    public void setRovers(final Map<Integer, Rover> rovers) {
        this.rovers = rovers;
    }

    /**
     * Gets the plateau.
     *
     * @return the plateau
     */
    public Plateau getPlateau() {
        return this.plateau;
    }

    /**
     * Sets the plateau.
     *
     * @param plateau the new plateau
     */
    public void setPlateau(final Plateau plateau) {
        this.plateau = plateau;
    }

}
