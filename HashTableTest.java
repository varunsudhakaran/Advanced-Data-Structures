
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
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////'
// TODO: add imports as needed

import static org.junit.jupiter.api.Assertions.*; // org.junit.Assert.*; 
import org.junit.jupiter.api.Assertions;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

/** TODO: add class header comments here */
/**
 * THis class tests the hash table methods for accuracy and debugging.
 * 
 * @author varunsudhakaran
 *
 */
public class HashTableTest {

	// TODO: add other fields that will be used by multiple tests

	// TODO: add code that runs before each test method
	/**
	 * This method sets up before test.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	// TODO: add code that runs after each test method
	/**
	 * This method tears down after test.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Tests that a HashTable returns an integer code indicating which collision
	 * resolution strategy is used. REFER TO HashTableADT for valid collision scheme
	 * codes.
	 */

	/**
	 * This test method checks for the collision scheme
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	public void test000_collision_scheme() {
		HashTableADT htIntegerKey = new HashTable<Integer, String>(); // makes an adt type
		int scheme = htIntegerKey.getCollisionResolution(); // checks the collision resolution
		if (scheme < 1 || scheme > 9) // checks the scheme to be less than 1 or greater than 9
			fail("collision resolution must be indicated with 1-9"); // fails
	}

	/**
	 * IMPLEMENTED AS EXAMPLE FOR YOU Tests that insert(null,null) throws
	 * IllegalNullKeyException
	 */
	/**
	 * This test method checks for illegal null key
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	public void test001_IllegalNullKey() {
		try { // try-catch block
			HashTableADT htIntegerKey = new HashTable<Integer, String>(); // makes an adt
			htIntegerKey.insert(null, null); // inserts null
			fail("should not be able to insert null key"); // fails
		} catch (IllegalNullKeyException e) {
			// catches exception
			/* expected */ } catch (Exception e) { // catches exception
			fail("insert null key should not throw exception " + e.getClass().getName()); // fails
		}
	}

	// TODO add your own tests of your implementation

	/**
	 * This test method checks the insert method
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 * @throws: KeyNotFoundException
	 * 
	 */
	@Test
	public void test002_insert() throws KeyNotFoundException {
		try {
			HashTable key = new HashTable<Integer, String>(10, 20); // makes hash table
			key.insert(12, "key1"); // inserts
			if (key.get(12).equals("key1")) { // checks if get equals the value

			} else {
				fail("numKeys has to equal key1"); // fails
			}
		} catch (DuplicateKeyException e) { // catches exception
			fail("shouldn't throw an exception"); // fails
		} catch (IllegalNullKeyException e) { // catches exception
			fail("shouldn't throw an exception"); // fails
		}
	}

	/**
	 * This test method checks the remove method
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	public void test003_remove() {
		try { // try-catch block
			HashTable key = new HashTable<Integer, String>(10, 20); // makes hash table
			key.insert(12, "key1"); // inserts
			key.insert(13, "key2"); // inserts
			key.insert(14, "key3"); // inserts
			key.insert(15, "key4"); // inserts
			key.insert(16, "key5"); // inserts
			key.remove(14); // removes
			key.get(14); // gets
			fail("numKeys has to equal 4"); // fails
		} catch (DuplicateKeyException e) { // catches exception
			fail("shouldn't throw an exception"); // fails
		} catch (IllegalNullKeyException e) { // catches exception
			fail("shouldn't throw an exception"); // fails
		} catch (KeyNotFoundException e) { // catches
			// correct
		}
	}

	/**
	 * This test method checks the get method.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	public void test004_get() {
		try { // try-catch block
			HashTable key = new HashTable<Integer, String>(10, 20); // makes a hash table
			key.insert(12, "key1"); // inserts
			key.insert(13, "key2"); // inserts
			key.insert(14, "key3"); // inserts
			key.insert(15, "key4"); // inserts
			key.insert(16, "key5"); // inserts
			if (key.get(16).equals("key5")) { // checks if the get equals the value

			} else {
				fail("should equal key5!"); // fails
			}
		} catch (Exception e) { // catches exception
			fail("shouldn't throw an exception"); // fails
		}
	}

	/**
	 * This test method checks the contains method.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	public void test005_contains() {
		try { // try-catch block
			HashTable key = new HashTable<Integer, String>(10, 20); // makes a hash table
			key.insert(12, "key1"); // inserts
			key.insert(13, "key2"); // inserts
			key.insert(14, "key3"); // inserts
			key.insert(15, "key4"); // inserts
			key.insert(16, "key5"); // inserts
			if (key.contains(14)) { // checks if the contains returns true
			} else {
				fail("should contain 14!"); // fails
			}
		} catch (Exception e) { // catches exception
			fail("shouldn't throw an exception"); // fails
		}
	}

}
