package datastructures;

/** This class creates the needed parts of a binary tree node
 * (a piece of data it can hold and two pointers), along with
 * associated methods
 * 
 * @author nooraftab
 *
 * @param <T> a passed in type
 */

public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {
	
	//data the node holds
	private T data;
	
	//pointers to left and right nodes (set to null)
	private BinaryTreeNode<T> leftChild, rightChild;

	/**
	 * empty constructor
	 */
	public DefaultBinaryTreeNode () {

	}

	/**
	 * getter method for the data a node holds
	 * @return the data of the node
	 */
	public T getData() {

		return data;

	}

	/** 
	 * sets the data of the node
	 * @param data the data we want the node to hold
	 */
	public void setData(T data) {

		this.data = data;

	}

	/** 
	 * getter method for the left child of this node
	 * @return the left pointer
	 */
	public BinaryTreeNode<T> getLeftChild() {

		return leftChild;

	}
	
	/**
	 * getter method for right child of this node
	 * @return the right pointer
	 */
	public BinaryTreeNode<T> getRightChild() {

		return rightChild;

	}
	
	/**
	 * setter method to set the left pointer of the node
	 * 
	 * @param left a passed in node to set as the left child
	 */
	public void setLeftChild( BinaryTreeNode<T> left ) {

		leftChild = left;
		
	}
	
	/**
	 * setter method to set the right pointer of the node
	 * 
	 * @param right a passed in node to set as the right child
	 */
	public void setRightChild( BinaryTreeNode<T> right ) {

		rightChild = right;
		
	}

	/**
	 * tells us if the node is a leaf by checking
	 * if it has right/left children
	 * 
	 * @return true if the node is a leaf
	 */
	public boolean isLeaf() {

		//ensures the node has neither a left child nor a right one!
		if ((leftChild == null) && (rightChild == null) ) {

			return true;
			
		}

		return false;

	}

}