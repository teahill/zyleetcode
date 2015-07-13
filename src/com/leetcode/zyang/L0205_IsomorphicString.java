package com.leetcode.zyang;

import java.util.HashMap;

/**
 * 
 * @author zyang
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note:
 * You may assume both s and t have the same length.
 */
public class L0205_IsomorphicString {

	public L0205_IsomorphicString() {
		// TODO Auto-generated constructor stub
	}

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null)
        	return false;
        
        if (s.length() != t.length())
        	return false;
        
        int len = s.length();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
        	char sChar = s.charAt(i);
        	char tChar = t.charAt(i);
        	
        	Character value = map.get(sChar);
        	if (value == null) {
        		if (!map.containsValue(tChar)) {
	        		sb.append(tChar);
	        		map.put(sChar, tChar);
        		}
        		else
        			return false;
        	}
        	else
        		sb.append(value);
        	
        }
        
        return sb.toString().equals(t);
    }
}
