package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * click to show more practice.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 * Show Tags
 * 
 */
public class L0053_MaxSubarray {

	public L0053_MaxSubarray() {
		// TODO Auto-generated constructor stub
	}

    public int maxSubArray(int[] nums) {
    	int n = nums.length;
    	
    	if (n == 0)
    		return 0;
    	
    	if (n == 1)
    		return nums[0];
    	
    	int max = nums[0];
    	int prevSum = nums[0];
    	for (int i = 1; i < n; i++) {
    		if (prevSum <=0)
    			prevSum = nums[i];
    		else
    			prevSum = prevSum + nums[i];
    	
    		if (prevSum > max) 
    			max = prevSum;
    	}
    		
        return max;
    }
}
