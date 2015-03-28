package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * 
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 */
public class L0063_UniquePathsII {

	public L0063_UniquePathsII() {
		// TODO Auto-generated constructor stub
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
				
    	int[][] num = new int[m][n];
    	
    	if (obstacleGrid[m - 1][n - 1] == 1) 
    		return 0;
    	       
        int def = 1;
        for (int j = 0; j < n; j++) {       	
        	if (obstacleGrid[0][j] == 1) {
        		def = 0;
        		num[0][j] = def;
        	}
        	else 
        		num[0][j] = def;
        }
        
        def = 1;
        for (int i = 0; i < m; i++) {
        	if (obstacleGrid[i][0] == 1) {
        		def = 0;
        		num[i][0] = def;
        	}
        	else 
        		num[i][0] = def;
        }
        	        
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		if (obstacleGrid[i][j] == 1) 
        			num[i][j] = 0;
        		else 
        			num[i][j] = num[i-1][j] + num[i][j-1];        			
        	}
        }
        
        return num[m-1][n-1];
    }
}
