package com.leetcode.zyang;

/**
 * @author zyang
 * 
 *         Given an array nums, write a function to move all 0's to the end of
 *         it while maintaining the relative order of the non-zero elements.
 * 
 *         For example, given nums = [0, 1, 0, 3, 12], after calling your
 *         function, nums should be [1, 3, 12, 0, 0].
 * 
 *         Note: You must do this in-place without making a copy of the array.
 *         Minimize the total number of operations.
 */
public class L0283_MoveZeros {

	public L0283_MoveZeros() {
		// TODO Auto-generated constructor stub
	}

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
        	return;
        
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr1 < nums.length) {
        	if (nums[ptr1] != 0) {
        		nums[ptr2] = nums[ptr1];
        		ptr2++;
         	}
        	
        	ptr1++;       	
        }
        
        while (ptr2 < nums.length) 
        	nums[ptr2++] = 0;
    }
}
