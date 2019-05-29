package diceGame;

public class Player {

	private String name;
	private int winStreak;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWinStreak() {
		return winStreak;
	}

	public void setWinStreak(int winStreak) {
		this.winStreak = winStreak;
	}
	
	Player(String name, int winStreak){
		this.name = name;
		this.winStreak = winStreak;
	}
	
}
