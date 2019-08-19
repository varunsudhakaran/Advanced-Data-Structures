////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: p2_BSTAVL
//Files: BST.java, AVL.java, BSTTest.java, AVLTest.java,
// 		BSTNode.java
//Course: CS 400, Semester 1, and Freshman
//
//Author: Varun Sudhakaran
//Email: vsudhakaran@wisc.edu
//Lecturer: Professor Debra Deppeler
//Lecturer Number: 002
//Due Date: 2/24/19
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.List;

// A BST search tree that maintains its balance using AVL rotations.
/**
 * This class is uses the BST class to implement AVL rotations
 * 
 * @author varunsudhakaran
 *
 * @param <K>
 * @param <V>
 */
public class AVL<K extends Comparable<K>,V> extends BST<K, V> {

	// must add rebalancing to BST via rotate operations
	
	public AVL() {
		
	}
	
	/**
	 * This method rotates BST left.
	 * 
	 * @param curr
	 * 
	 * @return: BSTNode<K, V>
	 * 
	 */
	public BSTNode<K, V> leftRotate(BSTNode<K, V> curr) {
		BSTNode<K, V> node1 = curr.right; // sets node to curr.right
		BSTNode<K, V> node2 = node1.left; // sets node to node1.left
		curr.right = node2; // sets curr.right to node2
		node1.left = curr; // sets node1.left to curr
		
		updateHeight(curr); // updates height
		updateHeight(node1); // updates height
		
		return node1; // returns node1
	}
	
