package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Calculate the sum of two integers a and b, but you are not allowed to
 *         use the operator + and -.
 * 
 *         Example: Given a = 1 and b = 2, return 3.
 */
public class L0371_SumOfTwoIntegers {
	//https://discuss.leetcode.com/topic/50315/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
		
	// https://leetcode.com/problems/sum-of-two-integers/#/solutions
    public int getSum(int a, int b) {
    	if (a == 0)
    		return b;
    	
    	if (b == 0)
    		return a;
    	
    	int carry = 0;
        while (b != 0) {
        	carry = (a&b) << 1;
        	a = a^b;
        	b = carry;
        }
        
        return a;
    }
    
    // Iterative
    public int getSubtract(int a, int b) {
    	while (b != 0) {
    		int borrow = (~a) & b;
    		a = a ^ b;
    		b = borrow << 1;
    	}
    	
    	return a;
    }
    
    // Get negative number: 2's complement
    public int negate(int x) {
    	return ~x + 1;
    }
}
