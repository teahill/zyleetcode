package com.leetcode.zyang;

import java.util.Stack;

/**
 * 
 * @author zyang
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * stack, string
 * 
 */
public class L0020_ValidParentheses {

	public L0020_ValidParentheses() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String x = "()[]{}";
		//String x = "(]";
		//String x = "([)]";
		//String x = "()[]{}A";
		//String x = "ABC";
		String x = "(])";
		
		L0020_ValidParentheses validParentheses = new L0020_ValidParentheses();

		boolean result = validParentheses.isValid(x);

		System.out.println(x + " ->  " + result);
	}

	public boolean isValid(String s) {
		boolean result = false;

		if ((s == null) || (s == ""))
			return result;
		
		Stack<Character> stack = new Stack<Character>();

		String strLeft = "([{";
		String strRight = ")]}";

		for (int i = 0; i < s.length(); i++){
			if (strLeft.contains(String.valueOf(s.charAt(i)))) {
				stack.push(Character.valueOf(s.charAt(i)));
			}
			else if (strRight.contains(String.valueOf(s.charAt(i)))) {
				if (stack.isEmpty())
					return result;
				
				if (isMatch(stack.peek().charValue(), s.charAt(i)))
					stack.pop();
				else
					return result;
			}
			else 
				return result;
		}

		if (stack.isEmpty())
			result = true;

		return result;
	}

	public boolean isMatch(char x, char y) {
		if (((x == '(') && (y == ')')) || ((x == '{') && (y == '}')) || ((x == '[') && (y == ']')))
			return true;

		return false;
	}
}
