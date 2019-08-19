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


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Assert;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
// TODO: Add tests to test the rebalancing of the AVL tree operations
//@SuppressWarnings("rawtypes")
/**
 * This test class makes sure the AVL class is implemented correctly.
 * 
 * @author varunsudhakaran
 * 
 * 
 *
 */
public class AVLTest extends BSTTest {
	AVL<String, String> avl; // makes two instances of avl
	AVL<Integer, String> avl2; // makes two instances of avl

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	/**
	 * This method sets up the instances of BST and AVL.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void setUp() throws Exception {
		dataStructureInstance = bst = avl = createInstance();
		// creates an instance of avl
		dataStructureInstance2 = bst2 = avl2 = createInstance2();
		// creates an instance of avl
	}

	/**
	 * This method sets the instances to null.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		avl = null; // sets to null
		avl2 = null; // sets to null
	}

	/*
	 * (non-Javadoc)
	 * This method returns an instance of avl.
	 * 
	 * @param: none
	 * 
	 * @return: AVL<String, String>
	 * 
	 * @see DataStructureADTTest#createInstance()
	 */
	@Override
	protected AVL<String, String> createInstance() {
		return new AVL<String, String>();
		// returns new instance
	}

	/*
	 * (non-Javadoc)
	 * This method creates another instance of avl.
	 * 
	 * @param: non
	 * 
	 * @return: AVL<Integer, String>
	 * 
	 * @see DataStructureADTTest#createInstance2()
	 */
	@Override
	protected AVL<Integer, String> createInstance2() {
		return new AVL<Integer, String>();
		// returns new instance
	}

