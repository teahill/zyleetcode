package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class L0044_WildcardMatch {

	public L0044_WildcardMatch() {
		// TODO Auto-generated constructor stub
	}

    public boolean isMatch(String s, String p) {
        if (( s == null && p != null) || (p == null && s != null))
        	return false;
        
        if ((p == null && s == null) || (s.length() == 0 && p.length() == 0))
        	return true;
       
        // "-1" include all leading and trailing empty string
        // "+" to skip any empty string in between
        String[] pattens = p.split("\\*+",-1);
        int n = pattens.length;

        // Special case: no * in p
        if (n == 1)
        	return isMatchWithQmark(s, p, 0) && s.length() == p.length();
        
        String head = pattens[0];
        String tail = pattens[n - 1];
        
        // Special case: compare the first and last segment of the string respectively
        // no match, return
        if (s.length() < head.length() + tail.length() || !isMatchWithQmark(s, head, 0)
        		|| !isMatchWithQmark(s, tail, s.length() - tail.length()))
        	return false;
        
        // Special case: if only two segments
        if (n == 2)
        	return true;
        
        // match the rest of patterns without first and last segments
        int start = head.length();     
        int end = s.length() - tail.length();
        for (int j = 1; j < n - 1; j++) {
        	int nj = pattens[j].length();
        	if (nj == 0)
        		continue;
        	
        	// not enough characters left in s to match pattern
        	if (start + nj > end)
        		return false; 
        
        	// look for match by moving the start pos
        	boolean found = false;
        	while (start + nj <= end) {
        		found = isMatchWithQmark(s, pattens[j], start);
        		
        		if (found)
        			break;
        		
        		start++;
        	}
        	
        	if (!found)
        		return false;
        	
        	// move to next segment
        	start += nj;
        }
        
        return true;
    }
    
    // check if there is match of s substring starting at position start
    // s string can be a lot longer as long as there is match at position start
    private boolean isMatchWithQmark(String s, String t, int start) {
    	if (s.length() - start < t.length())
    		return false;
    	
    	for (int i = 0; i < t.length(); i++) 
    		if (s.charAt(start + i) != t.charAt(i) && t.charAt(i) != '?')
    			return false;

    	return true;
    }
}
