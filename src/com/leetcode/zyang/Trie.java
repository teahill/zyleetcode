package com.leetcode.zyang;

public class Trie {

	private TrieNode root;
	
	public Trie() {
		// TODO Auto-generated constructor stub
		root = new TrieNode();
	}
   
    // Inserts a word into the trie.
    public void insert(String word) {
    	if (word == null)
    		return;
    	
    	int len = word.length();
    	TrieNode node = root;
    	for (int i = 0; i < len; i++) {
    		TrieNode nextNode = node.children[word.charAt(i) - 'a'];
    		if (nextNode == null) {
    			TrieNode newNode = new TrieNode();
    			node.children[word.charAt(i) - 'a'] = newNode;
    			node = newNode;
    		}
    		else 
    			node = nextNode;
    	}
    	
    	node.isWord = true;
    	
    	return;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	if (word == null)
    		return false;
    	
    	int len = word.length();
    	TrieNode node = root;
    	for (int i = 0; i < len; i++) {
    		TrieNode nextNode = node.children[word.charAt(i) - 'a'];
    		if (nextNode == null) 
    			return false;
    		node = nextNode;
    	}
    	
    	return node.isWord;
    }

    // Returns if there is any word in the Trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	if (prefix == null)
    		return false;
    	
    	int len = prefix.length();
    	TrieNode node = root;
    	for (int i = 0; i < len; i++) {
    		TrieNode nextNode = node.children[prefix.charAt(i) - 'a'];
    		if (nextNode == null) 
    			return false;
    		node = nextNode;
    	}
    	
    	return true;
    }
}