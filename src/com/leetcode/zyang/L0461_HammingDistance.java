package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         The Hamming distance between two integers is the number of positions
 *         at which the corresponding bits are different.
 * 
 *         Given two integers x and y, calculate the Hamming distance.
 * 
 *         Note: 0 ≤ x, y < 2^31.
 * 
 *         Example:
 * 
 *         Input: x = 1, y = 4
 * 
 *         Output: 2
 * 
 *         Explanation: 1 (0 0 0 1) 4 (0 1 0 0) ↑ ↑
 * 
 *         The above arrows point to positions where the corresponding bits are
 *         different.
 */
public class L0461_HammingDistance {
    public int hammingDistance(int x, int y) {
    	int count = 0;
    	
        for (int i = 0; i < 32; i++) {
        	count += (x&1) ^ (y&1);
        	x>>=1;
        	y>>=1;
        }
        return count;        	
    }
}
