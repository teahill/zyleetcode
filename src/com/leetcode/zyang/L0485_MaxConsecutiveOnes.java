package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given a binary array, find the maximum number of consecutive 1s in
 *         this array.
 * 
 *         Example 1: Input: [1,1,0,1,1,1] Output: 3 Explanation: The first two
 *         digits or the last three digits are consecutive 1s. The maximum
 *         number of consecutive 1s is 3. Note:
 * 
 *         The input array will only contain 0 and 1. The length of input array
 *         is a positive integer and will not exceed 10,000
 *         
 */
public class L0485_MaxConsecutiveOnes {
	//8ms, 96%
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length < 1)
        	return 0;
        
        int max = 0;
        int local = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 1)
        		local++;
        	else {
        		max = Math.max(local, max);
        		local = 0;
        	}       	
        }
         
        return Math.max(local, max);
    }
}
