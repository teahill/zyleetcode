package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class L0090_SubsetsII {

	public L0090_SubsetsII() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> all = new ArrayList<List<Integer>>();
    	
    	// Seed empty list
    	List<Integer> list = new ArrayList<Integer>();    	
    	all.add(list);
    	
    	if (nums == null || nums.length == 0)
    		return all;
    	
    	Arrays.sort(nums);
    	
    	int size = nums.length;    
    	//repeat count
    	int n = 0;
    	for (int i = 0; i < size; i++) {
    		if (i > 0 && nums[i] == nums[i-1])
    			n++;
    		else
    			n = 0;
    		
    		int len = all.size();
    		int start = 0;
    		if (n > 0)
    			start = len - len / (n + 1);
    			
    		for (int j = start; j < len; j++) {
        		List<Integer> newList = new ArrayList<Integer>(all.get(j));
        		newList.add(nums[i]);
    			all.add(newList);
    		}    		
    	}    	
    	
    	return all;
    }
}
