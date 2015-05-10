package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you 
 * from robbing each of them is that adjacent houses have security system connected 
 * and it will automatically contact the police if two adjacent houses were broken into 
 * on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 */
public class L0198_HouseRobber {

	public L0198_HouseRobber() {
		// TODO Auto-generated constructor stub
	}

    public int rob(int[] nums) {    	
    	int curYes = 0, curNo = 0, prevYes = 0, prevNo = 0;    
    	
    	for (int i = 0; i < nums.length; i++) {    		
    		curYes = prevNo + nums[i];    		
    		curNo = Integer.max(prevYes, prevNo);
    		
    		prevYes = curYes;
    		prevNo = curNo;
    	}
    	
    	return Integer.max(curYes, curNo);
    }
}
