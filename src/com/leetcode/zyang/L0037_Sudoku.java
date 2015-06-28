package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * 
 * A sudoku puzzle...
 * 
 * 
 * ...and its solution numbers marked in red.
 */
public class L0037_Sudoku {

	public L0037_Sudoku() {
		// TODO Auto-generated constructor stub
	}

    public void solveSudoku(char[][] board) {

    	solveSudokuInternal(board);
    	
    	return;
    }
    
    private boolean solveSudokuInternal(char[][] board) {        
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (board[i][j] == '.') {
    				for (char ch = '1'; ch <= '9'; ch++) {
    					if (okBoard(board, i, j, ch)) {
    						board[i][j] = ch;
    						boolean isSolved = solveSudokuInternal(board);
    						if (isSolved)
    							return true;
    						else
    							board[i][j] = '.';    							
    					}    					
    				}
    				
    				return false;
    			}    				
    		}
    	}
    	
    	return true;
    }
    
    private boolean okBoard(char[][] board, int x, int y, char ch) {
    	for (int i = 0; i < board.length; i++) {
    		if (ch == board[i][y])
    			return false;
    	}
    	
    	for (int j = 0; j < board[0].length; j++) {
    		if (ch == board[x][j])
    			return false;
    	}	
    	
    	for (int i = (x/3)*3; i < (x/3)*3 + 3; i++) {
    		for (int j = (y/3)*3; j < (y/3)*3 + 3; j++) {
    			if (ch == board[i][j])
    				return false;
    		}
    	}
    	
    	return true;
    }
}
