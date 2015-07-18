/**
 * 
 */
package com.leetcode.zyang;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zyang
 *
 */
public class L0200_TestSuite {

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

	//	@Test
	//	public void test() {
	//		fail("Not yet implemented");
	//	}

	//@Test
	public void testL0169_MajorityElement(){
		L0169_MajorityElement majorElement = new L0169_MajorityElement();

		int[] x = {1, 2, 2, 2, 3, 3, 4, 2, 2};

		int result = majorElement.majorityElement(x);

		System.out.println("input = " + Util.printArray(x) + ", output = " + result);
		System.out.println("input = ");
	}

	//@Test
	public void L0172_FactorialTrailingZero(){
		L0172_FactorialTrailingZero zeros = new L0172_FactorialTrailingZero();

		int n = 99;

		int result = zeros.trailingZeroes(n);

		System.out.println("input = " + n + ", output = " + result);
	}

	//@Test
	public void L0189_RotateArray() {
		L0189_RotateArray array = new L0189_RotateArray();

		int[] nums = {1,2};
		int k = 3;

		System.out.println("input = " + Util.printArray(nums));

		array.rotate(nums, k);

		System.out.println("input = " + Util.printArray(nums));			
	}

	//@Test
	public void L0190_ReverseBits() {
		L0190_ReverseBits reverseBits = new L0190_ReverseBits();

		//int n = 43261596;
		//int n = 4;
		long n = 4294967295L;

		System.out.println("input = " + n);

		int result = reverseBits.reverseBits((int)n);		

		System.out.println("output = " + result);		
	}

	//@Test
	public void L0191_NumberOf1Bits() {
		L0191_NumberOf1Bits numOfBits = new L0191_NumberOf1Bits();
		
		//long n = 11;
		long n = 4294967295L;
		
		System.out.println("input = " + n);

		int result = numOfBits.hammingWeight((int)n);		

		System.out.println("output = " + result);	
	}
	
	//@Test
	public void L0095_UniqueBSTII() {
		L0095_UniqueBSTII uniqueBST = new L0095_UniqueBSTII();
		
		int n = 3;
		
		System.out.println("input = " + n);
		
		List<TreeNode> list = uniqueBST.generateTrees(n);
		
		StringBuilder result = new StringBuilder();
		for (TreeNode node : list) {
			List<String> strs = BinaryTreeSerializer.serialize(node);
			for (String s : strs)
				result = result.append(s + ',');
			System.out.println("output = " + result.toString());
			result = new StringBuilder();
		}
	}
	
	//@Test
	public void L0062_UniquePaths() {
		L0062_UniquePaths uniquePaths = new L0062_UniquePaths();
		
		int m = 3, n = 7;
		
		System.out.println("input = " +  m + ", " +  n);
		
		int num = uniquePaths.uniquePaths(m, n);
		
		System.out.println("output = " + num);
				
	}
	
	//@Test
	public void L0063_UniquePathsII() {
		L0063_UniquePathsII uniquePaths = new L0063_UniquePathsII();
		
		//int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		//int[][] obstacleGrid = {{1, 0}};
		int[][] obstacleGrid = {{1}, {0}};
		System.out.println("input = " +  obstacleGrid);
		
		int num = uniquePaths.uniquePathsWithObstacles(obstacleGrid);
		
		System.out.println("output = " + num);
				
	}
	
	//@Test
	public void L0046_Permutation() {
		L0046_Permutation permutation = new L0046_Permutation();
		
		int[] num = new int[] {1, 2, 3};
		//int[] num = new int[] {1, 2};
		//int[] num = new int[] {1};
		
		System.out.println("input = " +  Util.printArray(num));
		
		List<List<Integer>> allList = permutation.permute(num);
		
		System.out.println("output = " +  permutation.printList(allList));
	}
	
	//@Test
	public void L0079_WordSearch() {
		L0079_WordSearch wordSearch = new L0079_WordSearch();
		
		/* test set 1
		char[][] board = new char[3][];
		board[0] = new char[] { 'A', 'B', 'C', 'E'};
		board[1] = new char[] { 'S', 'F', 'C', 'S'};
		board[2] = new char[] { 'A', 'D', 'E', 'E'};
		*/
		
		//String word = "ABCCED";
		//String word = "SEE";
		//String word = "ABCB";
		
		char[][] board = new char[3][];
		board[0] = new char[] { 'C', 'A', 'A'};
		board[1] = new char[] { 'A', 'A', 'A'};
		board[2] = new char[] { 'B', 'C', 'D'};	
		
		String word = "AAB";
		
		System.out.println("input = " + word);
		
		boolean result = wordSearch.exist(board, word);
		
		System.out.println("output = " + result);
	}
	
	//@Test
	public void L0077_Combination() {
		L0077_Combination combination = new L0077_Combination();
		
		//int n = 4, k = 2;
		int n = 2, k = 0;
		
		System.out.println("n = " + n + ", k = " + k);
		
		List<List<Integer>> allList = combination.combine(n, k);
		
		
		System.out.println("output" + Util.printList(allList));
	}
	
	//@Test
	public void L0075_SortColor() {
		L0075_SortColor sortColor = new L0075_SortColor();
		
		int[] A = new int[] {1, 2, 0, 1, 1, 2, 0, 0, 2};
		
		System.out.println("input = " + Util.printArray(A));
		
		sortColor.sortColors(A);
		
		System.out.println("output = " + Util.printArray(A));
	}
	
	//@Test
	public void L0060_PermutationSequence() {
		L0060_PermutationSequence permutationSequence = new L0060_PermutationSequence();
		int n = 3, k = 6;
		
		System.out.println("input: n = " + n + ", k = " + k);
		
		String result = permutationSequence.getPermutation(n, k);
		
		System.out.println("output = " + result);
	}
	
	//@Test
	public void L0078_Subsets() {
		L0078_Subsets ss = new L0078_Subsets();
		
		int[] S = new int[] {1, 2, 3};
		//int[] S = new int[] {4, 1, 0};
		
		System.out.println("input: S = " + Util.printArray(S));
				
		List<List<Integer>> allList = ss.subsets(S);
		
		System.out.println("output: " + Util.printList(allList));	
	}
	
	//@Test
	public void L0048_RotateImage() {
		L0048_RotateImage rotateImage = new L0048_RotateImage();
		
		/**
		int[][] matrix = new int[1][];
		matrix[0] = new int[]{1}; 
		*/
		
		/**
		int[][] matrix = new int[3][];
		matrix[0] = new int[]{1, 2, 3};
		matrix[1] = new int[]{4, 5, 6};
		matrix[2] = new int[]{7, 8, 9};
		**/
		
		/**
		int[][] matrix = new int[4][];
		matrix[0] = new int[]{1, 2, 3, 4};
		matrix[1] = new int[]{5, 6, 7, 8};
		matrix[2] = new int[]{9, 10, 11, 12};
		matrix[3] = new int[]{13, 14, 15, 16};
		**/
		
		int[][] matrix = new int[5][];
		matrix[0] = new int[]{1, 2, 3, 4, 100};
		matrix[1] = new int[]{5, 6, 7, 8, 200};
		matrix[2] = new int[]{9, 10, 11, 12, 300};
		matrix[3] = new int[]{13, 14, 15, 16, 400};
		matrix[4] = new int[]{17, 18, 19, 20, 500};
		
		
		System.out.println("input: " + Util.printMatrix(matrix));
		
		rotateImage.rotate(matrix);
		
		System.out.println("output: " + Util.printMatrix(matrix));		
	}
	
