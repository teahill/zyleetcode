package com.leetcode.zyang;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author zyang
 * 
 * Given an array of integers and an integer k, find out whether there there are two 
 * distinct indices i and j in the array such that nums[i] = nums[j] and the difference 
 * between i and j is at most k.
 * 
 */
public class L0219_ContainDupII {

	public L0219_ContainDupII() {
		// TODO Auto-generated constructor stub
	}

	// HashMap
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	if (nums == null || nums.length < 2 || k < 1)
    		return false;
    	
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
        	if (map.containsKey(nums[i])) {
        		int pos = map.get(nums[i]);
        		if (i - pos <= k)
        			return true;
        		else
        			map.put(nums[i], i);
        	}
        	else
        		map.put(nums[i], i);
        }
        
        return false;
    }
    
	// HashSet, using sliding window
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
    	if (nums == null || nums.length < 2 || k < 1)
    		return false;
    	
        HashSet<Integer> set = new HashSet<Integer>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {        	
        	if (i - start > k) {
        		set.remove(nums[start]);
        		start++;
        	}
        	
        	if (set.contains(nums[i])) 
        		return true;
        	
        	set.add(nums[i]);        		
        }
        
        return false;
    }
}
