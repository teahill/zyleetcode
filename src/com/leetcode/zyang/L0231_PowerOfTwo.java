package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an integer, write a function to determine if it is a power of two.
 */
public class L0231_PowerOfTwo {

	public L0231_PowerOfTwo() {
		// TODO Auto-generated constructor stub
	}

    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
        	return false;
        
        return (n & (n -1)) == 0;
    }
    
    public boolean isPowerOfTwo1(int n) {
        if (n <= 0)
        	return false;
        
        if (n == 1)
        	return true;

        int rem = 0;
        while (n > 1) {
        	rem = n % 2;        	
        	if (rem != 0)
        		return false;
        	
        	n = n / 2;
        }
        
        return true;
    }
}
