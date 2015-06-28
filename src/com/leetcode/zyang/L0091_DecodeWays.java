package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 */
public class L0091_DecodeWays {

	public L0091_DecodeWays() {
		// TODO Auto-generated constructor stub
	}

    public int numDecodings(String s) {
        int len = s.length() ;        
        if (s == null || len == 0)
        	return 0;
        
        int[] count = new int[len + 1];
        count[len] = 1;        
        count[len -1] = (s.charAt(len-1) == '0') ? 0 : 1; 

        for (int i = len - 2; i >= 0; i--){
        	if (s.charAt(i) == '0')
        		continue;       	
        	else {
        		int num = Integer.parseInt(s.substring(i, i+2));
        		if (num <= 26)
        			count[i] = count[i+1] + count[i+2];
        		else
        			count[i] = count[i+1];
        	}
        }
        
        return count[0];
    }
}
