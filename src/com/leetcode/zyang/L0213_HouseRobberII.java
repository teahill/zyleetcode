package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Note: This is an extension of House Robber.
 * 
 * After robbing those houses on that street, the thief has 
 * found himself a new place for his thievery so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. 
 *  means the first house is the neighbor of the last one. Meanwhile, 
 *  security system for these houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money 
 * of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class L0213_HouseRobberII {

	public L0213_HouseRobberII() {
		// TODO Auto-generated constructor stub
	}

	// break the circle into straight problems
    public int rob(int[] nums) {
    	int max = 0;
    	int len = nums.length;
    	if (len == 0)
    		return max;
    	
    	if (len == 1)
    		return nums[0];
    	
        // case 1: house 0 is not robbed, case 2: house n-1 is not robbed
    	max = Math.max(robStraight(nums, 1, len - 1), robStraight(nums, 0, len - 2));
    	
    	return max;
    }
    
    // break the problem into smaller ones. DP
    private int robStraight(int[] nums, int start, int end) {
    	int max = 0;    	
    	int curYes = 0; 
    	int curNo = 0; 
    	int prevYes = 0;
    	int prevNo = 0;
    	
    	for (int i = start; i <= end; i++) {
    		curYes = prevNo + nums[i];
    		curNo = Math.max(prevYes, prevNo);   
    		
    		prevYes = curYes;
    		prevNo = curNo;
    	}
    	
    	max = Math.max(curYes, curNo);
    	
    	return max;
    }
}
