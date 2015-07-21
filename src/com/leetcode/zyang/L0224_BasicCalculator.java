package com.leetcode.zyang;

import java.util.Stack;

/**
 * 
 * @author zyang
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
 * non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * 
 */
public class L0224_BasicCalculator {

	public L0224_BasicCalculator() {
		// TODO Auto-generated constructor stub
	}

	
    public int calculate(String s) {       
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int sign = 1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
        	char c = s.charAt(i);
        	if (c == '+')
        		sign = 1;
        	else if (c == '-')
        		sign = -1;
        	else if (c == '(') {
        		// save previous result/sigh into stack; start anew for the enclosed
        		stack.push(result);
        		stack.push(sign);
        		
        		result = 0;
        		sign = 1;
        	}
        	else if (c == ')') {        		
        		// pop previous result/sign before parenthesis, compute, continue
        		if (stack.isEmpty())
        			continue;
        			
        		int prevSign = stack.pop();
        		int prevResult = stack.pop();
        		 
        		result = result * prevSign + prevResult;
        	}
        	else if (Character.isDigit(c)){
        		// get the number and compute
                int n = s.charAt(i) - '0';
                while ((i + 1 < len) && Character.isDigit(s.charAt(i + 1))) {
                	i++;
                	n = n * 10 + (s.charAt(i) - '0');
                }
                
                result += n * sign;             
        	}    
        }        
        
        return result;
    }
    
    
    public int calculate1(String s) {
    	int value = 0;
        if (s == null || s.length() == 0)
        	return value;
        
        int len = s.length();
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < len; i++) {
        	char c = s.charAt(i);
        	if (Character.isWhitespace(c))
        		continue;
        	else if (c == '+' || c == '-' || c == '(')
        		stack.push(String.valueOf(c));
        	else if (c == ')') {        		
        		// pop the intermediate result in parenthesis
        		if (stack.isEmpty())
        			return value;
        			
        		String num = stack.pop();
        		
        		// pop open parenthesis
        		String ch = stack.peek();
                if (ch.equals("("))
                	stack.pop();
                
                if (stack.isEmpty())
                	stack.push(num);
                else { 
	                ch = stack.peek();
	                if (isOperator(ch) ) {
	                	stack.pop();
	                	String num2 = stack.pop();
	                	int result = calculate(Integer.parseInt(num2), Integer.parseInt(num), ch);
	                	stack.push(String.valueOf(result));
	                }
	                else
	                	stack.push(num);
                }
        	}
        	else if (Character.isDigit(c)){
                int n = s.charAt(i) - '0';
                int multiplier = 10;
                while ((i + 1 < len) && Character.isDigit(s.charAt(i + 1))) {
                	i++;
                	n = n * multiplier + s.charAt(i) - '0';
                	multiplier *= 10;
                }
                
        		// check any pending calculation
                if (stack.isEmpty()) {
                	stack.push(String.valueOf(n));
                	continue;
                }
                
        		String ch = stack.peek();
                if (isOperator(ch)) {
                	stack.pop();
                
	                String num = stack.pop();
	                int result = calculate(Integer.parseInt(num), n, ch);
	                stack.push(String.valueOf(result));
                }
                else
                	stack.push(String.valueOf(n));                
        	}        				
        }
        
        if (!stack.isEmpty()) {
	        String str = stack.peek();
	        if (str != null)
	        	value = Integer.parseInt(str);
        }
        
        return value;
    }

    
    private boolean isOperator(String str) {
    	return (str.equals("+") || str.equals("-"));
    }
    
    private int calculate(int n1, int n2, String operator) {
    	int result = 0;
    	
    	if (operator.equals("+"))
    		result = n1 + n2;
    	else if (operator.equals("-"))
    		result = n1 - n2;

    	return result;
    }
}
