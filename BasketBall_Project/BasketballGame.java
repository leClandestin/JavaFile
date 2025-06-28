package projects;

import java.util.Scanner;
import java.util.Random;

/**
 * @author Tran Ly 
 * This is a basketball game for 2v2. Random scores given to 2 players.
 *         After 4 quarters, it displays the player with highest scores win.
 */
public class BasketballGame {
	/**
	 * 
	 * Main method class that calls other methods to show output of game so
	 * validName1,validName2 calls method inputPlayerInfo() to get user input name
	 * scores array stores and call play(validName1, validName2); play method calls
	 * validName1, validName2 to shows the output of the program play displayWinner
	 * method is called and (validName1, validName2, scores) is sent to make the
	 * method run to show winner of game and their highest score
	 */
	public static void main(String[] args) {
		System.out.println("Simulating a one on one basketball game");
		String validName1 = inputPlayerInfo();
		String validName2 = inputPlayerInfo();
		int[] scores = play(validName1, validName2);
		displayWinner(validName1, validName2, scores);

	}

	/**
	 * 
	 * @return This method ask user to input their name, verify its alphabetical and
	 *         return it else it keep asking until verify is valid
	 * 
	 */
	public static String inputPlayerInfo() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			boolean isValid = true;
			System.out.print("Input name of player: ");
			String playerName = scan.next();
			for (int i = 0; i < playerName.length(); i++) {
				char letter = playerName.charAt(i);
				if (!(Character.isLetter(letter))) {
					isValid = false;
					break;
				}
			}
			if (isValid) {
				return playerName;
			}
		}
	}

	/**
	 * 
	 * @this class returns a random generate number
	 */
	public static int playShot() {
		Random rand = new Random();
		int randNums = rand.nextInt(4);
		return randNums;
	}

	/**
	 * 
	 * @this class gets a random number "shot" either 1 2 3 or 4
	 * @returns a string of the randomized number
	 */
	public static String displayShot(int shot) {
		if (shot == 0) {
			String randShots = "Air Ball";
			return randShots;
		} else if (shot == 1) {
			String freeThrow = "Free Throw";
			return freeThrow;
		} else if (shot == 2) {
			String twoPts = "Two Pointer";
			return twoPts;
		} else {
			String threePts = "Three Pointer";
			return threePts;
		}
	}

	/**
	 * 
	 * @param player1,player2 gets player name and displays also displays the shot#,
	 *                        quarters, shot name, shot score in a organized evenly
	 *                        spaced rows/columns then it @return the totalscores of
	 *                        each player that was added in the for loop
	 */
	public static int[] play(String player1, String player2) {
		int score1;
		int score2;
		int totalScore1 = 0;
		int totalScore2 = 0;
		String nameP1;
		String nameP2;
		int x = 0;
		for (int i = 1; i <= 4; i++) {
			System.out.println("\n" + "----------------------------Quarter " + i + "------------------------------");
			System.out.printf("%7s %s %34s %n", "", player1, player2);
			System.out.printf("%5s%7s%27s%6s%22s%n", "Shot#", "Shot", "Score", "Shot", "Score");

			for (int j = 0; j <= 23; j++) {
				score1 = playShot();
				score2 = playShot();
				nameP1 = displayShot(score1);
				nameP2 = displayShot(score2);
				System.out.printf("%2d %-4s %-13s %17d %s %-13s %12d  %n", x, "", nameP1, score1, "", nameP2, score2);
				totalScore1 += score1;
				totalScore2 += score2;
				x++;
			}
		}
		return new int[] { totalScore1, totalScore2 };
	}

	/**
	 * 
	 * gets @param scores array of two player [0] = player1, [1] = player2 and
	 * compares two scores whichever player scores higher, it displays the player
	 * winning the game with highest scores
	 */
	public static void displayWinner(String player1, String player2, int[] scores) {
		if (scores[0] > scores[1]) {
			System.out.println("\n" + player1 + " wins with a score of " + scores[0]);
		} else {
			System.out.println("\n" + player2 + " wins with a score of " + scores[1]);
		}
	}
}
