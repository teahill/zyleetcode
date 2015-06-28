package com.leetcode.zyang;

import java.util.HashSet;

/**
 * 
 * @author zyang
 * 
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class L0052_nQueenII {

	public L0052_nQueenII() {
		// TODO Auto-generated constructor stub
	}


	
    public int totalNQueens(int n) {    	
    	// Use HashSet to track col, left diag, right diag occupancy. 
    	// Left diag occupied: row - col const; 
    	//right diag occupied: row + col const
    	HashSet<Integer> setCol = new HashSet<Integer>();
    	HashSet<Integer> setLDiag = new HashSet<Integer>();
    	HashSet<Integer> setRDiag = new HashSet<Integer>();
    	
    	int total = totalNQueens(n, 0, setCol, setLDiag, setRDiag);
    	
    	return total;
    }
    
    private int totalNQueens(int n, int row, HashSet<Integer> setCol,
    		HashSet<Integer> setLDiag, HashSet<Integer> setRDiag) {
    	
    	int count = 0;
    	if (row == n) {
    		count++;
    		return count;
    	}
    	
        for (int i = 0; i < n; i++) {
        	int sum = row + i;
        	int delta = row - i;
        	if (setCol.contains(i) || setLDiag.contains(delta) || setRDiag.contains(sum))
        		continue;
        	
        	setCol.add(i);
        	setLDiag.add(delta);
        	setRDiag.add(sum);      
        	
        	count = count + totalNQueens(n, row + 1, setCol, setLDiag, setRDiag);
        	
        	// reset HashSet
        	setCol.remove(i);
        	setLDiag.remove(delta);
        	setRDiag.remove(sum);
        }
        
        return count;    	
    }
}
