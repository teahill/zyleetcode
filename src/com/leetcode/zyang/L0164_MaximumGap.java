package com.leetcode.zyang;

import java.util.Arrays;

/**
 * 
 * @author zyang
 * 
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class L0164_MaximumGap {

	public L0164_MaximumGap() {
		// TODO Auto-generated constructor stub
	}

	// bucket sort
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1)
        	return 0;
        
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        
        // find min and max of array
        for (int i = 0; i < n; i++) {
        	min = Math.min(min, nums[i]);
        	max = Math.max(max, nums[i]);        	
        }
        
        // find minimum possible max gap
        int gap = (int) Math.ceil((double)(max - min) / (n -1));
        int[] bucketMax = new int[n - 1];
        int[] bucketMin = new int[n - 1];        
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);        
        
        // fill the buckets
        for (int i = 0; i < n; i++) {
        	if (nums[i] == min || nums[i] == max)
        		continue;
        	
        	int k = (nums[i] - min) / gap;        	
        	bucketMax[k] = Math.max(nums[i], bucketMax[k]);
        	bucketMin[k] = Math.min(nums[i], bucketMin[k]);
        }
        
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int k = 0; k < n - 1; k++) {
        	// empty basket
        	if (bucketMax[k] == Integer.MIN_VALUE && bucketMin[k] == Integer.MAX_VALUE)
        		continue;
        	
        	// current min subtract the previous max
        	maxGap = Math.max(bucketMin[k] - previous, maxGap);
        	previous = bucketMax[k];
        }
        
        // update the final max gap
        maxGap = Math.max(max - previous, maxGap);
        
        return maxGap;
    }
}
