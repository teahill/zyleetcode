package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 */
public class L0081_SearchRotatedSortedArrayII {

	public L0081_SearchRotatedSortedArrayII() {
		// TODO Auto-generated constructor stub
	}

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
        	return false;
        
        int start = 0, end = nums.length - 1;
        while (start <= end) {
        	// terminating
        	if (start == end) {
        		if (nums[start] == target)
        			return true;
        		else 
        			return false;
        	}
        	
        	if (target == nums[start])
        		return true;
        	
        	if (target == nums[end])
        		return true;
        	
        	int mid = start + (end - start) / 2;        	
        	if (nums[mid] == target)
        		return true;
        	
        	if (nums[mid] > nums[end]) {
        		if (target > nums[start] && target < nums[mid]) {
        			start = start + 1;
        			end = mid - 1;
        		}
        		else {
        			mid = mid + 1;
        			end = end -1;
        		}
        	}
        	else if (nums[mid] < nums[end]) {
        		if (target > nums[mid] && target < nums[end]) {
        			mid = mid + 1;
        			end = end - 1;
        		}
        		else {
        			start = start + 1;
        			mid = mid - 1;
        		}
        	}    
        	else {        		
        		if (nums[start] == nums[mid]) {
        			start++;
        			end--;
        		}
    			else 
        			end = mid - 1;       			
        	}
        }
    	return false;
    }    
}
