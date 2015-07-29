package com.leetcode.zyang;

import java.util.Stack;

public class L0084_LargestRectangleHistogram {

	public L0084_LargestRectangleHistogram() {
		// TODO Auto-generated constructor stub
	}

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		
		int n = height.length;
		Stack<Integer> stack = new Stack<Integer>();
		
		// avoid empty stack, as well as the prev to 0 out of boundary exception
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < n; i++) {			
			while (stack.peek() > -1 && height[stack.peek()] > height[i]) {
				int pos = stack.pop();
				int area = height[pos] * (i - stack.peek() - 1);
				max = (max > area) ? max : area;
			}
			
			stack.push(i);
		}
		
		while (stack.peek() > -1) {
			int pos = stack.pop();						
			int area = height[pos] * (n - stack.peek() - 1);
			max = (max > area) ? max : area;
		}
		
		return max;
	}
}
