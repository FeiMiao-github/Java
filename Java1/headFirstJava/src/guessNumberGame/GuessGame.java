package guessNumberGame;

import java.util.ArrayList;
import java.util.Random;

public class GuessGame {
	//winnerFlag if the winner has been selected, the variable will be true
	private boolean winnerFlag = false;
	
	private final int targetNum;
	private Player[] player;
	private static int bound;
	
	public GuessGame(int b) {
		bound = b;
		targetNum = new Random().nextInt(bound);
	}
	
	public static int getBound() {
		return bound;
	}
	/**
	 * @param n the number of player*/
	public ArrayList<Integer> Gaming(int n) {
		player = new Player[n];
		for (int i = 0; i < player.length; i++)
			player[i]  = new Player();
		
		ArrayList<Integer> winnerNo = new ArrayList<>();
		
		while (true) {
			for (int i = 0; i < player.length; i++) {
				player[i].guess();
				if (player[i].getNum() == targetNum) {
					winnerFlag = true;
					winnerNo.add(i);
					player[i].setSuccess();
				}
			}
			
			if (winnerFlag == true) return winnerNo;
		}
	}
	
	public void printWinnerName(ArrayList<Integer> winnerNo) {
		for(int i: winnerNo) {
			System.out.println(player[i].getName() + "=====" +player[i].getNum());
		}
	}
	
	public void startGame(int n) {
		System.out.println("winning number is " + targetNum);
		ArrayList<Integer> winner = Gaming(n);
		System.out.println("===========winner name list=============");
		printWinnerName(winner);
	}
}
