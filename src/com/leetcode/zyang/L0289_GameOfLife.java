package com.leetcode.zyang;

/**
 * @author zyang
 * 
 *         According to the Wikipedia's article:
 *         "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * 
 *         Given a board with m by n cells, each cell has an initial state live
 *         (1) or dead (0). Each cell interacts with its eight neighbors
 *         (horizontal, vertical, diagonal) using the following four rules
 *         (taken from the above Wikipedia article):
 * 
 *         1. Any live cell with fewer than two live neighbors dies, as if caused by under-population. 
 *         
 *         2. Any live cell with two or three live neighbors lives on to the next generation. 
 *         
 *         3. Any live cell with more than three live neighbors dies, as if by over-population.. 
 *         
 *         4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction. 
 *         
 *         Write a function to compute the next state (after one update) of the board given its current state.
 * 
 *         Follow up: 
 *         
 *         1. Could you solve it in-place? Remember that the board needs
 *         to be updated at the same time: You cannot update some cells first
 *         and then use their updated values to update other cells. 
 *         
 *         2. In this question, we represent the board using a 2D array. In principle, the
 *         board is infinite, which would cause problems when the active area
 *         encroaches the border of the array. How would you address these
 *         problems?
 */
public class L0289_GameOfLife {

	public L0289_GameOfLife() {
		// TODO Auto-generated constructor stub
	}

	// since the state only uses 1 bit while board is int. Use second bit to store new state
    public void gameOfLife(int[][] board) {
        if (board == null) 
        	return;
        
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int count = 0;
        		for (int k = Math.max(i - 1, 0); k <= Math.min(i + 1, m - 1); k++) {
        			for (int l = Math.max(j - 1, 0); l <= Math.min(j + 1, n - 1); l++) 
        				count += board[k][l] & 1;
        		}
        		
        		count -= board[i][j];
        		if (((board[i][j] == 1) && (count == 2 || count == 3)) || ((board[i][j] == 0) && (count == 3)))
        				board[i][j] |= 2;        		
        	}
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) 
        		board[i][j] >>= 1;
        }
        
        return;        	
    }
}
