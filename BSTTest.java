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
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//TODO: Add tests to test that binary search tree operations work
/**
 * This class makes sure the BST methods 
 * are implemented correctly.
 * 
 * @author varunsudhakaran
 *
 */
public class BSTTest extends DataStructureADTTest {

	BST<String, String> bst; // instance of BST
	BST<Integer, String> bst2; // instance of BST

	/**
	 * This method sets up the instances of BST
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// The setup must initialize this class's instances
		// and the super class instances.
		// Because of the inheritance between the interfaces and classes,
		// we can do this by calling createInstance() and casting to the desired type
		// and assigning that same object reference to the super-class fields.
		dataStructureInstance = bst = createInstance(); // creates instance
		dataStructureInstance2 = bst2 = createInstance2(); // creates instance
	}

	/**
	 * This method sets all the instances to null
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		dataStructureInstance = bst = null; // sets to null
		dataStructureInstance2 = bst2 = null; // sets to null
	}

	/*
	 * (non-Javadoc)
	 * This method creates an instance of BST of strings
	 * 
	 * @param: none
	 * 
	 * @return: BST<String, String>
	 * 
	 * @see DataStructureADTTest#createInstance()
	 */
	@Override
	protected BST<String, String> createInstance() {
		return new BST<String, String>();
		// returns an instance
	}

	/*
	 * (non-Javadoc)
	 * This method creates an instance of BST of Integer
	 * and String.
	 * 
	 * @param: none
	 * 
	 * @return: BST<Integer, String>
	 * 
	 * @see DataStructureADTTest#createInstance2()
	 */
	@Override
	protected BST<Integer, String> createInstance2() {
		return new BST<Integer, String>();
		// returns an instance
	}

