/**
 * 
 */
package com.leetcode.zyang;

import static org.junit.Assert.*;

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
	
	@Test
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

}
