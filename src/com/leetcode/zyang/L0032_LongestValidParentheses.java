package com.leetcode.zyang;

import java.util.Stack;
/**
 * 
 * @author zyang
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) 
 * parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 */
public class L0032_LongestValidParentheses {

	public L0032_LongestValidParentheses() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Using stack
	public int longestValidParenthesesStack(String s) {
        int count = 0;        
        if (s == null || s.length() == 0)
        	return count;
        
        Stack<Integer> stack = new Stack<Integer>();
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
        	if (!stack.isEmpty() && s.charAt(i) == ')' && s.charAt(stack.peek()) == '(')
        		stack.pop();
        	else
        		stack.push(i);        		
        }
        
        if (stack.isEmpty())
        	return len;
        
        int rPos = len;
        while (!stack.isEmpty()) {
        	int lPos = stack.pop();
        	count = Math.max(count, rPos - lPos - 1);
        	rPos = lPos;
        }
        
        if (rPos != 0)
        	count = Math.max(count, rPos);
        
        return count;
    }
	
	//Using DP
    public int longestValidParentheses(String s) {     
        if (s == null || s.length() < 2)
        	return 0;

        int len = s.length();
        int[] count = new int[len];
        count[0] = 0;        
        if (s.charAt(0) == '(' && s.charAt(1) == ')')
        	count[1] = 2;
        else
        	count[1] = 0;
        
        int max = Math.max(count[0], count[1]);
        for (int i = 2; i < len; i++) {
        	if (s.charAt(i) == '(')
        		count[i] = 0;
        	else {
        		if (s.charAt(i - 1) == '(')
        			count[i] = count[i - 2] + 2;
        		else if ((i - count[i - 1] - 1 >= 0) && (s.charAt(i - count[i - 1] - 1) == '(')) 
        			count[i] = 2 + count[i - 1] + ((i - count[i - 1] - 2) >= 0 ? count[i - count[i - 1] - 2] : 0);
        		else
        			count[i] = 0;
        	}
        	
        	max = Math.max(max, count[i]);
        }
       
        return max;
    }
}
