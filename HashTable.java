////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: p2_BSTAVL
//Files: HashTable.java, HashTableTest.java
//Course: CS 400, Semester 1, and Freshman
//
//Author: Varun Sudhakaran
//Email: vsudhakaran@wisc.edu
//Lecturer: Professor Debra Deppeler
//Lecturer Number: 002
//Due Date: 3/14/19
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

// TODO: comment and complete your HashTableADT implementation
// DO ADD UNIMPLEMENTED PUBLIC METHODS FROM HashTableADT and DataStructureADT TO YOUR CLASS
// DO IMPLEMENT THE PUBLIC CONSTRUCTORS STARTED
// DO NOT ADD OTHER PUBLIC MEMBERS (fields or methods) TO YOUR CLASS
//
// TODO: implement all required methods
//
// TODO: describe the collision resolution scheme you have chosen
// identify your scheme as open addressing or bucket
//
// TODO: explain your hashing algorithm here 
// NOTE: you are not required to design your own algorithm for hashing,
//       since you do not know the type for K,
//       you must use the hashCode provided by the <K key> object
//       and one of the techniques presented in lecture
//

/**
 * This class makes a HashTable to store a key, value pair
 * 
 * @author varunsudhakaran
 *
 * @param <K>
 * @param <V>
 * 
 */
public class HashTable<K extends Comparable<K>, V> implements HashTableADT<K, V> {

	// TODO: ADD and comment DATA FIELD MEMBERS needed for your implementation

	private int numKeys; // initializes numKeys
	private int cap; // initializes cap
	private double loadFactorThreshold; // initializes loadFactorThreshold
	private Node[] hTable; // initializes the array hashTable

	// TODO: comment and complete a default no-arg constructor
	/**
	 * The HashTable constructor doesn't take any arguments
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	public HashTable() {
		// sets everything to zero and null
	}

	// TODO: comment and complete a constructor that accepts
	// initial capacity and load factor threshold
	// threshold is the load factor that causes a resize and rehash
	/**
	 * The HashTable constructor makes a HashTable with given initial capacity and
	 * loadFactorThreshold.
	 * 
	 * @param initialCapacity
	 * @param loadFactorThreshold
	 * 
	 * @return: none
	 * 
	 */
	public HashTable(int initialCapacity, double loadFactorThreshold) {
		this.cap = initialCapacity; // sets capacity
		this.loadFactorThreshold = loadFactorThreshold; // sets threshold
		hTable = (Node<K, V>[]) new Node[initialCapacity]; // makes the array
		this.numKeys = 0; // sets numKeys to zero
	}

	/**
	 * This class classifies a node of key and value to being a linked list.
	 * 
	 * @author varunsudhakaran
	 *
	 * @param <K>
	 * @param <V>
	 */
	private class Node<K, V> {

		private K key; // initializes key

		private V value; // initializes value

		private Node<K, V> next; // makes a next

		public Node(K key, V value) {
			this.key = key; // sets key
			this.value = value; // sets value
			next = null; // sets next to null
		}

	}

	// TODO: add all unimplemented methods so that the class can compile

	/**
	 * The insert method inserts a node into the hash table.
	 * 
	 * @param: K key
	 * 
	 * @param: V value
	 * 
	 * @return: none
	 * 
	 * @throws: IllegalNullKeyException
	 * 
	 * @throws: DuplicateKeyException
	 * 
	 */
	@Override
	public void insert(K key, V value) throws IllegalNullKeyException, DuplicateKeyException {
		// TODO Auto-generated method stub

		if (key == null && !contains(key)) { // checks if key is null
			throw new IllegalNullKeyException(); // throws exception
		} else {
			int hashIndex = Math.abs(key.hashCode()) % cap; // makes index
			if (hTable[hashIndex] == null) { // checks if spot is empty
				hTable[hashIndex] = new Node<K, V>(key, value); // makes new node in that spot
				numKeys++; // increments numKeys
			} else {
				Node<K, V> temp = hTable[hashIndex]; // makes a temp variable
				while (temp.next != null) { // checks while the next variable in linked
					// list as to be not null
					if (!temp.key.equals(key) && temp.next != null) { // checks if the key
						// is not equal to the key inserted and the next node is not null
						temp = temp.next; // recurses through list
					} else {
						if (contains(key)) { // checks if it contains
							throw new DuplicateKeyException(); // throws an exception
						}
					}
				}
				if (!temp.key.equals(key) && temp.next == null) { // checks if
					// the temp is equal to the key and if the next node is null
					temp.next = new Node<K, V>(key, value); // sets the next node to a new node
					numKeys++; // increments numKeys
				} else {
					if (contains(key)) { // checks if it contains
						throw new DuplicateKeyException(); // throws exception
					}
				}
			}
		}
		if (getLoadFactor() >= getLoadFactorThreshold()) { // checks if load factor is greater
			// than or equal to the loadfactor threshold
			rehash(); // rehashes
		}
	}

