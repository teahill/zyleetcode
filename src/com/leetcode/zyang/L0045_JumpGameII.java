package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, 
 * then 3 steps to the last index.)
 * 
 */
public class L0045_JumpGameII {

	public L0045_JumpGameII() {
		// TODO Auto-generated constructor stub
	}

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2)
        	return 0;
        
        int count = 0;
        int last_jump_max = 0;
        int cur_jump_max = 0;        
        for (int i = 0; i < nums.length - 1; i++) {
        	cur_jump_max = Math.max(cur_jump_max, i + nums[i]);
        	
        	if (i == last_jump_max) {
        		if (cur_jump_max == last_jump_max)
        			return -1;
        		
        		count++;        		
        		last_jump_max = cur_jump_max;
        	}
        	/*
        	if (cur_jump_max >= nums.length - 1)
        		break;
        	*/
        }

    	return count;
    }
}
