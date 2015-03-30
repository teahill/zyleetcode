package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class L0077_Combination {

	public L0077_Combination() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> allList = findNext(n, k, 1, 0);
    	
    	return allList;
    }
    
  
    public List<List<Integer>> findNext(int n, int k, int num, int lastPos) {
    	List<List<Integer>> newAllList = new ArrayList<List<Integer>>();
        if (num > k ) {
        	List<Integer> list = new ArrayList<Integer>();        	
        	newAllList.add(list);
        	return newAllList;
        }
        
        for (int i = 1; i <= n - lastPos; i++) {
        	int curPos = lastPos + i;
        	List<List<Integer>> updatedList = findNext(n, k, num + 1, curPos);

        	for (int j = 0; j < updatedList.size(); j++) {
        		List<Integer> list = updatedList.get(j);
        		list.add(0, curPos);
        		newAllList.add(list);
        	}	        	
        }

        return newAllList;
    }
    
    // Iterative, from Leetcode solution. Need to check again
    public List<List<Integer>> combine1(int n, int k) {
        if (k == 0 || n == 0 || k > n) return Collections.emptyList();
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n; i++) combs.add(Arrays.asList(i));
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> newCombs = new ArrayList<List<Integer>>();
            for (int j = i; j <= n; j++) {
                for (List<Integer> comb : combs) {
                    if (comb.get(comb.size()-1) < j) {
                        List<Integer> newComb = new ArrayList<Integer>(comb);
                        newComb.add(j);
                        newCombs.add(newComb);
                    }
                }
            }
            combs = newCombs;
        }
        return combs;
    }
}
