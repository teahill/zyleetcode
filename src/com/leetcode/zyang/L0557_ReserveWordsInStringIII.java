package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given a string, you need to reverse the order of characters in each
 *         word within a sentence while still preserving whitespace and initial
 *         word order.
 * 
 *         Example 1: Input: "Let's take LeetCode contest" Output:
 *         "s'teL ekat edoCteeL tsetnoc" Note: In the string, each word is
 *         separated by single space and there will not be any extra space in
 *         the string.
 */
public class L0557_ReserveWordsInStringIII {
	// Use char[] to do tokenizing and reversal; 9ms, 95.74%
	 public String reverseWords(String s) {
	        if (s == null || s.length() < 1)
	        	return s;
	        
	        char[] c = s.toCharArray();
	        int start = 0;
	        for (int i = 0; i < c.length; i++) {
	        	if (c[i] == ' ') {
	        		reverse(c, start, i - 1);
	        		start = i + 1;
	        	}
	        }
	        
	        reverse(c, start, c.length - 1);
	        return new String(c);
	 }
	 
	 private void reverse(char[] c, int start, int end) {
		 if (start > c.length - 1 || end > c.length - 1)
			 return;
		 
		 for (int i = 0; i < (end + 1 - start)/2; i++) {
			 char tmp = c[start + i];
			 c[start + i] = c[end - i];
			 c[end - i] = tmp;
		 }
		 
	 }
	 
	 // use String.split and StringBuffer.reverse(); 13ms, 76%
	 public String reverseWords2(String s) {
	        if (s == null || s.length() < 1)
	        	return s;
	        
	        String token = " ";
	        String[] strs = s.split(token);
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < strs.length; i++) {
	        	sb.append(new StringBuilder(strs[i]).reverse());
	        	sb.append(token);
	        }
	        
	        return sb.toString().trim();
	    }
	 
	 // initial impl use String.split, but use char[] to reverse; 10ms, 90%
    public String reverseWords1(String s) {
        if (s == null || s.length() < 1)
        	return s;
        
        String token = " ";
        String[] strs = s.split(token);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
        	sb.append(reverse(strs[i]));
        	sb.append(token);
        }
        
        return sb.toString().trim();
    }
    
    
    private String reverse(String s) {
    	int len = s.length();
    	char[] c = s.toCharArray();
    	for (int i = 0; i < len/2; i++) {
    		char tmp = c[i];
    		c[i] = c[len - 1 - i];
    		c[len - 1 - i] = tmp;
    	}
    	
    	return String.valueOf(c);
    }
}