	//@Test
	public void L0002_AddTwoNumbers() {
		L0002_AddTwoNumbers addTwoNumbers = new L0002_AddTwoNumbers();
		
		ListNode l1 = Util.createList(new int[] {2, 4, 3});
		ListNode l2 = Util.createList(new int[] {5, 6, 4});
		
		System.out.println("input: l1 = " + Util.printList(l1) + "\nl2 = " + Util.printList(l2));
		
		ListNode list = addTwoNumbers.addTwoNumbers(l1, l2);
		
		System.out.println("output: l3 = " + Util.printList(list)); 
	 }
	
	//@Test
	public void L0003_LongestSubstring() {
		L0003_LongestSubstring longSubstring = new L0003_LongestSubstring();
		
		//String s = "abcabcbb";
		//String s = "bbbbb";
		//String s = "b";
		//String s = "pwwkew";
		//String s = "au";
		//String s = "";
		String s = "acaubdf";
		//String s = "cdd";
		//String s = "abba";
		
		System.out.println("input: " + s);
		
		int maxLen = longSubstring.lengthOfLongestSubstring(s);
		
		System.out.println("output: " + maxLen);		
	}
	
	//@Test
	public void L0005_LongestPalindromeSubstring() {
		L0005_LongestPalindromeSubstring lp = new L0005_LongestPalindromeSubstring();
		
		//String s = "abcdefed";
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		System.out.println("input: " + s);
		
		String result = lp.longestPalindrome(s);
		
		System.out.println("output: " + result);			
	}
	
	//@Test
	public void L0015_3Sum() {
		L0015_3Sum threeSum = new L0015_3Sum();
		
		int[] num = new int[] {-1, 0, 1, 2, -1, -4};
		
		System.out.println("input: " + Util.printArray(num));
		
		List<List<Integer>> allList = threeSum.threeSum(num);
		
		System.out.println("output: " + Util.printList(allList));
		
	}
	
	//@Test
	public void L0016_3Sum_Closest() {
		L0016_3Sum_Closest threeSum_closest = new L0016_3Sum_Closest();
		
		int[] num = new int[]{-1, 2, 1, -4};
		int target = 1;
		
		System.out.println("input: " + Util.printArray(num) + ", target = " + target);
		
		int result = threeSum_closest.threeSumClosest(num, target);
		
		System.out.println("output: " + result);	
		
	}
	
	//@Test
	public void L0018_4Sum() {
		L0018_4Sum fourSum = new L0018_4Sum();
		
		int[] num = new int[] {1, 0, -1, 0, -2, 2};
		//int[] num = new int[] {0, 0, 0, 0};
		int target = 0;
		//int[] num = new int[] {-1,2,2,-5,0,-1,4};
		//int target = 3;
		
		System.out.println("input: " + Util.printArray(num) + ", target = " + target);
		
		List<List<Integer>> allList = fourSum.fourSum(num, target);
		
		System.out.println("output: " + Util.printList(allList));
	}
	
	//@Test
	public void L0011_ContainerWithMostWater() {
		L0011_ContainerWithMostWater containerWater = new L0011_ContainerWithMostWater();		
		
		int[] height = new int[] { 2, 3, 4, 1, 3, 2, 3, 3, 1};
		//int[] height = new int[] {1, 1};
		
		System.out.println("input: " + Util.printArray(height));
		
		int area = containerWater.maxArea(height);
		
		System.out.println("output: " + area);
	}
	
	//@Test
	public void L0012_IntegerToRoman() {
		L0012_IntegerToRoman integerToRoman = new L0012_IntegerToRoman();
		
		//int num = 1904; // MCMIV
		int num = 2438; //"MMCDXXXVIII"
		
		System.out.println("input: " + num);
		
		String result = integerToRoman.intToRoman(num);
		
		System.out.println("output: " + result);
	}
	
	//@Test
	public void L0017_Letter_Combo_Phone_Num() {
		L0017_Letter_Combo_Phone_Num letterCombo = new L0017_Letter_Combo_Phone_Num();
		
		String s = "23";
		
		System.out.println("input: " + s);
		
		List result = letterCombo.letterCombinations(s);
		
		System.out.println("output: " + result.toString());
	}
	
	//@Test
	public void L0022_GenerateParentheses() {
		L0022_GenerateParentheses paren = new L0022_GenerateParentheses();
		
		int n = 1;
		
		System.out.println("input: " + n);
		
		List<String> list = paren.generateParenthesis(n);
		
		System.out.println("output: " + list.toString());
	}
	
	/*
	 * 1,2,3 → 1,3,2
	 * 3,2,1 → 1,2,3
	 * 1,1,5 → 1,5,1
	 */
	//@Test
	public void L0031_NextPermutation() {
		L0031_NextPermutation nextPermutation = new L0031_NextPermutation();
		
		//int[] num = new int[] { 1,2,3 };
		int[] num = new int[] { 1,2,4,3 };
		//int[] num = new int[] { 3, 2, 1 };
		//int[] num = new int[] { 1, 1, 5 };
		//int[] num = new int[] { 1, 2, 1, 5, 4, 3, 3, 2, 1};				
		//int[] num = new int[] {5};
		//int[] num = new int[] {5, 7};
		
		System.out.println("input: " + Util.printArray(num));
		
		nextPermutation.nextPermutation(num);
		
		System.out.println("input: " + Util.printArray(num));
	}
	
	
	//@Test
	public void L0034_SearchForRange() {
		L0034_SearchForRange search = new L0034_SearchForRange();

		//int[] num = new int[] {5, 7, 7, 8, 8, 10};
		//int target = 8;
			
		//int[] num = new int[] {5, 7};
		//int target = 7;
		
		//int[] num = new int[] {5, 7, 7, 8, 8, 10};
		//int target = 4;
		
		//int[] num = new int[] {5};
		//int target = 4;
		
		int[] num = new int[] {1, 5};
		int target = 4;
		
		System.out.println("input: " + Util.printArray(num) + " target = " + target);
		
		int[] result = search.searchRange(num, target);
		
		System.out.println("output: " + Util.printArray(result));
	}
	
/**
 *  [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
*/
	//@Test
	public void L0035_SearchInsertPosition() {
		L0035_SearchInsertPosition search = new L0035_SearchInsertPosition();
		
		//int[] num = new int[] {5, 7, 8, 10, 11};
		//int target = 9;
		
		//int[] num = new int[] {5, 7};
		//int target = 6;
		
		//int[] num = new int[] {1,3,5,6};
		//int target = 0;
		
		int[] num = new int[] {};
		int target = 4;
		
		System.out.println("input: " + Util.printArray(num) + " target = " + target);
		
		int result = search.searchInsert(num, target);
		
		System.out.println("output: " + result);
		
	}
	
