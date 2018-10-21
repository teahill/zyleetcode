package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author zyang
 * 
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class L0417_PacificAtlanticWaterFlow {
	int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> list = new ArrayList<int[]>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return list;
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
        	DFS(matrix, pacific, i, 0, Integer.MIN_VALUE);
        	DFS(matrix, atlantic, i, n-1, Integer.MIN_VALUE);       	
        }

        for (int j = 0; j < n; j++) {
        	DFS(matrix, pacific, 0, j, Integer.MIN_VALUE);
        	DFS(matrix, atlantic, m-1, j, Integer.MIN_VALUE);      	
        }
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (pacific[i][j] && atlantic[i][j])
        			list.add(new int[] {i, j});
        	}
        }
        
        return list;
    }
    
    public void DFS(int[][] matrix, boolean[][] visited, int x, int y, int height) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	if (x < 0 || x > m-1 || y < 0 || y > n-1 || visited[x][y]
    			|| matrix[x][y] < height)
    		return;
    	
    	visited[x][y] = true;
    	for (int[] move : dir)    		   		
    		DFS(matrix, visited, x + move[0], y + move[1], matrix[x][y]);
    	
    	return;
    }
    
    // BFS approach
    public List<int[]> pacificAtlanticBFS(int[][] matrix) {
        List<int[]> list = new ArrayList<int[]>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return list;
        
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        Queue<int[]> pQueue = new LinkedList<int[]>();
        Queue<int[]> aQueue = new LinkedList<int[]>();
        for (int i = 0; i < matrix.length; i++) {
        	pacific[i][0] = true;
        	pQueue.offer(new int[]{i, 0});
        	atlantic[i][n-1] = true;
        	aQueue.offer(new int[]{i, n-1});
        }
        for (int j = 0; j < matrix[0].length; j++) {
        	pacific[0][j] = true;
        	pQueue.offer(new int[]{0, j});
        	atlantic[m-1][j] = true;
        	aQueue.offer(new int[]{m-1, j});
        }
        
        BFS(matrix, pacific, pQueue);
        BFS(matrix, atlantic, aQueue);
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (pacific[i][j] && atlantic[i][j])
        			list.add(new int[] {i, j});
        	}
        }
        
        return list;
    }
    
    private void BFS(int[][] matrix, boolean[][] visited, Queue<int[]> queue) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int[] pos;
    	int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    	while (!queue.isEmpty()) {
    		pos = queue.poll();
    		
    		for (int i = 0; i < dir.length; i++) {
    			int x = pos[0] + dir[i][0];
    			int y = pos[1] + dir[i][1];
    			
    			if (x < 0 || x > m-1 || y < 0 || y > n-1 || visited[x][y] 
    					|| matrix[x][y] < matrix[pos[0]][pos[1]])
    				continue;
    			
    			queue.offer(new int[] {x, y});
    			visited[x][y] = true;
    		}   		
    	}
    }
}
