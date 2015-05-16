package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * click to show follow up.
 * 
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 */
public class L0073_SetMatrixZeroes {

	public L0073_SetMatrixZeroes() {
		// TODO Auto-generated constructor stub
	}

    public void setZeroes(int[][] matrix) {
        if (matrix == null)
        	return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // use row 0 to store columns with zero
        // use col 0 to store rows with zero except row 0 and col 0
        // as matrix[0][0] is shared 
        // Separately handling row 0 and col 0
        boolean row_0_reset = false;
        boolean col_0_reset = false;
        for (int i = 0; i < m; i++) {
        	if (matrix[i][0] == 0) {
        		col_0_reset = true;
        		break;
        	}
        }
        
        for (int j = 0; j < n; j++) {
        	if (matrix[0][j] == 0) {
        		row_0_reset = true;
        		break;
        	}
        }
        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        
        // Zero out rows        
        for (int i = 1; i < m; i++) {
        	if (matrix[i][0] == 0)
        		setZeroRow(matrix, i, m, n);
        }
        
        // zero out cols
        for (int j = 1; j < n; j++) {
        	if (matrix[0][j] == 0)
        		setZeroCol(matrix, j, m, n);
        }
        
        // First row and col
        if (row_0_reset)
        	setZeroRow(matrix, 0, m, n);       
        
        if (col_0_reset)
        	setZeroCol(matrix, 0, m, n);
    }
    
    private void setZeroRow(int[][] matrix, int row, int m, int n) {
    	for (int j = 0; j < n; j++)
    		matrix[row][j] = 0;
    }
    
	private void setZeroCol(int[][] matrix, int col, int m, int n) {
    	for (int i = 0; i < m; i++)
    		matrix[i][col] = 0;
    }
}
