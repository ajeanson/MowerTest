package fr.opensides.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.opensides.domain.Input;
import fr.opensides.domain.Lawn;
import fr.opensides.domain.Mower;
import fr.opensides.domain.Position;
import fr.opensides.domain.repository.EOrientation;
import fr.opensides.services.impl.InputsDigesterImpl;
import fr.opensides.services.impl.MowerServiceImpl;

public class MowerTests {

	MowerService mowerService;
	InputsDigester digester;

	@Before
	public void setup() {
		mowerService = new MowerServiceImpl();
		digester = new InputsDigesterImpl();
	}

	@After
	public void teardown() {

	}

	
	@Test
	public void testAllFunctionalitiesWithGoodInputs() throws Exception {

		// loadfile:
		List<Input> inputs = digester.digestInputs("/Users/opensides/dev/workspaces/w-current/MvnStrategy/src/test/resources/mowerInput.txt");

		// check file was digest correctly:
		assertNotNull(inputs);

		// start first mower for each inputs, expected is 13N:
		int mowerNumber = 0;
		Position firstMowerPosition = mowerService.startMower(new Mower(inputs.get(mowerNumber).getInitialPosition()), new Lawn(inputs.get(mowerNumber).getLawnUpperRightCornerX(), inputs.get(mowerNumber).getLawnUpperRightCornerY()), inputs.get(mowerNumber).getControls());
		Position expectedFirstMowerPosition = new Position(1, 3, EOrientation.N);
		assertEquals(expectedFirstMowerPosition, firstMowerPosition);

		// start second mower for each inputs, expected is 51E:
		mowerNumber = 1;
		Position secondMowerPosition = mowerService.startMower(new Mower(inputs.get(mowerNumber).getInitialPosition()), new Lawn(inputs.get(mowerNumber).getLawnUpperRightCornerX(), inputs.get(mowerNumber).getLawnUpperRightCornerY()), inputs.get(mowerNumber).getControls());
		Position expectedSecondMowerPosition = new Position(5, 1, EOrientation.E);
		assertEquals(expectedSecondMowerPosition, secondMowerPosition);
	}

}
