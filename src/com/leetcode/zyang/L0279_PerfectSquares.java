package com.leetcode.zyang;

import java.util.HashMap;

/**
 * @author zyang
 * 
 *         Given a positive integer n, find the least number of perfect square
 *         numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 *         For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n =
 *         13, return 2 because 13 = 4 + 9.
 */
public class L0279_PerfectSquares {

	public L0279_PerfectSquares() {
		// TODO Auto-generated constructor stub
	}

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numSquares(int n) {
    	if (n == 0)
    		return 0;
    	
    	if (map.containsKey(n))
    		return map.get(n);
    	
    	int x = (int)Math.sqrt(n);
    	int min = Integer.MAX_VALUE;
        for (int y = x; y > 0; y--) 
        	min = Math.min(min, numSquares(n - y*y) + 1);
        
        map.put(n, min);        
        return min;
    }
}
