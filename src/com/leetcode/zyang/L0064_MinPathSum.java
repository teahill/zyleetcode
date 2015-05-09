package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top left 
 * to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 */
public class L0064_MinPathSum {

	public L0064_MinPathSum() {
		// TODO Auto-generated constructor stub
	}

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        
        //Bottom up dynamic programming
        sum[m-1][n-1] = grid[m-1][n-1];
        
        // Fill last row
        for (int j = n - 2; j >= 0; j--) 
        	sum[m - 1][j] = grid[m - 1][j] + sum[m - 1][j + 1];
        
        // Fill last column
        for (int i = m - 2; i >= 0; i--) 
        	sum[i][n - 1] = grid[i][n - 1] + sum[i + 1][n - 1];
        
        // Fill all the middle ones
        for (int i = m - 2; i >= 0; i--) {
        	for (int j = n - 2; j >= 0; j--) {
        		sum[i][j] = Integer.min(grid[i][j] + sum[i][j + 1], grid[i][j] + sum[i + 1][j]);
        	}
        }
        
        return sum[0][0];
    }
}
