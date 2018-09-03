package datastructures;

/** This class creates a node for a linked list (a piece of
 * data and a pointer to its next node) and the associated methods 
 * a node should have!
 * 
 * @author NoorAftab
 * @param <T> a passed in type (for the data the node will store)
 */

public class LinkedListNode<T> {

	//variable to hold data of the node
	private T data;
	
	//variables to hold what node this node 'points' to
	private LinkedListNode<T> next;

	/**
	 * Set the data stored at this node.
	 * @param data the data the node should store
 	 */
	public void setData (T data) {

		this.data = data;

	}

	/**
	 * Get the data stored at this node.
	 * @return returns the data this node contains
	 */
	public T getData () {

		return data;

	}

	/**
	 * Set the next pointer to passed node.
	 * @param node the node we want this node to point to
	 */
	public void setNext (LinkedListNode<T> node) {

		next = node;

	}

	/**
	 * Get (pointer to) next node.
	 * @return returns the node this node points to
	 */
	public LinkedListNode<T> getNext() {

		return next;

	}

	/**
	 * Returns a String representation of this node.
	 * @return returns the data converted to type String
	 */
	public String toString () {

		return data.toString();

	}

}