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

// Students may use and edit this class as they choose
// Students may add or remove or edit fields, methods, constructors for this class
// Students may inherit from an use this class in any way internally in other classes.
// Students are not required to use this class. 
// BUT, IF YOUR CODE USES THIS CLASS, BE SURE TO SUBMIT THIS CLASS
//
// RECOMMENDED: do not use public or private visibility modifiers
// package level access means that all classes in the package can access directly.
//
// Classes that use this type:  <TODO, list which if any classes use this type>
class BSTNode<K,V> {
	
	K key;
	V value; 
	BSTNode<K,V> left;
	BSTNode<K,V> right;
	int balanceFactor;
	int height;
	

	/**
	 * @param key
	 * @param value
	 * @param leftChild
	 * @param rightChild 
	 */
	BSTNode(K key, V value, BSTNode<K,V>  leftChild, BSTNode<K,V> rightChild) {
		this.key = key;
		this.value = value;
		this.left = leftChild;
		this.right = rightChild;
		this.height = 0;
		this.balanceFactor = 0;
	}
	
	BSTNode(K key, V value) { this(key,value,null,null); }
	
}
