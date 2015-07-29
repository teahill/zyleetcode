package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class L0209_MinimumSizeSubarraySum {

	public L0209_MinimumSizeSubarraySum() {
		// TODO Auto-generated constructor stub
	}

	// use two pointers
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
        	return 0;
        
        int sum = 0;
        int min = 0;
        int n = 0;
        int ptr2 = 0;
        for (int ptr1 = 0; ptr1 < nums.length; ptr1++) {
        	sum += nums[ptr1];
        	n++;
        	if (sum < s) 
        		continue;
        	else {
        		min = (min == 0) ? n : min;
        		while (sum - nums[ptr2] >= s && ptr2 <= ptr1) {
        			sum = sum - nums[ptr2];
        			ptr2++;
        			n--;
        		}
        		
        		min = (n < min) ? n : min;        			
        	}
        }
        
        return min;
    }
}
