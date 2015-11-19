package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zyang
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * 
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 */
public class L0131_PalindromePartition {

	private Map<String, List<List<String>>> map;
	
	public L0131_PalindromePartition() {
		// TODO Auto-generated constructor stub
		map = new HashMap<String, List<List<String>>>();
	}

    public List<List<String>> partition(String s) {
        List<List<String>> allList = new ArrayList<List<String>>();
        
        if (s == null || s.length() == 0)
        	return allList;
        
        allList = partitionInternal(s);
        
        return allList;
    }
    
    private List<List<String>> partitionInternal(String s) {
    	List<List<String>> allList = new ArrayList<List<String>>();
    	    	
        int n = s.length();        
        if (n == 0) {
        	List<String> list = new ArrayList<String>();
        	allList.add(list);
        	return allList;
        }
        
        if (map.containsKey(s))
        	return map.get(s);        	
        	
        for (int size = 1; size <= n; size++) {
        	String sub = s.substring(0, size);
        	if (isPalindrome(sub)) {
        		List<List<String>> newList = partitionInternal(s.substring(size));
        		for (List<String> l : newList) {
        			List<String> newL = new ArrayList<String>();
        			newL.add(sub);
        			newL.addAll(l);
        			allList.add(newL);
        		}
        	}
        }

        map.put(s, allList);
        
        return allList;
    }
    
    private boolean isPalindrome(String s) {   	
    	int n = s.length();
    	for (int i = 0; i < n/2; i++) {
    		if (s.charAt(i) != s.charAt(n - 1 - i))
    			return false;
    	}
    	
    	return true;
    }
}
