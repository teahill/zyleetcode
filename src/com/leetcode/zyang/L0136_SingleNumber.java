package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using 
 * extra memory?
 */
public class L0136_SingleNumber {

	public L0136_SingleNumber() {
		// TODO Auto-generated constructor stub
	}

	
    public int singleNumber(int[] nums) {
        int result = 0;
        
        if (nums == null || nums.length == 0)
        	return result;
        
        for (int i = 0; i < nums.length; i++) 
        	result = result ^ nums[i];
        	
        return result;	
    }
}
