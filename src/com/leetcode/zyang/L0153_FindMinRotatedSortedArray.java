package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 */
public class L0153_FindMinRotatedSortedArray {

	public L0153_FindMinRotatedSortedArray() {
		// TODO Auto-generated constructor stub
	}

	// iterative, use nums[end] for clean comparison vs nums[start], 
	// because start + (end - start) /2 may be the same as start.
	// this avoids the condition of nums[mid] = nums[start]
    public int findMin(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return 0;
    	
    	int start = 0, end = nums.length - 1;
        while (start < end) {
        	int mid = start + (end - start) / 2;
        	if (nums[mid] > nums[end])
        		start = mid + 1;
        	else 
        		end = mid;
        }
        
        return nums[start];
    }
    
    // recursive
    public int findMin1(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return 0;
    	
        int result = findMin(nums, 0, nums.length);
        
        return result;
    }
    
    private int findMin(int[] nums, int start, int end) {
    	int result = 0;
        if (start == end)
        	return nums[start];
        
        int mid = (start + end) / 2;
        
        if (nums[mid] > nums[0]) 
        	result = findMin(nums, mid + 1, end);
        else {
        	result = findMin(nums, start, mid);
        }
        
        return result;
    }
}
