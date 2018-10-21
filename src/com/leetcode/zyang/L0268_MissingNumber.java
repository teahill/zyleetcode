package com.leetcode.zyang;

/**
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
 * the one that is missing from the array.
 * 
 * For example, Given nums = [0, 1, 3] return 2.
 * 
 * Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 */
public class L0268_MissingNumber {

	public L0268_MissingNumber() {
		// TODO Auto-generated constructor stub
	}

	// 3rd method: swap numbers into the position of its value
	// bit operation
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
        	return 0;
        
        int result = 0;
        for (int i = 0; i < nums.length; i++) 
        	result ^= nums[i] ^ i;
        
        return result ^ nums.length;
    }
    
	// Math
    public int missingNumber1(int[] nums) {
        if (nums == null || nums.length == 0)
        	return 0;
        
        int total = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) 
        	total -= nums[i];
        
        return total;
    }
}