	/**
	 * Test that empty trees still produce a valid but empty traversal list for each
	 * of the four traversal orders.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testBST_001_empty_traversal_orders() {
		try { // try-catch block

			List<String> expectedOrder = new ArrayList<String>();
			// creates new list
			// Get the actual traversal order lists for each type
			List<String> inOrder = bst.getInOrderTraversal();
			// makes list for in order
			List<String> preOrder = bst.getPreOrderTraversal();
			// makes list for preorder
			List<String> postOrder = bst.getPostOrderTraversal();
			// makes list for post order
			List<String> levelOrder = bst.getLevelOrderTraversal();
			// makes list for level order

			// UNCOMMENT IF DEBUGGING THIS TEST
			System.out.println("   EXPECTED: " + expectedOrder); // prints
			System.out.println("   In Order: " + inOrder); // prints
			System.out.println("  Pre Order: " + preOrder); // prints
			System.out.println(" Post Order: " + postOrder); // prints
			System.out.println("Level Order: " + levelOrder); // prints

			assertEquals(expectedOrder, inOrder); // checks equality
			assertEquals(expectedOrder, preOrder); // checks equality
			assertEquals(expectedOrder, postOrder); // checks equality
			assertEquals(expectedOrder, levelOrder); // checks equality

		} catch (Exception e) { // catches exception
			e.printStackTrace(); // prints stack trace
			fail("Unexpected exception 002: " + e.getMessage()); // fails
		}

	}

	/**
	 * Test that trees with one key,value pair produce a valid traversal lists for
	 * each of the four traversal orders.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testBST_002_check_traversals_after_insert_one() {

		try { // try-catch block

			List<Integer> expectedOrder = new ArrayList<Integer>();
			// creates list
			expectedOrder.add(10); // adds
			bst2.insert(10, "ten"); // inserts
			if (bst2.numKeys() != 1) // checks if numKeys works
				fail("added 10, size should be 1, but was " + bst2.numKeys()); // fails

			List<Integer> inOrder = bst2.getInOrderTraversal(); // makes inorder list
			List<Integer> preOrder = bst2.getPreOrderTraversal(); // makes preorder list
			List<Integer> postOrder = bst2.getPostOrderTraversal(); // makes post order list
			List<Integer> levelOrder = bst2.getLevelOrderTraversal(); // makes level order list

			// UNCOMMENT IF DEBUGGING THIS TEST
			System.out.println("   EXPECTED: " + expectedOrder); // prints
			System.out.println("   In Order: " + inOrder); // prints
			System.out.println("  Pre Order: " + preOrder); // prints
			System.out.println(" Post Order: " + postOrder); // prints
			System.out.println("Level Order: " + levelOrder); // prints

			assertEquals(expectedOrder, inOrder); // checks equality
			assertEquals(expectedOrder, preOrder); // checks equality
			assertEquals(expectedOrder, postOrder); // checks equality
			assertEquals(expectedOrder, levelOrder); // checks equality

		} catch (Exception e) { // catches exception
			e.printStackTrace(); // prints stack trace
			fail("Unexpected exception 003: " + e.getMessage()); // fails
		}

	}

	/**
	 * Test that the in-order traversal order is correct if the items are entered in
	 * a way that creates a balanced BST
	 * 
	 * Insert order: 20-10-30 In-Order traversal order: 10-20-30
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testBST_003_check_inOrder_for_balanced_insert_order() {
		// insert 20-10-30 BALANCED
		try { // try-catch block
			bst2.insert(20, "1st key inserted"); // inserts
			bst2.insert(10, "2nd key inserted"); // inserts
			bst2.insert(30, "3rd key inserted"); // inserts

			// expected inOrder 10 20 30
			List<Integer> expectedOrder = new ArrayList<Integer>();
			// makes list
			expectedOrder.add(10); // L adds
			expectedOrder.add(20); // V adds
			expectedOrder.add(30); // R adds

			// GET IN-ORDER and check
			List<Integer> actualOrder = bst2.getInOrderTraversal();
			// makes list of in order 
			System.out.println("expectedOrder: " + expectedOrder); // prints
			System.out.println("actualOrder: " + actualOrder); // prints
			assertEquals(expectedOrder, actualOrder); // checks equality
		} catch (Exception e) { // catches exception
			e.printStackTrace(); // prints stack trace
			fail("Unexpected exception 004: " + e.getMessage()); // fails
		}
	}

	/**
	 * Test that the pre-order traversal order is correct if the items are entered
	 * in a way that creates a balanced BST
	 * 
	 * Insert order: 20-10-30 Pre-Order traversal order: 20-10-30
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testBST_004_check_preOrder_for_balanced_insert_order() {

		// TODO implement this test
		try { // try-catch block
			bst2.insert(20, "1st"); // inserts
			bst2.insert(10, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			List<Integer> expectedOrder = new ArrayList<Integer>(); 
			// makes list for expected order
			expectedOrder.add(20); // adds
			expectedOrder.add(10); // adds
			expectedOrder.add(30); // adds

			List<Integer> actualOrder = bst2.getPreOrderTraversal();
			// makes list for preorder
			assertEquals(expectedOrder, actualOrder); // checks equality
		} catch (Exception e) { // checks exception
			fail("Exception caught: " + e.getMessage()); // fails
		}

	}

	/**
	 * Test that the post-order traversal order is correct if the items are entered
	 * in a way that creates a balanced BST
	 * 
	 * Insert order: 20-10-30 Post-Order traversal order: 10-30-20
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testBST_005_check_postOrder_for_balanced_insert_order() {

		// TODO implement this test
		try { // try-catch block
			bst2.insert(20, "1st"); // inserts
			bst2.insert(10, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			List<Integer> expectedOrder = new ArrayList<Integer>();
			// makes list 
			expectedOrder.add(10); // adds
			expectedOrder.add(30); // adds
			expectedOrder.add(20); // adds

			List<Integer> actualOrder = bst2.getPostOrderTraversal();
			// makes list for postorder
			assertEquals(expectedOrder, actualOrder); // checks equality
		} catch (Exception e) { // catches exception
			fail("Exception caught: " + e.getMessage()); // fails
		}

	}

	/**
	 * Test that the level-order traversal order is correct if the items are entered
	 * in a way that creates a balanced BST
	 * 
	 * Insert order: 20-10-30 Level-Order traversal order: 20-10-30
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testBST_006_check_levelOrder_for_balanced_insert_order() {

		// TODO implement this test
		try { // try-catch block
			bst2.insert(20, "1st"); // inserts
			bst2.insert(10, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			List<Integer> expectedOrder = new ArrayList<Integer>();
			// makes list
			expectedOrder.add(20); // adds
			expectedOrder.add(10); // adds
			expectedOrder.add(30); // adds

			List<Integer> actualOrder = bst2.getLevelOrderTraversal();
			// makes list for level order
			assertEquals(expectedOrder, actualOrder); // checks equality
		} catch (Exception e) { // catches exception
			fail("Exception caught: " + e.getMessage()); // fails
		}

	}

	/**
	 * Test that the in-order traversal order is correct if the items are entered in
	 * a way that creates an un-balanced BST
	 * 
	 * Insert order: 10-20-30 In-Order traversal order: 10-20-30
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testBST_007_check_inOrder_for_not_balanced_insert_order() {

		// TODO implement this test
		try { // try-catch block
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			List<Integer> expectedOrder = new ArrayList<Integer>();
			// makes list
			expectedOrder.add(10); // adds
			expectedOrder.add(20); // adds
			expectedOrder.add(30); // adds

			List<Integer> actualOrder = bst2.getInOrderTraversal();
			// makes list for in order
			assertEquals(expectedOrder, actualOrder); // checks equality
		} catch (Exception e) { // catches exception
			fail("Exception caught: " + e.getMessage()); // fails
		}

	}

	/**
	 * Test that the pre-order traversal order is correct if the items are entered
	 * in a way that creates an un-balanced BST
	 * 
	 * Insert order: 10-20-30 Pre-Order traversal order: 10-20-30
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testBST_008_check_preOrder_for_not_balanced_insert_order() {

		// TODO implement this test
		try { // try-catch block
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			List<Integer> expectedOrder = new ArrayList<Integer>();
			// makes list
			expectedOrder.add(10); // adds
			expectedOrder.add(20); // adds
			expectedOrder.add(30); // adds

			List<Integer> actualOrder = bst2.getPreOrderTraversal();
			// makes list of preorder
			System.out.println(expectedOrder); // prints
			System.out.println(actualOrder); // prints
			assertEquals(expectedOrder, actualOrder); // checks equality
		} catch (Exception e) { // catches exception
			fail("Exception caught: " + e.getMessage()); // fails
		}

	}

	/**
	 * Test that the post-order traversal order is correct if the items are entered
	 * in a way that creates an un-balanced BST
	 * 
	 * Insert order: 10-20-30 Post-Order traversal order: 30-20-10
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testBST_009_check_postOrder_for_not_balanced_insert_order() {

		// TODO implement this test
		try { // try-catch block
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			List<Integer> expectedOrder = new ArrayList<Integer>();
			// makes list
			expectedOrder.add(30); // adds
			expectedOrder.add(20); // adds
			expectedOrder.add(10);  // adds

			List<Integer> actualOrder = bst2.getPostOrderTraversal();
			// makes list for post order
			assertEquals(expectedOrder, actualOrder); // checks equality
		} catch (Exception e) { // catches exception
			fail("Exception caught: " + e.getMessage()); // fails
		}

	}

	/**
	 * Test that the level-order traversal order is correct if the items are entered
	 * in a way that creates an un-balanced BST
	 * 
	 * Insert order: 10-20-30 Level-Order traversal order: 10-20-30 (FIXED ON
	 * 2/14/18)
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */

