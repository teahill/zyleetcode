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
 * The array may contain duplicates.
 * 
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 */
public class L0154_FIndMinRotatedSortedArrayII {

	public L0154_FIndMinRotatedSortedArrayII() {
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
        	else if (nums[mid] < nums[end]) {
        		end = mid;
        	}
        	else {
        		// 2, 2, 2, 1, 2, 2, 2, 2, 2, 2
        		//2, 2, 2, 2, 2, 2, 1, 2, 2, 2
        		//3, 4, 1, 2, 2, 2, 2, 2, 2
        		if (nums[mid] == nums[start]) {
        			start++;
        			end--;
        		}
        		else
        			end = mid;
        	}
        	
        }
        
        return nums[start];
    }
}
