public class goBang {
	private final static int BOARD_SIZE = 20;
	private final static String BOARD_LINE = "\uFF0B";
	private final static String BLACK_CHESSPIECE = "\u25CF";
	private final static String WHITE_CHESSPIECE = "\u25CB";
	private final static String INACCESSIBLE_REGION = "\u2588";

	private String[][] chessPiece = new String[BOARD_SIZE][BOARD_SIZE];

	enum chessPieceColor {
		white, black
	}; //????
	
	enum resultCheck {
		white, black, tied, not_yet
	}

	public void initBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				this.chessPiece[i][j] = BOARD_LINE;

				if (i < 4 || i > BOARD_SIZE - 5 || j < 4 || j > BOARD_SIZE - 5) {
					this.chessPiece[i][j] = INACCESSIBLE_REGION;
				}
			}
		}
		this.drawBoard();
	}

	public void drawBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(this.chessPiece[i][j]);
			}
			System.out.println();
		}
	}

	public boolean beforeMove(int x, int y) {
		if (this.chessPiece[x][y] != BOARD_LINE) {
			return false;
		} else {
			return true;
		}
	}

	public boolean victoryCheck(int x, int y) {
		int startX = x - 4;
		int startY = y - 4;
		int endX = x + 4;
		int endY = y + 4;
		int count = 0;

		// ??????
		for (int i = startY; i <= endY; i++) {
			if (this.chessPiece[x][i].equals(this.chessPiece[x][y])) {
				count++;
			} else {
				count = 0;
			}
			
			if (count >= 5) {
				return true;
			}
		}
		
		// ????
		count = 0;
		for (int i = startX; i <= endX; i++) {
			if (this.chessPiece[i][y] == this.chessPiece[x][y]) {
				count++;
			} else {
				count = 0;
			}

			if (count >= 5) {
				return true;
			}
		}
		
		// ?????
		count = 0;
		for (int i = startX, j = startY; (i <= endX && j <= endY); i++, j++) {
			if (this.chessPiece[i][i] == this.chessPiece[x][y]) {
				count++;
			} else {
				count = 0;
			}

			if (count >= 5) {
				return true;
			}
		}
		
		// ?????
		count = 0;
		for (int i = endX, j = startY; (i >= startX && j <= endY); i--, j++) {
			if (this.chessPiece[i][j] == this.chessPiece[x][y]) {
				count++;
			} else {
				count = 0;
			}

			if (count >= 5) {
				return true;
			}
		}

		return false;
	}
	

	public boolean moveChesspieces(int x, int y, chessPieceColor color) {
		String circle = "";
		boolean isSuccess = false;

		if (this.beforeMove(x, y)) {

			if (color == chessPieceColor.white) {
				circle = WHITE_CHESSPIECE;
			} else {
				circle = BLACK_CHESSPIECE;
			}

			this.chessPiece[x][y] = circle;
			this.clearScreen();
			this.drawBoard();
			isSuccess = true;
		} else {
			System.out.println("此处不可落子");
			isSuccess = false;
		}

		return isSuccess;
	}

	public void clearScreen() {
		for (int i = 0; i < 1; i++) {
			System.out.println();
		}
	}

	public boolean checkBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (this.chessPiece[i][j] == BOARD_LINE)
					return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		goBang test = new goBang();
		boolean isBlack = false;
		boolean result = false;

		test.initBoard();

		do{
			int x = (int)(Math.random() * 12) + 4;
			int y = (int) (Math.random() * 12) + 4;

			if (isBlack) {
				if (!test.moveChesspieces(x, y, chessPieceColor.black)) {
					continue;
				}
			} else {
				if (!test.moveChesspieces(x, y, chessPieceColor.white)) {
					continue;
				}
			}

			isBlack = !isBlack;
			result = test.victoryCheck(x, y);
			System.out.println("胜负结果: " + result);
			
			if (!test.checkBoard()) {
				break;
			}
		} while (!result);
	}		
}