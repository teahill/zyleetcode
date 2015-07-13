package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author zyang
 * 
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class L0140_WordBreakII {

	public L0140_WordBreakII() {
		// TODO Auto-generated constructor stub
	}

	private HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	
	
	// Does nto work well with "baaaaaaaaaaa", TLE
	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> list = new ArrayList<String>();
    	list.add("");
        if (s == null || s.length() == 0) 
        	return list; 
        
		map.put("", list);
       
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
        	List<String> listNew = new ArrayList<String>();
        	String end = s.substring(i);        	
        	if (wordDict.contains(end)) 
        		listNew.add(end);
        	      	
        	int m = end.length();        	
        	for (int j = 1; j < m; j++) {        		
        		String prefix = s.substring(i, i + j);
            	if (wordDict.contains(prefix)) {
            		String suffix = s.substring(i + j);
            		List<String> prev = map.get(suffix);
            		if (prev != null) {
	            		int size = prev.size();
	            		for (int k = 0; k < size; k++) {
	            			String old = prev.get(k);
	            			String str = (old.length() == 0) ? prefix : (prefix + " " + old);
	            			//str.trim();
	            			listNew.add(str);   
	            			
	            		}     
            		}
            	} 
        	}
        	
        	map.put(end, listNew);
        }
        
        return map.get(s);
	}
	
	// works 
	public List<String> wordBreak1(String s, Set<String> wordDict) {
		List<String> list = new ArrayList<String>();	
        if (s == null || s.length() == 0) {
        	list.add("");
        	return list; 
        }
       
        int n = s.length();
        for (int i = 1; i < n + 1; i++) {
        	String prefix = s.substring(0, i);
        	if (wordDict.contains(prefix)) {
        		String suffix = s.substring(i);
        		List<String> prev;
        		if (map.containsKey(suffix)) 
        			prev = map.get(suffix);
        		else {
        			prev = wordBreak(suffix, wordDict);
        			map.put(suffix, prev);
        		}
        		
        		int size = prev.size();
        		for (int j = 0; j < size; j++) {
        			String old = prev.get(j);
        			String str = (old.length() == 0) ? prefix : (prefix + " " + old);
        			//str.trim();
        			list.add(str);        			
        		}        		
        	}       	
        }
        
        return list;
	}
	
	// Does not work will with "aaaaaaaaaaaaaaab", TLE
    @SuppressWarnings("unchecked")
	public List<String> wordBreak2(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0)
        	return new ArrayList<String>();
        
        int n = s.length();
        boolean[] b = new boolean[n];
        List<String>[] listArray = new ArrayList[n];
        for (int i = 0; i < n; i++) {
        	listArray[i] = new ArrayList<String>();
        	if (wordDict.contains(s.substring(0, i + 1))) {
        		b[i] = true;
        		listArray[i].add(s.substring(0, i + 1));
        	}        		
        		
        	for (int j = i - 1; j >= 0; j--) {
        		boolean breakable = b[j] && wordDict.contains(s.substring(j + 1, i + 1));
        		
        		if (breakable) {
        			b[i] = true;
        			int size = listArray[j].size();
        			for (int k = 0; k < size; k++) 
        				listArray[i].add(listArray[j].get(k) + " " + s.substring(j + 1, i + 1));
        		}       				
        	}
        }
        
        return listArray[n-1];     
    }
}