	//@Test
	public void L0039_CombinationSum() {
		L0039_CombinationSum combSum = new L0039_CombinationSum();
				
		//int[] candidates = new int[] {2,3,6,7};
		//int target = 7;
		
		int[] candidates = new int[] {2, 2, 5};
		int target = 7;
		
		System.out.println("input: " + Util.printArray(candidates) + " target = " + target);
		
		List<List<Integer>> newAllList = combSum.combinationSum(candidates, target);
		
		System.out.println("output: " + Util.printList(newAllList));		
	}
	
	//@Test
	public void L0040_CombinationSumII() {
		L0040_CombinationSumII combSum = new L0040_CombinationSumII();
				
		int[] candidates = new int[] {2,3,6,7};
		int target = 7;
		
		//int[] candidates = new int[] {2, 2, 5};
		//int target = 7;
		
		//int[] candidates = new int[] {10,1,2,7,6,1,5};
		//int target = 8;
		
		System.out.println("input: " + Util.printArray(candidates) + " target = " + target);
		
		List<List<Integer>> newAllList = combSum.combinationSum2(candidates, target);
		
		System.out.println("output: " + Util.printList(newAllList));		
	}
	
	//@Test
	public void L0141_LinkedListCycle() {
		L0141_LinkedListCycle cycle = new L0141_LinkedListCycle();
		
		//int[] x = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] x = {1,2};	
		//int[] x = {1,2, 3};	
		
		// Create straight list
		//ListNode list = Util.createList(x);
		//System.out.println("input: list = " + Util.printList(list));
		
		
		// Create cyclic list
		int k = 0;
		ListNode list = Util.createCyclicList(x, k);
		System.out.println("input: list = " + Util.printCyclicList(list, k));
		
		boolean result = cycle.hasCycle(list);		
		
		System.out.println("result = " + result);
	}
	
	//@Test
	public void L0142_LinkedListCycleII() {
		L0142_LinkedListCycleII cycle2 = new L0142_LinkedListCycleII();
		
		//int[] x = {1, 2, 3, 4, 5, 6, 7, 8};
		//int k = 3;
		
		int[] x = {1,2};
		int k = 0;
		ListNode list = Util.createCyclicList(x, k);
		
		System.out.println("input: list = " + Util.printCyclicList(list, k));
		
		ListNode node = cycle2.detectCycle(list);
		
		System.out.println("result = " + node.val);
	}
	
	//@Test
	public void L0043_MultiplyStrings() {
		L0043_MultiplyStrings multiStrings = new L0043_MultiplyStrings();
		
		//String num1 = "145";
		//String num2 = "23";
		
		//String num1 = "9";
		//String num2 = "9";
		
		//String num1 = "9133";
		//String num2 = "0";
		
		//String num1 = "0";
		//String num2 = "52";
		
		String num1 = "0";
		String num2 = "0";
		
		//String num1 = "123456789";
		//String num2 = "987654321";
		
		System.out.println("num1 = " + num1 + " num2 = " + num2);
		
		String product = multiStrings.multiply(num1, num2);
		
		System.out.println("product = " + product);
	}
	
	//@Test
	public void L0049_Anagrams() {
		L0049_Anagrams anagram = new L0049_Anagrams();
		
		String[] strs = new String[] {"silent", "listen", "tall"};
		
		System.out.println("strs = " + Util.printStringArray(strs));
		
		List<String> list = anagram.anagrams(strs);
		
		System.out.println("result = " + list);
	}
	
	//@Test
	public void L0053_MaxSubarray() {
		L0053_MaxSubarray maxSubarray = new L0053_MaxSubarray();
		
		//int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		//int[] nums = new int[] {1, -3, 3};
		//int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4, 10};
		//int[] nums = new int[] {2, 5, 0, 0};
		int[] nums = new int[] {-1, -2};
		
		System.out.println("input = " + Util.printArray(nums));
		
		int result = maxSubarray.maxSubArray(nums);
		
		System.out.println("output = " + result);
	}
	
	//@Test
	public void L0055_JumpGame() {
		L0055_JumpGame jumpGame = new L0055_JumpGame();
		
		//int[] nums = new int[] {2, 3, 1, 1, 4};
		//int[] nums = new int[] {3,2,1,0,4};
		//int[] nums = new int[] {2,5,0,0};
		int[] nums = new int[] {2, 0};
				
		System.out.println("input = " + Util.printArray(nums));
				
		boolean result = jumpGame.canJump(nums);
		
		System.out.println("output = " + result);
	}
	
	//@Test 
	public void L0054_SpiralMatrix() {
		L0054_SpiralMatrix spiralMatrix = new L0054_SpiralMatrix();
		
		//int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		//int[][] matrix = new int[][] {{1}};
		//int[][] matrix = new int[][] {{1, 2}, {3, 4}};
		//int[][] matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		//int[][] matrix = new int[][] {{}};
		int[][] matrix = new int[][] {};
		
		System.out.println("Input = " + Util.printMatrix(matrix));
		
		List<Integer> list = spiralMatrix.spiralOrder(matrix);
		
		System.out.println("Output = " + list);
	}
	
	//@Test
	public void L0059_SpiralMatrixII() {
		L0059_SpiralMatrixII spiralMatrixII = new L0059_SpiralMatrixII();
		
		int n = 3;
		
		System.out.println("Input = " + n);
		
		int[][] matrix = spiralMatrixII.generateMatrix(n);
		
		System.out.println("Output = " + Util.printMatrix(matrix));
	}
	
	//@Test
	public void L0050_Pow() {
		L0050_Pow pow = new L0050_Pow();
		
		double x = 1.0;
		int n = Integer.MAX_VALUE;
		
		System.out.println("Input x = " + x + ", n = " + n);
		
		double result = pow.myPow(x, n);
		
		System.out.println("Output = " + result);
	}
	
	//@Test
	public void L0061_RotateList() {
		L0061_RotateList rotateList = new L0061_RotateList();
		
		int[] x = {1, 2, 3, 4, 5};
		int k = 6;	
		
		//int[] x = {};
		//int k = 0;
		
		ListNode head = Util.createList(x);
		
		System.out.println("input: list = " + Util.printList(head));
	
		ListNode result = rotateList.rotateRight(head, k);
		
		System.out.println("output: " + Util.printList(result));
	}
	
