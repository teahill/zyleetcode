package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * 
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * 
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * Hint
 * 
 * You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
 * 
 * If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. 
 * What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? 
 * How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: 
 * Implement Trie (Prefix Tree) first.
 * 
 */
public class L0212_WordSearchII {
	public L0212_WordSearchII() {
		
	}
	
	private Trie trie;
	HashSet<String> set;

    public List<String> findWords(char[][] board, String[] words) {
    	List<String> list = new ArrayList<String>();    	
        if (board == null || words == null || board.length == 0 || words.length == 0 || words[0].length() == 0)
        	return list;
        
        int size = words.length;
        trie = new Trie();
        set = new HashSet<String>();
        for (int i = 0; i < size; i++) 
        	trie.insert(words[i]);
        
        int m = board.length;
        int n = board[0].length;
        int[][] occupied = new int[m][];
        for (int i = 0; i < m; i++) {
        	occupied[i] = new int[n];
        	for (int j = 0; j < n; j++) 
        		occupied[i][j] = 0;
        }
        
        String word = "";
        for (int i = 0; i < m; i++) 
        	for (int j = 0; j < n; j++)       		        		
        		findWordsInternal(board, m, n, i, j, word, occupied);
        
      
        // iterator approach
        /*
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
        	list.add(iterator.next());
         */
        
        // alternative is to use ArrayList constructor with set as input
        list = new ArrayList<String>(set);
        
        return list;
    }
    
    private void findWordsInternal(char[][] board, int m, int n, int x, int y, String word, int[][] occupied) {
    	if (x < m && x >= 0 && y >= 0 && y < n && occupied[x][y] == 0) {   		
    		String newWord = word + String.valueOf(board[x][y]);     		
    		if (!trie.startsWith(newWord))
    			return;
    		
    		occupied[x][y] = 1;
    		if (trie.search(newWord))
    			set.add(newWord);
    			
        	//move down
    		findWordsInternal(board, m, n, x + 1, y, newWord, occupied);   		
    		// move up
    		findWordsInternal(board, m, n, x - 1, y, newWord, occupied);   		
    		// move right
    		findWordsInternal(board, m, n, x, y + 1, newWord, occupied);    		
    		// move left 
    		findWordsInternal(board, m, n, x, y - 1, newWord, occupied);
    		
    		occupied[x][y] = 0;
    	}
    	
    	return;
    }

    // this approach has issue with duplicate strings in the result set
    public List<String> findWords1(char[][] board, String[] words) {
    	List<String> list = new ArrayList<String>();    	
        if (board == null || words == null || board.length == 0 || words.length == 0 || words[0].length() == 0)
        	return list;
        
        int size = words.length;
        trie = new Trie();
        for (int i = 0; i < size; i++) 
        	trie.insert(words[i]);
        
        int m = board.length;
        int n = board[0].length;
        int[][] occupied = new int[m][];
        for (int i = 0; i < m; i++) {
        	occupied[i] = new int[n];
        	for (int j = 0; j < n; j++) 
        		occupied[i][j] = 0;
        }
        
        String word = "";
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {       		        		
        		List<String> result = findWordsInternal1(board, m, n, i, j, word, occupied);
        		for (String s : result)
        			list.add(s);
        	}
        }
        
        return list;
    }
    
    private List<String> findWordsInternal1(char[][] board, int m, int n, int x, int y, String word, int[][] occupied) {
    	List<String> list = new ArrayList<String>();

    	if (x < m && x >= 0 && y >= 0 && y < n && occupied[x][y] == 0) {   		
    		String newWord = word + String.valueOf(board[x][y]);     		
    		if (!trie.startsWith(newWord))
    			return list;
    		
    		occupied[x][y] = 1;
    		if (trie.search(newWord))
    			list.add(newWord);
    			
        	//move down
    		List<String> result = findWordsInternal1(board, m, n, x + 1, y, newWord, occupied);
    		for (String s : result)
    			list.add(s);
    		
    		// move up
    		result = findWordsInternal1(board, m, n, x - 1, y, newWord, occupied);
    		for (String s : result)
    			list.add(s);
    		
    		// move right
    		result = findWordsInternal1(board, m, n, x, y + 1, newWord, occupied);
    		for (String s : result)
    			list.add(s);
    		
    		// move left 
    		result = findWordsInternal1(board, m, n, x, y - 1, newWord, occupied);
    		for (String s : result)
    			list.add(s);
    		
    		occupied[x][y] = 0;
    	}
    	
    	return list;
    }
}
