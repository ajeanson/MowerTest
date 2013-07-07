package fr.opensides.services;

import java.util.List;

import fr.opensides.domain.Input;

/**
 * @author ajeanson
 * <br><br>
 * 
 * <b>Digester service to load instruction file for a mower</b><br>
 * The first line corresponds to the coordinates of the upper right corner of the lawn. The coordinates of the bottom left corner is assumed to be (0,0)
 * <li> The following lines are sequences used to instruct all mowers that have been deployed. There is one sequence for each mower. Each sequence has two lines of information:
 * <li> The first line gives the initial position of the mower as well as its orientation. The position and orientation are in the form of a letter and two digits, separated by a space
 * <li> The second line is a series of instructions that direct the lawn mower to move about the lawn. The instructions are a series of characters without spaces.
 * 
 * <br>
 * Sample file:<br>
 *  55<br>
 * 	12N<br>
 * 	GAGAGAGAA<br>
 * 	33E<br>
 * 	AADAADADDA
 * 
 *
 */
public interface InputsDigester {
	
	/**
	 * @param filename
	 * @return an input list for each mower to start
	 */
	public List<Input> digestInputs(String filename);
}