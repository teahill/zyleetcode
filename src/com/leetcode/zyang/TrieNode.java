package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Trie implementation using array
 * 
 */
public class TrieNode {
	public final TrieNode[] children ;
	public boolean isWord;
	
	public TrieNode() {
		// TODO Auto-generated constructor stub
		children = new TrieNode[26];
		isWord = false;
	}
}
