package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 *         Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 *         some elements appear twice and others appear once.
 * 
 *         Find all the elements of [1, n] inclusive that do not appear in this
 *         array.
 * 
 *         Could you do it without extra space and in O(n) runtime? You may
 *         assume the returned list does not count as extra space.
 * 
 *         Example:
 * 
 *         Input: [4,3,2,7,8,2,3,1]
 * 
 *         Output: [5,6]
 */
public class L0448_FindAllNumbers {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length < 1)
        	return list;
        
        for (int i = 0; i < nums.length; i++) {
        	int val = Math.abs(nums[i]);
        	if (nums[val-1] > 0)
        		nums[val-1] = -nums[val-1];
        }
        	
        
        for (int i = 0; i < nums.length; i++) 
        	if (nums[i] > 0)
        		list.add(i+1);
        
        return list;
    }
}
