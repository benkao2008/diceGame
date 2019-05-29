package diceGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	public static ArrayList<Player> pool = new ArrayList<Player>();
	private static int playerPoint;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		playGame();
		playAgain();
		
	}
	
	public static void playGame() {
		greet();
		int playerSum = diceSum(rollDice(), rollDice());	
		setPlayerPoint(initDecider(playerSum));
		
		promptEnterKey();
		
		int playerSum2 = diceSum(rollDice(), rollDice());
		System.out.println("Your re-roll is " + playerSum2);
		secDecider(playerSum2, getPlayerPoint());
	}
	
	public static void greet() {
		System.out.println("Welcome to the DICE GAME!");
		System.out.println("Please enter your name: ");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		Player newPlayer = new Player(name, 0);
		pool.add(newPlayer);
		System.out.println("Welcome " + name + "!!");
		System.out.println("You will simulate rolling two 6-sided dice to generate two random numbers between 1-6");
		System.out.println("If the total equals 7 or 11 on your first try, you WIN!");
		System.out.println("If the total equals 2, 3 or 12 on your first try, you LOSE...");
		System.out.println("If the total equals any other number on your first try,");
		System.out.println("that number becomes your POINT number and must be rolled a second time in order to WIN!");
		System.out.println("\n" + "Press Enter to start your first roll...");
		Scanner keyIn = new Scanner(System.in);
		keyIn.nextLine();
	}
	
	
	public static void promptEnterKey(){
		Scanner keyIn = new Scanner(System.in);
		System.out.println("=============== NEXT ROUND ===============");
		System.out.print("Press the enter key to re-roll");
		keyIn.nextLine();
	}
	
	// generate one dice number
	public static int rollDice() {
		int roll = 1 + (int)(Math.random() * 6);
		return roll;
	}
	
	// sum of the two dices
	public static int diceSum(int x, int y) {
		return x + y;
	}
	
	// make decision whether the player win or lose after first roll
	public static int initDecider(int x) {
		if(x == 7 || x == 11) {
			System.out.println("You rolled " + x + ". You WIN!");
			playAgain();
		} else if (x == 2 || x == 3 || x == 12) {
			System.out.println("You rolled " + x + ". You LOSE!");
			playAgain();
		} else {
			System.out.println("You rolled " + x + ". Your POINT is now " + x);
			System.out.println("-------------------------------------------");
			System.out.println("Your next roll needs to be " + x + " for you to win.");
			System.out.println("If your next roll is 7, you lose.");
			System.out.println("-------------------------------------------");
			return x;
		}
		return x;
	}
	
	// second decider after POINT is determined
	public static void secDecider(int x, int point) {
		while ((x == point) == false && (x == 7) == false) {
			x = diceSum(rollDice(), rollDice());
			promptEnterKey();
			System.out.println("The re-roll is " + x);
			secDecider(x, getPlayerPoint());
		}
		
		if (x == point) {
			System.out.println("You rolled POINT " + point + ", You WIN!");
			playAgain();
		} else if(x == 7) {
			System.out.println("You rolled 7, you LOSE!");
			playAgain();
		}
	}
	
	// Play again function to restart from beginning
	public static void playAgain() {
		System.out.println("\n" + "Play again? Y / N");
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();
		if (answer.toUpperCase().equals("Y")) {
			playGame();
		} else if (answer.toUpperCase().equals("N")) {
			System.out.println("Thank you for playing!");
			System.exit(1);
		} else {
			System.out.println("Invalid input. Please try again...");
			playAgain();
		}
	}
	
	
	// getter for player point
	public static int getPlayerPoint() {
		return playerPoint;
	}

	// setter for player point
	public static void setPlayerPoint(int playerPoint) {
		Game.playerPoint = playerPoint;
	}
	

	
	

}
