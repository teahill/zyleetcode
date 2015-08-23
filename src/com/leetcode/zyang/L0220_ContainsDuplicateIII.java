package com.leetcode.zyang;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author zyang
 * 
 * Given an array of integers, find out whether there are two distinct indices i and j 
 * in the array such that the difference between nums[i] and nums[j] is at most t 
 * and the difference between i and j is at most k.
 * 
 */
public class L0220_ContainsDuplicateIII {

	public L0220_ContainsDuplicateIII() {
		// TODO Auto-generated constructor stub
	}
	
	//WATCH FOR Integer OVERFLOW!!! arrange sequence of operator so that no chance of integer overflow
	
	// Use TreeSet, leveraging its sorted property, O(nlogn)
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || t < 0 || k < 1)
        	return false;
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
        	// remove element out of window
        	if (i - k - 1 >= 0 && set.contains(nums[i - k - 1]))
        		set.remove(nums[i - k - 1]);
        	
        	if (set.floor(nums[i]) != null && (nums[i] <= set.floor(nums[i]) + t)
        			|| (set.ceiling(nums[i]) != null && set.ceiling(nums[i]) <= nums[i] + t))
        		return true;
        			
        	set.add(nums[i]); 		       	
        }
        
        return false;
	}

	
	//WATCH FOR Integer OVERFLOW!!! Use Long
	
	// use bucket sort, O(n)
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || t < 0 || k < 1)
        	return false;
        
        long min = nums[0];
        for (int i = 0; i < nums.length; i++) 
        	min = Math.min(min, nums[i]);
        	
        // Define bucket of size (t+1), if two nums land in the bucket, the difference
        // must be equal or smaller than t
        // also need to check neighboring buckets for cross bucket duplicate
        // save buckets in hash map
        // remove element that pass (j - k - 1) as it is out of range now
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        long bucket = 0;
        for (int i = 0; i < nums.length; i++) {
        	bucket = ((long)nums[i] - min) / ((long)t + 1);
        	
        	// check current bucket
        	if (map.get(bucket) != null)
        		return true;
        	
        	// check neighboring buckets
        	if (map.get(bucket + 1) != null && Math.abs((long)nums[map.get(bucket + 1)] - (long)nums[i]) <= t)
        		return true;
        	
        	if (map.get(bucket - 1) != null && Math.abs((long)nums[map.get(bucket - 1)] - (long)nums[i]) <= t)
        		return true;
        		
        	map.put(bucket, i);
        	
        	// delete item that will be out of range for next num if exists. (i+1 - k - 1)
        	if (i >= k) {
	        	long oldBucket = ((long)nums[i - k] - min)/ ((long)t + 1);
	        	if (map.get(oldBucket) != null)
	        		map.remove(oldBucket);
        	}
        }
        
        return false;
    }
}
