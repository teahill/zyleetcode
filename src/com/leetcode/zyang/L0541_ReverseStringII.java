package com.leetcode.zyang;

import java.util.Arrays;

/**
 * 
 * @author zyang
 * 
 *         Given a string and an integer k, you need to reverse the first k
 *         characters for every 2k characters counting from the start of the
 *         string. If there are less than k characters left, reverse all of
 *         them. If there are less than 2k but greater than or equal to k
 *         characters, then reverse the first k characters and left the other as
 *         original. 
 *         
 *         Example: Input: s = "abcdefg", k = 2 
 *         Output: "bacdfeg"
 *         
 *         Restrictions: 
 *         1. The string consists of lower English letters only.
 *         2. Length of the given string and k will in the range [1, 10000]
 * 
 */
public class L0541_ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s == null || k < 2)
        	return s;
        
        char[] array = s.toCharArray();
        int len = s.length();
        int twoK = 2 * k;
        
        for (int i = 0; i < len / twoK + 1; i++) {
        	int start = i*twoK;
        	int end;
        	
        	if (i == len/twoK && (len - i*twoK) < k)
        		end = i*twoK + len - i*twoK - 1;
        	else
        		end = i*twoK + k - 1;
        	
        	while (start < end) {
        		char tmp = array[start];
        		array[start] = array[end];
        		array[end] = tmp;
        		
        		start++;
        		end--;
        	}
        }	
        
        return String.valueOf(array);
    }
}
