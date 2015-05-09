package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Implement pow(x, n).
 * 
 * Show Tags  Math Binary Search
 * 
 */
public class L0050_Pow {

	public L0050_Pow() {
		// TODO Auto-generated constructor stub
	}

    public double myPow(double x, int n) {   	    	
    	double result = 1;
    	
    	if (n == 0)
    		return result;    
    	
    	if (n < 0) {
    		// Preventing integer overflow
    		result = 1 / (myPow(x, - (n + 1)) * x);
    		return result;
    	}

    	result = myPow(x*x, n / 2);
       	if (n % 2 == 1)
       		result *= x;
        
    	return result;
    }
}
