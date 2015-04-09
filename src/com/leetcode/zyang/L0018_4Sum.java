package com.leetcode.zyang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * 
 * 
 */
public class L0018_4Sum {

	public L0018_4Sum() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> allList = new LinkedList<List<Integer>>();
    	
    	if (num.length < 4)
    		return allList;
    	
    	Arrays.sort(num);
    	
    	for (int i = 0; i < num.length - 3; i++) {
    		if (i > 0 && num[i] == num[i - 1])
    			continue;
    		
    		for (int j = i + 1; j < num.length - 2; j++) {
        		if (j > i + 1 && num[j] == num[j - 1])
        			continue;
    			
        		int low = j + 1;
        		int high = num.length - 1;
        		int diff = target - num[i] - num[j];
        		while (low < high) {      			
        			if (num[low] + num[high] == diff) {
        				List<Integer> list = new LinkedList<Integer>(Arrays.asList(num[i], num[j], num[low], num[high]));
        				allList.add(list);
        				
        				// Skip equal elements to avoid duplicate set
        				while (low < high && num[low + 1] == num[low])
        					low++;
        				
        				while (low < high && num[high - 1] == num[high])
        					high--;
        				
        				low++;
        				high--;
        			}
        			else if (num[low] + num[high] > diff) 
        				high--;
        			else 
        				low++;
        				
        		}
    		}    		
    	}   	
    	
    	return allList;
    }
}
