package com.leetcode.zyang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  * @author zyang
 *  
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 */
public class L0040_CombinationSumII {

	public L0040_CombinationSumII() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<List<Integer>> allList = combinationSumInternal(candidates, target, 0);
    	
    	return allList;
    }
    
    public List<List<Integer>> combinationSumInternal(int[] candidates, int target, int pos) {
    	List<List<Integer>> newAllList = new LinkedList<List<Integer>>();
				
    	for (int i = pos; i < candidates.length; i++) {  
    		while (i > 0 && i < candidates.length && i > pos && candidates[i] == candidates[i - 1])
    			i++;
    		
    		if (i == candidates.length)
    			break;
    		
    		int newTarget = target - candidates[i];
    		if (newTarget > 0) {
    			List<List<Integer>> allList = combinationSumInternal(candidates, newTarget, i + 1);
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
