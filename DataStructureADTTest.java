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
// Due Date: 2/7/19
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The DataStructureADTTest class was given with our instance
 * of our implemented of the data structure. I implemented the class
 * to test my data structure for errors.
 * 
 * @author varunsudhakaran
 *
 * @param <T> that contains Strings to pass in
 * 
 */
abstract class DataStructureADTTest<T extends 
DataStructureADT<String, String>> {

	private T dataStructureInstance; // instance of dataStructure	

	protected abstract T createInstance(); // makes a new instance

	@BeforeAll
	/**
	 * The setUpBeforeClass() method is a static method
	 * that sets up the data structure.
	 * 
	 * @throws Exception
	 * 
	 * @param: none 
	 * 
	 * @return: none
	 * 
	 */
	static void setUpBeforeClass() {
	}

	@AfterAll
	/**
	 * The tearDownAfterClass() is a static method
	 * that tears down the data structure.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	static void tearDownAfterClass() {
	}

	@BeforeEach
	/**
	 * The setup() method creates
	 * a new instance for the data structure.
	 * 
	 * @throws Exception
	 * 
	 * @param: none 
	 * 
	 * @return: none
	 * 
	 */
	void setUp() throws Exception {
		dataStructureInstance = createInstance();
		// creates new instance
	}

	@AfterEach
	/**
	 * The tearDown() method deletes
	 * the instance for the data structure.
	 * 
	 * @throws Exception
	 * 
	 * @param: none 
	 * 
	 * @return: none
	 * 
	 */
	void tearDown() {
		dataStructureInstance = null;
		// sets the instance to null
	}

	@Test
	/**
	 * This test method checks if the
	 * size is zero.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test00_empty_ds_size() {
		if (dataStructureInstance.size() != 0)
			// checks if size is not zero
			fail("data structure should be empty, with size=0, but size="			
		+ dataStructureInstance.size()); // fails
	}

	// TODO: implement tests 01 - 04

	@Test
	/**
	 * This test method checks the insert method
	 * and the size method to see if the size is incremented.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test01_after_insert_one_size_is_one() {
		dataStructureInstance.insert("Key1", "Test1"); // inserts
		if (dataStructureInstance.size() == 1) { // checks if size is 1
		} else {
			fail("size should be 1, but the size is " 
		+ dataStructureInstance.size()); // fails
		}
	}

	@Test
	/**
	 * This test method checks the insert, remove, and size method
	 * as well as seeing if the size is correctly incremented and 
	 * decremented.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test02_after_insert_one_remove_one_size_is_0() {
		dataStructureInstance.insert("Key2", "Test2"); // inserts
		dataStructureInstance.remove("Key2"); // removes
		if (dataStructureInstance.size() == 0) { // checks if size is zero
		} else {
			fail("size should be 0, but the size is " 
		+ dataStructureInstance.size()); // fails
		}
	}

	@Test
	/**
	 * This test method inserts a duplicate key
	 * and the test checks if an exception is thrown.
	 * 
	 * @throws Exception
	 * 
	 * @param: none 
	 * 
	 * @return: none
	 * 
	 */
	void test03_duplicate_exception_is_thrown() {
		try { // try-catch block
			dataStructureInstance.insert("Key3", "Test3"); // inserts
			dataStructureInstance.insert("Key4", "Test4"); // inserts
			dataStructureInstance.insert("Key5", "Test5"); // inserts
			dataStructureInstance.insert("Key3", "Test6"); // inserts
			fail("test should've thrown Runtime Exception!"); 
			// throws exception
		} catch (RuntimeException e) { // catches exception
		} finally {
		}
	}

	@Test
	/**
	 * This test method tests for a remove 
	 * of a key that is not in the data structure.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test04_remove_returns_false_when_key_not_present() {
		dataStructureInstance.insert("Key6", "Test7"); // inserts
		dataStructureInstance.insert("Key7", "Test8"); // inserts
		dataStructureInstance.insert("Key8", "Test9"); // inserts
		if (dataStructureInstance.remove("Key9")) { 
			// checks if you can remove
			fail("Key not found"); // fails
		} else {
		}
	}

	// TODO: add tests to ensure that you can detect implementation that fail

	// Tip: consider different numbers of inserts and removes and 
	//how different combinations of insert and removes

	@Test
	/**
	 * This test method checks if the contains
	 * returns true for the key that is inserted.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test05_contains() {
		dataStructureInstance.insert("Key9", "Test10"); // inserts
		dataStructureInstance.insert("Key10", "Test11"); // inserts
		if (dataStructureInstance.contains("Key9")) { 
			// checks if key is contained
		} else {
			fail("test should've contained Key9"); // fails
		}

	}

	@Test
	/**
	 * This test method checks if the insert
	 * method throws an exception if a null
	 * key is inserted after a couple of inserts
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test06_insert_nullK() {
		try { // try-catch block
			dataStructureInstance.insert("Key30", "Test30"); //inserts
			dataStructureInstance.insert("Key31", "Test31"); // inserts
			dataStructureInstance.insert("Key32", "Test32"); // inserts
			dataStructureInstance.insert(null, "Test12"); // inserts
			fail("test should've threw IllegalArgumentException!"); // fails
		} catch (IllegalArgumentException e) { // catches Exception
		} finally {
		}
	}

	@Test
	/**
	 * This test method checks if the insert method
	 * doesn't throw an exception if a null value
	 * is inserted.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test07_insert_nullV() {
		try { // try-catch block
			dataStructureInstance.insert("Test13", null); // inserts
		} catch (IllegalArgumentException e) { // catches Exception
			fail("test shouldn't have threw IllegalArgumentException"); 
			// fails
		}
	}

	@Test
	/**
	 * This test method checks if the get method
	 * returns the right value.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test08_get() {
		dataStructureInstance.insert("Key12", "Test14"); // inserts
		dataStructureInstance.insert("Key13", "Test15"); // inserts
		dataStructureInstance.insert("Key14", "Test16"); // inserts
		if (dataStructureInstance.get("Key13").equals("Test15")) { 
			// checks if the get method returns the right value
		} else {
			fail("test should've retrieved Test13"); // fails
		}
	}

	@Test
	/**
	 * This test method checks if the insert
	 * method throws an exception if a null
	 * key is inserted without any inserts yet.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test09_get_null() {
		try { // try-catch block
			dataStructureInstance.insert(null, "Test17"); // inserts
			fail("test should've threw an IllegalArgumentException"); 
			// fails
		} catch (IllegalArgumentException e) { // catches Exception

		} finally {

		}
	}

	@Test
	/**
	 * This test method checks if the data 
	 * structure can hold 500 data items.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test10_size_cap() {
		for (int i = 0; i < 500; i++) { // runs for 500 times
			dataStructureInstance.insert("" + i, "" + i); // inserts
		}
		if (dataStructureInstance.size() == 500) { //checks if size is 500
		} else {
			fail("data structure should hold 500 items"); // fails
		}
	}

	@Test
	/**
	 * This test method checks if the remove method will
	 * throw an exception if we remove a null key value.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test11_remove_null() {
		try { // try-catch block
			dataStructureInstance.remove(null); // removes
			fail("test should've threw an IllegalArgument Exception"); 
			// fails
		} catch (IllegalArgumentException e) { // catches Exception
		} finally {
		}
	}
	
	@Test
	/**
	 * This test method checks if the get method
	 * throws an Exception if a null key is inputted
	 * in the get method.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test12_get_null() {
		try { // try-catch block
			dataStructureInstance.get(null); // gets
			fail("test should've threw an IllegalArgument Exception"); 
			// fails
		} catch (IllegalArgumentException e) { // catches Exception

		} finally {
		}
	}

	@Test
	/**
	 * This test method checks if the contains 
	 * method is false if we use the contains method
	 * for a key that doesn't exist.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test13_contains_returns_false() {
		dataStructureInstance.insert("Key18", "Test18"); // inserts
		dataStructureInstance.insert("Key19", "Test19"); // inserts
		dataStructureInstance.insert("Key20", "Test20"); // inserts
		if (!dataStructureInstance.contains("Key21")) { 
			// checks if key is contained

		} else {
			fail("test shouldn't contain Key21"); // fails
		}
	}

	@Test
	/**
	 * This test method checks if the contains method
	 * returns true after a combination of inserts and
	 * removes. 
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test14_check_contains_returns_true() {
		dataStructureInstance.insert("Key21", "Test21"); // inserts
		dataStructureInstance.insert("Key22", "Test22"); // inserts
		dataStructureInstance.insert("Key23", "Test23"); // inserts
		dataStructureInstance.remove("Key22"); // removes
		dataStructureInstance.insert("Key22", "Test22"); // inserts
		if (dataStructureInstance.contains("Key22")) { 
			// checks if key is contained

		} else {
			fail("test should've contained Key22"); // fails
		}
	}
	
	@Test
	/**
	 * This test method checks if the get method used on
	 * a key that doesn't exist will return null.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test15_checks_get_null() {
		dataStructureInstance.insert("Key24", "Test24"); // inserts
		dataStructureInstance.insert("Key25", "Test25"); // inserts
		dataStructureInstance.insert("Key26", "Test26"); // inserts
		dataStructureInstance.remove("Key25"); // removes
		if (dataStructureInstance.get("Key25") == null) { 
			// checks if get method returns null
		} else {
			fail("test should've returned null"); // fails
		}

	}
	
	@Test
	/**
	 * This test method does a combination of inserts
	 * and removes and check the size method and the contains 
	 * method to see if they are matched.
	 * 
	 * @throws Exception
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void test16_checks_size_and_contains() {
		dataStructureInstance.insert("Key27", "Test27"); // inserts
		dataStructureInstance.insert("Key28", "Test28"); // inserts
		dataStructureInstance.insert("Key29", "Test29"); // inserts
		dataStructureInstance.remove("Key28"); // removes
		dataStructureInstance.remove("Key29"); // removes
		if(dataStructureInstance.size() == 1 
				&& dataStructureInstance.contains("Key27")) {
			// checks if the size is correct as well as
			// if the key is contained
		}
		else {
			fail("test should've had size 1 and contained Key27"); // fails
		}
	}

}
