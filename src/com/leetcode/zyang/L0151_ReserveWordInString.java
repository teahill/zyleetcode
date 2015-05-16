package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * 
 */
public class L0151_ReserveWordInString {

	public L0151_ReserveWordInString() {
		// TODO Auto-generated constructor stub
	}

    public String reverseWords(String s) {
    	if (s == null)
    		return s;
    	
    	s = s.trim();    	
        String[] words = s.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {        	
        	if (sb.length() != 0)
        		sb.append(' ');
        	
        	sb.append(words[i]);        	
        }
        
        return sb.toString();
    }
}
