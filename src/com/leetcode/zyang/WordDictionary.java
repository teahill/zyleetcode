package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class WordDictionary {
	private TrieNode root;
	
	public WordDictionary() {
		root = new TrieNode();
	}
    // Adds a word into the data structure.
    public void addWord(String word) {
    	if (word == null)
    		return;
    	
        TrieNode node = root;        
        int len = word.length();
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    
    public boolean search(String word) {
    	boolean found = search(word, root);
    	
    	return found;
    }
    
    private boolean search(String word, TrieNode node) {      
        int len = word.length();
        for (int i = 0; i < len; i++) {
        	TrieNode nextNode;
        	if (word.charAt(i) != '.') {
        		nextNode = node.children[word.charAt(i) - 'a'];
        		if (nextNode == null)
        			return false;
        		
        		node = nextNode;
        	}
        	else {
        		for (int j = 0; j < 26; j++) {
        			if (node.children[j] != null) {
        				boolean found = search (word.substring(i+1), node.children[j]);
        				
        				if(found)
        					return found;
        			}
        		}
        		
        		return false;
        	}
        }
        
        return node.isWord;    
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");