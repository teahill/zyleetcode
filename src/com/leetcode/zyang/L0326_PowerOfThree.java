package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given an integer, write a function to determine if it is a power of
 *         three.
 * 
 *         Follow up: Could you do it without using any loop / recursion?
 */
public class L0326_PowerOfThree {
	public boolean isPowerOfThree(int n) {
		if (n < 1)
			return false;
		
		int maxThreePower = (int)Math.pow(3, (int)(Math.log10(Integer.MAX_VALUE) / Math.log10(3)));
    	if (maxThreePower%n == 0)
    		return true;
    	
    	return false;
    }
	
	public boolean isPowerOfThree1(int n) {
    	if (n < 3)
    		return false;
    	
        while (n >= 3) {
        	if (n%3 != 0)
        		return false;
        	
        	n = n / 3;
        }
        
        if (n != 1)
        	return false;
        
        return true;
    }
}
