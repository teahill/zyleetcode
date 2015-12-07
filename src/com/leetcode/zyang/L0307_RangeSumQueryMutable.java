package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given an integer array nums, find the sum of the elements between
 *         indices i and j (i ≤ j), inclusive.
 * 
 *         The update(i, val) function modifies nums by updating the element at
 *         index i to val. Example: Given nums = [1, 3, 5]
 * 
 *         sumRange(0, 2) -> 9 update(1, 2) sumRange(0, 2) -> 8 
 *         
 *         Note: The array is only modifiable by the update function. 
 *         You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class L0307_RangeSumQueryMutable {
	private int[] nums;
	private int[] sum;
	
	// O(n), TLE
    public L0307_RangeSumQueryMutable(int[] nums) {
        this.nums = nums;    	
        if (nums == null || nums.length == 0)
    		return;
        
        sum = new int[nums.length];
        sum[0] = nums[0];        
		for (int i = 1; i < nums.length; i++) 
			sum[i] = sum[i - 1] + nums[i];
    }

    void update(int i, int val) {
    	if (i < 0 || i > nums.length - 1)
    		return;
    	
    	for (int k = i; k < sum.length; k++) 
    		sum[k] += val - nums[i];     
    	
    	nums[i] = val;
    }

    public int sumRange(int i, int j) {
    	if (i < 0 || j > nums.length - 1 || i > j)
    		return Integer.MIN_VALUE;
    	
        if (i == 0)
        	return sum[j];
        
        return sum[j] - sum[i - 1];
    }
}
