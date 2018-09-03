package unrestrictedgame;

/** 
 * runs our unrestricted game of 20 questions!
 * 
 * @author nooraftab
 *
 */

public class UnrestrictedGuessingGameApplication {

	/**
	 * runs our unrestricted game!
	 * 
	 * @param args file name for a passed in xml file
	 */
	public static void main (String[] args) {
		
		new UnrestrictedGuessingGameGUI(args[0]);
	
	}
	
}