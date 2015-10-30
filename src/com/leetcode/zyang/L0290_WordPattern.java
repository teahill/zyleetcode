package com.leetcode.zyang;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zyang
 * 
 *         Given a pattern and a string str, find if str follows the same
 *         pattern.
 * 
 *         Here follow means a full match, such that there is a bijection
 *         between a letter in pattern and a non-empty word in str.
 * 
 *         Examples: pattern = "abba", str = "dog cat cat dog" should return
 *         true. pattern = "abba", str = "dog cat cat fish" should return false.
 *         pattern = "aaaa", str = "dog cat cat dog" should return false.
 *         pattern = "abba", str = "dog dog dog dog" should return false. Notes:
 *         You may assume pattern contains only lowercase letters, and str
 *         contains lowercase letters separated by a single space.
 */
public class L0290_WordPattern {

	public L0290_WordPattern() {
		// TODO Auto-generated constructor stub
	}

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null)
        	return false;
        
        String[] segments = str.split(" ");
        if (pattern.length() != segments.length || segments.length == 0)
        	return false;
        
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> map1 = new HashMap<String, String>();
        for (int i = 0; i < pattern.length(); i++) {
        	String patternChar = pattern.substring(i, i+1);
        	
        	// Check pattern -> segment match
        	if (map.containsKey(patternChar)) {     		
        		if (!segments[i].equals(map.get(patternChar)))
        				return false;
        	}
        	else 
        		map.put(patternChar, segments[i]); 
        	
        	// Check segment -> pattern match
        	if (map1.containsKey(segments[i])) {     		
        		if (!patternChar.equals(map1.get(segments[i])))
        				return false;
        	}
        	else 
        		map1.put(segments[i], patternChar); 
        }
        
        return true;
    }    
    
    
    /*
	 * String java.util.HashMap.put(String key, String value)
	 * 
	 * Associates the specified value with the specified key in this map. If the
	 * map previously contained a mapping for the key, the old value is
	 * replaced.
	 * 
	 * Specified by: put(...) in Map, Overrides: put(...) in AbstractMap
	 * Parameters: key key with which the specified value is to be associated
	 * value value to be associated with the specified key Returns: the previous
	 * value associated with key, or null if there was no mapping for key. (A
	 * null return can also indicate that the map previously associated null
	 * with key.)
	 */
    public boolean wordPattern1(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (int i=0; i<words.length; ++i)
            if (!Objects.equals(index.put(pattern.charAt(i), i),
                                index.put(words[i], i)))
                return false;
        return true;
    }
}
