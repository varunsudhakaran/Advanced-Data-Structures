
////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title: p1_ADT
//Files: DS_My.java, DataStructureADTTest.java,         
//Course: CS 400, Semester 1, and Freshman
//
//Author: Varun Sudhakaran
//Email: vsudhakaran@wisc.edu
//Lecturer: Professor Debra Deppeler
//Lecturer Number: 002
//Due Date: 2/7/19
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class DS_My implements the ADT of LinkedList and can store data of an
 * intended of 500 objects.
 * 
 * @author varunsudhakaran
 *
 */
public class DS_My implements DataStructureADT {
	private KVal head; // first linked node
	private int size; // stores number of keys

	// Private Fields of the class
	// TODO create field(s) here to store data pairs

	/**
	 * The constructor DS_My() initializes the fields 
	 * of head node and the size.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 */
	public DS_My() {
		// TODO Auto-generated method stub
		this.head = null; // sets head to null
		this.size = 0; // sets size to zero
	}

	// TODO may wish to define an inner class
	// for storing key and value as a pair
	// such a class and its members should be "private"

	/**
	 * The class KVal stores the two objects of key 
	 * and value into a node of types K and V.
	 * 
	 * @author varunsudhakaran
	 *
	 * @param <K> this is the type compared as key
	 * @param <V> this is the type compared as value
	 * 
	 * @return: none
	 * 
	 */
	private class KVal<K extends Comparable<K>, V> {
		private K key; // type k as key
		private KVal<K, V> next; // node KVal as next
		private final V value; // type v as value

		/**
		 * The constructor KVal() initializes the fields 
		 * of key and value.
		 * 
		 * @param key   object as k
		 * @param value object as v
		 * 
		 * @return: none
		 * 
		 */
		public KVal(K key, V value) {
			this.key = key; // sets key
			this.value = value; // sets value
			next = null; // sets next to null
		}

		/**
		 * The setter method of setNext() changes 
		 * the initial next to new next.
		 * 
		 * @param next as a node of k and v
		 * 
		 * @return: none
		 * 
		 */
		public void setNext(KVal<K, V> next) {
			this.next = next; // sets next to new next
		}

		/**
		 * The getter method of getNext() returns the next node.
		 * 
		 * @param: none
		 * 
		 * @return: KVal<K, V> node
		 */
		public KVal<K, V> getNext() {
			return this.next; // returns next
		}

		/**
		 * The getter method of getKey() returns the key.
		 * 
		 * @param: none
		 * 
		 * @return: K key
		 * 
		 */
		public K getKey() {
			return this.key; // returns key
		}

		/**
		 * The getter method of getValue() returns the value.
		 * 
		 * @param: none
		 * 
		 * @return: V value
		 * 
		 */
		public V getValue() {
			return this.value; // returns value
		}

	}

	@Override
	/**
	 * The insert method I have implemented will
	 *  add a new node to the front of the linked list 
	 *  by using the head node.
	 * 
	 * @param: K key
	 * @param: V value
	 * 
	 * @return: none
	 * 
	 */
	public void insert(Comparable k, Object v) {
		// TODO Auto-generated method stub
		// Base Case
		if (k == null) { // checks if key is null
			throw new IllegalArgumentException("null key");
			// throws IllegalArgumentException
		}
		// Base Case
		if (contains(k)) { // checks if linked list contains k
			// used contains so I don't have to loop through again
			throw new RuntimeException("duplicate key");
			// throws RuntimeException
		}
		// Base Case
		if (head == null) { // checks if head node is null
			head = new KVal(k, v); // initializes head as a node
			size++; // increments node
			// Algorithm: I chose to insert the node by the head
			// or the beginning of the list since it enhances
			// efficiency by not going through the whole list
			// Recursive Case
		} else {
			KVal temp = head; // sets the temp as old head
			head = new KVal(k, v); // sets new head as the new node
			head.setNext(temp); // sets the next of new head to old head
			size++; // increments size
		}
	}

