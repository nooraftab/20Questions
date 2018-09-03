package datastructures;

/**
 * BinaryTree.java
 * CS 201
 * Heather Pon-Barry
 */

/**
 * BinaryTree is the interface for a basic binary tree. 
 */
public interface BinaryTree<T>
{

	/**
	 * Get the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 */
	public BinaryTreeNode<T> getRoot();

	/**
	 * Set the root node for this tree.
	 * 
	 * @param root a given node to set as the root
	 */
	public void setRoot(BinaryTreeNode<T> root);

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 */
	public boolean isEmpty();

	/**
	 * Get the data of this tree using inorder traversal.
	 * 
	 * @return inorder List.
	 */
	public LinkedList<T> inorderTraversal();

	/**
	 * Get the data of this tree using preorder traversal.
	 * 
	 * @return preorder List.
	 */
	public LinkedList<T> preorderTraversal();

	/**
	 * Get the data of this tree using postorder traversal.
	 * 
	 * @return postorder List.
	 */
	public LinkedList<T> postorderTraversal();

}
