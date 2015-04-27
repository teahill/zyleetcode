package com.leetcode.zyang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 */
public class L0049_Anagrams {

	public L0049_Anagrams() {
		// TODO Auto-generated constructor stub
	}

    public List<String> anagrams(String[] strs) {
    	List<String> list = new LinkedList<String>();
    	
        if (strs == null || strs.length < 2)
        	return list;
        
        HashMap<String, String> map = new HashMap<String, String>();
        HashSet<String> set = new HashSet<String>();
        
        for (String s : strs) {
        	char[] chArray = s.toCharArray();
        	Arrays.sort(chArray);        	
        	String key = new String(chArray);
        	
        	String match = map.get(key);        	
        	if (match == null) {
        		map.put(key, s);
        		continue;
        	}
        	
        	if (!set.contains(key)) {
        		list.add(match);
        		set.add(key);
        	}
        	
        	list.add(s);
        }   
        
        return list;
    }
}
