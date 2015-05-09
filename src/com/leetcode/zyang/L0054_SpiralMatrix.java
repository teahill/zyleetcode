package com.leetcode.zyang;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 */
public class L0054_SpiralMatrix {

	public L0054_SpiralMatrix() {
		// TODO Auto-generated constructor stub
	}

    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> list = new LinkedList<Integer>();
    	
    	if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1)
    		return list;
    	
    	int colMin = 0, rowMin = 0, colMax = matrix[0].length - 1, rowMax = matrix.length - 1;
    	
    	// x axis = 1; y axis = 2; pos direction = 1; neg direction = -1
    	int axis = 1, dir = 1;
    	// current pointer pos
    	int colPos = 0, rowPos = 0;
    	while (colMin <=  colMax && rowMin <= rowMax) {
    		// Travel x axis in positive direction
    		if (axis == 1 && dir > 0) {
    			for (colPos = colMin; colPos <= colMax; colPos++) 
    				list.add(matrix[rowPos][colPos]);
    			
    			// At the end, turn to y axis, positive direction
    			axis = 2;
    			dir = 1;
    			rowMin = rowPos + 1; 
    			colPos--;
    		}
    		else if (axis == 2 && dir > 0) {
    			for (rowPos = rowMin; rowPos <= rowMax; rowPos++) 
    				list.add(matrix[rowPos][colPos]);
    			
    			// At the end, turn to x axis, negative direction
    			axis = 1;
    			dir = -1;
    			colMax = colPos - 1;  
    			rowPos--;
    		}
    		else if (axis == 1 && dir < 0) {
    			for (colPos = colMax; colPos >= colMin; colPos--) 
    				list.add(matrix[rowPos][colPos]);
    			
    			// At the end, turn to y axis, positive direction
    			axis = 2;
    			dir = -1;
    			rowMax = rowPos - 1;  
    			colPos++;
    		}
    		else if (axis == 2 && dir < 0) {
    			for (rowPos = rowMax; rowPos >= rowMin; rowPos--) 
    				list.add(matrix[rowPos][colPos]);
    			
    			// At the end, turn to x axis, positive direction
    			axis = 1;
    			dir = 1;
    			colMin = colPos + 1;  
    			rowPos++;
    		}
    		
    	}
    	
    	return list;        
    }   
}
