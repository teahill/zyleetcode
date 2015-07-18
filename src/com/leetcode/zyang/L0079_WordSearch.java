package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 */
public class L0079_WordSearch {

	public L0079_WordSearch() {
		// TODO Auto-generated constructor stub
	}

	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0)
			return false;

		if (board == null || board.length == 0 || board[0].length == 0)
			return false;

		int m = board.length;
		int n= board[0].length;
		int[][] occupied = new int[m][];
		for (int i = 0; i < m; i++) {
			occupied[i] = new int[n];
			for (int j = 0; j < n; j++)
				occupied[i][j] = 0;
		}    	

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean exist = existInternal(board, m, n, i, j, word, 0, occupied);
				if (exist)
					return exist;
			}    		
		}   
		
		return false;
	}
    
	private boolean existInternal(char[][] board, int m, int n, int x, int y, String word, int k, int [][] occupied) {
		if (k == word.length())
			return true;
		
		boolean exist = false;
		if (x < m && x >= 0 && y >= 0 && y < n && occupied[x][y] == 0) {
			if (word.charAt(k) != board[x][y])
				return exist;
			
			occupied[x][y] = 1;
			
			//move right
			exist = existInternal(board, m, n, x, y + 1, word, k + 1, occupied);
			if (exist)
				return exist;
			
			//move left
			exist = existInternal(board, m, n, x, y -1, word, k + 1, occupied);
			if (exist)
				return exist;
			
			//move up
			exist = existInternal(board, m, n, x - 1, y, word, k + 1, occupied);
			if (exist)
				return exist;
			
			//move down
			exist = existInternal(board, m, n, x + 1, y, word, k + 1, occupied);
			if (exist)
				return exist;
			
			occupied[x][y] = 0;
		}
		
		return exist;
	}
	
	// first solution, works, but not clean;
    public boolean exist1(char[][] board, String word) {
    	if (word == null || word.length() == 0)
    		return false;
    	
    	if (board == null || board.length == 0 || board[0].length == 0)
    		return false;
    	
    	int[][] occupied = new int[board.length][];
    	for (int i = 0; i < board.length; i++) {
    		occupied[i] = new int[board[i].length];
    		for (int j = 0; j < board[i].length; j++)
    			occupied[i][j] = 0;
    	}    	
    	
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[i].length; j++)
    			if (board[i][j] == word.charAt(0)) {
    				occupied[i][j] = 1;
    				boolean exist = existWord(board, word, 1, i, j, occupied);
    				if (exist)
    					return exist;
    				
    				occupied[i][j] = 0;
    			}    		
    	}     	   	
        return false;
    }
    
    boolean existWord(char[][] board, String word, int k, int lastX, int lastY, int [][] occupied) {
    	if (k >= word.length())
    		return true;
    	
    	//move down
    	int curX = lastX + 1;
    	int curY = lastY;
    	if (foundLetter(board, word, k, curX, curY, occupied)) 
    		return true;  	    			
    	
    	// move up 
    	curX = lastX - 1;
       	curY = lastY;       	
    	if (foundLetter(board, word, k, curX, curY, occupied))     		
    		return true;  
    	
    	// move right
    	curX = lastX;
       	curY = lastY + 1;    	
    	if (foundLetter(board, word, k, curX, curY, occupied)) 
    		return true;    	
    	
    	// move left 
    	curX = lastX;
       	curY = lastY - 1;
    	if (foundLetter(board, word, k, curX, curY, occupied)) 
    		return true;  
    	
    	return false;
    }
    
    boolean foundLetter(char[][] board, String word, int k, int curX, int curY, int[][] occupied) {
    	char ch = word.charAt(k);
    	
    	if (curX < board.length && curX >= 0 && curY >= 0 && curY < board[0].length && occupied[curX][curY] == 0 && board[curX][curY] == ch) {
    		occupied[curX][curY] = 1;
    		boolean ok = existWord(board, word, k + 1, curX, curY, occupied);
    		if (ok)
    			return ok;
    		else {
    			occupied[curX][curY] = 0; 
    			return false;
    		}
    	}	
    	else
    		return false;
    }   
}
