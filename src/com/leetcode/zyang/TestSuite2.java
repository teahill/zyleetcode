/**
 * 
 */
package com.leetcode.zyang;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zyang
 *
 */
public class TestSuite2 {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	//@Test
	public void L0319_BulbSwitcher() {
		
		L0319_BulbSwitcher bs = new L0319_BulbSwitcher();
		
		int n = 16;
		
		int result = bs.bulbSwitch(n);
		
		System.out.println(result);	
	}
	
	//@Test
	public void L0318_MaxProductOfWordLength() {
		L0318_MaxProductOfWordLength maxProduct = new L0318_MaxProductOfWordLength();
				 
		//Return 16 The two words can be "abcw", "xtfn"
		//String[] words = new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		
		//Return 4 The two words can be "ab", "cd"
		//String[] words = new String[] {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
				
		//Return 0 No such pair of words
		String[] words = new String[] {"a", "aa", "aaa", "aaaa"};
		
		int result = maxProduct.maxProduct(words);
		
		System.out.println(result);	
	}
	
	//@Test
	public void L0316_RemoveDuplicateLetter() {
		L0316_RemoveDuplicateLetter rd = new L0316_RemoveDuplicateLetter();

		//String s = "bcabc"; // Return "abc"
		
		//String s = "cbacdcbc"; // Return "acdb"
		
		String s = "bbcaac"; // Output: "bac" 
		
		String result = rd.removeDuplicateLetters(s);
		
		System.out.println(result);	
	}

	//@Test
	public void L0326_PowerOfThree() {
		L0326_PowerOfThree pt = new L0326_PowerOfThree();
		
		int n = (int)Math.pow(3, 18);
		
		boolean result = pt.isPowerOfThree(n);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0328_OddEvenLinkedList() {
		L0328_OddEvenLinkedList ll = new L0328_OddEvenLinkedList();
		
		int[] in = new int[] {1, 2, 3, 4, 5, 6, 7};
		ListNode list = Util.createList(in);
		
		ListNode result = ll.oddEvenList(list);
		
		System.out.println(Util.printList(result));
	}
	
	//@Test 
	public void L0099_RecoverBinarySearchTree() {
		L0099_RecoverBinarySearchTree bst = new L0099_RecoverBinarySearchTree();
		
		List<String> list = new ArrayList<String>();

		list.add("1");		
		list.add("2");
		list.add("#");
		list.add("#");
		list.add("3");
		list.add("#");
		list.add("#");
		
		/*
		list.add("2");		
		list.add("#");
		list.add("1");
		list.add("#");
		list.add("#");
		 */
		
		/*
		list.add("4");
		list.add("6");		
		list.add("1");
		list.add("#");
		list.add("#");
		list.add("3");
		list.add("#");
		list.add("#");
		list.add("5");
		list.add("#");
		list.add("2");
		list.add("#");
		list.add("#");
		*/
		
		TreeNode node = BinaryTreeSerializer.deserialize(list);
		
		System.out.println(BinaryTreeSerializer.serialize(node));
		
		bst.recoverTree(node);
		
		System.out.println(BinaryTreeSerializer.serialize(node));		
	}
	
	//@Test
	public void L0327_CounfOfRangeSum() {
		L0327_CounfOfRangeSum countSum = new L0327_CounfOfRangeSum();
		
		int[] nums = {0,-1,1,2,-3,-3};		
		int lower = -3;
		int upper = 1;
		
		/*
		int[] nums = {-2, 5, -1};		
		int lower = -2;
		int upper = 1;
		*/		
		int result = countSum.countRangeSum(nums, lower, upper);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0322_CoinChange() {
		L0322_CoinChange coin = new L0322_CoinChange();
		
		//int[] coins = {1, 2, 5};
		//int amount = 11;
		
		int[] coins = {2};
		int amount = 3;
		
		int result = coin.coinChange(coins, amount);
		
		System.out.println(result);		
	}
	
	//@Test
	public void L0338_CountingBits() {
		L0338_CountingBits counting = new L0338_CountingBits();
		
		int num = 8;
		int[] count = counting.countBits1(num);
		
		String result = Util.printArray(count);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0343_IntegerBreak() {
		L0343_IntegerBreak integerBreak = new L0343_IntegerBreak();
		
		int n = 16;		
		int result = integerBreak.integerBreak(n);
		
		System.out.print(result);
	}
	
	//@Test
	public void Sorting_MergeSort() {
		Sorting_MergeSort m = new Sorting_MergeSort();
		
		int[] nums = new int[] {6, 4, 7, 3, 8, 9, 1, 10};
		//int[] nums = new int[] {};
		//int[] nums = {1};
		
		System.out.print(Util.printArray(nums));
		
		m.mergeSort(nums);
		System.out.print(Util.printArray(nums));
	}
	
	//@Test
	public void Sorting_QuickSort() {
		Sorting_QuickSort m = new Sorting_QuickSort();
		
		int[] nums = new int[] {2, 1, 6, 3, 8, 9, 4, 10};
		//int[] nums = new int[] {};
		//int[] nums = {1};
		
		System.out.print("quick sort");
		System.out.print(Util.printArray(nums));
		
		m.quickSort(nums);
		System.out.print(Util.printArray(nums));
	}
	
	//@Test
	public void Sorting_HeapSort() {
		Sorting_HeapSort m = new Sorting_HeapSort();
		
		int[] nums = new int[] {6, 4, 7, 3, 8, 9, 1, 10};
		//int[] nums = new int[] {};
		//int[] nums = {1};
		
		System.out.print("heap sort");
		System.out.print(Util.printArray(nums));
		
		m.heapSort(nums);
		System.out.print(Util.printArray(nums));
	}
	
	//@Test
	public void FeaturePhoneMap() {
		FeaturePhoneMap map = new FeaturePhoneMap();
		int[] nums = {1, 1, 1, 2, 2, 3};
		
		List<String> list = map.combo(nums);
		
		for (String s : list)
			System.out.print(s + ",");
	}
}
