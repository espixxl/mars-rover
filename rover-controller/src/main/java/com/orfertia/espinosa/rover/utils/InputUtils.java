package com.orfertia.espinosa.rover.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.espinosa.rover.domain.Mars;
import com.espinosa.rover.domain.Plateau;
import com.espinosa.rover.domain.Rover;
import com.espinosa.rover.domain.RoverLocation;
import com.espinosa.rover.domain.RoverMovement;
import com.espinosa.rover.domain.RoverMovementSequence;
import com.espinosa.rover.domain.RoverOrientation;
import com.espinosa.rover.domain.RoverRotation;

/**
 * The Class InputUtils.
 * 
 * @author David Espinosa
 */
public class InputUtils {

    /**
     * Creates the mars from input line.
     *
     * @param inputLine the input line
     * @return the mars
     * @throws Exception the exception
     */
    public static Mars createMarsFromInputLine(final String inputLine) throws Exception {
        final Mars mars = new Mars();
        final String inputTokens[] = inputLine.split(" ");

        // first two elements corresponds to plateuau dimensions
        final int plateauWidth = Integer.valueOf(inputTokens[0]);
        final int plateauHeigth = Integer.valueOf(inputTokens[1]);
        final Plateau plateau = new Plateau(plateauWidth, plateauHeigth);

        final Map<Integer, Rover> rovers = createRoversFromInput(Arrays.copyOfRange(inputTokens, 2, inputTokens.length));

        mars.setPlateau(plateau);
        mars.setRovers(rovers);

        return mars;
    }

    /**
     * Creates the rovers from input.
     *
     * @param message the message
     * @return the hash map
     */
    public static HashMap<Integer, Rover> createRoversFromInput(final String message[]) {

        final HashMap<Integer, Rover> rovers = new HashMap<Integer, Rover>();
        for (final Rover rover : createRoversFromInput(0, message)) {
            rovers.put(rover.getRoverId(), rover);
        }

        return rovers;
    }

    /**
     * Creates the rovers from input.
     *
     * @param initialRoverId the initial rover id
     * @param message the message
     * @return the list
     */
    public static List<Rover> createRoversFromInput(final int initialRoverId, final String message[]) {

        final List<Rover> rovers = new ArrayList<Rover>();

        final int roverXPosition = Integer.valueOf(message[0]);
        final int roverYPosition = Integer.valueOf(message[1]);
        final RoverOrientation roverOrientation = createRoverOrientationFromInput(message[2]);
        final RoverLocation roverLocation = new RoverLocation(roverXPosition, roverYPosition, roverOrientation);
        final Rover rover = new Rover(initialRoverId, roverLocation);

        final RoverMovementSequence roverMovementSequence = createRoverMovementSequenceFromInput(message[3]);
        rover.setRoverMovementSequence(roverMovementSequence);
        rovers.add(rover);

        if (message.length > 4) {
            rovers.addAll(createRoversFromInput(initialRoverId + 1, Arrays.copyOfRange(message, 4, message.length)));
        }
        return rovers;
    }

    /**
     * Creates the rover orientation from input.
     *
     * @param message the message
     * @return the rover orientation
     */
    public static RoverOrientation createRoverOrientationFromInput(final String message) {

        RoverOrientation roverOrientation;
        switch (message) {
            case "N":
                roverOrientation = RoverOrientation.NORTH;
                break;
            case "E":
                roverOrientation = RoverOrientation.EAST;
                break;
            case "S":
                roverOrientation = RoverOrientation.SOUTH;
                break;
            default:
                roverOrientation = RoverOrientation.WEST;
                break;
        }
        return roverOrientation;
    }

    /**
     * Creates the rover movement sequence from input. Although it's not indicated into the exercise wording, I take for granted that the
     * sequence of movements will never be ended by a L or R.
     * 
     * @param message the message
     * @return the rover movement sequence
     */
    public static RoverMovementSequence createRoverMovementSequenceFromInput(final String message) {
        final RoverMovementSequence roverMovementSequence = new RoverMovementSequence();
        final String movements[] = message.split("(?<=M)");

        for (final String movement : movements) {
            roverMovementSequence.addRoverMovement(createRoverMovementFromInput(movement));
        }
        return roverMovementSequence;
    }

    /**
     * Creates the rover movement from input.
     *
     * @param message the message
     * @return the rover movement
     */
    public static RoverMovement createRoverMovementFromInput(final String message) {
        final RoverMovement roverMovement = new RoverMovement();

        for (final char charachter : message.toCharArray()) {
            if (charachter == 'M') {
                break;
            } else if (charachter == 'L') {
                roverMovement.addRoverRotation(RoverRotation.LEFT);
            } else if (charachter == 'R') {
                roverMovement.addRoverRotation(RoverRotation.RIGHT);
            }
        }
        return roverMovement;
    }

    /**
     * Creates the output line.
     *
     * @param rovers the rovers
     * @return the string
     */
    public static String createOutputLine(final List<Rover> rovers) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < rovers.size(); i++) {
            final Rover rover = rovers.get(i);
            if (i > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(rover.getRoverLocation().getxPosition() + " " + rover.getRoverLocation().getyPosition() + " "
                    + getOrientationChar(rover.getRoverLocation().getRoverOrientation()));
        }
        return stringBuilder.toString();
    }

    /**
     * Gets the orientation char.
     *
     * @param roverOrientation the rover orientation
     * @return the orientation char
     */
    public static char getOrientationChar(final RoverOrientation roverOrientation) {

        char charachter;
        switch (roverOrientation) {
            case EAST:
                charachter = 'E';
                break;
            case WEST:
                charachter = 'W';
                break;
            case SOUTH:
                charachter = 'S';
                break;
            default:
                charachter = 'N';
                break;
        }
        return charachter;
    }
}
