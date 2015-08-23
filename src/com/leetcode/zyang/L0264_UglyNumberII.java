package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Write a program to find the n-th ugly number.
 * 
 *         Ugly numbers are positive numbers whose prime factors only include 2,
 *         3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of
 *         the first 10 ugly numbers.
 * 
 *         Note that 1 is typically treated as an ugly number.
 *         
 *         http://www.geeksforgeeks.org/ugly-numbers/
 */
public class L0264_UglyNumberII {

	public L0264_UglyNumberII() {
		// TODO Auto-generated constructor stub
	}

    public int nthUglyNumber(int n) {
        if (n < 1)
        	return 1;
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 1; i < n; i++) {
        	ugly[i] = Math.min(Math.min(ugly[idx2] * 2, ugly[idx3] * 3), ugly[idx5] * 5);
        	
          	// Do not use else if as it will cause duplicate like 2 * 3, 3 *2
        	// if they are the same, advance both
        	if (ugly[i] == ugly[idx2] * 2)
        		idx2++;
        	
        	if (ugly[i] == ugly[idx3] * 3)
        		idx3++;

        	if (ugly[i] == ugly[idx5] * 5)
        		idx5++;    	
        }
        
        return ugly[n - 1];
    }
	
    public int nthUglyNumber1(int n) {
        if (n < 1)
        	return 1;
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i = 1, idx2 = 0, idx3 = 0, idx5 = 0;
        while (i < n) {
        	int num = Math.min(Math.min(ugly[idx2] * 2, ugly[idx3] * 3), ugly[idx5] * 5);
        	
          	// the else if will cause duplicate
        	if (num == ugly[idx2] * 2)
        		idx2++;
        	else if (num == ugly[idx3] * 3)
        		idx3++;
        	else 
        		idx5++;
        	
        	// only populate if not the same
        	if (num > ugly[i - 1]) {
        		ugly[i] = num;
        		i++;
        	}       	
        }
        
        System.out.println("output: " + Util.printArray(ugly));
        return ugly[n - 1];
    }
}
