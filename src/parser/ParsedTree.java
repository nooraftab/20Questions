package parser;

/**
 * This class parses our xml file of questions into a java binary tree, for further
 * use in implementing our 20 questions game!
 * 
 * @author nooraftab
 */

import javax.xml.parsers.*;
import org.xml.sax.SAXException;  
import org.w3c.dom.*;
import java.io.*;

import datastructures.*; 

public class ParsedTree {
	
	//binary tree to hold our xml question tree
	private BinaryTree<String> decisionTree;
	
	//a linked list to hold our guessed answers (leaves)
	private LinkedList<String> leafList;

	/**
	 * constructor instantiates our instance variables and parses 
	 * the passed in xml file
	 * 
	 * @param xml a passed in file to create our binary tree from
	 */
	public ParsedTree(String xml) {
		
		//instantiates
		decisionTree = new DefaultBinaryTree<>();
		leafList = new LinkedList<String>();
		
		//kickstarts parsing of given xml file!
		parser(xml);

	}
	
	/**
	 * this method kickstarts the parsing process with a passed in
	 * xml file!
	 */
	private void parser(String fileName) {
		
		try {
			
			//creates the needed variables to put our file into a document
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();			
			DocumentBuilder builder = factory.newDocumentBuilder();
			File xmlFile = new File(fileName); 	
			
			//puts our file into a variable of type document
			Document document = builder.parse(xmlFile);	//IO here		
			
			//begins the parsing process
			parseIntoTree(document);
			
		}
		
		catch (ParserConfigurationException pce) {
			
			System.out.println("ParserConfigurationException hit!");
			
		}
		
		catch (SAXException saxe) {
			
			System.out.println("SAXException hit!");
			
		}
		
		catch  (IOException ioe) {
			
			System.out.println("IOException hit!");
			
		}
		
	}
	
	/**
	 * creates a tree from the root element of the xml file and
	 * sets that to be the root of our decision tree
	 */
	private void parseIntoTree (Document document) {
		
		//gets the root of the xml file
		Element rootElement = document.getDocumentElement();
		
		//parses question root into a node (it has it's various children too)
		BinaryTreeNode<String> root = parseQuestionsIntoNodes (rootElement);
		
		//sets this to be the root of the decision tree
		decisionTree.setRoot(root);
			
	}
	
	/**
	 * this function takes a question element, converts it into a binary tree node, and 
	 * subsequently converts its children into nodes. it returns a node containing
	 * the relevant question in the element
	 */
	private BinaryTreeNode<String> parseQuestionsIntoNodes (Element e) {
		
		if (e.getTagName().equals("question")) { //ensures e is a question
			
			//creates a tree node for the question
			BinaryTreeNode<String> treeNode = new DefaultBinaryTreeNode<>();
			treeNode.setData(e.getAttribute("text"));
			
			if (e.hasChildNodes()) { //if the element has children elements
				
				//creates a list of children
				NodeList childList = e.getChildNodes();
				
				//loops through children
				for (int i = 0; i < childList.getLength(); i++) {
					
					//ensures the child is an element
					if (childList.item(i).getNodeType() == Node.ELEMENT_NODE) {
						
						Element child = (Element) childList.item(i);
											
						//parses the child (a question/guess) into node
						BinaryTreeNode<String> node = parseAnswerElementIntoNode(child);
						
						//we know a questions children are it's answer paths
						String answer = child.getAttribute("useranswer");

						//sets it to be the question node's left child
						if (answer.equals("yes")) {
							
							treeNode.setLeftChild(node);
							
						}
						
						//sets it to be the question node's right child
						else { //if answer is no
														
							treeNode.setRightChild(node);
							
						}	
						
					}
					
				}
				
				return treeNode;
				
			}
			
		}
		
		else { //if element e isn't a question, something's wrong!
			
			System.out.println("question error!");
			
		}
		
		return null;
			
	}
	
	/**
	 * takes in an answer element, parses it into a binary tree node, and returns
	 * said node
	 */
	private BinaryTreeNode<String> parseAnswerElementIntoNode (Element e) {
		
		//ensuring e is an answer element
		if (e.getTagName().equals("answer")) {
			
			//ensures it has children nodes
			if (e.hasChildNodes()) {
			
				//gets list of e's children
				NodeList children = e.getChildNodes();
				
				//loops through children
				for (int i = 0; i < children.getLength(); i++) {
					
					//ensures the child is an element node
					if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
						
						Element child = (Element) children.item(i); 
						
						//creates a new node to hold the element
						BinaryTreeNode<String> node = new DefaultBinaryTreeNode<>();
						
						if (child.getTagName().equals("guess")) { //guess -> final answer/guess
							
							//sets the node to contain the text of the child
							String content = child.getTextContent();					
							node.setData(content);
							
							//adds text content to our list of leaves
							leafList.add(leafList.size(), content);
							
							return node;
							
						}
						
						//calls the question parsing method if the child is a question
						else if (child.getTagName().equals("question")) {
							
							node = parseQuestionsIntoNodes(child);
							
							return node;	
							
						}			
					
					}
				
				}
			
			}
			
		}
		
		else { //if the node isn't an answer node, something's wrong!
			
			System.out.println("answer error!");
			
		}
		
		return null;
		
	}
	/**
	 * returns a linked list of our tree's leaves
	 * 
	 * @return linked list of strings (the contents of the leaf nodes)
	 */
	public LinkedList<String> getLeaves() {
		
		return leafList;
		
	}
	
	/**
	 * getter method for our tree, containing the various questions
	 * and answers for a game of 20 questions
	 * 
	 * @return a binary tree
	 */
	public BinaryTree<String> getParsedTree() {
		
		return decisionTree;
		
	}
	
}