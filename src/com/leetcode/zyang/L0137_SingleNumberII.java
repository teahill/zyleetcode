package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it 
 * without using extra memory?
 */
public class L0137_SingleNumberII {

	public L0137_SingleNumberII() {
		// TODO Auto-generated constructor stub
	}

	// rewrite the number in binary
	// add up the digits at the same position from all nums
	// modulo 3 cancels the elements with 3 appearances and leaves the element that appears only once 
    public int singleNumber(int[] nums) {
    	int result = 0;
        int[] sum = new int[32];
        int len = nums.length;
        
        for (int i = 0; i < 32; i++) {
        	for (int j = 0; j < len; j++) 
        		sum[i] += (nums[j]>>i) & 1;
        	sum[i] = sum[i]%3;
        	
        	result += sum[i]<<i;
        }
        
        return result;
    }
}
