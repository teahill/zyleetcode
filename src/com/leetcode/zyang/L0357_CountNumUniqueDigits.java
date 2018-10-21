package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given a non-negative integer n, count all numbers with unique digits,
 *         x, where 0 ≤ x < 10^n.
 * 
 *         Example: Given n = 2, return 91. (The answer should be the total
 *         numbers in the range of 0 ≤ x < 100, excluding
 *         [11,22,33,44,55,66,77,88,99])
 */
public class L0357_CountNumUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
        	return 1;
        
        if (n == 1)
        	return 10;
        
        int count = 10;
        for (int i = 2; i < n; i++) {
        	int incre = 9;
        	for (int j = 2; j <= i; j++) 
        		incre = incre * (10 - j + 1);
        	count += incre;
        }
        
        
        return count;        	
    }
}
