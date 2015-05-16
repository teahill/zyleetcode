package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class L0074_Search2DMatrix {

	public L0074_Search2DMatrix() {
		// TODO Auto-generated constructor stub
	}

    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix == null)
    		return false;
    	
        int m = matrix.length;
        int n = matrix[0].length;
        int len = m * n;
        
        boolean found = binarySearch(matrix, target, m, n, 0, len - 1);
        
        return found;        
    }
    
    private boolean binarySearch(int[][] matrix, int target, int m, int n, int begin, int end) {
    	boolean found = false;
     	
    	if (begin > end)
    		return found;
    	
    	// avoid overflow
    	int mid = begin + (end - begin) / 2;   
    	int xPos = mid / n;    	
    	int yPos = mid % n;
      	
    	if (target == matrix[xPos][yPos])
    		found = true;    	
    	else if (target < matrix[xPos][yPos]) 
    		found = binarySearch(matrix, target, m, n, 0, mid - 1);    	
    	else
    		found = binarySearch(matrix, target, m, n, mid + 1, end);
    	
    	return found;    	
    }
}
