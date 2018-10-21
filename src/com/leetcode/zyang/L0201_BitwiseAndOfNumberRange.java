package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, 
 * return the bitwise AND of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * 
 */
public class L0201_BitwiseAndOfNumberRange {

	public L0201_BitwiseAndOfNumberRange() {
		// TODO Auto-generated constructor stub
	}

    public int rangeBitwiseAnd(int m, int n) {
        
    	int count = 0;
    	while (m != n) {
    		m >>= 1;
    		n >>= 1;
    		count++;
    	}
    		
    	m <<= count;
    	
    	return m;
    }
}
