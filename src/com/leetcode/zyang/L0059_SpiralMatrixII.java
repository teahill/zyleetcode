package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * 
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class L0059_SpiralMatrixII {

	public L0059_SpiralMatrixII() {
		// TODO Auto-generated constructor stub
	}

    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
    	
    	if (n == 0)
    		return matrix;
    	
    	int colMin = 0, rowMin = 0, colMax = n - 1, rowMax = n - 1;
    	int value = 0;
    	// x axis = 1; y axis = 2; pos direction = 1; neg direction = -1
    	int axis = 1, dir = 1;
    	// current pointer pos
    	int colPos = 0, rowPos = 0;
    	while (colMin <=  colMax && rowMin <= rowMax) {
    		// Travel x axis in positive direction
    		if (axis == 1 && dir > 0) {
    			for (colPos = colMin; colPos <= colMax; colPos++) {
    				value++;
    				matrix[rowPos][colPos] = value;
    			}
    			
    			// At the end, turn to y axis, positive direction
    			axis = 2;
    			dir = 1;
    			rowMin = rowPos + 1; 
    			colPos--;
    		}
    		else if (axis == 2 && dir > 0) {
    			for (rowPos = rowMin; rowPos <= rowMax; rowPos++) {
    				value++;
    				matrix[rowPos][colPos] = value;
    			}
    			
    			// At the end, turn to x axis, negative direction
    			axis = 1;
    			dir = -1;
    			colMax = colPos - 1;  
    			rowPos--;
    		}
    		else if (axis == 1 && dir < 0) {
    			for (colPos = colMax; colPos >= colMin; colPos--) {
    				value++;
    				matrix[rowPos][colPos] = value;
    			}
    			
    			// At the end, turn to y axis, positive direction
    			axis = 2;
    			dir = -1;
    			rowMax = rowPos - 1;  
    			colPos++;
    		}
    		else if (axis == 2 && dir < 0) {
    			for (rowPos = rowMax; rowPos >= rowMin; rowPos--) {
    				value++;
    				matrix[rowPos][colPos] = value;
    			}
    			
    			// At the end, turn to x axis, positive direction
    			axis = 1;
    			dir = 1;
    			colMin = colPos + 1;  
    			rowPos++;
    		}
    	}
    	
    	return matrix;           
    }
}
