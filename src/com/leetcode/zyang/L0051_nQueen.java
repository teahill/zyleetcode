package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class L0051_nQueen {

	public L0051_nQueen() {
		// TODO Auto-generated constructor stub
	}

    public List<String[]> solveNQueens(int n) {
    	String[] board = new String[n];
    	
    	List<String[]> finalList = solveNQueensInternal(n, 0, board);
    	
    	return finalList;
    }
    
    private List<String[]> solveNQueensInternal(int n, int row, String[] board) {
        List<String[]> list = new ArrayList<String[]>();
        
        if (row == n) {
        	list.add(board);
        	return list;
        }
        	        
        for (int i = 0; i < n; i++) {
         	if (okBoard(n, row, board, i)) {
         		String[] newBoard = board.clone();
        		StringBuilder sb = new StringBuilder(initRow(n));
               	sb.replace(i, i+1, "Q");
            	String s = sb.toString();
        		newBoard[row] = s;
        		List<String[]>  newList = solveNQueensInternal(n, row + 1, newBoard);
        		for (String[] str : newList) 
        			list.add(str);
        	}
        }
        
        return list;
    }
    
    private boolean okBoard(int n, int row, String[] board, int pos) {
    	
    	for (int i = 0; i < row; i++) {
    		int lDiag = pos - (row - i);
    		int rDiag = pos + (row - i);
    		if ( board[i].charAt(pos) == 'Q')
    			return false;

    		if (lDiag >= 0 && board[i].charAt(lDiag) == 'Q')
    			return false;
    		else if (rDiag <= n - 1 && board[i].charAt(rDiag) == 'Q')
    			return false;
    		else
    			continue;    		
    	}
    	
    	return true;
    }
    
    private String initRow(int n) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < n; i++)
    		sb.append('.');
    	
    	return sb.toString();
    }
}
