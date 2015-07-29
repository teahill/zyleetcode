package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Return 4.
 * 
 */
public class L0221_MaximumSquare {

	public L0221_MaximumSquare() {
		// TODO Auto-generated constructor stub
	}

	// Using DP; 
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return 0;
        
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] square = new int[m][n];
        
        // Copy over the matrix[0][n]; matrix[m][0]
        for (int i = 0; i < m; i++) {
        	square[i][0] = (matrix[i][0] == '0') ? 0 : 1;
    		if (square[i][0] > max)
    			max = square[i][0]; 
        }
        
        for (int j = 0; j < n; j++) {
        	square[0][j] = (matrix[0][j] == '0') ? 0 : 1;
    		if (square[0][j] > max)
    			max = square[0][j]; 
        }
        
        for (int i = 1; i < m; i++) 
        	for (int j = 1; j < n; j++) 
        		if (matrix[i][j] == '0')
	        		square[i][j] = 0;
        		else {
        			square[i][j]= Math.min(Math.min(square[i-1][j], square[i][j-1]), square[i-1][j-1]) + 1;   
			        if (square[i][j] > max)
						max = square[i][j];   
        		}      	        	
        
        return max * max;
    }	
}
