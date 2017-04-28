package com.leetcode.zyang;

/**
 * 
 * @author zyang 
 * 
 * 		   Given a positive integer, output its complement number. The
 *         complement strategy is to flip the bits of its binary representation.
 * 
 *         Note: The given integer is guaranteed to fit within the range of a
 *         32-bit signed integer. You could assume no leading zero bit in the
 *         integer’s binary representation. 
 *         
 *         Example 1: Input: 5 Output: 2
 *         Explanation: The binary representation of 5 is 101 (no leading zero
 *         bits), and its complement is 010. So you need to output 2. 
 *         
 *         Example 2:
 *         Input: 1 Output: 0 
 *         Explanation: The binary representation of 1 is 1
 *         (no leading zero bits), and its complement is 0. So you need to
 *         output 0.
 */
public class L0476_NumberComplement {

	// 13ms, 32%
	
    // Use bit operator
	// 1. Negate the input, however the leading zeros will become 1 and needs to be trimmed
	// 2. Use a mask of 1's up to the leftmost 1 of the input - use Integer utility to find the 
	//    highest 1 bit (100), left shift by 1 (1000), then subtract 1 from it (111)
	// 3. AND 1 and 2 above
	// Additional note: since the leading 1 will have 0 as its complement, the mask does not need
	// to include the leading 1, so no need to left shift (100 -> 100-1 -> 11)
    public int findComplement(int num) {
    	int mask = (Integer.highestOneBit(num)<<1) - 1;
    	num = ~num;
    	return num & mask;
    }
    
    // 11ms, 67%
    public int findComplement1(int num) {
    	int cnum = 0;
    	int multiplier = 1;
    	while (num > 0) {
    		cnum += (1- num%2) * multiplier;
    		multiplier*=2;
    		num>>=1;    		
    	}
    		
        return cnum;
    }
}
