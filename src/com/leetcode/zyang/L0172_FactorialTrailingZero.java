package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 */
public class L0172_FactorialTrailingZero {

	public L0172_FactorialTrailingZero() {
		// TODO Auto-generated constructor stub
	}

    public int trailingZeroes(int n) {
    	if (n == 0)
    		return 0;
    	
    	n = (n > 0) ? n : -n;
    	
    	int numZeros = 0;
    	
    	int x = n;
    	int divider = 5;
    	while (x >= 5) {
    		x = n / divider;
    		numZeros = numZeros + x;   		
    		divider *= 5;    		
    	}
        
    	return numZeros;
    }
}
