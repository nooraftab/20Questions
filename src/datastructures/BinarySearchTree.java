package datastructures;

/**
 * BinarySearchTree.java
 * CS 201
 * Heather Pon-Barry
 */

/**
 * BinarySearchTree is the interface for a basic binary search tree.
 * The binary search tree contains Comparable objects as data with
 * the invariant that all data in the left subtree of a node is
 * less than the data at the node, and all data in the right subtree
 * is greater than or equal to the data at the node.
 */
public interface BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>
{
  /**
   * Insert the data into the tree, maintaining the
   * search tree invariant.
   * 
   * @param data given piece of data to insert
   */  
  public void insert( T data );

  /**
   * Search for data in the tree, finding the node
   * containing it, or null if the data is not present
   * in the tree.
   * 
   * @return the node containing data or null if none exists.
   * @param data a piece of data to look for
   */
  public BinaryTreeNode<T> search( T data );
  
  /**
   * Find the minimum element in the tree.
   * 
   * @return returns the minimum, left-most element
   */
  public T minElement();

  /**
   * Find the maximum element in the tree.
   * 
   * @return returns the max, rightmost element
   */
  public T maxElement();
}