	/**
	 * This method rotates BST right.
	 * 
	 * @param curr
	 * 
	 * @return: BSTNode<K, V>
	 * 
	 */
	public BSTNode<K, V> rightRotate(BSTNode<K, V> curr) {
		BSTNode<K, V> node1 = curr.left; // sets node to curr.left
		BSTNode<K, V> node2 = node1.right; // sets node to node1.right
		curr.left = node2; // sets curr.left to node2
		node1.right = curr; // sets node1.right to curr
		
		updateHeight(curr); // updates height
		updateHeight(node1); // updates height
		
		return node1;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see DataStructureADT#insert(java.lang.Comparable, java.lang.Object)
	 */
	public void insert(K key, V value) throws IllegalNullKeyException, DuplicateKeyException {
		// TODO Auto-generated method stub
		if (key == null) { // checks if key is null
			throw new IllegalNullKeyException(); // throws exception
		} else if (contains(key)) { // checks if key is contained
			throw new DuplicateKeyException(); // throws exception
		} else {
			root = insertAssist(root, key, value); // sets root to helper
			numKeys++; // increments numKeys
		}
	}
	
	
	/**
	 * This method helper inserts the node into the BST and rebalances.
	 *
	 * @param curr
	 * @param K key
	 * @param V value
	 * 
	 * @return: none
	 * 
	 * @throws DuplicateKeyException
	 * 
	 */
	public BSTNode<K, V> insertAssist(BSTNode<K, V> curr, K key, V value) {

		if(curr == null) { // checks if curr is null
			curr = new BSTNode<K, V>(key, value);
			// makes new BSTNode
		}
		else if(keyRightRecurse(curr, key)){ // checks recurse right
			curr.right = insertAssist(curr.right, key, value);
			// sets curr.right to helper
		}
		else {
			curr.left = insertAssist(curr.left, key, value);
			// sets curr.left to helper
		}

		updateHeight(curr); //updates height
		
		
		if(balanceFactor(curr) > 1 && balanceFactor(curr.left) < 0) {
			// checks balance factor
			curr.left = leftRotate(curr.left); // sets curr.left to left rotate
			return rightRotate(curr); // returns right rotate
		}
		if(balanceFactor(curr) > 1 && balanceFactor(curr.left) >= 0) {
			// checks balance factor
			return rightRotate(curr); // returns right rotate
		}
		if(balanceFactor(curr) < -1 && balanceFactor(curr.right) > 0) {
			// checks balance factor
			curr.right = rightRotate(curr.right); // sets curr.right to right rotate
			return leftRotate(curr);
			// returns left rotate
		}
		if(balanceFactor(curr) < -1 && balanceFactor(curr.right) <= 0) {
			// checks balance factor
			return leftRotate(curr);
			// returns left rotate
		}
		
		return curr; // returns curr
	}
	
	
	/**
	 * This helper method determines to left recurse 
	 * given a node and a key.
	 * 
	 * @param node
	 * @param key
	 * 
	 * @return: boolean
	 * 
	 */
	private boolean keyLeftRecurse(BSTNode<K, V> node, K key) {
		if (key.compareTo(node.key) < 0) { // compares nodes
			return true; // returns true
		} else {
			return false; // returns false
		}
	}
	
	/**
	 * This helper method determines to right recurse 
	 * given a node and a key.
	 * 
	 * @param node
	 * @param key
	 * 
	 * @return: boolean
	 * 
	 */

	private boolean keyRightRecurse(BSTNode<K, V> node, K key) {
		if (key.compareTo(node.key) > 0) { //compares nodes
			return true; // returns true
		} else {
			return false; // returns false
		}
	}

	/**
	 * This helper method determines to stop recurse 
	 * given a node and a key.
	 * 
	 * @param node
	 * @param key
	 * 
	 * @return: boolean
	 * 
	 */
	
	private boolean keyStopRecurse(BSTNode<K, V> node, K key) {
		if (key.compareTo(node.key) == 0) { // compares nodes
			return true; // returns true
		} else {
			return false; // returns false
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see DataStructureADT#remove(java.lang.Comparable)
	 */
	public boolean remove(K key) throws IllegalNullKeyException, KeyNotFoundException {
		// TODO Auto-generated method stub
		if (key == null) { // checks if key is null
			throw new IllegalNullKeyException(); // throws exception
		} else {
			if (!contains(key)) { // checks if key is not contained
				throw new KeyNotFoundException(); // throws exception
			} else {
				root = removeHelper(root, key); // sets root to helper
				numKeys--; // decrements numKeys
				return true; // returns true
			}
		}
	}
	/**
	 * This helper method goes through the binary tree
	 *  and removes the node from BST. The method checks for
	 *  most of the cases in which a remove can be implemented
	 *  and also rebalances tree.
	 * 
	 * @param curr
	 * @param removableKey
	 * 
	 * @return: BSTNode<K, V> 
	 * 
	 * @throws IllegalNullKeyException
	 * 
	 * @throws KeyNotFoundException
	 */
	protected BSTNode<K, V> removeHelper(BSTNode<K, V> curr, K removableKey)
			throws IllegalNullKeyException, KeyNotFoundException {
		if (curr == null) { // checks if curr is null
			return curr; // returns null
		}
		if (keyRightRecurse(curr, removableKey)) { // checks right recurse
			curr.right = removeHelper(curr.right, removableKey);
			// sets curr.right to helper
		}
		else if (keyLeftRecurse(curr, removableKey)) { // checks left recurse
			curr.left = removeHelper(curr.left, removableKey);
			// sets curr.left to helper
		} else {
			if (!hasChildren(curr)) { // checks if it doesn't have children
				return null; // returns null
			}
			else if (hasRightChild(curr)) { // checks if there is right child
				return curr.right; // returns curr.right
			} 
			else if (hasLeftChild(curr)) { // checks if there is a left chuld
				return curr.left; // returns curr.left
			} else {
				curr.value = minHelper(curr.right).value; // changes value
				curr.key = minHelper(curr.right).key; // changes key
				curr.right = removeHelper(curr.right, curr.key); // removes node
			}
			
		}
		
		updateHeight(curr); // updates height
		
		if(balanceFactor(curr) > 1 && balanceFactor(curr.left) < 0) {
			// checks balance factor
			curr.left = leftRotate(curr.left); // sets curr.left to left rotate
			return rightRotate(curr); // returns right rotate
		}
		if(balanceFactor(curr) > 1 && balanceFactor(curr.left) >= 0) {
			// checks balance factor
			return rightRotate(curr); // returns right rotate
		}
		if(balanceFactor(curr) < -1 && balanceFactor(curr.right) > 0) {
			// checks balance factor
			curr.right = rightRotate(curr.right); // sets curr.right to right rotate
			return leftRotate(curr);
			// returns left rotate
		}
		if(balanceFactor(curr) < -1 && balanceFactor(curr.right) <= 0) {
			// checks balance factor
			return leftRotate(curr);
			// returns left rotate
		}
		
		return curr; // returns curr
	}
	/**
	 * This helper method helps find the
	 * minimum node of the right subtree.
	 * 
	 * @param removableNode
	 * 
	 * @return: BSTNode<K, V>
	 * 
	 */
	protected BSTNode<K, V> minHelper(BSTNode<K, V> removableNode) {
		while (removableNode.left != null) { 
			// runs while the left node is not null
			removableNode = removableNode.left; 
			// sets removableNode to left node
		}
		return removableNode; // returns removableNode
	}

	/**
	 * This helper method checks if has left child
	 * given a node
	 * 
	 * @param node
	 * 
	 * @return: boolean
	 * 
	 */
	private boolean hasLeftChild(BSTNode<K, V> node) {
		if (node.left != null && node.right == null) {
			// checks the children
			return true; // returns true
		} else {
			return false; // returns false
		}
	}
	
	/**
	 * This helper method checks if has right child
	 * given a node
	 * 
	 * @param node
	 * 
	 * @return: boolean
	 * 
	 */

	private boolean hasRightChild(BSTNode<K, V> node) {
		if (node.right != null && node.left == null) {
			// checks children
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This helper method checks if they have children 
	 * given a node
	 * 
	 * @param node
	 * 
	 * @return: boolean
	 * 
	 */

	private boolean hasChildren(BSTNode<K, V> node) {
		if (node.left == null && node.right == null) {
			// checks children
			return false; // returns false
		} else {
			return true; // returns true
		}
	}
	
	
	/**
	 * This helper methof recurses through the BST
	 * and increments left height and right height
	 * and the method returns the greater height
	 * of the two.
	 * 
	 * @param curr
	 * 
	 * @return: BST<K, V> curr
	 * 
	 */
	private int getHeightHelper(BSTNode<K, V> curr) {
		int heightLeft = 0; // sets to zero
		int heightRight = 0; // sets to zero
		if (curr == null) { // checks if curr is null
			return 0; // returns zero
		} else {
			heightLeft++; // increments heightLeft
			heightLeft += getHeightHelper(curr.left); // recurses
			heightRight++; // increments heightRight
			heightRight += getHeightHelper(curr.right); // recurses
		}
		return heightMax(heightLeft, heightRight); // returns max height
	}
	
	/**
	 * This helper method returns the max height.
	 * 
	 * @param l
	 * @param r
	 * 
	 * @return: int height
	 * 
	 */

	private int heightMax(int l, int r) {
		if (r > l) { // checks if r is greater than l
			return r; // returns r
		} else {
			return l; // returns l
		}
	}
	
	/**
	 * This helper node is used for tests and 
	 * to get the node given a key and value.
	 * 
	 * @param key
	 * @param value
	 * 
	 * @return: BSTNode<K, V> 
	 * 
	 */
	protected BSTNode<K, V> getNode(K key, V value){
		BSTNode <K, V> node = new BSTNode<K, V>(key, value);
		// creates BSTNode
		return node; // returns node
	}
	
	/**
	 * This method updates the height
	 * 
	 * @param node
	 * 
	 * @return: none
	 * 
	 */
	public void updateHeight(BSTNode<K, V> node) {
		node.height = heightMax(getHeightHelper(node.left), getHeightHelper(node.right))+1;
		// updates the height
	}
	
	/**
	 * This method calculates the balance factor
	 * 
	 * @param curr
	 * 
	 * @return: int balance factor
	 * 
	 */
	public int balanceFactor(BSTNode<K, V> curr) {
		return getHeightHelper(curr.left)-getHeightHelper(curr.right);
		// returns balance factor
	}
}
