package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has 
 * (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
 * so the function should return 3.
 * 
 * 
 * 
 */
public class L0191_NumberOf1Bits {

	public L0191_NumberOf1Bits() {
		// TODO Auto-generated constructor stub
	}

    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
    	int num = 0;
    	
    	for (int i = 0; i < 32; i++) {
    		num = num + (n&1);
    		n = n>>1;
    	}
        
    	return num;
    }
    
    public int hammingWeight(int n) {
    	int num = 0, count = 0;
    	
    	while (n != 0 && count < 32) {
    		num = num + (n&1);
    		n = n>>1;
    		count++;
    	}
        
    	return num;
    }
}
