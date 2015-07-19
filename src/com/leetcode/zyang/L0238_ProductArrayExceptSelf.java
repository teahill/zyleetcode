package com.leetcode.zyang;
/**
 * 
 * @author zyang
 * 
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] 
 * is equal to the product of all the elements of nums except nums[i].
 * 
 * Solve it without division and in O(n).
 * 
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count 
 * as extra space for the purpose of space complexity analysis.)
 * 
 */
public class L0238_ProductArrayExceptSelf {

	public L0238_ProductArrayExceptSelf() {
		// TODO Auto-generated constructor stub
	}

    public int[] productExceptSelf(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return null;
    	
    	int len = nums.length;
        int[] output = new int[len]; 
        output[0] = 1;
        for (int i = 1; i < len; i++) 
        	output[i] = output[i - 1] * nums[i - 1];
           
        int multiplier = 1;
        for (int i = len - 2; i >= 0; i--) {
        	multiplier *= nums[i + 1];
        	output[i] *= multiplier;
        }
        
        return output;
    }
}
