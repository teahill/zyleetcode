package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */

//Leetcode L0208_Trie
public class L0208_Trie {
    private TrieNodeList root;

    public L0208_Trie() {
        root = new TrieNodeList();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNodeList node = root;
        TrieNodeList parent = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
        	boolean found = false;
        	List<TrieNodeList> children = parent.children;
        	if (children != null) {
        		for (int j = 0; j < children.size(); j++) {
        			node = children.get(j);
        			if (word.charAt(i) == node.ch) {
        				found = true;
        				break;
        			}
        		}

        		if (found) {
        			parent= node;
        			continue;
        		}
        	}

        	if (children == null) 
        		parent.children = new ArrayList<TrieNodeList>();

        	TrieNodeList newNode = new TrieNodeList();
        	newNode.ch = word.charAt(i);
        	parent.children.add(newNode); 
        	
        	parent = newNode;
        }
        
        // make sure closing '\0'
        List<TrieNodeList> children = parent.children;
    	if (children != null) 
	    	for (int j = 0; j < children.size(); j++) 
	    		if (children.get(j).ch == '\0') 
	    			return;
	    	
    	if (children == null) 
    		parent.children = new ArrayList<TrieNodeList>();
    	
    	TrieNodeList end = new TrieNodeList();
    	end.ch = '\0';
    	parent.children.add(end);
    	return;      
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	if (word == null || word.length() == 0)
    		return true;
    	
        TrieNodeList parent = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
        	boolean found = false;
        	List<TrieNodeList> children = parent.children;
        	if (children == null)
        		return false;
        	
        	for (int j = 0; j < children.size(); j++) {
        		if (word.charAt(i) == children.get(j).ch) {
        			found = true;
        			parent = children.get(j);        			
        			break;
        		}
        	}
        	 
        	if (!found)
        		return found;        	
        }
        
        // check closing null
        List<TrieNodeList> children = parent.children;
    	if (children == null)
    		return false;
    	
    	for (int j = 0; j < children.size(); j++) 
    		if (children.get(j).ch == '\0') 
    			return true;
    	
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	if (prefix == null || prefix.length() == 0)
    		return true;
    	
        TrieNodeList parent = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
        	boolean found = false;
        	List<TrieNodeList> children = parent.children;
        	if (children == null)
        		return false;
        	
        	for (int j = 0; j < children.size(); j++) {
        		if (prefix.charAt(i) == children.get(j).ch) {
        			found = true;
        			parent = children.get(j);        			
        			break;
        		}
        	}
        	 if (!found)
        		 return found;        	
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");