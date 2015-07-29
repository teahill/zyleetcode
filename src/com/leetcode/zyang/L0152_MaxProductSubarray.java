package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class L0152_MaxProductSubarray {

	public L0152_MaxProductSubarray() {
		// TODO Auto-generated constructor stub
	}

	// DP, time O(n), space O(1)
    public int maxProduct(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return 0;
    	
    	int gMax = nums[0];
    	int min = nums[0];
    	int max = nums[0];    	
    	for (int i = 1; i < nums.length; i++) {
			int preMax = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(min * nums[i], preMax * nums[i]), nums[i]);
			if (max > gMax) 
				gMax = max;
			
			/* more verbose solution
    		if (nums[i] > 0) {
    			max = Math.max(max * nums[i], nums[i]);
    			min = Math.min(min * nums[i], nums[i]);
    			if (max > gMax) 
    				gMax = max;
    		}
    		else {
    			max = Math.max(min * nums[i], nums[i]);
    			min = Math.min(preMax * nums[i], nums[i]);
    			if (max > gMax) 
    				gMax = max;
    		}  
    		*/  			
    	}
    	
    	return gMax;
    }
    
	// DP, time O(n^2), space O(n^2), TLE
    public int maxProduct1(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return 0;
    	
    	int max = Integer.MIN_VALUE;
    	int n = nums.length;
    	int[][] product = new int[n][];
    	for (int i = 0; i < n; i++) {
    		product[i] = new int[n];
    		product[i][i] = nums[i];
    		max = Math.max(max, product[i][i]);
    	}
    	
        for (int ptr1 = 1; ptr1 < n; ptr1++) {
        	for (int ptr2 = 0; ptr2 < ptr1; ptr2++) {
        		product[ptr1][ptr2] = product[ptr1 - 1][ptr2] * nums[ptr1];
        		max = Math.max(max, product[ptr1][ptr2]);
        	}
        }
        
        return max;
    }
}
