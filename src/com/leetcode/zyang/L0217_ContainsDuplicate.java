package com.leetcode.zyang;

import java.util.HashSet;

/**
 * 
 * @author zyang
 * 
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears 
 * at least twice in the array, and it should return false if every element is distinct.
 */
public class L0217_ContainsDuplicate {

	public L0217_ContainsDuplicate() {
		// TODO Auto-generated constructor stub
	}

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
        	return false;
        
        HashSet<Integer> set = new HashSet<Integer>();        
        for (int n : nums) {
        	if (set.contains(n)) 
        		return true;
        	
        	set.add(n);
        }
        
        return false;
    }
}