	//@Test
	public void L0064_MinPathSum() {
		L0064_MinPathSum minPathSum = new L0064_MinPathSum();
		
		//int[][] grid = new int[][] {{1, 2, 3}, {7, 4, 1}};
		int[][] grid = new int[][] {{5, 1, 2, 3, 4}, {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
		
		System.out.println("input: grid = " + Util.printMatrix(grid));
				
		int sum = minPathSum.minPathSum(grid);
		
		System.out.println("output: " + sum);
		
	}
	
	//@Test
	public void L0198_HouseRobber() {
		L0198_HouseRobber houseRobber = new L0198_HouseRobber();
		
		int[] nums = {7, 3, 6, 9, 1};
		
		System.out.println("input: " + Util.printArray(nums));
		
		int result = houseRobber.rob(nums);
		
		System.out.println("output: " + result);		
	}
	
	//@Test
	public void L0121_BuySellStock() {
		L0121_BuySellStock stock = new L0121_BuySellStock();
		
		//int[] prices = new int[] {3,2,6,5,0,3};
		//int[] prices = new int[] {6,1,3,2,4,7};
		int[] prices = new int[] {};
		
		System.out.println("input: " + Util.printArray(prices));
		
		int result = stock.maxProfit(prices);
		
		System.out.println("output: " + result);
	}
	
	//@Test
	public void L0122_BuySellStockII() {
		L0122_BuySellStockII stockII = new L0122_BuySellStockII();
		
		int[] prices = new int[] {6,1,3,2,4,7};
		
		System.out.println("input: " + Util.printArray(prices));
		
		int result = stockII.maxProfit(prices);
		
		System.out.println("output: " + result);		
	}
	
	//@Test
	public void L0151_ReserveWordInString() {
		L0151_ReserveWordInString reverseWords = new L0151_ReserveWordInString();
		
		//String s = "      ";
		String s = "the sky is blue";
		
		System.out.println("input: " + s);
		
		String result = reverseWords.reverseWords(s);
		
		System.out.println("output: " + result);		
	}
	
	//@Test
	public void L0073_SetMatrixZeroes() {
		L0073_SetMatrixZeroes setMatrixZero = new L0073_SetMatrixZeroes();
		
		/**
		int[][] matrix = new int[][] {	{1, 2, 3, 4, 5}, 
										{6, 7, 0, 8, 9}, 
										{11, 0, 12, 13, 14}, 
										{4, 5, 6, 7, 9}};
										*/
		
		int[][] matrix = new int[][] {{0}, {1}};
		
		System.out.println("input: matrix = " + Util.printMatrix(matrix));
		
		setMatrixZero.setZeroes(matrix);
		
		System.out.println("output: matrix = " + Util.printMatrix(matrix));
	}
	
	//@Test
	public void L0074_Search2DMatrix() {
		L0074_Search2DMatrix searchMatrix = new L0074_Search2DMatrix();
		

		int[][] matrix = new int[][] {	{1,   3,  5,  7},
	 									{10, 11, 16, 20},
										{23, 30, 34, 50}};
										
		int target = 3;
		
		//int[][] matrix = new int[][] {{3}};
		
		System.out.println("input: matrix = " + Util.printMatrix(matrix));
		System.out.println("input: target  = " + target);
		
		boolean found = searchMatrix.searchMatrix(matrix, target);
		
		System.out.println("output: found = " + found);
	}
	
	//@Test
	public void L0080_RemoveDupSortedArrayII() {
		L0080_RemoveDupSortedArrayII removeDup = new L0080_RemoveDupSortedArrayII();
		
		int[] array = new int[] {1, 1};
		
		System.out.println("input: array = " + Util.printArray(array));
				
		int len = removeDup.removeDuplicates(array);
		
		System.out.println("output: " + len);
	}
	
	//@Test
	public void L0086_PartitionList() {
		L0086_PartitionList patitionList = new L0086_PartitionList();
		
		int x = 3;
		//ListNode head = Util.createList(new int[] {1, 4, 3, 2, 5, 2});
		ListNode head = Util.createList(new int[] {4, 1, 2});
		
		//int x = 1;
		//ListNode head = Util.createList(new int[] {2, 1});
		
		//int x = 2;
		//ListNode head = Util.createList(new int[] {2, 3, 1});
		
		System.out.println("Input: " + Util.printList(head));
				
		ListNode result = patitionList.partition(head, x);
		
		System.out.println("Output: " + Util.printList(result));
	}
	
	//@Test
	public void L0090_SubsetsII() {
		L0090_SubsetsII ss = new L0090_SubsetsII();
		
		//int[] S = new int[] {1, 2, 3, 3, 3};
		//int[] S = new int[] {1, 2, 3, 3, 4};
		int[] S = new int[] {1, 2, 2};
		
		System.out.println("input: S = " + Util.printArray(S));
				
		List<List<Integer>> allList = ss.subsetsWithDup(S);
		
		System.out.println("output: " + Util.printList(allList));	
	}
	
	//@Test
	public void L0089_GrayCode() {
		L0089_GrayCode grayCode = new L0089_GrayCode();
		
		int n = 3;
		
		System.out.println("input: n = " + n);
		
		List<Integer> list = grayCode.grayCode(n);
		
		System.out.println("output: " + list);
	}
	
	//@Test
	public void L0144_BinaryTreePreorderTraversal() {
		L0144_BinaryTreePreorderTraversal preOrderTraversal = new L0144_BinaryTreePreorderTraversal();
		
		List<String> strs = new ArrayList<String>();		
		strs.add("1");
		strs.add("#");
		strs.add("2");
		strs.add("3");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		/*
		strs.add("9");
		strs.add("#");
		strs.add("#");
		strs.add("20");
		strs.add("15");
		strs.add("#");
		strs.add("#");
		strs.add("7");
		strs.add("9");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		*/
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
		
		List<Integer> result = preOrderTraversal.preorderTraversal(root);
		
		System.out.println("result = " + result);
	}
	
	//@Test
	public void L0114_FlattenBinaryTreeToLinkedList() {
		L0114_FlattenBinaryTreeToLinkedList flatten = new L0114_FlattenBinaryTreeToLinkedList();
		
		List<String> strs = new ArrayList<String>();
		/*
		strs.add("1");
		strs.add("#");
		strs.add("2");
		strs.add("3");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		*/

		/*
		strs.add("1");
		strs.add("2");
		strs.add("3");
		strs.add("#");
		strs.add("#");
		strs.add("4");
		strs.add("#");
		strs.add("#");
		strs.add("5");
		strs.add("#");
		strs.add("6");
		strs.add("#");
		strs.add("#");
		*/
		
		strs.add("1");
		strs.add("2");
		strs.add("#");
		strs.add("#");
		strs.add("3");
		strs.add("#");
		strs.add("#");
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("Tree = " + BinaryTreeSerializer.serialize(root));
		
		flatten.flatten(root);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
	}
	
	//@Test
	public void L0091_DecodeWays() {
		L0091_DecodeWays decodeWays = new L0091_DecodeWays();
		
		String s = "330";
		
		System.out.println("Input = " + s);
		
		int count = decodeWays.numDecodings(s);
		
		System.out.println("result = " + count);
	}
	
	//@Test
	public void L0098_ValidateBinarySearchTree() {
		L0098_ValidateBinarySearchTree validBST = new L0098_ValidateBinarySearchTree();
		
		//CreateBinarySearchTree t1 = new CreateBinarySearchTree();
		//t1.add(1,2,3,4,5,6,7,8,9);
		
		List<String> strs = new ArrayList<String>();		
		strs.add("3");
		strs.add("9");
		strs.add("#");
		strs.add("#");
		strs.add("20");
		strs.add("15");
		strs.add("#");
		strs.add("#");
		strs.add("7");
		strs.add("#");
		strs.add("#");
		
		System.out.println("Input = " + strs);
		
		TreeNode t1 = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("Input = " + t1.toString());
		
		boolean isValid = validBST.isValidBST(t1);
		
		System.out.println("result = " + isValid);
		
	}
	
	//@Test
	public void L0105_TreeFromPreorderInorderTraversal() {
		L0105_TreeFromPreorderInorderTraversal tree = new L0105_TreeFromPreorderInorderTraversal();
		
		int[] preorder = new int[] {1, 2, 4, 8, 5, 3, 6};
		int[] inorder = new int[] {8, 4, 2, 5, 1, 6, 3};
		
		System.out.println("input = " + Util.printArray(preorder));
		System.out.println("input = " + Util.printArray(inorder));
		
		TreeNode node = tree.buildTree(preorder, inorder);
		
		System.out.println("output = " + BinaryTreeSerializer.serialize(node));
		
	}
	
	//@Test
	public void L0106_TreeFromInorderPostOrderTraversal() {
		L0106_TreeFromInorderPostOrderTraversal tree = new L0106_TreeFromInorderPostOrderTraversal();
	
		int[] inorder = new int[] {8, 4, 2, 5, 1, 6, 3};
		int[] postorder = new int[] {8, 4, 5, 2, 6, 3, 1};

		System.out.println("input = " + Util.printArray(inorder));	
		System.out.println("input = " + Util.printArray(postorder));
		
		TreeNode node = tree.buildTree(inorder, postorder);
		
		System.out.println("output = " + BinaryTreeSerializer.serialize(node));
		
	}
	
	//@Test
	public void L0108_ConvertSortedArrayToBST() {
		L0108_ConvertSortedArrayToBST tree = new L0108_ConvertSortedArrayToBST();
		
		int[] nums = new int[] { 1, 2,3, 4, 5, 6, 7};
		
		System.out.println("input = " + Util.printArray(nums));
		
		TreeNode root = tree.sortedArrayToBST(nums);
		
		System.out.println("output = " + BinaryTreeSerializer.serialize(root));
		
	}
	
	//@Test
	public void L0109_ConverSortedListToBST() {
		L0109_ConverSortedListToBST tree = new L0109_ConverSortedListToBST();
		
		int[] nums = new int[] { 1, 2,3, 4, 5, 6, 7};
		
		ListNode head = Util.createList(nums);
		
		System.out.println("input = " + Util.printList(head));
		
		TreeNode root = tree.sortedListToBST(head);
		
		System.out.println("output = " + BinaryTreeSerializer.serialize(root));
		
	}
	
	//@Test
	public void L0116_PopulatingNextRightPointer() {
		L0116_PopulatingNextRightPointer tree = new L0116_PopulatingNextRightPointer();
		
		List<String> strs = new ArrayList<String>();		
		strs.add("1");
		strs.add("2");
		strs.add("4");
		strs.add("#");
		strs.add("#");
		strs.add("5");
		strs.add("#");
		strs.add("#");
		strs.add("3");
		strs.add("6");
		strs.add("#");
		strs.add("#");
		strs.add("7");
		strs.add("#");
		strs.add("#");
		
		TreeLinkNode root = BinaryTreeLink.deserialize(strs);
		
		System.out.println("input = " + BinaryTreeLink.serialize(root));
		
		tree.connect(root);
		
		System.out.println("output = " + BinaryTreeLink.printLinks(root));
		
	}
	
	//@Test
	public void L0117_PopulatingNextRightPointerII() {
		L0117_PopulatingNextRightPointerII tree = new L0117_PopulatingNextRightPointerII();
		
		List<String> strs = new ArrayList<String>();		
		strs.add("1");
		strs.add("2");
		strs.add("4");
		strs.add("8");
		strs.add("#");
		strs.add("#");
		strs.add("9");
		strs.add("11");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		strs.add("5");
		strs.add("#");
		strs.add("#");
		strs.add("3");
		strs.add("#");
		strs.add("7");
		
		strs.add("10");
		strs.add("12");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		
		TreeLinkNode root = BinaryTreeLink.deserialize(strs);
		
		System.out.println("input = " + BinaryTreeLink.serialize(root));
		
		tree.connect(root);
		
		System.out.println("output = " + BinaryTreeLink.printLinks(root));		
	}
	
	//@Test
	public void L0129_SumRootToLeaf() {
		L0129_SumRootToLeaf sumRootLeaf = new L0129_SumRootToLeaf();
		
		List<String> strs = new ArrayList<String>();		
		strs.add("1");
		strs.add("2");
		strs.add("4");
		strs.add("#");
		strs.add("#");
		strs.add("1");
		strs.add("#");
		strs.add("#");
		strs.add("3");
		strs.add("1");
		strs.add("#");
		strs.add("#");
		strs.add("2");
		strs.add("#");
		strs.add("#");
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("input = " + BinaryTreeSerializer.serialize(root));
		
		int sum = sumRootLeaf.sumNumbers(root);
		
		System.out.println("output = " + sum);	
	}
	
	//@Test
	public void L0199_BinaryTreeRightSideView() {
		L0199_BinaryTreeRightSideView sideView = new L0199_BinaryTreeRightSideView();
		
		List<String> strs = new ArrayList<String>();		
		strs.add("1");
		strs.add("2");
		strs.add("#");
		strs.add("5");
		strs.add("#");
		strs.add("#");
		strs.add("3");
		strs.add("#");
		strs.add("4");
		strs.add("#");
		strs.add("#");
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("input = " + BinaryTreeSerializer.serialize(root));
		
		List<Integer> list = sideView.rightSideView(root);
		
		System.out.println("output = " + list);
	}
	
	//@Test
	public void L0222_CountCompleteTreeNodes() {
		L0222_CountCompleteTreeNodes countNodes = new L0222_CountCompleteTreeNodes();
		
		List<String> strs = new ArrayList<String>();	
		/**
		strs.add("1");
		strs.add("2");
		strs.add("4");
		strs.add("8");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		strs.add("5");
		strs.add("#");
		strs.add("#");
		strs.add("3");
		strs.add("6");
		strs.add("#");
		strs.add("#");
		strs.add("7");
		strs.add("#");
		strs.add("#");
		**/
		
		strs.add("1");
		strs.add("2");
		strs.add("#");		
		strs.add("#");
		strs.add("#");
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("input = " + BinaryTreeSerializer.serialize(root));
		
		int count = countNodes.countNodes(root);
		
		System.out.println("output = " + count);
	}
	
	//@Test
	public void L0145_BinaryTreePostorderTraversal() {
		L0145_BinaryTreePostorderTraversal postTraversal = new L0145_BinaryTreePostorderTraversal();
		
		List<String> strs = new ArrayList<String>();	
		strs.add("1");
		strs.add("#");		
		strs.add("2");
		strs.add("3");		
		strs.add("#");
		strs.add("#");
		strs.add("#");
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("input = " + BinaryTreeSerializer.serialize(root));
		
		List<Integer> list = postTraversal.postorderTraversal(root);
		
		System.out.println("output = " + list);
	}
	
	//@Test
	public void L0136_SingleNumber() {
		L0136_SingleNumber singleNumber = new L0136_SingleNumber();
		
		int[] nums = new int[] {1, 3, 4, 6, 3, 7, 1, 6, 7};
		
		System.out.println("input = " + Util.printArray(nums));
		
		int result = singleNumber.singleNumber(nums);
		
		System.out.println("output = " + result);
	}
	
	//@Test
	public void L0217_ContainsDuplicate() {
		L0217_ContainsDuplicate duplicate = new L0217_ContainsDuplicate();
		
		int[] nums = new int[] {1, 3, 4, 6, 7, 3};
		
		System.out.println("input = " + Util.printArray(nums));
		
		boolean result = duplicate.containsDuplicate(nums);
		
		System.out.println("output = " + result);
	}
	
	//@Test
	public void L0153_FindMinRotatedSortedArray() {
		L0153_FindMinRotatedSortedArray findMin = new L0153_FindMinRotatedSortedArray();
		
		int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
		//int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2, 3};
		//int[] nums = new int[] {2, 1};
		
		System.out.println("input = " + Util.printArray(nums));
		
		int result = findMin.findMin(nums);
		
		System.out.println("output = " + result);
	}
	
	//@Test
	public void L0154_FIndMinRotatedSortedArrayII() {
		L0154_FIndMinRotatedSortedArrayII findMin = new L0154_FIndMinRotatedSortedArrayII();
		
		int[] nums = new int[] {2, 2, 2, 1, 2, 2, 2, 2, 2, 2};
		//int[] nums = new int[] {2, 2, 2, 2, 2, 2, 1, 2, 2, 2};
		//int[] nums = new int[] {3, 4, 1, 2, 2, 2, 2, 2, 2};
		//int[] nums = new int[] {4, 5, 6, 7, 0, 0, 0, 1, 2, 2, 2};
		//int[] nums = new int[] {2, 2, 2, 2, 2, 2};
		//int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2, 3};
		//int[] nums = new int[] {2, 1};
		
		System.out.println("input = " + Util.printArray(nums));
		
		int result = findMin.findMin(nums);
		
		System.out.println("output = " + result);
	}
	
	//@Test
	public void L0137_SingleNumberII() {
		L0137_SingleNumberII singleNumberII = new L0137_SingleNumberII();
		
		int[] nums = new int[] {43, 43, 43, 17, 17, 17, 12};
		//int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2, 3};
		//int[] nums = new int[] {2, 1};
		
		System.out.println("input = " + Util.printArray(nums));
		
		int result = singleNumberII.singleNumber(nums);
		
		System.out.println("output = " + result);
	}
	
	//@Test
	public void L0206_ReverseLinkedList() {
		L0206_ReverseLinkedList reverseLL = new L0206_ReverseLinkedList();
		
		int[] x = {1, 2, 3};
		
		ListNode head = Util.createList(x);
		
		System.out.println("input = " + Util.printList(head));
		
		ListNode result = reverseLL.reverseList(head);
		
		System.out.println("output = " + Util.printList(result));
	}
	
	//@Test
	public void L0202_HappyNumber() {
		L0202_HappyNumber happyNumber = new L0202_HappyNumber();
		
		int n = 19;
		
		System.out.println("input = " + n);
		
		boolean isHappy = happyNumber.isHappy(n);
		
		System.out.println("output = " + isHappy);			
	}
	
	//@Test 
	public void L0033_SearchRotatedSortedArray() {
		L0033_SearchRotatedSortedArray searchArray = new L0033_SearchRotatedSortedArray();
		
		int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2};
		//int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2, 3};
		//int[] nums = new int[] {2, 1};
		
		int target = 0;
		
		System.out.println("input nums = " + Util.printArray(nums) + ", target = " + target);
		
		int result = searchArray.search(nums, target);
		
		System.out.println("output = " + result);
	}
	
	//@Test 
	public void L0081_SearchRotatedSortedArrayII() {
		L0081_SearchRotatedSortedArrayII searchArray = new L0081_SearchRotatedSortedArrayII();
		
		int[] nums = new int[] {2, 2, 2, 1, 2, 2, 2, 2, 2, 2};
		//int[] nums = new int[] {2, 2, 2, 2, 2, 2, 1, 2, 2, 2};
		//int[] nums = new int[] {3, 4, 1, 2, 2, 2, 2, 2, 2};
		//int[] nums = new int[] {4, 5, 6, 7, 0, 0, 0, 1, 2, 2, 2};
		//int[] nums = new int[] {2, 2, 2, 2, 2, 2};
		//int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2, 3};
		//int[] nums = new int[] {2, 1};
		
		int target = 1;
		
		System.out.println("input nums = " + Util.printArray(nums) + ", target = " + target);
		
		boolean result = searchArray.search(nums, target);
		
		System.out.println("output = " + result);
	}
	
	//@Test 
	public void L0162_FindPeakElement() {
		L0162_FindPeakElement findPeak = new L0162_FindPeakElement();
		
		//int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2, 3};
		//int[] nums = new int[] {2, 1};
		int[] nums = new int[] {0, 2, 1};
		
		System.out.println("input nums = " + Util.printArray(nums));
		
		int result = findPeak.findPeakElement(nums);
		
		System.out.println("output = " + result);
	}
	
	//@Test 
	public void L0226_InvertBinaryTree() {
		L0226_InvertBinaryTree binaryTree= new L0226_InvertBinaryTree();
	

		List<String> strs = new ArrayList<String>();	
		strs.add("4");
		strs.add("2");		
		strs.add("1");		
		strs.add("#");
		strs.add("#");
		strs.add("3");
		strs.add("#");
		strs.add("#");
		strs.add("7");		
		strs.add("6");		
		strs.add("#");
		strs.add("#");
		strs.add("9");
		strs.add("#");
		strs.add("#");
		
		/**
		List<String> strs = new ArrayList<String>();	
		strs.add("1");
		strs.add("2");	
		strs.add("#");
		strs.add("#");
		strs.add("#");
		*/
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("input = " + BinaryTreeSerializer.serialize(root));
		
		TreeNode node = binaryTree.invertTree(root);
		
		System.out.println("output = " + BinaryTreeSerializer.serialize(node));
	}
	
	//@Test 
	public void L0042_TrappingRainWater() {
		L0042_TrappingRainWater water = new L0042_TrappingRainWater();
		
		int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println("input = " + Util.printArray(height));
		
		int max = water.trap(height);
		
		System.out.println("output = " + max);
	}
	
	//@Test 
	public void L0129_LongestConsecutiveSequence() {
		L0128_LongestConsecutiveSequence seq = new L0128_LongestConsecutiveSequence();
		
		//int[] nums = new int[] {100, 4, 200, 1, 3, 2};
		int[] nums = new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
		
		System.out.println("input = " + Util.printArray(nums));
		
		int max = seq.longestConsecutive(nums);
		
		System.out.println("output = " + max);		
	}
	
	//@Test 
	public void L0216_CombinationSumIII() {
		L0216_CombinationSumIII combSum = new L0216_CombinationSumIII();
		
		int k = 3, n = 9;
		
		System.out.println("input: k = " + k + ", n = " + n);
		
		List<List<Integer>> allList = combSum.combinationSum3(k, n);
		
		System.out.println("output = " + Util.printList(allList));		
	}
	
	//@Test 
	public void L0215_KthLargestInArray() {
		L0215_KthLargestInArray largeArray = new L0215_KthLargestInArray();
		
		int[] nums = new int[] { 3,2,1,5,6,4};
		
		int k = 2;
		
		System.out.println("input: k = " + k + ", nums = " + Util.printArray(nums));
		
		int num = largeArray.findKthLargest(nums, k);
		
		System.out.println("output = " + num);	
	}

	//@Test 
	public void L0120_Triangle() {
		L0120_Triangle minTotal = new L0120_Triangle();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(6);
		list3.add(5);
		list3.add(7);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);
		
		System.out.println("input: " + Util.printList(triangle));
		
		int min = minTotal.minimumTotal(triangle);
		
		System.out.println("output = " + min);	
	}
	
