package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zyang
 * 
 *         Given a List of words, return the words that can be typed using
 *         letters of alphabet on only one row's of American keyboard like the
 *         image below. 
 *         Example 1: Input: ["Hello", "Alaska", "Dad", "Peace"]
 *         Output: ["Alaska", "Dad"] 
 *         Note: You may use one character in the
 *         keyboard more than once. You may assume the input string will only
 *         contain letters of alphabet.
 * 
 */
public class L0500_KeywordRow {

	//6ms, 33%
    public String[] findWords(String[] words) {
        if (words == null || words.length < 1)
        	return new String[0];
        
	   	String[] board = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
	   	Map<Character, Integer> map = new HashMap<Character, Integer>();
	   	for (int i = 0; i < board.length; i++) {
	   		for (Character c : board[i].toCharArray())
	   			map.put(c, i);
	   	}
	   	
    	List<String> list = new ArrayList<String>();
    	for (String word : words) { 
    		if (word.length() == 0 || map.get(word.toLowerCase().charAt(0)) == null)
    			continue;
    		
    		int row = map.get(word.toLowerCase().charAt(0));			
			boolean exist = true;
    		for (int j = 1; j < word.length(); j++) {
    			if (map.get(word.toLowerCase().charAt(j)) != row) {
    				exist = false;
    				break;
    			}
    		}
    		
    		if (exist)
    			list.add(word);
    	}
    	    	
    	return list.toArray(new String[list.size()]);
    }
	
	//6ms, 33%
    public String[] findWords1(String[] words) {
        if (words == null || words.length < 1)
        	return new String[0];
        
	   	List<String> board = Arrays.asList("qwertyuiop", "asdfghjkl", "zxcvbnm");
	   	
    	List<String> list = new ArrayList<String>();
    	for (int i = 0; i < words.length; i++) {
    		int row = -1;   
    		//find which row from the first letter
			for (int k = 0; k < 3; k++) {
				if (board.get(k).contains(
						String.valueOf(words[i].toLowerCase().charAt(0)))) {
					row = k;
					break;
				}
			}
			
			if (row == -1)
				continue;
			
			boolean exist = true;
    		for (int j = 1; j < words[i].length(); j++) {
    			if (!board.get(row).contains(String.valueOf(words[i].toLowerCase().charAt(j)))) {
    				exist = false;
    				break;
    			}
    		}
    		
    		if (exist)
    			list.add(words[i]);
    	}
    	    	
    	return list.toArray(new String[list.size()]);
    }
}
