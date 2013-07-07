package fr.opensides.services.impl;

import java.util.List;

import org.apache.log4j.Logger;

import fr.opensides.domain.Lawn;
import fr.opensides.domain.Mower;
import fr.opensides.domain.Position;
import fr.opensides.domain.repository.EControl;
import fr.opensides.domain.repository.EOrientation;
import fr.opensides.services.MowerService;

public class MowerServiceImpl implements MowerService {
	private final static Logger log = Logger.getLogger(MowerServiceImpl.class.getName());
	
	public Position startMower(Mower mower, Lawn lawn, List<EControl>controls) {
		log.info("Start a mower: mower:"+mower+"/lawn:"+lawn);
		for (EControl control : controls) {
			move(mower, lawn, control);
		}
		log.info("Mower has finish its course. New position: "+mower.getPosition());
		return mower.getPosition();
	}
	
	/**
	 * Move a mower on a lawn
	 * 
	 * @param mower
	 * @param lawn
	 * @param control
	 * @return last mower position
	 */
	private Position move(Mower mower, Lawn lawn, EControl control) {
		log.info("Move a mower: mower:"+mower+"/lawn:"+lawn+"/control:"+control);
		EOrientation initialOrientation = mower.getPosition().getOrientation();
		switch (control)
		{
			case A:
				moveA(mower, initialOrientation, lawn);
				break;
			case D:
				moveD(mower, initialOrientation);
				break;
			case G:
				moveG(mower, initialOrientation);
				break;

		}
		log.info("Mower has finish its move. New position: "+mower.getPosition());
		return mower.getPosition();
	}
	

	/**
	 * Move a mower forward on a lawn
	 * 
	 * @param mower
	 * @param initialOrientation
	 * @param lawn
	 */
	private void moveA(Mower mower, EOrientation initialOrientation, Lawn lawn){
		switch(initialOrientation){
		case E:
			if (mower.getPosition().getX() < lawn.getxMax()){
				mower.getPosition().setX(mower.getPosition().getX()+1);
			}else{
				log.error("Bad move while moving toward E position, mover go outside lawn - mower:"+mower+"/lawn:"+lawn+"/initialOrientation:"+initialOrientation);
				//TODO: throws exception
			}
			break;
		case N:
			if (mower.getPosition().getY() < lawn.getyMax()){
				mower.getPosition().setY(mower.getPosition().getY()+1);
			}else{
				log.error("Bad move while moving toward E position, mover go outside lawn - mower:"+mower+"/lawn:"+lawn+"/initialOrientation:"+initialOrientation);
				//TODO: throws exception
			}
			break;
		case S:
			if (mower.getPosition().getY() > 0){
				mower.getPosition().setY(mower.getPosition().getY()-1);
			}else{
				log.error("Bad move while moving toward E position, mover go outside lawn - mower:"+mower+"/lawn:"+lawn+"/initialOrientation:"+initialOrientation);
				//TODO: throws exception
			}
			break;
		case W:
			if (mower.getPosition().getX() > 0){
				mower.getPosition().setX(mower.getPosition().getX()-1);
			}else{
				log.error("Bad move while moving toward E position, mover go outside lawn - mower:"+mower+"/lawn:"+lawn+"/initialOrientation:"+initialOrientation);
				//TODO: throws exception
			}
			break;
		}
	}
	
	
	/**
	 * Turn mower on the left
	 * @param mower
	 * @param initialOrientation
	 */
	private void moveG(Mower mower, EOrientation initialOrientation){
		switch(initialOrientation){
		case E:
			mower.getPosition().setOrientation(EOrientation.N);
			break;
		case N:
			mower.getPosition().setOrientation(EOrientation.W);
			break;
		case S:
			mower.getPosition().setOrientation(EOrientation.E);
			break;
		case W:
			mower.getPosition().setOrientation(EOrientation.S);
			break;
		}
	}
	
	/**
	 * Turn mower on the right
	 * 
	 * @param mower
	 * @param initialOrientation
	 */
	private void moveD(Mower mower, EOrientation initialOrientation){
		switch(initialOrientation){
		case E:
			mower.getPosition().setOrientation(EOrientation.S);
			break;
		case N:
			mower.getPosition().setOrientation(EOrientation.E);
			break;
		case S:
			mower.getPosition().setOrientation(EOrientation.W);
			break;
		case W:
			mower.getPosition().setOrientation(EOrientation.N);
			break;
		}
	}

}
