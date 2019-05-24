package diceGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {
	
	
	public static int diceSum(int x, int y) {
		return x + y;
	}
	
	@Test
	public void testIfDiceSumWorks() {
		assertEquals(10, diceSum(5, 5));
	}


}
