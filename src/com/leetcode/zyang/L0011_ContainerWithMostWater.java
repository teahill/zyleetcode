package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn 
 * such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 */
public class L0011_ContainerWithMostWater {

	public L0011_ContainerWithMostWater() {
		// TODO Auto-generated constructor stub
	}

    public int maxArea(int[] height) {
    	int maxArea = 0;
    	if (height.length < 2)
    		return maxArea;
    	
    	int left = 0, right = height.length -1;    	
    	while (left < right) {
    		int area;
    		if (height[left] < height[right]) {
    			area = height[left] * (right - left);
    			left++;
    		}
    		else {
    			area = height[right] * (right - left);
    			right--;
    		}
    		
    		if (area > maxArea)
    			maxArea = area;    			
    	}
    	
    	return maxArea;
    }
}
