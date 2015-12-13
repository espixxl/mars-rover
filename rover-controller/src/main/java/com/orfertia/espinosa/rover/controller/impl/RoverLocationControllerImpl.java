package com.orfertia.espinosa.rover.controller.impl;

import java.util.List;

import com.ofertia.espinosa.rover.domain.Plateau;
import com.ofertia.espinosa.rover.domain.RoverLocation;
import com.ofertia.espinosa.rover.domain.RoverMovement;
import com.ofertia.espinosa.rover.domain.RoverRotation;
import com.ofertia.espinosa.rover.domain.RoverOrientation;
import com.orfertia.espinosa.rover.controller.RoverLocationController;

/**
 * The Class RoverLocationControllerImpl.
 * 
 * @author David Espinosa
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
		
		RoverOrientation newRoverOrientation = applyRoverRotation(roverLocation.getRoverOrientation(), roverMovement.getRoverRotations());
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
	
	
	/* (non-Javadoc)
	 * @see com.orfertia.espinosa.rover.controller.RoverLocationController#applyRoverRotation(com.ofertia.espinosa.rover.domain.RoverOrientation, com.ofertia.espinosa.rover.domain.RoverMovementRotation)
	 */
	@Override
	public RoverOrientation applyRoverRotation(RoverOrientation roverOrientation, List<RoverRotation> roverMovementRotations) {
		
		RoverOrientation addaptedRoverOrientation = roverOrientation;		
		for (RoverRotation roverMovementRotation: roverMovementRotations) {
			int newOrientationValue = addaptedRoverOrientation.getValue()+roverMovementRotation.getValue();
			addaptedRoverOrientation = RoverOrientation.valueOf(Math.floorMod(newOrientationValue,4));
		}
		return addaptedRoverOrientation;
	}
	
	/* (non-Javadoc)
	 * @see com.orfertia.espinosa.rover.controller.RoverLocationController#existsPlateauCollision(com.ofertia.espinosa.rover.domain.RoverLocation, com.ofertia.espinosa.rover.domain.Plateau)
	 */
	@Override
	public boolean existsPlateauCollision(RoverLocation roverLocation, Plateau roverPlateau) {
		boolean checkPlateau = false;
		
		if ((roverLocation.getxPosition()>roverPlateau.getWidth())||(roverLocation.getyPosition()>roverPlateau.getHeight())) {
			checkPlateau = true;
		}
		return checkPlateau;
	}

}
