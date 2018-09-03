package datastructures;

/** This class creates the functions needed in order to implement a 
 * linked list! 
 * 
 * @author NoorAftab
 * @param T a passed in type for the data the list stores
 */

public class LinkedList<T> implements List<T> {

	//variable to hold the head of the list
	private LinkedListNode<T> head;
	
	//variable to hold number of elements in the list
	private int size;

	//empty constructor
	public LinkedList () { 	

	}
	
	/**
	 * adds a node to the list!
	 * @param index the index we want to insert this node at
	 * @param data the data we want this inserted node to store
	 */
	public void add (int index, T data) {
		
		//creates the node we want to add
		LinkedListNode<T> node = new LinkedListNode<T> ();
		
		//gives said node the data it should have
		node.setData(data);

		//if we're inserting at the beginning
		if (index == 0) {
			
			//checks if the list isnt empty (if it is, the node will point to null)
			if (!isEmpty()){
				
				//points the node the current head node
				node.setNext(head);

			}
			
			//updates the node of the head
			head = node; 

		}
		
		//otherwise, if inserting anywhere else in the list
		else { 
			
			//finds the previous node
			LinkedListNode<T> previousNode = getNode(index - 1);

			//points the node to the the node previousNode points to
			node.setNext (previousNode.getNext());
			
			//points previousNode to our inserted node
			previousNode.setNext (node);
			
		}
		
		//increments size of the list
		size++;

	}
	
	/**
	 * getter method for the data a node contains at a given index
	 * @param index the index of the node whose data we want
	 * @return returns the data of the node
	 */
	public T get(int index) {
		
		//finds the node at the given index
		LinkedListNode<T> node = getNode(index);
		
		return node.getData();

	}

	/**
	 * deletes a node from the linked list!
	 * @param index the index of the node we want to delete
	 */
	public void delete (int index) {
		
		//checks if we're deleting a node at the beginning of the list
		if (index == 0) {
				
			//if there's multiple nodes to refer to
			if (size() > 1) {

				//updates head to node after it
				head = getNode(index+1);

			}
			else { //if there's only one element in the list

				head = null;

			}
			
											
		}
		
		//otherwise
		else { 
			
			//gets node at previous index
			LinkedListNode<T> previousNode = getNode (index-1);
			
			//if deleting node at end
			if (index == size() - 1) { 
				
				previousNode.setNext(null);
			
			}
			
			//otherwise
			else {
				
				//point previous node's to node after the one to be deleted
				previousNode.setNext (getNode(index+1));	
		
			}
			
		}

		//decrements size of the list
		size--;

	}

	/**
	 * method to get the size of our linked list
	 * @return returns size 
	 */
	public int size() {

		return size;

	}

	/**
	 * checks the head of the list to see if the list contains any elements or not
	 * @return returns true if list is empty (i.e., the head isn't assigned a value)
	 */
	public boolean isEmpty() {

		return head == null;

	}

	//returns the node at a given index!
	private LinkedListNode<T> getNode (int index) {
		
		//throws an exception if the passed in index is negative or bigger than size of the list
		if (index < 0 || index >= size()) {

			return null;

		}
		
		//stores node at the head in a variable
		LinkedListNode<T> tempNode = head;
		
		//loops through the list until tempNode stores the node at index
		for (int i = 0; i < index; i++) {
			
				tempNode = tempNode.getNext();

		}

		return tempNode;

	}

	/**
	 * @return returns a string representation of our linked list!
	 */
	public String toString() {
		
		//variable to store the head
		LinkedListNode<T> tempNode = head;
		
		//empty string to hold the list
		String listString = "";

		//loops through list
		for (int i = 0; i < size(); i++) {
			
			//as long as there's a node after tempNode, print data and an arrow after it
			if (tempNode.getNext() != null) {

				listString += tempNode.toString() + " -> ";
				
				//update tempNode
				tempNode = tempNode.getNext();

			}
			
			//if tempNode is the last node in the list, only print tempNode's data
			else {

				listString += tempNode.toString();

			}
			
		}

		return listString;

	}

}