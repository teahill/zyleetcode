package com.leetcode.zyang;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * Show Tags - backracking
 * 
 * 
 */
public class L0046_Permutation {

	public L0046_Permutation() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> permute(int[] num) {
    	List<List<Integer>> allList = new LinkedList<List<Integer>>();  
   		List<Integer> list = new LinkedList<Integer>();
   		allList.add(list);
   		
    	List<List<Integer>> finalList  = permute(num, 0, allList);
    	
    	return finalList;
    }
    
    List<List<Integer>> permute(int[]num, int n, List<List<Integer>> allList) {
    	if (n >= num.length)
    		return allList;
    	    		
    	List<List<Integer>> newAllList = new LinkedList<List<Integer>>();
    	
    	for (int i = 0; i < num.length; i++) {
    		for (int j = 0; j < allList.size(); j++) {
    			if (okPermute(num[i], allList.get(j))) {
    				List<Integer> newList = new LinkedList<Integer>(allList.get(j));
    				newList.add(num[i]);
    				newAllList.add(newList);
    			}    			
    		}
    	}
    	
    	if (newAllList.size() == 0)
    		return newAllList;
    	
    	List<List<Integer>> finalList = permute(num, n + 1, newAllList);
    	
    	return finalList;
    }
    
    boolean okPermute(int picked,  List<Integer> list) {
    	for (int i = 0; i < list.size(); i++) {
    		if (picked == list.get(i).intValue())
    			return false;
    	}
    	
    	return true;
    }
    
    String printList(List<List<Integer>> allList) {
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < allList.size(); i++) {
    		sb = sb.append("{");
    		List<Integer> list = allList.get(i);
    		for (int j = 0; j < list.size(); j++) {
    			sb = sb.append(list.get(j).intValue());
    			sb.append(",");
    		}
    		sb = sb.append("}");
    	}
    	
    	return sb.toString();
    }
}
