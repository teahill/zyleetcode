package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 */
public class L0242_ValidAnagram {

	public L0242_ValidAnagram() {
		// TODO Auto-generated constructor stub
	}

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
        	return false;
        
        int size = s.length();
        int[] count = new int[26];
        for (int i = 0; i < size; i++) {
        	count[s.charAt(i) - 'a']++;
        	count[t.charAt(i) - 'a']--;
        }
        
        for (int j = 0; j < 26; j++) {
        	if (count[j] != 0)
        		return false;
        }
        	
        return true;
    }
}
