package com.leetcode.zyang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author zyang
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *     For example, given array S = {-1 0 1 2 -1 -4},
 * 
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 * 
 * 
 */
public class L0015_3Sum {

	public L0015_3Sum() {
		// TODO Auto-generated constructor stub
	}

    public List<List<Integer>> threeSum(int[] num) {    	
    	List<List<Integer>> allList = new LinkedList<List<Integer>>();
    	
    	if (num.length < 3)
    		return allList;
    	
    	Arrays.sort(num);
    	
    	for (int i = 0; i < num.length - 2; i++) {
    		if (i > 0 && num[i] == num[i-1])
    			continue;
    		
    		int target = 0 - num[i];
    		int low = i + 1;
    		int high = num.length - 1;
    		
    		if (num[low] > target)
    			break;
    			
    		while (low < high) {
    			if (num[low] + num[high] < target) 
    				low++;
    			else if (num[low] + num[high] > target)
    				high--;
    			else {
    				List<Integer> list = new LinkedList<Integer>();
    				list.add(num[i]);
    				list.add(num[low]);
    				list.add(num[high]);
    				allList.add(list);    				
    				
    				// Skip equal elements to avoid duplicate set
    				while (low < high && num[low + 1] == num[low])
    					low++;
    				
    				while (low < high && num[high - 1] == num[high])
    					high--;
    				
    				low++;
    				high--;
    			}    				
    		}    		
    	}
    	
        return allList;
    }
}
