package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination 
 * should be a unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 */
public class L0216_CombinationSumIII {

	public L0216_CombinationSumIII() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> combinationSum3(int k, int n) {
    	int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    	List<List<Integer>> newList = new ArrayList<List<Integer>>();
    	
        if (k == 0 || n < 1)
        	return newList;
        
        newList = combinationSum3Internal(k, n, nums, 0);
        
        return newList;
    }
    
    private List<List<Integer>> combinationSum3Internal(int k, int n, int[] nums, int pos) {  
    	List<List<Integer>> newList = new ArrayList<List<Integer>>();
        if (k < 0 || n < 0)
        	return newList;
                    	
        if (k == 0 && n == 0) {
        	List<Integer> list = new ArrayList<Integer>();
        	newList.add(list);
        	return newList;
        }
        
        if ((k == 0 && n > 0) || (n == 0 && k > 0) || (n > 0 && k > 0 && pos >= nums.length)) 
        	return newList;
        
        for (int i = pos; i < nums.length; i++) {
        	List<List<Integer>> tmp = combinationSum3Internal(k - 1, n - nums[i], nums, i + 1);
        	int size = tmp.size();
        	for (int j = 0; j < size; j++) {
        		List<Integer> list = tmp.get(j);
        		list.add(0, nums[i]);
        		newList.add(list);
        	}
        }
        
        return newList;
    }
}