	@Override
	/**
	 * The remove method I have implemented will use 
	 * two variables that will be useful to point 
	 * the previous node to the new next node.
	 * 
	 * @param: k key
	 * 
	 * @return: boolean depending if removed or not
	 * 
	 */
	public boolean remove(Comparable k) {
		// TODO Auto-generated method stuff
		// Base Case
		if (k == null) { // checks if key is null
			throw new IllegalArgumentException("null key");
			// throws IllegalArgumentException
		}
		// Base Case
		if (head == null) { // checks if head is null
			return false; // returns false
		}
		// Base Case
		if (head.getKey().equals(k)) { // checks if key is found at head
			head = head.getNext(); // sets the head to the next node
			size--; // decrements size
			return true; // returns true
			// Algorithm: I chose to implement 
			// two variables as a previous and temp
			// so in the end when I find the appropriate
			// key I can set the prev pointer to the deleted
			// node's next node.
			// Recursive Case
		} else {
			KVal temp = head; // sets temp as head
			KVal prev = null; // sets prev as null
			while (temp.getNext() != null) {
				// runs through until temp's next is not null
				if (temp.getKey().equals(k)) { // checks if key is found					
					prev.setNext(temp.getNext()); 
					// sets prev next to temp's next node
					size--; // decrements size					
					return true; // returns true
				} else {
					prev = temp; // sets prev to temp					
					temp = temp.getNext(); // sets prev to next
				}
			}
			if (temp.getKey().equals(k)) { // checks if key is found
				prev.setNext(temp.getNext()); 
				// sets prev nest to temp's new node
				size--; // decrements size
				return true; // returns true
			} else {
				return false; // returns false
			}
		}
	}

	@Override
	/**
	 * The method get() is a getter for the value 
	 * given for the appropriate key. I simply used
	 * a base-recursive method to extract the data.
	 * 
	 * @param: k key
	 * 
	 * @return: V value
	 * 
	 */
	public Object get(Comparable k) {
		// TODO Auto-generated method stub
		// Base Case
		if (k == null) { // checks if key is null
			throw new IllegalArgumentException("null key");
			// throws IllegalArgumentException
		}
		// Base Case
		if (head == null) { // checks if head is null
			return null; // returns null
			// Algorithm: I chose the recursion
			// because then it'll be easier to
			// extract the data and has a clear
			// organization to code.
			// Recursive Case
		} else {
			KVal temp = head; // sets temp to head
			while (temp.getNext() != null) {
				// runs through until temp's next is not null
				if (temp.getKey().equals(k)) {
					return temp.getValue(); // return value
				} else {
					temp = temp.getNext(); // sets temp to next
				}
			}
			if (temp.getKey().equals(k)) { // checks if key is found
				return temp.getValue(); // returns value				
			} else {
				return null; // returns null
			}
		}
	}

	@Override
	/**
	 * The method contains() is a way to
	 * check if the key is in the linked list.
	 * I have used a base-recursive method here
	 * to check for the keys.
	 * 
	 * @param: k key
	 * 
	 * @return: boolean depending if key is there or not
	 *  
	 */
	public boolean contains(Comparable k) {
		// TODO Auto-generated method stub
		// Base case
		if (head == null) { // checks if head is null
			return false; // returns false
			// Algorithm: I chose recursion as a 
			// way to loop through the linked list
			// and a clear, organized way to 
			// find the key
			// Recursive Case
		} else {
			KVal temp = head; // sets temp to head
			while (temp.getNext() != null) {
				// runs until temp's next is not null
				if (temp.getKey().equals(k)) { // checks if key is found
					return true; // returns true					
				} else {
					temp = temp.getNext(); // sets temp to next
				}
			}
			if (temp.getKey().equals(k)) { // checks if key is found
				return true; // returns true
			} else {
				return false; // returns false
			}
		}
	}

	@Override
	/**
	 * The method size() returns the size.
	 * 
	 * @param: none
	 * 
	 * @return: int size
	 * 
	 */
	public int size() {
		// TODO Auto-generated method stub
		return size; // returns size
	}

}
