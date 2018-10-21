package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
public class L0048_RotateImage {

	public L0048_RotateImage() {
		// TODO Auto-generated constructor stub
	}

    public void rotate(int[][] matrix) {
        int n = matrix.length;
    	
    	for (int k = 0; k < n/2; k++) {
    		if (n - k*2 == 1)
    			break;
    		
    		for (int j = k; j < n - 1 - k; j++) {
    			int row = k;
    			int col = j;
    			int tmp = matrix[row][col];
    			for (int i = 0; i < 3; i++) {
    				matrix[row][col] = matrix[n-1-col][row];
    				int oldRow = row;
    				row = n - 1 - col;
    				col = oldRow;
    			}
    			matrix[row][col] = tmp;    			
    		}   		
    	}   
    }
    
    //From leetcode, Algorithm: m[i][j] <-> m[n-j][n-i] 
    //First swap diagonally m[i][j] <-> matrix[n-i][j] 
    // Second swap vertically
    public void rotate1(int[][] matrix) {

        if(matrix.length == 0 || matrix.length == 1){
            return;
        }

        int temp = 0;
        int n = matrix.length - 1;

        for(int i = 0; i < matrix.length - 1; i++){
            for(int j = 0; j + i < n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-j][n-i];
                matrix[n-j][n-i] = temp;
            }
        }

        for(int i = 0; i< matrix.length / 2; i++){
            for(int j = 0; j < matrix[0].length; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-i][j];
                matrix[n-i][j] = temp;
            }
        }
    }
}
