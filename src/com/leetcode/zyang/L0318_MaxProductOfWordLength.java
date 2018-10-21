package com.leetcode.zyang;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author zyang
 * 
 *         Given a string array words, find the maximum value of length(word[i])
 *         * length(word[j]) where the two words do not share common letters.
 *         You may assume that each word will contain only lower case letters.
 *         If no such two words exist, return 0.
 * 
 *         Example 1: Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 *         Return 16 The two words can be "abcw", "xtfn".
 * 
 *         Example 2: Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] Return
 *         4 The two words can be "ab", "cd".
 * 
 *         Example 3: Given ["a", "aa", "aaa", "aaaa"] Return 0 No such pair of
 *         words.
 */
public class L0318_MaxProductOfWordLength {
    public int maxProduct(String[] words) {
    	int max = 0;
    	if (words == null || words.length <= 1)
    		return max;
    	
    	@SuppressWarnings("unchecked")
		Set<Integer>[] setArray = new HashSet[26];
    	for (int i = 0; i < 26; i++)
    		setArray[i] = new HashSet<Integer>();
    	
    	add(setArray, words[0], 0);
    	for (int i = 1; i < words.length; i++) {
    		Set<Integer> unique = createUniqueWordSet(i);
    		for (int j = 0; j < words[i].length(); j++) 
    			unique.removeAll(setArray[words[i].charAt(j) - 'a']);
    		
    		for (int word : unique)
    			max = Math.max(max, words[i].length() * words[word].length());
    		
    		add(setArray, words[i], i);
    	}
    	
    	return max;
    }
    
    private void add(Set<Integer>[] setArray, String word, int n) {
    	for (int i = 0; i < word.length(); i++)
    		setArray[word.charAt(i) - 'a'].add(n);
    }
    
    private Set<Integer> createUniqueWordSet(int n) {
    	Set<Integer> unique = new HashSet<Integer>();
    	for (int i = 0; i < n; i++)
    		unique.add(i);
    	
    	return unique;
    }
}
