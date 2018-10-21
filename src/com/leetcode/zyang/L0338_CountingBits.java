package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given a non negative integer number num. For every numbers i in the
 *         range 0 ≤ i ≤ num calculate the number of 1's in their binary
 *         representation and return them as an array.
 * 
 *         Example: For num = 5 you should return [0,1,1,2,1,2].
 * 
 *         Follow up:
 * 
 *         It is very easy to come up with a solution with run time
 *         O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly
 *         in a single pass? Space complexity should be O(n). Can you do it like
 *         a boss? Do it without using any builtin function like
 *         __builtin_popcount in c++ or in any other language. Hint:
 * 
 *         You should make use of what you have produced already. Divide the
 *         numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to
 *         generate new range from previous. Or does the odd/even status of the
 *         number help you in calculating the number of 1s?
 */
public class L0338_CountingBits {
    public int[] countBits(int num) {
        if (num <= 0)
        	return new int[1];
        
        int[] count = new int[num + 1];
        
        int start = 1;
        while (start <= num) {
        	int end = (start*2-1 < num) ? start*2-1 : num;
        	for (int i = start; i <= end; i++)
        		count[i] = count[i-start] + 1;
        	
        	start = start * 2;
        }
        
        return count;
    }
    
    // use bit counting, f[i] = f[i/2] + f[i]%2
    public int[] countBits1(int num) {
        if (num <= 0)
        	return new int[1];
        
        int[] count = new int[num + 1];
        for (int i = 1; i <= num; i++)
        	count[i] = count[i>>1] + (i&1);
        	        
        return count;
    }
}
