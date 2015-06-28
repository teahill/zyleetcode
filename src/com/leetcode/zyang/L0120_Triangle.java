package com.leetcode.zyang;

import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a triangle, find the minimum path sum from top to bottom. 
 * step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 */
public class L0120_Triangle {

	public L0120_Triangle() {
		// TODO Auto-generated constructor stub
	}

	// bottom up
    public int minimumTotal(List<List<Integer>> triangle) {
    	if (triangle == null || triangle.size() == 0)
    		return Integer.MIN_VALUE;
    	
    	int len = triangle.size();    	
        int[] min = new int[len];   
        List<Integer> list = triangle.get(len - 1);
        for (int i = 0; i < list.size(); i++) 
        	min[i] = list.get(i);
                
        for (int i = len - 2; i >= 0; i--) {
        	list = triangle.get(i);        	
        	int size = list.size();
        	for (int j = 0; j < size; j++) 
        		min[j] = Math.min(min[j], min[j + 1]) + list.get(j);        			
        }
        
        return min[0];
    }
    
	// top down
    public int minimumTotal1(List<List<Integer>> triangle) {
    	if (triangle == null || triangle.size() == 0)
    		return Integer.MIN_VALUE;
    	
    	int len = triangle.size();    	
        int[] min = new int[len];        
        for (int i = 0; i < len; i++) {
        	List<Integer> list = triangle.get(i);
        	int size = list.size();
        	for (int j = size - 1; j >= 0; j--) {
        		if(j == 0)
        			min[j] += list.get(j);
        		else if (j == size - 1)
        			min[j] = min[j - 1] + list.get(j);
        		else 
        			min[j] = Math.min(min[j - 1], min[j]) + list.get(j);        			
        	}
        }
     
        int result = min[0];
        for (int i = 1; i < len; i++) 
        	result = Math.min(result, min[i]);
        
        return result;
    }
}
