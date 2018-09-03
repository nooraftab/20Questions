package datastructures;

/** This class creates a binary tree and methods for
 * traversing one! It also has a main method where we test
 * out our implementation! :)
 * 
 * @author nooraftab
 *
 * @param <T> a passed in type for the tree
 */

public class DefaultBinaryTree<T> implements BinaryTree<T> {

	//root node of the tree (protected so children can access it!)
	protected BinaryTreeNode<T> root;  

	/**
	 * The main method creates a binary tree of dwarf names, as
	 * shown in the example picture in the assignment document
	 * 
	 * @param args passed in string, not needed for this program
	 */
	public static void main (String[] args) {

		//instance of a tree for the dwarf name tree
		BinaryTree<String> dwarfTree = new DefaultBinaryTree<>();
		
		//array of nodes of type string to hold the dwarves 
		BinaryTreeNode<String>[] dwarfArray = new DefaultBinaryTreeNode[7];

		//for loops instantiates all the dwarves nodes
		for (int i = 0; i < dwarfArray.length; i++) {

			dwarfArray[i] = new DefaultBinaryTreeNode<>();
			
		}

		//string array of the dwarves names
		String[] dwarfNames = {"Happy", "Doc", "Sleepy", "Bashful", "Grumpy", "Dopey", "Sneezy"};

		//loop sets the data of the name nodes to the values of the name array
		for (int i = 0; i < dwarfArray.length; i++) {

			dwarfArray[i].setData(dwarfNames[i]);
			
		}
		
		//sets happy as the root of the tree
		dwarfTree.setRoot(dwarfArray[0]);
		
		//happy points to doc (left) and sleepy (right)
		dwarfArray[0].setLeftChild(dwarfArray[1]);
		dwarfArray[0].setRightChild(dwarfArray[2]);

		//doc points to bashful(left) and grumpy (right)
		dwarfArray[1].setLeftChild(dwarfArray[3]);
		dwarfArray[1].setRightChild(dwarfArray[4]);
		
		//sleepy points to sneezy(right)
		dwarfArray[2].setRightChild(dwarfArray[6]);

		//grumpy points to dopey(right)
		dwarfArray[4].setRightChild(dwarfArray[5]);
		
		//prints out the pre/in/postorder traversals to the terminal
		System.out.println("preorderTraversal: " + dwarfTree.preorderTraversal().toString());
		System.out.println("inorderTraversal: " + dwarfTree.inorderTraversal().toString());
		System.out.println("postorderTraversal: " + dwarfTree.postorderTraversal().toString());

	}

	/**
	 * getter method for the root of the binary tree
	 * 
	 * @return returns the root node
	 */
	public BinaryTreeNode<T> getRoot() {

		return root;

	}

	/**
	 * sets the root of the binary tree
	 * 
	 * @param root passed in node we want to set as the root
	 */
	public void setRoot(BinaryTreeNode<T> root) {

		this.root = root;

	}
	
	/**
	 * checks if the binary tree has any nodes in it
	 * 
	 * @return true if the tree is empty
	 */
	public boolean isEmpty() {
		
		//if the root has no value, it must mean the tree is empty!
		if (root == null) {

			return true;
			
		}

		return false;

	}
	
	/**
	 * this methods walks through our tree from the middle node to the 
	 * left node to the right node in the tree/subtree
	 * 
	 * @return returns a linked list of our traversal
	 */
	public LinkedList<T> preorderTraversal() {
		
		//list to hold the traversal
		LinkedList<T> list = new LinkedList<>();
		
		//traverses through our tree starting from the root
		preorderTraversal (root, list);

		return list;

	}
	
	/**
	 * this method traverses through our binary tree from
	 * middle -> left -> right, and adds each node visited to a
	 * linked list
	 */
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		
		//returns if tree is empty
		if (node == null) {

			return;

		}

		else {
			
			//adds node to the linked list if it has no children
			if (node.isLeaf()) {

				traversal.add(traversal.size(), node.getData());
			}
			
			else {
				
				//adds node's data to the list
				traversal.add(traversal.size(), node.getData());
				
				//traverses through the left subtree
				preorderTraversal(node.getLeftChild(), traversal);

				//traverses through the right subtree
				preorderTraversal (node.getRightChild(), traversal);

			}
			
		}

	}

	/**
	 * this method traverses through a binary tree, going from the
	 * left to the middle to the right node, starting from the root
	 * 
	 * @return a linked list of the inorder traversal
	 */
	public LinkedList<T> inorderTraversal() {
		
		//linked list to hold our traversal
		LinkedList<T> list = new LinkedList<>();
		
		//traverses through our tree and adds values to our list
		inorderTraversal (root, list);

		return list;

	}
	
	/**
	 * traverses through a binary tree from left -> middle -> right and adds each
	 * visited node to a linked list (traversal)
	 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		
		//returns if tree is empty
		if (node == null) {

			return; 
			
		}

		else {

			//adds the data of the node to the list if it has no children
			if (node.isLeaf()) {

				traversal.add(traversal.size(), node.getData());

			}
			
			else {
				
				//traverses through the left subtree of the node	
				inorderTraversal(node.getLeftChild(), traversal);
				
				//adds the current node's data to the list
				traversal.add(traversal.size(), node.getData()) ;
				
				//traverses through the right subtree of the node
				inorderTraversal(node.getRightChild(), traversal);

			}

		}

	}
	
	/**
	 * traverses through a binary tree from the left node, to the
	 * right node, to the middle node
	 * 
	 * @return a linked list of our traversal
	 */
	public LinkedList<T> postorderTraversal() {
		
		//list to hold the traversal
		LinkedList<T> list = new LinkedList<>();
		
		//traverses and adds node values to above list
		postorderTraversal (root, list);

		return list;

	}
	
	/**
	 * traverses through a given binary tree and adds values to a linked list in
	 * the order: left -> right -> middle
	 */
	private void postorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {
		
		//returns if tree is empty
		if (node == null) {

			return;
			
		}
		
		else {
			
			//adds node's data to the list if it is a leaf of the tree
			if (node.isLeaf()) {

				traversal.add(traversal.size(), node.getData());

			}

			else {
				
				//traverses through the left subtree
				postorderTraversal (node.getLeftChild(), traversal);

				//traverses through the right subtree
				postorderTraversal (node.getRightChild(), traversal);
				
				//adds middle nodes data to the list
				traversal.add(traversal.size(), node.getData());

			}
			
		}

	}

}