	//@Test 
	public void L0201_BitwiseAndOfNumberRange() {
		L0201_BitwiseAndOfNumberRange bitRange = new L0201_BitwiseAndOfNumberRange();
		
		int m = 1, n = 3;
		
		System.out.println("input: m= " + m + ", n = " + n);
		
		int result = bitRange.rangeBitwiseAnd(m, n);
		
		System.out.println("output = " + result);
	}
	
	//@Test 
	public void L0131_PalindromePartition() {
		L0131_PalindromePartition palinPartition = new L0131_PalindromePartition();
		
		String s = "aab";
		
		System.out.println("input: " + s);
		
		List<List<String>> result = palinPartition.partition(s);
		
		System.out.println("output = " + Util.printListString(result));
	}
	
	//@Test 
	public void L0051_nQueen() {
		L0051_nQueen queen = new L0051_nQueen();
		
		int n = 4;
		
		System.out.println("input: " + n);
		
		List<String[]> list = queen.solveNQueens(n);
		
		System.out.println("output = " + Util.printListStringArray(list));
	}
	
	//@Test 
	public void L0052_nQueenII() {
		L0052_nQueenII queen = new L0052_nQueenII();
		
		int n = 4;
		
		System.out.println("input: " + n);
		
		int count = queen.totalNQueens(n);
		
		System.out.println("output = " + count);
	}
	
