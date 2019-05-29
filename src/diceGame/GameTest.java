package diceGame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class GameTest {
	
	
	
	public static int diceSum(int x, int y) {
		return x + y;
	}
	
	
	// Test if the dice sum works
	@Test
	public void testIfDiceSumWorks() {
		assertEquals(10, diceSum(5, 5));
	}
	
	public static int initDecider(int x) {
		if(x == 7 || x == 11) {
			System.out.println("You rolled " + x + ". You WIN!");
		} else if (x == 2 || x == 3 || x == 12) {
			System.out.println("You rolled " + x + ". You LOSE!");
		} else {
			System.out.println("You rolled " + x + ". Your POINT is now " + x);
			System.out.println("-------------------------------------------");
			System.out.println("Your next roll needs to be " + x + " for you to win.");
			System.out.println("If your next roll is 7, you lose.");
			System.out.println("-------------------------------------------");
			System.out.println("Press Enter to roll again...");
		}
		return x;
	}

	// Test initial decider
	@Test
	public void testInitDecider() {
		assertEquals(7, initDecider(7));
;	}
	
	public static void playAgain() {
		System.out.println("\n" + "Play again? Y / N");
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();
		if (answer.toUpperCase().equals("Y")) {
			System.out.println("New Game Starting...");
		} else if (answer.toUpperCase().equals("N")) {
			System.out.println("Thank you for playing!");
			System.exit(1);
		} else {
			System.out.println("Invalid input. Please try again...");
		}
		
	}
	
	public static void secDecider(int x, int point) {
		while ((x == point) == false && (x == 7) == false) {
		System.out.println("Testing while loop");
		}
		
		if (x == point) {
			System.out.println("You rolled POINT " + point + ", You WIN!");
			playAgain();
		} else if(x == 7) {
			System.out.println("You rolled 7, you LOSE!");
			playAgain();
		}
	}
	
	@Test
	public void testsecDecider() {
		assertEquals("You rolled 7, you LOSE!", 7);
	}
	
	
	


}
