package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Write a function that takes a string as input and returns the string
 *         reversed.
 * 
 *         Example: Given s = "hello", return "olleh".
 */
public class L0344_ReverseString {
	// 5ms, 57%
    public String reverseString(String s) {
    	if (s == null || s.length() < 2)
    		return s;
    	
    	char[] c = s.toCharArray();
    	int len = c.length;
    	int mid = len/2;
        for (int i = 0; i < mid; i++) {
        	char tmp = c[i];
        	c[i] = c[c.length - 1 - i];
        	c[c.length - 1 - i] = tmp;
        }
        
        return new String(c);
    }
}
