package com.leetcode.zyang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C 
 * where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * 
 */
public class L0039_CombinationSum {

	public L0039_CombinationSum() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<List<Integer>> allList = combinationSumInternal(candidates, target, 0);
    	
    	return allList;
    }
    
    public List<List<Integer>> combinationSumInternal(int[] candidates, int target, int pos) {
    	List<List<Integer>> newAllList = new LinkedList<List<Integer>>();
				
    	for (int i = pos; i < candidates.length; i++) {
    		while (i > 0 && i < candidates.length && candidates[i] == candidates[i - 1])
    			i++;
    		
    		if (i == candidates.length)
    			break;
    		
    		int newTarget = target - candidates[i];
    		if (newTarget > 0) {
    			List<List<Integer>> allList = combinationSumInternal(candidates, newTarget, i);
    			for (List<Integer> list : allList) {
    				list.add(0, candidates[i]);
    				newAllList.add(list);
    			}
    		}
    		else if (newTarget == 0) {
    			List<Integer> list = new LinkedList<Integer>();
    			list.add(candidates[i]);
    			newAllList.add(list);
    		}
    	}
    	
		return newAllList;	        
    }
}
