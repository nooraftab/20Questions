package unrestrictedgame;

/**
 * This class creates the logic/view of the unrestricted 
 * 20 questions game! (it's a child of the restricted guessing 
 * game!)
 * 
 * @author nooraftab
 * 
 */

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTreeNode;
import restrictedgame.GuessingGameGUI;

public class UnrestrictedGuessingGameGUI extends GuessingGameGUI {
	
	//swing components for when it comes to displaying 
	private JPanel panel;
	private JTextField actualAnswer, questionForAnswer;
	private JRadioButton yesOption, noOption;
	
	/**
	 * constructor calls the super constructor!
	 * 
	 * @param xmlFile a passed in name for an xml file
	 */
	public UnrestrictedGuessingGameGUI(String xmlFile) {
		
		super(xmlFile);
		
	}
	/**
	 * this method extends createQuestionSet in the super class but
	 * adds in a feature to check if the correct answer was guessed and
	 * if not, the user has the option to add a new question node
	 * 
	 * an illustration:
	 *  
	 * 	(A)     ->       (N.Q)
	 * 	        			/    \
	 * 	  		(A)/(N.A)    (A)/(N.A)  (depending)
	 * 
	 * @param root passed in node to base subsequent actions on (if it's a leaf or not)
	 */
	protected void createQuestionSet (BinaryTreeNode<String> root) {
	
		super.createQuestionSet(root); //call to super's method
		
		//if a guess is reached
		if (root.isLeaf()) {
			
			//asks the user if the guess hit the nail
			String confirmation = "Is " + root.getData() + " what you were thinking of?";
			int userAnswer = JOptionPane.showConfirmDialog(null, confirmation, "Let's confirm!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			//if the guess wasn't what the user was thinking of
			if (userAnswer == JOptionPane.NO_OPTION) {
											
				//pop-up window with replacing panel in it
				int option = JOptionPane.showConfirmDialog(null, createReplacingPanel(), "Answer the following:", JOptionPane.OK_CANCEL_OPTION);
				
				//after clicking ok
				if (option == JOptionPane.OK_OPTION) {
					
					//sets up the screen of the game so user can play again
					replaceWithNewNode();
					
					//displays yes button if there's a left child
					if (root.getLeftChild() != null) {
						
						yesButton.setVisible(true);
						
					}
					
					//displays no button if there's a right child
					if (root.getRightChild() != null) {
						
						noButton.setVisible(true);
						
					}
					
					repaint(); //refreshes view
					
				}
			
			}	
		
		}
		
	}

	/**
	 * creates a JPanel containing text fields and radio buttons to get 
	 * information for creating a new binary tree node from
	 */
	private JPanel createReplacingPanel() {
		
		//sets up jpanel
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//sets up text field to get what user was thinking of
		actualAnswer = new JTextField("So what were you thinking of?");
		panel.add(actualAnswer);
		
		//sets up text field for a question to what user was thinking of
		questionForAnswer = new JTextField("Could you give me a yes/no question to your answer?");
		panel.add(questionForAnswer);
		
		//a little panel to hold the radio buttons
		JPanel subOptionPanel = new JPanel();
		subOptionPanel.setLayout(new BoxLayout(subOptionPanel, BoxLayout.X_AXIS));
		
		//label to ask for yes/no answer
		subOptionPanel.add(new JLabel("What's the answer to this question?"));
		
		//creates yes option
		yesOption = new JRadioButton ("Yes!");
		yesOption.addActionListener(this);
		subOptionPanel.add(yesOption);
		
		//creates no option
		noOption = new JRadioButton("No!");
		noOption.addActionListener(this);
		subOptionPanel.add(noOption);
		
		//adds sub panel for radio buttons to main panel
		panel.add(subOptionPanel);
		
		return panel;
			
	}
	
	/**
	 * this function replays the game with an updated binary tree which 
	 * includes the answer and question given by the user 
	 */
	private void replaceWithNewNode() {
		
		//node to store the current answer of the game
		BinaryTreeNode<String> oldAnswerNode = new DefaultBinaryTreeNode<>();
		oldAnswerNode.setData(currentQuestionNode.getData());
		
		//updates the current answer node to the new question given
		currentQuestionNode.setData(questionForAnswer.getText());
		
		//creates node to store the new answer
		BinaryTreeNode<String> newAnswerNode = new DefaultBinaryTreeNode<>();
		newAnswerNode.setData(actualAnswer.getText());
		
		//sets the new answer to be the left child of the new question
		if (yesOption.isSelected()) {
			
			currentQuestionNode.setLeftChild(newAnswerNode);
			currentQuestionNode.setRightChild(oldAnswerNode);		
			
		}
		
		//sets the new answer to be the right child of the new question
		else {
			
			currentQuestionNode.setRightChild(newAnswerNode);
			currentQuestionNode.setLeftChild(oldAnswerNode);
			
		}
		
		//replays the game, starting from the beginning!
		createQuestionSet(tree.getRoot());
		
	}

}