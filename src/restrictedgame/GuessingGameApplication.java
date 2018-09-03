package restrictedgame;

/** 
 * runs our restricted guessing game
 * 
 * @author nooraftab
 *
 */

public class GuessingGameApplication {

	/**
	 * main method runs our restricted game of 20 questions
	 * 
	 * @param args name of a passed in xml file
	 */
	public static void main (String[] args) {

		new GuessingGameGUI(args[0]);

	}
	
}