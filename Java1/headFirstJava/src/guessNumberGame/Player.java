package guessNumberGame;

import java.util.Random;

public class Player {
	private int number = 0;
	private boolean successFlag = false;
	private String name = "player";
	private static int nextInt = 0;
	
	public Player() {
		nextInt++;
		name = name + nextInt;
	}
	public void guess() {
		number = new Random().nextInt(GuessGame.getBound());
		System.out.println(this.getName() + "--" + number);
	}
	
	public void setSuccess() {
		successFlag = true;
	}
	
	public boolean getSuccess() {
		return this.successFlag;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNum() {
		return this.number;
	}
}
