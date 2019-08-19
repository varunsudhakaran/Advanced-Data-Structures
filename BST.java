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

import java.util.ArrayList; // allowed for creating traversal lists
import java.util.List; // required for returning List<K>
// TODO: Implement a Binary Search Tree class here

/**
 * This class implements a BST by inserting and removing and sorts it out with
 * traversals
 * 
 * @author varunsudhakaran
 *
 * @param <K>
 * @param <V>
 * 
 */
public class BST<K extends Comparable<K>, V> implements BSTADT<K, V> {
	// Tip: Use protected fields so that they may be inherited by AVL
	protected BSTNode<K, V> root;
	protected int numKeys; // number of keys in BST
	// Must have a public, default no-arg constructor

	public BST() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchTreeADT#getPreOrderTraversal()
	 */
	@Override
	public List<K> getPreOrderTraversal() {
		// TODO Auto-generated method stub
		List<K> allKeys = new ArrayList<K>(); // creates list
		if (root == null) { // checks if root is null
			return allKeys; // returns list
		} else {
			preOrderHelper(root, allKeys); // recurses
			return allKeys; // returns list
		}
	}

	/**
	 * This method helper is for recursing through list to get the preorder of the
	 * list.
	 * 
	 * @param curr
	 * @param allKeys
	 * 
	 * @return: none
	 * 
	 */
	private void preOrderHelper(BSTNode<K, V> curr, List<K> allKeys) {
		if (curr == null) { // checks if curr is null
			return; // returns nothing
		} else {
			allKeys.add(curr.key); // adds to list
			preOrderHelper(curr.left, allKeys); // recurses left
			preOrderHelper(curr.right, allKeys); // recurses right
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchTreeADT#getPostOrderTraversal()
	 */
	@Override
	public List<K> getPostOrderTraversal() {
		// TODO Auto-generated method stub
		List<K> allKeys = new ArrayList<K>(); // creates list
		if (root == null) { // checks if root is null
			return allKeys; // returns list
		} else {
			postOrderHelper(root, allKeys); // recurses
			return allKeys; // returns list
		}
	}

	/**
	 * This method helper is for recursing through list to get the postorder of the
	 * list.
	 * 
	 * @param curr
	 * @param allKeys
	 * 
	 * @return: none
	 * 
	 */
	private void postOrderHelper(BSTNode<K, V> curr, List<K> allKeys) {
		if (curr == null) { // checks if curr is null
			return; // returns nothing
		} else {
			postOrderHelper(curr.left, allKeys); // recurses left
			postOrderHelper(curr.right, allKeys); // recurses right
			allKeys.add(curr.key); // adds to list
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchTreeADT#getLevelOrderTraversal()
	 */
	@Override
	public List<K> getLevelOrderTraversal() {
		// TODO Auto-generated method stub
		List<K> allKeys = new ArrayList<K>(); // creates list
		int height = this.getHeight(); // initializes height
		int i = 1; // initializes i
		while (i < height + 1) { // runs a while loop
			getLevelOrderHelper(root, allKeys, i); // recurses
			i++; // increments i
		}
		return allKeys; // returns allKeys
	}

	/**
	 * This method helper is for recursing through list to get the levelorder of the
	 * list.
	 * 
	 * @param curr
	 * @param allKeys
	 * @param level
	 * 
	 * @return: none
	 * 
	 */

	private void getLevelOrderHelper(BSTNode<K, V> curr, List<K> allKeys, int level) {
		if (curr == null) { // checks if curr is null
			return; // returns nothing
		}
		if (level == 1) { // checks if level is 1
			allKeys.add(curr.key); // adds to list
		} else if (level > 1) { // checks if level is greater than 1
			getLevelOrderHelper(curr.left, allKeys, level - 1); // recurses left
			getLevelOrderHelper(curr.right, allKeys, level - 1); // recurses right
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SearchTreeADT#getInOrderTraversal()
	 */
	@Override
	public List<K> getInOrderTraversal() {
		// TODO Auto-generated method stub
		List<K> allKeys = new ArrayList<K>();// creates list
		if (root == null) { // checks if root is null
			return allKeys; // returns list
		} else {
			getInOrderHelper(root, allKeys); // recurses
			return allKeys; // returns list
		}
	}

	/**
	 * This method helper is for recursing through list to get the inorder of the
	 * list.
	 * 
	 * @param curr
	 * @param allKeys
	 * 
	 * @return: none
	 */
	private void getInOrderHelper(BSTNode<K, V> curr, List<K> allKeys) {
		if (curr == null) { // checks if curr is null
			return; // returns nothing
		} else {
			getInOrderHelper(curr.left, allKeys); // recurses left
			allKeys.add(curr.key); // adds to list
			getInOrderHelper(curr.right, allKeys); // recurses right
		}
	}

	/**
	 * This helper method determines to recurse left given two nodes.
	 * 
	 * @param node1
	 * @param node2
	 * 
	 * @return: boolean
	 * 
	 */
	private boolean recurseLeft(BSTNode<K, V> node1, BSTNode<K, V> node2) {
		if (node1.key.compareTo(node2.key) > 0) { // compares nodes
			return true; // returns true
		} else {
			return false; // returns false
		}
	}

	/**
	 * This helper method determines to recurse right given two nodes.
	 * 
	 * @param node1
	 * @param node2
	 * 
	 * @return: boolean
	 * 
	 */

	private boolean recurseRight(BSTNode<K, V> node1, BSTNode<K, V> node2) {
		if (node1.key.compareTo(node2.key) < 0) // compares nodes
			return true; // returns
		else {
		return false; // returns false
	}
}

	/**
	 * This helper method determines to stop recursion.
	 * 
	 * @param node1
	 * @param node2
	 * 
	 * @return: boolean
	 */

	private boolean stopRecurse(BSTNode<K, V> node1, BSTNode<K, V> node2) {
		if (node1.key.compareTo(node2.key) == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DataStructureADT#insert(java.lang.Comparable, java.lang.Object)
	 */
	@Override
	public void insert(K key, V value) throws IllegalNullKeyException, DuplicateKeyException {
		// TODO Auto-generated method stub
		if (key == null) { // checks if key is null
			throw new IllegalNullKeyException(); // throws exception
		} else if (root == null) { // checks if root is null
			root = new BSTNode<K, V>(key, value); // makes a new root
			numKeys++; // increments numKeys
		} else {
			BSTNode<K, V> newNode = new BSTNode<K, V>(key, value); // makes a new node
			insertHelper(root, newNode); // recurses
			numKeys++; // increments numKeys
		}
	}

	/**
	 * This method helper inserts the node into the BST and checks for exceptions.
	 *
	 * @param curr
	 * @param insertNode
	 * 
	 * @return: none
	 * 
	 * @throws DuplicateKeyException
	 * 
	 */
	public void insertHelper(BSTNode<K, V> curr, BSTNode<K, V> insertNode) throws DuplicateKeyException {
		// Algorithm: this is how we can recurse through tree
		// by using the compareTo to check the keys and to
		// keep going deep in the tree.
		if (curr == null) { // checks if curr is null
			curr = insertNode; // makes a curr
		} else {
			if (stopRecurse(curr, insertNode)) {
				// checks if key is equals to curr's key
				throw new DuplicateKeyException(); // throws exception
			} else if (recurseLeft(curr, insertNode)) {
				// checks if key is less than curr's key
				if (curr.left != null) {
					// checks if curr's left is not null
					insertHelper(curr.left, insertNode); // recurses left
				} else {
					curr.left = insertNode; // sets curr.left to insertNode
				}
			} else {
				if (curr.right != null) {
					// checks if curr's right is not null
					insertHelper(curr.right, insertNode); // recurses right
				} else {
					curr.right = insertNode; // sets curr.right to insertNodee
				}
			}
		}
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
	@Override
	public boolean remove(K key) throws IllegalNullKeyException, KeyNotFoundException {
		// TODO Auto-generated method stub
		if (key == null) { // checks if key is null
			throw new IllegalNullKeyException(); // throws exception
		} else {
			if (!contains(key)) { // checks if key is not contained
				throw new KeyNotFoundException(); // throws exception
			} else {
				root = removeHelper(root, key); // sets root to result of removeHelper
				numKeys--; // decrements numKeys
				return true; // returns true
			}
		}
	}

	/**
	 * This helper method goes through the binary tree
	 *  and removes the node from BST. The method checks for
	 *  most of the cases in which a remove can be implemented.
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
			return curr;
		}
		if (keyRightRecurse(curr, removableKey)) { // checks right recurse
			curr.right = removeHelper(curr.right, removableKey); 
			// sets curr.right to the result of removeHelper
			return curr; // returns curr
		} else if (keyLeftRecurse(curr, removableKey)) {  // checks left recurse
			curr.left = removeHelper(curr.left, removableKey);
			// sets curr.left to the result of removeHelper
			return curr; // returns curr
		} else {
			if (!hasChildren(curr)) { // checks if there no children
				return null; // returns null
			}
			else if (hasRightChild(curr)) { // checks if has right child
				return curr.right; // returns curr.right
			}
			else if (hasLeftChild(curr)) { // checks if has left child
				return curr.left; // returns curr.left
			}  else {
				curr.value = minHelper(curr.right).value; // sets curr.value
				curr.key = minHelper(curr.right).key; // sets curr.key
				curr.right = removeHelper(curr.right, curr.key); // removes the node
				return curr; // returns curr
			}
		}
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
	private BSTNode<K, V> minHelper(BSTNode<K, V> removableNode) {
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
			return true; // returns true
		} else {
			return false; // returns false
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see DataStructureADT#get(java.lang.Comparable)
	 */
	@Override
	public V get(K key) throws IllegalNullKeyException, KeyNotFoundException {
		// TODO Auto-generated method stub
		if (key == null) { // checks if key is null
			throw new IllegalNullKeyException(); // throws exception
		} else {
			if (!contains(key)) { // checks if key is contained
				throw new KeyNotFoundException(); // throws exception
			} else {
				return findNode(root, key).value; // recurses through findNode
			}
		}
	}
	
	/**
	 * This helper method recurses through the BST
	 * and finds the node.
	 * 
	 * @param curr
	 * @param key
	 * 
	 * @return: BSTNode<K, V>
	 * 
	 * @throws IllegalNullKeyException
	 * 
	 * @throws KeyNotFoundException
	 */

	private BSTNode<K, V> findNode(BSTNode<K, V> curr, K key) throws IllegalNullKeyException, KeyNotFoundException {
		if (curr == null) { // checks if curr is null
			return null; // returns null
		} else {
			if (keyRightRecurse(curr, key)) { // checks if right recurse
				return findNode(curr.right, key); // recurses
			} else if (keyLeftRecurse(curr, key)) { // checks if left recurse
				return findNode(curr.left, key); // recurses
			} else {
				return curr; // returns curr
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DataStructureADT#contains(java.lang.Comparable)
	 */
	@Override
	public boolean contains(K key) throws IllegalNullKeyException {
		// TODO Auto-generated method stub
		if (key == null) { // checks if key is null
			throw new IllegalNullKeyException(); // throws exception
		} else {
			return containsHelper(root, key); // recurses
		}
	}

	/**
	 * This helper method recurses through BST
	 * and returns a boolean to represent if
	 * the key is contained or not.
	 * 
	 * @param curr
	 * @param key
	 * 
	 * @return: boolean
	 * 
	 */
	private boolean containsHelper(BSTNode<K, V> curr, K key) {
		if (curr == null) { // checks if curr is null
			return false; // returns false
		} else {
			if (keyLeftRecurse(curr, key)) { // checks left recurse
				return containsHelper(curr.left, key); // recurses
			} else if (keyRightRecurse(curr, key)) { // checks right recurse
				return containsHelper(curr.right, key); // recurses
			} else {
				return true; // returns true
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DataStructureADT#numKeys()
	 */
	@Override
	public int numKeys() {
		// TODO Auto-generated method stub
		return numKeys; // returns numKeys
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTADT#getKeyAtRoot()
	 */
	@Override
	public K getKeyAtRoot() {
		// TODO Auto-generated method stub
		if (root == null) { // checks if root is null
			return null; // returns null
		}
		return root.key; // returns key at root
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTADT#getKeyOfLeftChildOf(java.lang.Comparable)
	 */
	@Override
	public K getKeyOfLeftChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
		// TODO Auto-generated method stub
		if (key != null) { // checks if key is not null
			if (contains(key)) { // checks if key is contained
				if (findNode(root, key).left.key == null) { // checks if key is null
					return null; // returns null
				} else {
					return findNode(root, key).left.key; // recurses
				}
			}
		} else {
			throw new IllegalNullKeyException(); // throws exception
		}
		throw new KeyNotFoundException(); // throws exception
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTADT#getKeyOfLeftChildOf(java.lang.Comparable)
	 */
	public K getKeyOfRightChildOf(K key) throws IllegalNullKeyException, KeyNotFoundException {
		// TODO Auto-generated method stub
		if (key != null) { // checks if key is not null
			if (contains(key)) { // checks if key is contained
				if (findNode(root, key).right.key == null) { // checks if key is null
					return null; // returns null
				} else {
					return findNode(root, key).right.key; // recurses
				}
			}
		} else {
			throw new IllegalNullKeyException(); // throws exception
		}
		throw new KeyNotFoundException(); // throws exception
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see BSTADT#getHeight()
	 */
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return getHeightHelper(root); // returns height
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
}