	//@Test
	public void L0213_HouseRobberII() {
		L0213_HouseRobberII houserobberII = new L0213_HouseRobberII();
				
		//int[] nums = {7, 3, 6, 9, 1};
		int[] nums = {1};
		
		System.out.println("input: " + Util.printArray(nums));
		
		int result = houserobberII.rob(nums);
		
		System.out.println("output: " + result);	
	}
	
	//@Test 
	public void L0147_InsertionSortList() {
		L0147_InsertionSortList insertion = new L0147_InsertionSortList();
		
		//int nums[] = new int[] {7, 3, 6, 9, 1};
		int nums[] = new int[] {1};
		
		ListNode head = Util.createList(nums);
		
		System.out.println("input: " + Util.printList(head));
		
		ListNode newHead = insertion.insertionSortList(head);
		
		System.out.println("output: " + Util.printList(newHead));		
	}

	//@Test
	public void L0047_PermutationII() {
		L0047_PermutationII permutionII = new L0047_PermutationII();
		
		//int nums[] = new int[] {1, 1, 3};
		int nums[] = new int[] {-1, -1, 3, -1};
		
		System.out.println("input: " + Util.printArray(nums));
		
		List<List<Integer>> allList = permutionII.permuteUnique(nums);
		
		System.out.println("output: " + Util.printList(allList));
	}

