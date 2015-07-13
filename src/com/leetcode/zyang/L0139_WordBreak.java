package com.leetcode.zyang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author zyang
 * 
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence 
 * of one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 */
public class L0139_WordBreak {

	public L0139_WordBreak() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0)
        	return false;
        
        int n = s.length();
        boolean[] b = new boolean[n];     	
        for (int i = 0; i < n; i++) {
        	if (wordDict.contains(s.substring(0, i + 1))) {
        		b[i] = true;
        		continue;
        	}        		
        		
        	for (int j = i - 1; j >= 0; j--) {
        		b[i] = b[j] && wordDict.contains(s.substring(j + 1, i + 1));
        		
        		if (b[i])
        			break;        				
        	}
        }
        
        return b[n - 1];        
	}

    public boolean wordBreak1(String s, Set<String> wordDict) {
        boolean isWord = false;
        if (s == null)
        	return isWord;
        
        char[] chars = s.toCharArray();
        int n = chars.length;
        HashMap<String, Boolean> lastWords = new HashMap<String, Boolean>(); 
        lastWords.put("", false);
        for (int i = 0; i < n; i++) {
        	HashMap<String, Boolean> newList = new HashMap<String, Boolean>();
        	isWord = false;
        	Set<String> oldSet = lastWords.keySet();
        	Iterator<String> iterator = oldSet.iterator();
        	while (iterator.hasNext())	 {
        		String last = iterator.next();
        		StringBuilder sb = new StringBuilder(last);
        		sb = sb.append(chars[i]);
        		if (wordDict.contains(sb.toString())) {
        			isWord = true;
        			newList.put(sb.toString(), true);
        		}
        		else
        			newList.put(sb.toString(), false);
        		
        		if (lastWords.get(last) == true) {
        			String newChar = String.valueOf(chars[i]);
        			if (wordDict.contains(newChar)) {
        				newList.put(newChar, true);
        				isWord = true;
        			}
        			else
        				newList.put(newChar, false);
        		}
        	}
        	
        	lastWords = newList;
        }
       
        return isWord;
    }
}
