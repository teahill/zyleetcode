package com.leetcode.zyang;

import java.util.Stack;

/**
 * 
 * @author zyang
 * 
 *         Given an encoded string, return it's decoded string.
 * 
 *         The encoding rule is: k[encoded_string], where the encoded_string
 *         inside the square brackets is being repeated exactly k times. Note
 *         that k is guaranteed to be a positive integer.
 * 
 *         You may assume that the input string is always valid; No extra white
 *         spaces, square brackets are well-formed, etc.
 * 
 *         Furthermore, you may assume that the original data does not contain
 *         any digits and that digits are only for those repeat numbers, k. For
 *         example, there won't be input like 3a or 2[4].
 * 
 *         Examples:
 * 
 *         s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return
 *         "accaccacc". s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class L0395_DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
        	return s;
        
        String result = "";
        Stack<Integer> sNum = new Stack<Integer>();
        Stack<String> sString = new Stack<String>();
        int i = 0;
        while (i < s.length()) {
        	char ch = s.charAt(i);
        	if (Character.isDigit(ch)) {
        		int num = 0;
        		while (Character.isDigit (s.charAt(i))) 
        			num = num * 10 + s.charAt(i++) - '0';
        			
        		sNum.push(num);
        	}
        	else if (ch == '[') {
        		sString.push(result);
        		result = "";
        		i++;
        	}
        	else if (ch == ']') {
        		StringBuilder sb = new StringBuilder(sString.pop());
        		int n = sNum.pop();
        		for (int j = 0; j < n; j++)
        			sb.append(result);
        		
        		result = sb.toString();
        		i++;
        	}
        	else {
        		result += ch;
        		i++;
        	}   
        }
        
        return result;
    } 
}