	/**
	 * The remove method removes a node from the hash table
	 * 
	 * @param: K key
	 * 
	 * @return: boolean
	 * 
	 * @throws: IllegalNullKeyException
	 */
	@Override
	public boolean remove(K key) throws IllegalNullKeyException {
		// TODO Auto-generated method stub
		if (key == null && !contains(key)) { // checks if key is null and doesn't contain key
			throw new IllegalNullKeyException(); // throws exception
		} else {
			int hashIndex = Math.abs(key.hashCode()) % cap; // creates hashIndex
			if (hTable[hashIndex] == null) { // checks if spot is empty
				return false; // returns false
			} else {
				Node<K, V> head = hTable[hashIndex]; // makes a variable for the head of the lsist
				while (head.next != null) { // runs until head.next is null
					if (!head.next.key.equals(key) && head.next != null) {
						// checks if head's next node doesn't equal key and the next node is not null
						head = head.next; // recurses
					} else {
						head.next = head.next.next; // removes
						numKeys--; // decrements numKeys
						return true; // returns true
					}
				}
				if (!head.key.equals(key) && head.next == null) { // checks if the key equals key and
					// if the next node is null
					return false; // returns false
				} else {
					hTable[hashIndex] = head.next; // sets the spot to the next node
					numKeys--; // decrements numKeys
					return true; // returns true
				}
			}
		}
	}

	/**
	 * The get() method finds the key and returns the value of it.
	 * 
	 * @param: K key
	 * 
	 * @return: V value
	 * 
	 * @throws IllegalNullKeyException
	 * 
	 * @throws DuplicateKeyException
	 * 
	 */
	@Override
	public V get(K key) throws IllegalNullKeyException, KeyNotFoundException {
		// TODO Auto-generated method stub
		if (key == null && !contains(key)) { // checks if key is null
			throw new IllegalNullKeyException(); // throws exception
		} else {
			int hashIndex = Math.abs(key.hashCode()) % cap; // makes index
			if (hTable[hashIndex] == null && !contains(key)) { // checks if spot is empty
				// and checks if key is not contained
				throw new KeyNotFoundException(); // throws exception
			} else {
				Node<K, V> head = hTable[hashIndex]; // makes variable to spot
				while (head.next != null) { // runs while next node isn't null
					if (head.key.equals(key) && head.next != null) {
						// checks if the spot's key equals key and checks next node if it not null
						return head.value; // returns value
					} else {
						head = head.next; // recurses
					}
				}
				if (head.next == null && head.key.equals(key)) {
					// checks if next node is null
					return head.value; // returns value
				} else {
					throw new KeyNotFoundException(); // throws exception
				}
			}
		}

	}

	/**
	 * This method is used for the KeyNotFoundException and the
	 * DuplicateKeyException as a way to make it easier for me to single out the
	 * exceptions.
	 * 
	 * @param key
	 * 
	 * @return: boolean
	 * 
	 * @throws IllegalNullKeyException
	 * 
	 */
	public boolean contains(K key) throws IllegalNullKeyException {
		if (key == null) { // checks if key is null
			throw new IllegalNullKeyException(); // throws exception
		} else {
			int hashIndex = Math.abs(key.hashCode()) % cap; // makes index
			if (hTable[hashIndex] == null) { // checks if spot is empty
				return false; // throws exception
			} else {
				Node<K, V> head = hTable[hashIndex]; // makes variable to spot
				while (head.next != null) { // runs while next node isn't null
					if (head.key.equals(key) && head.next != null) {
						// checks if the spot's key equals key and checks next node if it not null
						return true; // returns value
					} else {
						head = head.next; // recurses
					}
				}
				if (head.next == null && head.key.equals(key)) {
					// checks if next node is null and the key equals key
					return true; // returns value
				} else {
					return false; // returns false
				}
			}
		}
	}

	@Override
	/**
	 * This method returns numKeys.
	 * 
	 * @param: none
	 * 
	 * @return: int numKeys
	 * 
	 */
	public int numKeys() {
		// TODO Auto-generated method stub
		return numKeys; // returns numKeys
	}

	@Override
	/**
	 * This method returns the loadFactorThreshold
	 * 
	 * @param: none
	 * 
	 * @return: double loadFactorThreshold
	 */
	public double getLoadFactorThreshold() {
		// TODO Auto-generated method stub
		return loadFactorThreshold; // returns loadFactorThreshold
	}

	@Override
	/**
	 * This method returns the load factor
	 * 
	 * @param: none
	 * 
	 * @return: double loadFactor
	 * 
	 */
	public double getLoadFactor() {
		// TODO Auto-generated method stub
		return (double) numKeys / cap; // returns load factor
	}

	@Override
	/**
	 * This method returns the capacity
	 * 
	 * @param: none
	 * 
	 * @return: int cap
	 * 
	 */
	public int getCapacity() {
		// TODO Auto-generated method stub
		return cap; // returns cap
	}

	@Override
	/**
	 * This method returns the proper resolution to the collisions that we are
	 * trying to prevent.
	 * 
	 * @param: none
	 * 
	 * @return: integer
	 * 
	 */
	public int getCollisionResolution() {
		// TODO Auto-generated method stub
		return 5; // returns an integer
	}

	/**
	 * This method resizes the array and rehashes the elements
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 * @throws IllegalNullKeyException
	 * 
	 * @throws DuplicateKeyException
	 */
	private void rehash() throws IllegalNullKeyException, DuplicateKeyException {
		numKeys = 0; // sets numKeys to zero here because numKeys
		// shouldn't be incremented because of the fact that it is inserted
		Node<K, V>[] temp = hTable; // makes a variable to refer to old table
		cap = (2 * cap) + 1; // makes a new capacity
		hTable = (Node<K, V>[]) new Node[cap]; // sets reference of old table to a new table
		for (int i = 0; i < temp.length; i++) { // runs for loop through old table
			Node<K, V> t = temp[i]; // makes a variable of node
			if (t != null) { // checks if t is not null
				while (t.next != null) { // runs while t's next node is not null
					insert(t.key, t.value); // inserts
					t = t.next; // recurses
				}
				if (t.next == null) { // checks if t's next node is null
					insert(t.key, t.value); // inserts
				} else { // checks the else

				}
			}
		}
	}

}
