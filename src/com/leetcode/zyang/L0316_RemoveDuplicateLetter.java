package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 *         Given a string which contains only lowercase letters, remove
 *         duplicate letters so that every letter appear once and only once. You
 *         must make sure your result is the smallest in lexicographical order
 *         among all possible results.
 * 
 *         Example: Given "bcabc" Return "abc"
 * 
 *         Given "cbacdcbc" Return "acdb"
 */
public class L0316_RemoveDuplicateLetter {
	
	// Correct answer, but TLE
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2)
        	return s;
        
    	List<String> list = new ArrayList<String>();
    	String str = new String();
    	list.add(str);
    	
    	int rem = s.length();
        while(rem > 0) {
        	int curPos = s.length() - rem;
	    	char c = s.charAt(curPos);
	    	
	    	List<String> nList = new ArrayList<String>();
	    	for (String element : list) {
	    		boolean isDuplicate = false;
		    	for(int i = 0; i < element.length(); i++) {
		    		if (element.charAt(i) == c) {
		    			String s1 = element.substring(0, i) + element.substring(i+1) + c;
		    			nList.add(s1);
		    			nList.add(element);
		    			isDuplicate = true;
		    			break;
		    		}
		    	}
		    	
		    	if (!isDuplicate) {
		    		nList.add(element + c);
		    		break;
		    	}
	    	}
	    	
	    	list = nList;
	    	rem--;
        }
        
        String result = list.get(0);
        for (String element : list) 
        	result = (result.compareTo(element) <= 0) ? result : element;

        return result;
    }
}
