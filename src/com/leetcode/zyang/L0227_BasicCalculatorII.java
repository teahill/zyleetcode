package com.leetcode.zyang;

import java.util.Stack;

/**
 * 
 * @author zyang
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
 * The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 * 
 */
public class L0227_BasicCalculatorII {

	public L0227_BasicCalculatorII() {
		// TODO Auto-generated constructor stub
	}

	// using operator to prioritize * and /. if it is set, then when num is in, it does computation
	// +, -, just push to stack
    public int calculate(String s) {
    	int result = 0;
    	int sign = 1;
    	Stack<Integer> stack = new Stack<Integer>();   
    	stack.push(sign);
        char operator = '0';
        int len = s.length();
        for (int i = 0; i < len; i++) {
        	char c = s.charAt(i);
        	if (Character.isDigit(c)) {
        		int n = s.charAt(i) - '0';
        		while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
        			i++;
        			n = n * 10 + (s.charAt(i) - '0');
        		}
        		if (operator == '*' || operator == '/') {
        			int n1 = stack.pop();
        			n = (operator == '*') ? n1 * n : n1 / n;
        			stack.push(n);
        			operator = '0';
        		}
        		else
        			stack.push(n);
        	}
        	else if (c == '+' || c == '-') {
        		sign = (c == '+') ? 1 : -1;
        		stack.push(sign);
        	}
        	else if (c == '*' || c == '/') {
        		operator = c;
        	}
        }
        
        while (!stack.isEmpty()) {
        	int n = stack.pop();
        	sign = stack.pop();
        	result += n * sign;
        }
        
        return result;
    }
}
