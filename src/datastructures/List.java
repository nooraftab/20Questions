package datastructures;

/**
 * List interface for simplest ADT of sequentially stored data with changing length.
 * 
 * @author astjohn and NoorAftab
 *
 * @param <T> data type 
 * 
 */

public interface List<T> {
 
	/**
	 * Add (insert) data at specific index in list,
	 * e.g., add( 0, data ) inserts data to front/head of list
	 * 
	 * @param index index to insert at
	 * @param data data for node to hold
	 **/
	public void add( int index, T data );
 
	/**
	 * Get data stored at specific index in list.
	 * 
	 * @param index specified index
	 * @return T data returned
	 **/
	public T get( int index );
 
	/**
	 * Delete data at specific index in list,
	 * e.g., delete( 0 ) removes the first element from the list
	 * 
	 * @param index index of node to be deleted
	 **/
	public void delete( int index );
 
	/**
	 * Get the number of elements in this list.
	 * 
	 * @return size
	 **/
	public int size();
 
	/**
	 * Check if the list is empty.
	 * 
	 * @return true if list is empty
 	 **/
	public boolean isEmpty();
 
	/**
	 * Return a string representation of the list
	 * 
	 * @return returns string
 	 **/
	public String toString();
	
}