package fourInARow;

//package dm550.tictactoe;

import java.util.*;

public class CLI implements UserInterface {

	public static void main(String[] args) {
		UserInterface ui = new CLI();
		int numColoums = getParameter("width of board", 5, 10);
		Game game = new TTTGame(numColoums);
		ui.startGame(game);

	}

	private static int getParameter(String message, int min, int max) {
		int result = min - 1;
		while (result < min || result > max) {
			System.out.print("Please enter number between" + message + " " + min + " and " + max + ": ");
			try {
				result = Integer.parseInt(new Scanner(System.in).nextLine());
			} catch (NumberFormatException e) {
			}
		}
		return result;
	}

	@Override
	public void showResult(String message) {
		System.out.println(message + "\n\nThanks for playing.");
		System.exit(0);
	}

	@Override
	public void startGame(Game game) {
		game.setUserInterface(this);
		while (true) {
			System.out.println(game);
			game.checkResult();
			Coordinate pos = null;
			int y = this.getParameter("y coordinate", 1, game.getVerticalSize()) - 1;
			int x = 4;
			while (true) {
				pos = new XYCoordinate(x, y);
				if (game.isFree(pos)) {
					break;
				}
				x--;
				if (x < 0) {
					System.out.println("That row is full!");
					break;
				}
			}
			try {
				game.addMove(pos);
			} catch (IllegalArgumentException e) {
				System.out.println(e);
			}

		}
	}

}