	//@Test
	public void L0219_ContainDupII() {
		L0219_ContainDupII containDupII = new L0219_ContainDupII();

		int nums[] = new int[] {1, 2, 3, 4, 1};
		//int nums[] = new int[] {-1, -1, 3, -1};
		int k = 3;

		System.out.println("input: nums = " + Util.printArray(nums));
		System.out.println("input: k = " + k);

		boolean hasDup = containDupII.containsNearbyDuplicate(nums, k);

		System.out.println("output: " + hasDup);
	}
	
	// Test code not working, not sure why??
	//@Test
	public void L0037_Sudoku() {
		L0037_Sudoku sudoku = new L0037_Sudoku();

    	char[][] board = new char[9][];
    	
    	board[0] = new char[] {'5', '3', '.', '.', '7', '.', '.', '.', '.'}; 		
    	board[1] = new char[] {'6', '.', '.', '1', '9', '5', '.', '.', '.'}; 
    	board[2] = new char[] {'.', '9', '8', '.', '.', '.', '.', '.', '.'}; 
    	board[3] = new char[] {'8', '.', '.', '.', '6', '.', '.', '6', '3'}; 
    	board[4] = new char[] {'4', '.', '.', '8', '.', '3', '.', '.', '1'}; 
    	board[5] = new char[] {'7', '.', '.', '.', '2', '.', '.', '.', '6'}; 
    	board[6] = new char[] {'.', '6', '.', '.', '.', '.', '2', '8', '.'}; 
    	board[7] = new char[] {'.', '.', '.', '4', '1', '9', '.', '.', '5'}; 
    	board[8] = new char[] {'.', '.', '.', '.', '8', '.', '.', '7', '9'}; 

		System.out.println("input: " + Util.printCharMatrix(board));
				
		sudoku.solveSudoku(board);
		
		System.out.println("output: " + Util.printCharMatrix(board));
	}
	
	//@Test
	public void L0223_RectangleArea() {
		L0223_RectangleArea recArea = new L0223_RectangleArea();

		int A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2;
		//int A = -2, B = -2, C = 2, D = 2, E = -2, F = -2, G = 2, H = 2;

		int area = recArea.computeArea(A, B, C, D, E, F, G, H);

		System.out.println("output: " + area);
	}
	
	//@Test
	public void L0134_GasStation() {
		L0134_GasStation gasStation = new L0134_GasStation();

		/*
		int[] gas = new int[] {1,2,3,3};
		int[] cost = new int[] {2,1,5,1};
		*/
		
		int[] gas = new int[] {4};
		int[] cost = new int[] {5};
		
		int index = gasStation.canCompleteCircuit(gas, cost);

		System.out.println("output: " + index);
	}
	
	//@Test
	public void L0072_EditDistance() {
		L0072_EditDistance distance = new L0072_EditDistance();

		String word1 = "horse";
		String word2 = "ros";
		
		int dis = distance.minDistance(word1, word2);
		System.out.println("output: " + dis);
	}
	
