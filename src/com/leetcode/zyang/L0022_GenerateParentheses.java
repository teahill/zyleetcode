package com.leetcode.zyang;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 */
public class L0022_GenerateParentheses {

	public L0022_GenerateParentheses() {
		// TODO Auto-generated constructor stub
	}
	
    // Leetcode simple solution. Try it again
    public List<String> generateParenthesis(int n) {
    	List<String> list = new LinkedList<String>();
    	
    	generateParenthesisInternal(list, "", 0, 0, n);
    	
    	return list;        
    }	

    public void generateParenthesisInternal(List<String> list, String s, int left, int right, int n) {
    	if (left == n && right == n) {
    		list.add(s);
    		return;
    	}
    	
    	if (left < n) {
    		StringBuilder sb = new StringBuilder(s);
    		sb.append('(');
    		generateParenthesisInternal(list, sb.toString(), left + 1, right, n);
    	} 
    	
    	if (left > right) {
    		StringBuilder sb = new StringBuilder(s);
    		sb.append(')');
    		generateParenthesisInternal(list, sb.toString(), left, right + 1, n);
    	}   	    	
    }
    
    
    
    public List<String> generateParenthesis1(int n) {
    	List<String> list = new LinkedList<String>();
    	list.add("");
    	
    	if (n == 0)
    		return list;
    	
    	List<String> finalList = generateParenthesisRecursive(list, 0, n);
    	
    	return finalList;
        
    }
    
    public List<String> generateParenthesisRecursive(List<String> list, int pos, int n) {
    	if (pos == 2 * n)
    		return list;
    	
    	char[] pt = new char[] {'(', ')'};
    	List<String> newList = new LinkedList<String>();
    	for (char ch : pt) {
    		for (String s : list) {
    			if (okParenthesis(s, ch, pos, n)) {
    				StringBuilder sb = new StringBuilder(s);
    				sb.append(ch);
    				newList.add(sb.toString());
    			}  			    				
    		}
    	}
        
    	List<String> finalList = generateParenthesisRecursive(newList, pos + 1, n);
    	
    	return finalList;
    }
    
    private boolean okParenthesis(String s, char ch, int pos, int n) {
    	int left = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(')
    			left++;
    		else 
    			left--;
    	}
    	
    	if ((ch == '(' && 2 * n - pos - 1 >= left + 1) || ch == ')' && left > 0)
    		return true;
    	else 
    		return false;
    }
    

}
