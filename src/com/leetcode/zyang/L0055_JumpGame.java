package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 *  Array Greedy
 */
public class L0055_JumpGame {

	public L0055_JumpGame() {
		// TODO Auto-generated constructor stub
	}

	//from leetcode
	public boolean canJump(int[] nums) {
	    int n=nums.length;
	    
	    // From pos 0, the max steps it can jump for every pos currently within reach
	    // if max steps increase, then update and continuously check if max steps will increase further
	    int maxSteps = nums[0];
	    for(int i = 1; i <= n - 1; i++)
	    {
	    	// If the max steps it can reach falls short of array
	        if(maxSteps < i)
	        	return false;
	        	        
	        //Update maxSteps if a bigger one is found
	        maxSteps = maxSteps > i + nums[i] ? maxSteps : i + nums[i];
	        
	        if (maxSteps >= n - 1)
	        	return true;
	    }
	    
	    return true;
	}
	
	// from leetcode
	// Idea is to work backwards from the last index. Keep track of the smallest index that can "jump" to the last index. 
	// Check whether the current index can jump to this smallest index.
	boolean canJump2(int A[], int n) {
	    int last=n-1,i,j;
	    for(i=n-2;i>=0;i--){
	        if(i+A[i]>=last)last=i;
	    }
	    return last<=0;
	}
	
	//Runtime Error Message:	Line 25: java.lang.StackOverflowError
	//Last executed input:	[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1.......]
	// Backtracking recursive does not work!
    public boolean canJump1(int[] nums) {
    	int n = nums.length;
    	
    	if (n == 0 || n == 1)
    		return true;
    	
    	boolean result = canJumpRecur(nums, 0);
        
    	return result;
    }
    
    public boolean canJumpRecur(int[] nums, int pos) {
    	int n = nums.length;

    	if (nums[pos] == 0 && pos != n - 1)
    		return false;
    		
    	if (pos + nums[pos] >= n - 1)
    		return true;
    		
    	boolean result = false;
		for (int i = 1; i <= nums[pos]; i++) {
			pos = pos + i;
			result = canJumpRecur(nums, pos);
			
			if (result)
				return result;
		}
        
    	return result;
    }
}
