package guessNumberGame;

public class GameLauncher {
	public static void main(String[] args) {
		int winningNumBound = 100;
		int playerNum = 3;
		new GuessGame(winningNumBound).startGame(playerNum);
	}
}
