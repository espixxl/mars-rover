package com.orfertia.espinosa.rover.controller.impl;

import java.util.Map;

import com.ofertia.espinosa.rover.domain.RoverLocation;
import com.ofertia.espinosa.rover.domain.RoverMovement;
import com.ofertia.espinosa.rover.domain.RoverMovementRotation;
import com.ofertia.espinosa.rover.domain.RoverOrientation;
import com.ofertia.espinosa.rover.domain.Plateau;
import com.orfertia.espinosa.rover.controller.RoverLocationController;

/**
 * The Class RoverLocationControllerImpl.
 */
public class RoverLocationControllerImpl implements RoverLocationController {

	
	/* (non-Javadoc)
	 * @see com.orfertia.espinosa.rover.controller.RoverLocationController#isApplicable(com.ofertia.espinosa.rover.domain.RoverLocation, com.ofertia.espinosa.rover.domain.RoverMovement, com.ofertia.espinosa.rover.domain.RoverPlateau)
	 */
	public boolean isApplicable(RoverLocation roverLocation, RoverMovement roverMovement, Plateau roverPlateau) {
		boolean isApplicable = false;
		
		
		
		return isApplicable;
	}

	/* (non-Javadoc)
	 * @see com.orfertia.espinosa.rover.controller.RoverLocationController#applyMovement(com.ofertia.espinosa.rover.domain.RoverLocation, com.ofertia.espinosa.rover.domain.RoverMovement)
	 */
	public RoverLocation applyMovement(RoverLocation roverLocation, RoverMovement roverMovement) {
		
		RoverOrientation newRoverOrientation = applyRoverRotation(roverLocation.getRoverOrientation(), roverMovement.getRoverMovementRotation());
		roverLocation.setRoverOrientation(newRoverOrientation);
		switch (newRoverOrientation) {
		case WEST:

			roverLocation.setxPosition(roverLocation.getxPosition()-1);
			break;
		case EAST:
			roverLocation.setxPosition(roverLocation.getxPosition()+1);
			break;
		case NORTH:
			roverLocation.setyPosition(roverLocation.getyPosition()+1);
			break;
		case SOUTH:
			roverLocation.setyPosition(roverLocation.getyPosition()-1);
			break;
		default:
			break;
		}
		return roverLocation;
	}
	
	public RoverOrientation applyRoverRotation(RoverOrientation roverOrientation, RoverMovementRotation roverMovementRotation) {
		
		RoverOrientation addaptedRoverOrientation;		
		int newOrientationValue = roverOrientation.getValue()+roverMovementRotation.getValue();
		addaptedRoverOrientation = RoverOrientation.valueOf(newOrientationValue%4);
		return addaptedRoverOrientation;
	}
	
	private boolean checkPlateau(RoverLocation roverLocation, Plateau roverPlateau) {
		boolean checkPlateau = true;
		
		if ((roverLocation.getxPosition()>roverPlateau.getWidth())||(roverLocation.getyPosition()>roverPlateau.getHeight())) {
			checkPlateau = false;
		}
		return checkPlateau;
	}

}