	//@Test
	public void L0203_RemoveLLElement() {
		L0203_RemoveLLElement removeLL = new L0203_RemoveLLElement();

		//int[] nums = new int[] {1, 2, 6, 3, 4, 5, 6};
		int[] nums = new int[] {6, 1};
		ListNode head = Util.createList(nums);
		
		int val = 6;
		
		System.out.println("input = " + Util.printList(head));
		
		ListNode node = removeLL.removeElements(head, val);
		
		System.out.println("output: " + Util.printList(node));
	}
	
	//@Test
	public void L0115_DistinctSubsequence() {
		L0115_DistinctSubsequence distSubsequence = new L0115_DistinctSubsequence();

		//String s = "rabbbit";
		//String t = "rabbit";
		
		// "ACE" is a subsequence of "ABCDE" while "AEC"
		String s = "ABCDE";
		String t = "AEC";
		
		System.out.println("input s = " + s + ", t = " + t);
		
		int distance = distSubsequence.numDistinct(s, t);
		
		System.out.println("output: " + distance);
	}
	
	//@Test
	public void L0205_IsomorphicString() {
		L0205_IsomorphicString isomorphic = new L0205_IsomorphicString();

		//String s = "foo";
		//String t = "bar";

		//String s = "paper";
		//String t = "title";
		
		//String s = "egg";
		//String t = "add";
		
		String s = "ab";
		String t = "aa";
		
		System.out.println("input s = " + s + ", t = " + t);
		
		boolean isisomorphic= isomorphic.isIsomorphic(s, t);
		
		System.out.println("output: " + isisomorphic);
	}
	
	//@Test
	public void L0138_CopyListRandowPointer() {
		L0138_CopyListRandowPointer copyList = new L0138_CopyListRandowPointer();

		/*
		int[] nums = new int[] {1, 2, 3, 4, 5};

		RandomListNode head = Util.createListRandom(nums);
		Util.connectListRandom(head, 2, 1);
		Util.connectListRandom(head, 3, 5);
		*/
		
		/*
		int[] nums = new int[] {1, 2};

		RandomListNode head = Util.createListRandom(nums);
		Util.connectListRandom(head, 1, 2);
		Util.connectListRandom(head, 2, 2);
		*/
		
		int[] nums = new int[] {-1};

		RandomListNode head = Util.createListRandom(nums);
		Util.connectListRandom(head, -1, -1);
		
		System.out.println("input = " + Util.printListRandom(head));
		
		RandomListNode node = copyList.copyRandomList(head);
		
		System.out.println("output: " + Util.printListRandom(node));
	}
	
	//@Test
	public void L0087_ScrambleString() {
		L0087_ScrambleString scramble = new L0087_ScrambleString();

		/*
		String s1 = "abbbcbaaccacaacc";
		String s2 = "acaaaccabcabcbcb";
		*/
		
		/*
		String s1 = "hobobyrqd";
		String s2 = "hbyorqdbo";
		*/
		
		String s1 = "abcdefghijklmnopq";
		String s2 = "efghijklmnopqcadb";
		
		/*
		String s1 = "great";
		String s2 = "rgeat";
		*/
		System.out.println("input s1 = " + s1 + ", s2 = " + s2);
		
		boolean isScramble= scramble.isScramble(s1, s2);
		
		System.out.println("output: " + isScramble);
	}
	
	//@Test
	public void L0228_SummaryRange() {
		L0228_SummaryRange summary = new L0228_SummaryRange();

		int[] nums = new int[] {0, 1, 2, 4, 5, 7};
		//int[] nums = new int[] {-1};
		//int[] nums = new int[] {-2147483648, -2147483647, 2147483647};
		
		System.out.println("input: " + Util.printArray(nums));
		
		List<String> list = summary.summaryRanges(nums);
		
		System.out.println("output: " + list);
	}
	
	//@Test
	public void L0204_CountPrime() {
		L0204_CountPrime prime = new L0204_CountPrime();

		int n = 1500000;
		
		System.out.println("input: " + n);
		
		int count = prime.countPrimes(n);
		
		System.out.println("output: " + count);
	}
	
	//@Test
	public void L0139_WordBreak() {
		L0139_WordBreak wordBreak = new L0139_WordBreak();

		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		wordDict.add("a");
		wordDict.add("b");
		wordDict.add("bbb");
		wordDict.add("bbbb");
		
		//String s = "leetcode";
		//String s = "abc";
		//String s = "a";
		String s = "bb"; 
		
		System.out.println("input: " + s);
		
		boolean isBreak = wordBreak.wordBreak(s, wordDict);
		
		System.out.println("output: " + isBreak);
	}
	
	//@Test
	public void L0140_WordBreakII() {
		L0140_WordBreakII wordBreak = new L0140_WordBreakII();
				 
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		wordDict.add("a");
		wordDict.add("b");
		wordDict.add("bbb");
		wordDict.add("bbbb");
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		wordDict.add("catsanddog");
		
		String s = "catsanddog";
		//String s = "leetcode";
		//String s = "abc";
		//String s = "a";
		//String s = "bb"; 
		//String s = "ab";
		
		System.out.println("input: " + s);
		
		List<String> list = wordBreak.wordBreak(s, wordDict);
		
		System.out.println("output: " + list);
	}
	
	//@Test
	public void L0229_MajorityElementII() {
		L0229_MajorityElementII majorElemII = new L0229_MajorityElementII();
				 
		//int[] nums = new int[] {1, 2, 1, 4, 5, 6};
		int[] nums = new int[] {0, 3, 4, 0};
		
		System.out.println("input: " + Util.printArray(nums));
		
		List<Integer> list = majorElemII.majorityElement(nums);
		
		System.out.println("output: " + list);
	}
	
	//@Test
	public void Trie() {
		Trie trie = new Trie();
		
		trie.insert("a");
		boolean foundKey = trie.search("abcde");
		boolean foundPrefix = trie.startsWith("a");
		
		System.out.println("foundKey: " + foundKey);
		System.out.println("foundPrefix: " + foundPrefix);
	}
	
	//@Test
	public void WordDictionary() {
		WordDictionary wd = new WordDictionary();
		
		wd.addWord("abcd");
		boolean foundKey = wd.search("....");
		
		System.out.println("foundKey: " + foundKey);
	}
	
	@Test
	public void L0212_WordSearchII() {
		L0212_WordSearchII wdSearchII = new L0212_WordSearchII();
		

		String[] words = new String[] {"oath","pea","eat","rain"};
		    		
		char[][] board = new char[4][];
		board[0] = new char[] {'o','a','a','n'};
		board[1] = new char[] {'e','t','a','e'};
		board[2] = new char[] {'i','h','k','r'};
		board[3] = new char[] {'i','f','l','v'};

		/**
		String[] words = new String[] {"a"};
		
		char[][] board = new char[1][];
		board[0] = new char[] {'a', 'a'};
		**/
		
		List<String> list = wdSearchII.findWords(board, words);
		
		System.out.println("output = " + list);
	}
}
