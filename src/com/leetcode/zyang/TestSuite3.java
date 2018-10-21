package com.leetcode.zyang;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSuite3 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Test
	public void test() {
		fail("Not yet implemented");
	}

	//@Test
	public void L0561_ArrayPartitionI(){
		L0561_ArrayPartitionI arrayPartitionI = new L0561_ArrayPartitionI();

		int[] nums = {1,4,3,2};

		int result = arrayPartitionI.arrayPairSum(nums);

		System.out.println("input = " + Util.printArray(nums) + ", output = " + result);
	}
	
	//@Test
	public void L0461_HammingDistance() {
		L0461_HammingDistance hDist = new L0461_HammingDistance();
		
		int x = 1;
		int y = 4;
		int result = hDist.hammingDistance(x, y);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0557_ReserveWordsInStringIII() {
		L0557_ReserveWordsInStringIII reverse = new L0557_ReserveWordsInStringIII();
		
		String s = "Let's take LeetCode contest";
		
		String result = reverse.reverseWords(s);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0476_NumberComplement() {
		L0476_NumberComplement numComp = new L0476_NumberComplement();
		
		int num = 8;
		
		int result = numComp.findComplement(num);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0500_KeywordRow() {
		L0500_KeywordRow keyRow = new L0500_KeywordRow();
		
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		
		String[] result = keyRow.findWords(words);
		
		System.out.println(Util.printStringArray(result));
	}
	
	//@Test
	public void L0412_FizzBuzz() {
		L0412_FizzBuzz fizzBuzz = new L0412_FizzBuzz();
		
		int n = 15;
		List<String> result = fizzBuzz.fizzBuzz(n);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0344_ReverseString() {
		L0344_ReverseString rs = new L0344_ReverseString();
		
		String s = "Hello";
		
		String result = rs.reverseString(s);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0496_NextGreaterElementI() {
		L0496_NextGreaterElementI next = new L0496_NextGreaterElementI();
		
		int[] findNums = {4,1,2};
		int[] nums = {1,3,4,2};
		
		//int[] findNums = {2,4};
		//int[] nums = {1,2,3,4};
				
		int[] result = next.nextGreaterElement(findNums, nums);
		
		System.out.println(Util.printArray(result));
	}
	
	//@Test
	public void L0463_IslandPerimeter() {
		L0463_IslandPerimeter peri = new L0463_IslandPerimeter();
		
		int[][] grid = new int[4][];
		
		grid[0] = new int[] {0,1,0,0}; 
		grid[1] = new int[] {1,1,1,0}; 
		grid[2] = new int[] {0,1,0,0}; 
		grid[3] = new int[] {1,1,0,0};
		
		int result = peri.islandPerimeter(grid);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0485_MaxConsecutiveOnes() {
		L0485_MaxConsecutiveOnes maxConsecutive = new L0485_MaxConsecutiveOnes();
		
		int[] nums = {1,1,0,1,1,1};
		int result = maxConsecutive.findMaxConsecutiveOnes(nums);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0520_DetectCapital() {
		L0520_DetectCapital detect = new L0520_DetectCapital();
		
		//String word =  "USA";
		//String word =  "FlaG";
		String word = "FFFFFFFFFFFFFFFFFFFFf";
		boolean result = detect.detectCapitalUse(word);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0448_FindAllNumbers() {
		L0448_FindAllNumbers missing = new L0448_FindAllNumbers();
		
		int[] nums = {4,3,2,7,8,2,3,1};
		
		List<Integer> result = missing.findDisappearedNumbers(nums);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0389_FindDifference() {
		L0389_FindDifference findDiff = new L0389_FindDifference();
		
		String s = "abcd";
		String t = "decab";
		
		char result = findDiff.findTheDifference(s, t);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0521_LongestUncommonSubsequenceI() {
		L0521_LongestUncommonSubsequenceI longUncommon = new L0521_LongestUncommonSubsequenceI();
		
		String a = "abc";
		String b = "ecre";
		int len = longUncommon.findLUSlength(a, b);
		
		System.out.println(len);
	}
	
	//@Test 
	public void L0371_SumOfTwoIntegers() {
		L0371_SumOfTwoIntegers sumOfTwo = new L0371_SumOfTwoIntegers();
		
		int a = -3;
		int b = -1;
		int sum = sumOfTwo.getSum(a, b);
		
		System.out.println(sum);
	}
	
	//@Test
	public void L0492_ConstructRectangle() {
		L0492_ConstructRectangle rec = new L0492_ConstructRectangle();
		
		int area = 12;
		
		int[] result = rec.constructRectangle(area);
		
		System.out.println(Util.printArray(result));
	}
	
	
	//@Test
	public void L0563_BinaryTreeTilt() {
		
		L0563_BinaryTreeTilt bTree = new L0563_BinaryTreeTilt();
		
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

		
		/*
		strs.add("1");
		strs.add("2");
		strs.add("#");
		strs.add("#");
		strs.add("3");
		strs.add("#");
		strs.add("#");
		*/
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("Tree = " + BinaryTreeSerializer.serialize(root));
		
		int result = bTree.findTilt(root);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0530_MinAbsDiffInBST() {		
		/*
		 *         _______6______
		 *        /              \
		 *     ___2__          ___8__
		 *    /      \        /      \
		 *    0      _4       7       9
		 *          /  \
		 *          3   5
		 */
		L0530_MinAbsDiffInBST minDiff = new L0530_MinAbsDiffInBST();
		
		CreateBinarySearchTree bTree = new CreateBinarySearchTree();
		//bTree.add(6, 2, 8, 0, 4, 7, 9, 3, 5);
		bTree.add(1, 3, 2);
		
		int result = minDiff.getMinimumDifference(bTree.root);
		
		System.out.println(bTree.toString());
		System.out.println(result);
	}
	
	//@Test
	public void L0388_LongestAbsoluteFilePath() {
		L0388_LongestAbsoluteFilePath longPath = new L0388_LongestAbsoluteFilePath();
		
		//String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		
		int result = longPath.lengthLongestPath(input);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0482_LicenseKeyFormatting() {
		L0482_LicenseKeyFormatting lic = new L0482_LicenseKeyFormatting();
		
		String S = "2-4A0r7-4k";
		int K = 3;
		
		String result = lic.licenseKeyFormatting(S, K);
		
		System.out.println(result);
	}
	
	//@Test 
	public void L0395_DecodeString() {
		L0395_DecodeString decode = new L0395_DecodeString();
		
		//String s = "3[a]2[bc]";  // "aaabcbc". 
		//String s = "3[a2[c]]";  // "accaccacc"
		//String s = "2[abc]3[cd]ef"; // "abcabccdcdcdef"
		String s = "100[leetcode]";
		
		String result = decode.decodeString(s);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0200_NumberOfIslands() {
		L0200_NumberOfIslands islands = new L0200_NumberOfIslands();

		char[][] grid = new char[4][];		
		/* 11110
		 * 11010
		 * 11000
		 * 00000
		 * Answer: 1
		 */	
		/*
		grid[0] = new char[]{'1', '1', '1', '1', '0'};
		grid[1] = new char[]{'1', '1', '0', '1', '0'};
		grid[2] = new char[]{'1', '1', '0', '0', '0'};			
		grid[3] = new char[]{'0', '0', '0', '0', '0'};
	*/
		/* Example 2:
		 * 11000
		 * 11000
		 * 00100
		 * 00011
		 */

		grid[0] = new char[]{'1', '1', '0', '0', '0'};
		grid[1] = new char[]{'1', '1', '0', '0', '0'};
		grid[2] = new char[]{'0', '0', '1', '0', '0'};			
		grid[3] = new char[]{'0', '0', '0', '1', '1'};	

		
		int result = islands.numIslands(grid);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0393_UTF8Validation() {
		L0393_UTF8Validation utf = new L0393_UTF8Validation();
		
		//int[] data = {197, 130, 1};
		//int[] data = {235, 140, 4};
		//int[] data = {255};
		int[] data = {248,130,130,130};
		
		boolean result = utf.validUtf8(data);
		
		System.out.println(result);
	}
	
	//@Test
	public void L0406_QueueReconstructionByHeight() {
	/*
	* Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	* 
	* Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	* 
	*/
		L0406_QueueReconstructionByHeight queue = new L0406_QueueReconstructionByHeight();
		
		int people[][] = new int[][] {
				{7, 0},
				{4, 4},
				{7, 1},
				{5, 0},
				{6, 1},
				{5, 2}			
			};
		
		int[][] result = queue.reconstructQueue(people);
		
		System.out.println(Util.printMatrix(result));		
	}
	
	//@Test
	public void L0345_ReverseVowelsInString() {
		L0345_ReverseVowelsInString reverse = new L0345_ReverseVowelsInString();
		//String s = "hello"; // "holle".
		String s = "leetcode"; // "leotcede"
		
		String result = reverse.reverseVowels(s);
		
		System.out.println(result);
	}
	
	@Test
	public void L0417_PacificAtlanticWaterFlow() {
		L0417_PacificAtlanticWaterFlow flow = new L0417_PacificAtlanticWaterFlow();
		
		int[][] matrix = new int[][] { 	{1, 2, 2, 3, 5}, 
										{3, 2, 3, 4, 4},
										{2, 4, 5, 3, 1},
										{6, 7, 1, 4, 5},
										{5, 1, 1, 2, 4}
		
										};
		
		List<int[]> result = flow.pacificAtlantic(matrix);
		
		StringBuilder sb = new StringBuilder();
		for (int[] point : result) 
			sb.append(Util.printArray(point));
		
		System.out.println(sb.toString());
	}
	
}