	/**
	 * Insert three values in sorted order and then check the root, left, and right
	 * keys to see if rebalancing occurred.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testAVL_001_insert_sorted_order_simple() {
		try { // try-catch block
			avl2.insert(10, "10"); // inserts
			if (!avl2.getKeyAtRoot().equals(10)) // checks key
				fail("avl insert at root does not work"); // fails

			avl2.insert(20, "20"); // inserts
			if (!avl2.getKeyOfRightChildOf(10).equals(20)) // checks key
				fail("avl insert to right child of root does not work"); // fails

			avl2.insert(30, "30"); // inserts
			Integer k = avl2.getKeyAtRoot(); // sets an integer to key
			if (!k.equals(20)) // checks if key is not equal
				fail("avl rotate does not work"); // fails

			// IF rebalancing is working,
			// the tree should have 20 at the root
			// and 10 as its left child and 30 as its right child
			Assert.assertEquals(avl2.getKeyAtRoot(), new Integer(20)); // checks equality
			Assert.assertEquals(avl2.getKeyOfLeftChildOf(20), new Integer(10)); // checks equality
			Assert.assertEquals(avl2.getKeyOfRightChildOf(20), new Integer(30)); // checks equality

		} catch (Exception e) { // catches exception
			e.printStackTrace(); // prints
			fail("Unexpected exception AVL 000: " + e.getMessage()); // fails
		}
	}

	/**
	 * Insert three values in reverse sorted order and then check the root, left,
	 * and right keys to see if rebalancing occurred in the other direction.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testAVL_002_insert_reversed_sorted_order_simple() {

		// TODO: implement this test
		try { // try-catch block
			avl2.insert(1, "one"); // inserts
			avl2.insert(2, "two"); // inserts
			avl2.insert(3, "three"); // inserts
			if (avl2.getKeyAtRoot() == 2 && avl2.getKeyOfLeftChildOf(2) == 1 && avl2.getKeyOfRightChildOf(2) == 3) {
				// checks keys
			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}

	}

	/**
	 * Insert three values so that a right-left rotation is needed to fix the
	 * balance.
	 * 
	 * Example: 10-30-20
	 * 
	 * Then check the root, left, and right keys to see if rebalancing occurred in
	 * the other direction.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testAVL_003_insert_smallest_largest_middle_order_simple() {

		// TODO: implement this test
		try { // try-catch block
			avl2.insert(10, "ten"); // inserts
			avl2.insert(30, "thirty"); // inserts
			avl2.insert(20, "twenty"); // inserts
			if (avl2.getKeyAtRoot() == 2 && avl2.getKeyOfLeftChildOf(2) == 1 && avl2.getKeyOfRightChildOf(2) == 3) {
				// checks keys
			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}

	/**
	 * Insert three values so that a left-right rotation is needed to fix the
	 * balance.
	 * 
	 * Example: 30-10-20
	 * 
	 * Then check the root, left, and right keys to see if rebalancing occurred in
	 * the other direction.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testAVL_004_insert_largest_smallest_middle_order_simple() {

		// TODO: implement this test
		try { // try-catch block
			avl2.insert(30, "thirty"); // inserts
			avl2.insert(10, "twenty"); // inserts
			avl2.insert(20, "twenty"); // inserts
			if (avl2.getKeyAtRoot() == 2 && avl2.getKeyOfLeftChildOf(2) == 1 && avl2.getKeyOfRightChildOf(2) == 3) {
				// checks keys
			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}

	// TODO: Add your own tests

	// Add tests to make sure that rebalancing occurs even if the
	// tree is larger. Does it maintain it's balance?
	// Does the height of the tree reflect it's actual height
	// Use the traversal orders to check.

	// Can you insert many and still "get" them back out?

	// Does delete work? Does the tree maintain balance when a key is deleted?
	
	
	/**
	 * This method checks if the remove method works.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	@Test
	void testAVL_005_remove_() {
		try {
			avl2.insert(30, "thirty"); // inserts
			avl2.insert(10, "ten"); // inserts
			avl2.insert(20, "twenty"); // inserts
			avl2.insert(40, "forty"); // inserts
			avl2.insert(50, "fifty"); // inserts
			avl2.insert(60, "sixty"); // inserts
			avl2.insert(70, "seventy"); // inserts
			avl2.insert(5, "five"); // inserts
			avl2.remove(5); // removes
			if (!avl2.contains(5)) { // checks if five is contained

			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}

	@Test
	/**
	 * This method checks if the remove method rebalances.
	 *  the BST.
	 *  
	 *  @param: none
	 *  
	 *  @return: none
	 *  
	 */
	void testAVL_006_remove_balance() {
		try { // try-catch block
			avl2.insert(30, "thirty"); // inserts
			avl2.insert(20, "ten"); // inserts
			avl2.insert(10, "twenty"); // inserts
			avl2.insert(40, "forty"); // inserts
			avl2.insert(5, "twenty-five"); // inserts
			if (avl2.getNode(30, "thirty").key == 30) {
				// checks the key
			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}

	@Test
	/**
	 * This method checks for balanced preOrder.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_008_check_preOrder_for_not_balanced_insert_order() {

		// TODO implement this test
		try { // try-catch block
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			List<Integer> expectedOrder = new ArrayList<Integer>();
			// creates list
			expectedOrder.add(20); // adds
			expectedOrder.add(10); // adds
			expectedOrder.add(30); // adds

			List<Integer> actualOrder = bst2.getPreOrderTraversal();
			// makes a list of preorder
			assertEquals(expectedOrder, actualOrder); // checks equality
		} catch (Exception e) { // catches exception
			fail("test shoulnd't have thrown an exception"); // fails
		}
	}

	@Test
	/**
	 * This method checks for balanced level order.
	 * 
	 * @param: none
	 * 
	 * @return: non
	 * 
	 */
	void testBST_010_check_levelOrder_for_not_balanced_insert_order() {

		// TODO implement this test

		try { // try-catch block

			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts

			List<Integer> expectedOrder = new ArrayList<Integer>();
			// makes list
			expectedOrder.add(20); // adds
			expectedOrder.add(10); // adds
			expectedOrder.add(30); // adds

			List<Integer> actualOrder = bst2.getLevelOrderTraversal();
			// makes list of level order
			assertEquals(expectedOrder, actualOrder); // checks equality

		}

		catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}

	@Test
	/**
	 * This method checks the getleftkey method 
	 * for no exceptions.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_014_check_get_key_of_left_child_for_no_exceptions() {
		try { // try-catch block
			bst2.insert(30, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(10, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			bst2.insert(50, "5th"); // inserts
			bst2.insert(60, "6th"); // inserts
			if (bst2.getKeyOfLeftChildOf(20) == 10) {
				// checks key
			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}

	@Test
	/**
	 * This method checks for the height of the tree
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_21_checks_the_height_of_tree() {
		try { // try-catch block
			bst2.insert(10, "1st"); // insertts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			if (bst2.getHeight() == 4) {
				// checks height
			}

		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}

	@Test
	/**
	 * This method checks for the balanced postorder.
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testBST_009_check_postOrder_for_not_balanced_insert_order() {

		// TODO implement this test
		try { // try-catch block
			bst2.insert(10, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(30, "3rd"); // inserts
			List<Integer> expectedOrder = new ArrayList<Integer>();
			// creates list
			expectedOrder.add(10); // adds
			expectedOrder.add(30); // adds
			expectedOrder.add(20); // adds

			List<Integer> actualOrder = bst2.getPostOrderTraversal();
			// creates list of postorder
			assertEquals(expectedOrder, actualOrder); // checks equality
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}

	}

	@Test
	/**
	 * This method checks the get 
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
			if (bst2.getKeyOfRightChildOf(50) == 20) {
				// checks key
			}
		} catch (Exception e) { // catches exception
			fail("test shouldn't have thrown an exception"); // fails
		}
	}

	@Test
	/**
	 * This method checks balance factor
	 * 
	 * @param: none
	 * 
	 * @return: none
	 * 
	 */
	void testAVL_007_check_balance_factor() {
		try { // try-catch block
			bst2.insert(30, "1st"); // inserts
			bst2.insert(20, "2nd"); // inserts
			bst2.insert(10, "3rd"); // inserts
			bst2.insert(40, "4th"); // inserts
			bst2.insert(50, "5th"); // inserts
			bst2.insert(60, "6th"); // inserts
			if (avl2.balanceFactor(avl2.getNode(30, "1st")) == 0) {
				// checks balance factor
			}
		} catch (Exception e) { // catches exception
			fail("test shoulnd't have thrown an exception"); // fails
		}
	}

}
