package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * 
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * 
 */
public class L0233_NumberDigitOne {

	public L0233_NumberDigitOne() {
		// TODO Auto-generated constructor stub
	}

    public int countDigitOne(int n) {
        if (n <= 0)
        	return 0;
        
        if (n < 10)
        	return 1;
        
        int rem = n;
        int m = 1;
        int div = 1;
        while (rem > 9 ) {
        	rem = rem / 10;
        	div *= 10;
        	m++;
        }
        
        int[] count = new int[m + 1];
        count[0] = 0;
        int multiplier = 1;
        for (int i = 1; i < m + 1; i++) {
        	count[i] = count[i - 1] * 10 + multiplier;
        	multiplier *= 10;
        }
        
        int result = 0;
        int multiple = n / div;
        for (int i = m - 1; i > 0; i--) {
        	if (n < 10)
        		break;
        	
        	result += count[i] * multiple;
        	        
        	if (multiple > 1)
        		result += div;         		
        	else if (multiple == 1)
        		result += (n - div + 1);
        	
        	n = n % div;       	        	
        	div /= 10;
        	multiple = n / div;
        }
        
        if (n >= 1)
        	result += 1;
        
        return result;
    }
    
    // Leetcode 
    /**
     *  Go through the digit positions by using position multiplier m with values 1, 10, 100, 1000, etc.
     *  
     *  For each position, split the decimal representation into two parts, for example split n=3141592 into a=31415 
     *  and b=92 when we're at m=100 for analyzing the hundreds-digit. And then we know that the hundreds-digit of n 
     *  is 1 for prefixes "" to "3141", i.e., 3142 times. Each of those times is a streak, though. Because it's the 
     *  hundreds-digit, each streak is 100 long. So (a / 10 + 1) * 100 times, the hundreds-digit is 1.
     *  
     *  Consider the thousands-digit, i.e., when m=1000. Then a=3141 and b=592. The thousands-digit is 1 for prefixes "" 
     *  to "314", so 315 times. And each time is a streak of 1000 numbers. However, since the thousands-digit is a 1, 
     *  the very last streak isn't 1000 numbers but only 593 numbers, for the suffixes "000" to "592". 
     *  So (a / 10 * 1000) + (b + 1) times, the thousands-digit is 1.
     *  
     *  The case distincton between the current digit/position being 0, 1 and >=2 can easily be done in one expression. 
     *  With (a + 8) / 10 you get the number of full streaks, and a % 10 == 1 tells you whether to add a partial streak.
     *  
     *  public int countDigitOne(int n) {
     *      int ones = 0;
     *      for (long m = 1; m <= n; m *= 10)
     *          ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
     *      return ones;
     *  }
     */
}
