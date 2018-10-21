package com.leetcode.zyang;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSuite5 {

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
	public void L0532_KdiffPairsInArray() {
		L0532_KdiffPairsInArray l0532 = new L0532_KdiffPairsInArray();
		
		//int[] nums = {3, 1, 4, 1, 5};
		//int[] nums = {1, 2, 3, 4, 5};
		//int[] nums = {1, 3, 1, 5, 4};
		int[] nums = {1, 1, 1, 3, 1, 5, 4, 3, 3};
		//int k = 2;
		//int k = 1;
		int k = 0;
		
		int pairs = l0532.findPairs(nums, k);
		System.out.print(pairs);
	}
	
	//@Test
	public void L0538_ConvertBSTtoGreaterTree() {
		L0538_ConvertBSTtoGreaterTree l0538 = new L0538_ConvertBSTtoGreaterTree();
		
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(15);
		
		l0538.convertBST(root);
		
		System.out.print(BinaryTreeSerializer.serialize(root));
	}
	
	
	//@Test
	public void L0541_ReverseStringII() {
		L0541_ReverseStringII l0541 = new L0541_ReverseStringII();

		String in = "abcdef";
		int k = 2;
		
		String result = l0541.reverseStr(in, k);
		
		System.out.print(result);
	}
		
	//@Test
	public void L0543_DiameterBinaryTree() {
		L0543_DiameterBinaryTree l0543 = new L0543_DiameterBinaryTree();
		
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		int max = l0543.diameterOfBinaryTree(root);
		
		System.out.print(max);
	}
	
	
	//@Test
	public void L0551_StudentAttendanceRecordI() {
		L0551_StudentAttendanceRecordI l0551 = new L0551_StudentAttendanceRecordI();
		
		//String s = "PPALLP";
		String s = "PPALLL";
		boolean result = l0551.checkRecord(s);
		
		System.out.print(result);
	}
	
	
	@Test
	public void L0566_ReshapeMatrix() {
		L0566_ReshapeMatrix l0566 = new L0566_ReshapeMatrix();
		
		int[][] nums = new int[2][];
		nums[0] = new int[] {1, 2};
		nums[1] = new int[] {3, 4};
		int r = 1; 
		int c = 4;
			
		int[][] result = l0566.matrixReshape(nums, r, c);
		
		System.out.print(Util.printMatrix(result));
	}
}
