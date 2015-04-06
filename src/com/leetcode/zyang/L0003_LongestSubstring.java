package com.leetcode.zyang;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author zyang
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 */
public class L0003_LongestSubstring {

	public L0003_LongestSubstring() {
		// TODO Auto-generated constructor stub
	}

    public int lengthOfLongestSubstring(String s) {        
    	if (s == null || s.length() == 0)
    		return 0;
    	
    	HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
    	int steps = 0, maxLen = 0;
    	int resetPos = 0;
    	for (int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		if (hMap.containsKey(ch)) {
    			int hPos = hMap.get(ch);
    			if (hPos < resetPos) 
    				steps++;   				
    			else {
    				resetPos = hPos;
    				maxLen = (maxLen > steps) ? maxLen : steps;
    				steps = i - hPos;
    			}
    		}
    		else 
    			steps++;
    		
    		hMap.put(ch, i);
    	}
    	
    	maxLen = (maxLen > steps) ? maxLen : steps;
    	return maxLen;	
    }
    
    public int lengthOfLongestSubstring1(String s) {        
    	if (s == null || s.length() == 0)
    		return 0;
    	
    	HashMap<Character, Integer> hMap = new HashMap<Character, Integer>();
    	int maxLen = 0, lastLen = 1;
    	int resetPos = 0;
    	for (int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		if (hMap.containsKey(ch)) {
    			int prevPos = hMap.get(ch);
    			if (prevPos < resetPos) {
        			hMap.put(ch, i); 
        			maxLen++;
    			} 
    			else {	
	    			int len = i - prevPos;
	    			if (len > lastLen && len > maxLen)
	    				lastLen = len;
	    			else if (maxLen > lastLen)
	    				lastLen = maxLen;
	    			
	    			resetPos = prevPos;	
	    			hMap.put(ch, i);
	    			maxLen = 1;
    			}
    		}
    		else {
    			hMap.put(ch, i); 
    			maxLen++;
    		}
    	}
    	
    	return (maxLen > lastLen) ? maxLen : lastLen;
    }
}
