package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class L0041_FirstMissingPositive {

	public L0041_FirstMissingPositive() {
		// TODO Auto-generated constructor stub
	}
    
	// leetcode version
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
        	return 1;
        
        int n = nums.length;
        int i = 0;
        while (i < n) {
        	if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] >= n) {
        		i++;
        		continue;
        	}     	
        	else if (nums[nums[i] - 1] != nums[i]) {	        	
	        	// place num into the right position
	        	int tmp = nums[nums[i] - 1];
	        	nums[nums[i] - 1] = nums[i];
	        	nums[i] = tmp;
        	}
        	else
        		i++;
        }
        
        for (int j = 0; j < n; j++) 
        	if (nums[j] != j + 1) 
        		return j + 1;        
        
        return n + 1;
    }
    
    // my own version works
    public int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0)
        	return 1;
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
        	if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] >= n) 
        		continue;
        	
        	// place num into the right position
        	int num = nums[i];
        	while (num - 1 >= 0 && num - 1 < n) {
        		if (nums[num - 1] == num)
        			break;
        		
	        	int tmp = nums[num - 1];
	        	nums[num - 1] = num;
	        	num = tmp;
        	}
        }
        
        for (int i = 0; i < n; i++) 
        	if (nums[i] != i + 1) 
        		return i + 1;        
        
        return n + 1;
    }
}
