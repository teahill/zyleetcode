package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * 
 *  Array Backtracking Bit Manipulation
 * 
 */
public class L0078_Subsets {

	public L0078_Subsets() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> subsets2(int[] S) {
        List<List<Integer>> allList = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        
        allList.add(list);
        Arrays.sort(S);
        for (int i = 1; i < S.length + 1; i++) {
        	List<List<Integer>> result = subsets(S, i);
        	for (int j = 0; j < result.size(); j++)
        		allList.add(result.get(j));
        }
        
        return allList;
    }
    
    public List<List<Integer>> subsets(int[] S, int k) {
        List<List<Integer>> result = subsetsRecursive(S, k, 1, 0);       
        	
        return result;
    }
    
    public List<List<Integer>> subsetsRecursive(int[] S, int k, int seq, int curPos) {
    	List<List<Integer>> allList = new ArrayList<List<Integer>>();
    
    	if (seq > k) {       
    		List<Integer> list = new ArrayList<Integer>();
    		allList.add(list);
    		return allList;
    	}
    	
    	for (int i = curPos; i < S.length; i++) {
    		int picked = S[i];
    		List<List<Integer>> result = subsetsRecursive(S, k, seq+1, i+1);
    		for (int j = 0; j < result.size(); j++) {
    			List<Integer>  list = result.get(j);
    			list.add(0, picked);
    			allList.add(list);
    		}
    	}
    	
    	return allList;
    }  
    
    public List<List<Integer>> subsets(int[] S) {
    	List<List<Integer>> all = new ArrayList<List<Integer>>();
    	
    	// Seed empty list
    	List<Integer> list = new ArrayList<Integer>();    	
    	all.add(list);
    	
    	if (S == null || S.length == 0)
    		return all;
    	
    	Arrays.sort(S);
    	
    	int size = S.length;    	
    	for (int i = 0; i < size; i++) {
    		int len = all.size();
    		for (int j = 0; j < len; j++) {
        		List<Integer> newList = new ArrayList<Integer>(all.get(j));
        		newList.add(S[i]);
    			all.add(newList);
    		}    		
    	}    	
    	
    	return all;
    }
    
    // Iterative, from Leetcode
    public List<List<Integer>> subsets1(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(S);
        for(int i = S.length - 1; i >= 0; i--){
            int size = res.size() - 1;
            for(int j = size; j >= 0; j--){
                List<Integer> newList1 = new ArrayList<Integer>();
                newList1.add(S[i]);
                newList1.addAll(res.get(j));
                res.add(newList1);
            }
        }
        return res;
    }
}
