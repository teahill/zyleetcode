package com.leetcode.zyang;

import java.util.Stack;

/**
 * 
 * @author zyang
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * 
 */
public class L0085_MaximalRectangle {

	public L0085_MaximalRectangle() {
		// TODO Auto-generated constructor stub
	}

	// use the same method as largest rectangle histogram, problem #84
    public int maximalRectangle(char[][] matrix) {
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) 
    	   return 0;
       
       int max = 0;
       int m = matrix.length;
       int n = matrix[0].length;
       int[] height = new int[n];
	   Stack<Integer> stack = new Stack<Integer>();
	   stack.push(-1);
       for (int i = 0; i < m; i++) {
    	   for (int j = 0; j < n; j++) {
    		   height[j] = matrix[i][j] == '0' ? 0 : (height[j] + 1);    		   
    		   while (stack.peek() > -1 && height[j] < height[stack.peek()]) {
    			   int pos = stack.pop();    			   
    			   int area = height[pos] * (j - stack.peek() - 1);
    			   max = (max > area) ? max : area;
    		   }
    		   stack.push(j);
    	   }
    	   
		   while (stack.peek() != -1) {
			   int pos = stack.pop();
			   int area = height[pos] * (n - stack.peek() -1);
			   max = (max > area) ? max : area;
		   }
       }
       
       return max;
    }
}
