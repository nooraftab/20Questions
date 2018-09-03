package restrictedgame;

/**
 * creates the logic/GUI for our restricted 20 questions game!
 * 
 * @author nooraftab
 * 
 */

import datastructures.BinaryTree; 
import datastructures.BinaryTreeNode;
import datastructures.LinkedList;
import parser.ParsedTree;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.util.Random;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GuessingGameGUI extends JFrame implements ActionListener {
	
	//binary tree to hold our tree of questions/answers
	protected BinaryTree<String> tree;
	
	//list of leaves to show at the start (so one can choose!)
	private LinkedList<String> leafList;
	
	//buttons to choose what ur answer to a question is
	protected JButton yesButton, noButton;
	
	//panel contains our buttons
	private JPanel buttonPanel;

	//label for our question
	private JLabel questionLabel;
	
	//variable to hold the current question to display on the GUI
	protected BinaryTreeNode<String> currentQuestionNode;
	
	/**
	 * constructor instantiates our tree and list of leaves, 
	 * and creates the GUI!
	 * 
	 * @param xml name for the xml-file to parse
	 */
	public GuessingGameGUI (String xml) {
		
		//creates our  tree
		ParsedTree parsedTree = new ParsedTree(xml);
		tree = parsedTree.getParsedTree();
		
		//gets the leaves of the tree (for display purposes)
		leafList = parsedTree.getLeaves();
		
		//creates GUI
		createGame();
		
	}
	
	/**
	 * creates the GUI, by setting up the display of choices and
	 * the question to be asked
	 */
	private void createGame() {
		
		//creates a pop-up window with possible answers to choose from
		createOptionsPanel();
		
		//sets up the buttons/text for interrogation
		createQuestioningView();
		
		//deals with displaying the proper question on the GUI
		createQuestionSet(tree.getRoot());
		
		//sets up the JFrame to hold all this
		setSize(600, 500);
		setLocationRelativeTo(null); //centers the frame!
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	/**
	 * creates a JOptionPane with a cute lil table/panel of the things one
	 * should think of
	 */
	private void createOptionsPanel() {
		
		//creates a panel with a 4x4 grid layout
		JPanel optionsPanel = new JPanel(new GridLayout(4,4));
		
		//loops through all our leaves
		for (int i = 0; i < leafList.size(); i++) {
			
			//creates a centered JLabel of the leaf's text
			JLabel label = new JLabel(leafList.get(i), JLabel.CENTER);
			
			//gives the label a (hopefully) pretty background color
			label.setOpaque(true);
			label.setBackground(generateColor());
			
			//adds JLabel to panel of option
			optionsPanel.add(label);			
			
		}
		
		//string to hold instructions
		String instruction = "Hi! Think of one of these, and we'll try to guess it! :)";
		
		//object array of information we want to show the user (instructions and their options)
		Object[] sweetInformation = {new JLabel(instruction, JLabel.CENTER), optionsPanel};
		
		//creates a pop-up window with our object array! :)
		JOptionPane.showMessageDialog(null, sweetInformation, "20 Questions!", JOptionPane.INFORMATION_MESSAGE);
				
	}
	
	/**
	 * creates and returns a random color in the pastel-ish range! (to be easy
	 * on the eyes!)
	 */
	private Color generateColor() {
		
		//creates a random generator
		Random rand = new Random();
		
		//creates random rgb values within 120-240
		int redness = 120 + rand.nextInt(121);
		int greenness = 120 + rand.nextInt(121);
		int blueness = 120 + rand.nextInt(121);
		
		return new Color (redness, greenness, blueness);
		
	}
	
	/**
	 * creates the buttons and text for our 
	 */
	private void createQuestioningView() {
		
		//instantiates our question label
		questionLabel = new JLabel();
		questionLabel.setHorizontalAlignment(JLabel.CENTER);
		
		//creates a panel with a 1x2 grid to hold our two buttons
		buttonPanel = new JPanel (new GridLayout(1, 2));

		//creates our yes button
		yesButton = new JButton ("yep!");
		yesButton.addActionListener(this);
		yesButton.setOpaque(true);
		yesButton.setBorderPainted(false);
		yesButton.setBackground(new Color(60, 179, 133));
		buttonPanel.add(yesButton);
		
		//creates our no button
		noButton = new JButton("nope!");
		noButton.addActionListener(this);
		noButton.setOpaque(true);
		noButton.setBorderPainted(false);
		noButton.setBackground(new Color(219, 78, 78) );
		buttonPanel.add(noButton);
		
		//adds the question label and the button panel to the frame
		add(questionLabel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	
	}
	
	/**
	 * creates the relevant question's we want to ask, updating them
	 * and the view as necessary
	 * 
	 * @param root node to base wthe view/question on
	 */
	protected void createQuestionSet(BinaryTreeNode<String> root) {
		
		//updates variable for current question
		currentQuestionNode = root;
		
		//updates JLabel for the question
		questionLabel.setText(root.getData());
					
			//if there's no left child, user cant answer yes
			if (root.getLeftChild() == null) {
				
				yesButton.setVisible(false);;
				
			}			
			
			//if there's no right child, user cant answer no
			if (root.getRightChild() == null) {
				
				noButton.setVisible(false);;
				
			}
						
	}
	
	/**
	 * method for the action listener for when a button is
	 * clicked
	 * 
	 * @param ae a given action event (eg pressing a JButton)
	 * 
	 */
	public void actionPerformed (ActionEvent ae) {
		
		//displays left child to the GUI
		if (ae.getSource() == yesButton) {
			
			createQuestionSet(currentQuestionNode.getLeftChild());
						
		}
		
		//displays right child to the GUI
		else if (ae.getSource() == noButton) {
			
			createQuestionSet(currentQuestionNode.getRightChild());
						
		}
		
		repaint(); //refreshes view
		
	}
 
}
