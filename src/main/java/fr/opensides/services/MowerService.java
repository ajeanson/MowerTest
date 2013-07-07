package fr.opensides.services;

import java.util.List;

import fr.opensides.domain.Lawn;
import fr.opensides.domain.Mower;
import fr.opensides.domain.Position;
import fr.opensides.domain.repository.EControl;

/**
 * @author ajeanson
 * 
 * <br><br>
 * <b>Mower service that start a mover with an instruction plan</b>
 * <br>
 * <li> Each mower moves sequentially, which means that the second mower moves only when the first one has run its full set of instructions.
 * <li> When a mower completes its sequence instructions, it communicates its position and orientation
 */
public interface MowerService {

	/**
	 * Start a mower on a lawn and move it with each controls given in parameter
	 * 
	 * @param mower
	 * @param lawn
	 * @param controls
	 * @return mower last position
	 */
	public Position startMower(Mower mower, Lawn lawn, List<EControl>controls);
	
}