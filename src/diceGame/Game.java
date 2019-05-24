package diceGame;

public class Game {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int playerSum = diceSum(rollDice(), rollDice());
		System.out.println(playerSum);
		
	}
	
	public static int rollDice() {
		int roll = 1 + (int)(Math.random() * 6);
		return roll;
	}
	
	public static int diceSum(int x, int y) {
		return x + y;
	}
	
	

}