	@Test

	void testBST_010_check_levelOrder_for_not_balanced_insert_order() {

		// TODO implement this test

		try { // try-catch block

			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts

			List<Integer> expectedOrder = new ArrayList<Integer>();
			// makes list
			expectedOrder.add(10); // adds
			expectedOrder.add(20); // adds
			expectedOrder.add(30); // adds
			List<Integer> actualOrder = bst2.getLevelOrderTraversal();
			// makes list for level order
			assertEquals(expectedOrder, actualOrder); // checks equality

		}

		catch (Exception e) { // catches exception
			fail("Exception caught: " + e.getMessage()); // fails
		}
	}

	// TODO: Add your own tests

	// Add tests to make sure that get and remove work as expected.
	// Does the height of the tree reflect it's actual and its expected height?
	// Use the traversal orders to check.

	// Can you insert many and still "get" them back out?

	// Does delete work?
	// When the key is a leaf? node with one left child?
	// node with one right child? node with two children?

	// Write replacement value did you choose?
	// in-order precessor? in-order successor?
	// How can you test if it is replaced correctly?

	@Test
	/**
	 * The method checks right child for no exceptions.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_011_check_get_key_of_right_child_for_no_exceptions() {
		try { // try-catch block
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			bst2.insert(50, "5th"); // inserts
			bst2.insert(60, "6th"); // inserts
			if (bst2.getKeyOfRightChildOf(10).equals(20)) {
				// checks key
			}
		} catch (Exception e) { // catches exception
			fail("Key should've existed"); // fails
		}
	}

	@Test
	/**
	 * This method cehcks left child for existence.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_012_check_get_key_of_left_child_if_doesnt_exists() {
		try { // try-catch exception
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			bst2.insert(50, "5th"); // inserts
			bst2.insert(60, "6th"); // inserts
			if (bst2.getKeyOfLeftChildOf(10).equals(20)) { // checks key
				fail("Key shouldn't have existed"); // fails
			}
		} catch (Exception e) { // catches exception
		}
	}

	@Test
	/**
	 * This method checks right child key for existence.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_013_check_get_key_of_right_child_if_doesnt_exists() {
		try { // try-catch exception
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			bst2.insert(50, "5th"); // inserts
			bst2.insert(60, "6th"); // inserts
			if (bst2.getKeyOfRightChildOf(50).equals(20)) { // checks key
				fail("Key shouldn't have existed"); // fails
			}
		} catch (Exception e) { // catches exception
		}
	}

	@Test
	/**
	 * This method checks for left child for no excpetions.
	 */
	void testBST_014_check_get_key_of_left_child_for_no_exceptions() {
		try { // try-catch block
			bst2.insert(30, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(10, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			bst2.insert(50, "5th"); // inserts
			bst2.insert(60, "6th"); // inserts
			if (bst2.getKeyOfLeftChildOf(30).equals(10)) {
				// checks key
			}
		} catch (Exception e) { // catches exception
			fail("Key should've have existed"); // fails
		}
	}

	@Test
	/**
	 * This method checks the get method.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_015_get_right_value() {
		try {
			bst2.insert(30, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(10, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			bst2.insert(50, "5th"); // inserts
			bst2.insert(60, "6th"); // inserts
			if (bst2.get(40).equals("4th")) {
				// checks value
			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}

	}

	@Test
	 /**
	  * This method check for get method as an exception.
	  * 
	  * @param: none
	  * 
	  * @return: none
	  * 
	  */
	void testBST_016_get_exception_no_value() {
		try { // try-catch exception
			bst2.insert(30, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(10, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			bst2.insert(50, "5th"); // inserts
			bst2.insert(60, "6th"); // inserts
			if (bst2.get(70).equals("4th")) { // checks key
				fail("test should've have thrown an exception"); // fails
			}
		} catch (Exception e) { // catches exception

		}
	}

	@Test
	/**
	 * This method checks the contains method for false
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_017_checks_key_is_not_contained() {
		try { // try-catch block
			bst2.insert(30, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(10, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			bst2.insert(50, "5th"); // inserts
			bst2.insert(60, "6th"); // inserts
			if (bst2.contains(0)) { // checks contains
				fail("test should've have thrown an exception"); // fails
			}
		} catch (Exception e) { // catches exception
		}
	}

	@Test
	/**
	 * This method checks the contains method for true
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_018_checks_key_is_contained() {
		try { // try-catch block
			bst2.insert(30, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(10, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			bst2.insert(50, "5th"); // inserts
			bst2.insert(60, "6th"); // inserts
			if (bst2.contains(20)) { // checks contains 
			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}

	@Test
	/**
	 * This method checks numKeys
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_019_checks_num_keys() {
		try { // try-catch block
			bst2.insert(30, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(10, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			if (bst2.numKeys() == 4) { // checks numKeys

			} else {
				fail("test should've given a number of keys of 4"); // fails
			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}
	
	@Test
	/**
	 * This method checks the key at the root
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_20_checks_the_key_at_root() {
		try { // try-catch block
			bst2.insert(30, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(10, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			if (bst2.getKeyAtRoot().equals(40)) { // checks key
				fail("test should've had a key as 30 at root"); // fails
			} 
			else {
			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}
	
	@Test
	/**
	 * This method checks the height of tree.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 */
	void testBST_21_checks_the_height_of_tree() {
		try { // try-catch block
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			if (bst2.getHeight() == 4) { // checks the height
			} 
			else {			 	
				fail("test should've been 4"); // fails
			}
			
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}
	
	@Test
	/**
	 * This method checks the remove method it it
	 * does not exist
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_22_checks_the_remove_if_it_doesnt_exist() {
		try { // try-catch block
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			if(bst2.remove(50)) { // removes
				fail("test shouldn't be true"); // fails
			}
			else {
				fail("test should not be false"); // fails
			}
			
		} catch (Exception e) { // catches exception
		}
	}
	
	@Test
	/**
	 * This method checks the remove method if it
	 * does exist.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_23_checks_the_remove_if_it_does_exist() {
		try { // try-catch block
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			if(bst2.remove(40)) { // removes
			}
			else {
				fail("test should not be false"); // fails
			}
			
		} catch (Exception e) { // catches exception
			fail("test shouldn't throw an exception"); // fails
		}
	}
	
} 