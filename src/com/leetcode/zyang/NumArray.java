package com.leetcode.zyang;

import java.util.Arrays;

/**
 * 
 * @author zyang
 * 
 * Leetcode 303
 * 
 *         Given an integer array nums, find the sum of the elements between
 *         indices i and j (i ≤ j), inclusive.
 * 
 *         Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 *         sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 Note:
 *         You may assume that the array does not change. There are many calls
 *         to sumRange function.
 */
public class NumArray {
	
	private int[] sum;
	
    public NumArray(int[] nums) {
    	sum = new int[nums.length];
    	if (nums.length >= 1) {	    	
	    	sum[0] = nums[0];
	        for (int i = 1; i < nums.length; i++) 
	        	sum[i] = nums[i] + sum[i -1];
    	}
    }

    public int sumRange(int i, int j) {
        if (sum.length < 1 || sum.length <= j || i < 0)
        	return Integer.MIN_VALUE;
        
        if (i == 0)
        	return sum[j];
        
        return sum[j] - sum[i -1];
    }
}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);