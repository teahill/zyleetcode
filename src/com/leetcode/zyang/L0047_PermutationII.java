package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author zyang
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 */
public class L0047_PermutationII {

	public L0047_PermutationII() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> permuteUnique(int[] num) {
    	Arrays.sort(num);
    	List<Integer> listPos = new LinkedList<Integer>();    	
    	List<List<Integer>> finalList = permute(num, 0, listPos);
    	
    	return finalList;
    }
    
    private List<List<Integer>> permute(int[]num, int n, List<Integer> listPos) {
    	List<List<Integer>> allList = new LinkedList<List<Integer>>();
    	
    	if (n >= num.length) {
    		List<Integer>  list = new LinkedList<Integer>();
    		for (int i = 0; i < n; i++) 
    			list.add(num[listPos.get(i)]);
    		
    		allList.add(list);
    		
    		return allList;
    	}

    	boolean prevPicked = false;
    	for (int i = 0; i < num.length; i++) {
    		if (i > 0 && num[i] == num[i - 1] && prevPicked)
    			continue;
    		
    		if (okPermute(i, listPos)) {
    			List<Integer> newListPos = new LinkedList<Integer>(listPos);
    			newListPos.add(i);
    			List<List<Integer>> newList = permute(num, n + 1, newListPos);
    			
    			for (int j = 0; j < newList.size(); j++) 
    				allList.add(newList.get(j));  
    			
    			prevPicked  = true;
    		} 
    		else    		
    			prevPicked = false;
    	}
    	
    	return allList;
    }
    
    private boolean okPermute(int pickedPos,  List<Integer> listPos) {
    	for (int i = 0; i < listPos.size(); i++) {
    		if (pickedPos == listPos.get(i))
    			return false;
    	}
    	
    	return true;
    }
    
    // From leetcode, interesting to see the use of Set<List<Integer>>
    public List<List<Integer>> permuteUnique1(int[] num) {
        Set<List<Integer>> permutations = new HashSet<List<Integer>>();

        if(num.length > 0){
            permutations.add(Arrays.asList(num[0]));

            for(int index = 1; index < num.length; index++) {

                Set<List<Integer>> newPermutations = new HashSet<List<Integer>>();
                for(List<Integer> list : permutations){

                    for(int innerIndex = 0; innerIndex <= list.size(); innerIndex++){
                        List<Integer> newList = new ArrayList(list);
                        newList.add(innerIndex, num[index]);
                        newPermutations.add(newList);
                    }
                }

                permutations = newPermutations;
            }
        }
        return new ArrayList<List<Integer>>(permutations);
    }
}
