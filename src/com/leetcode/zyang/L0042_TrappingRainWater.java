package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
 * In this case, 6 units of rain water (blue section) are being trapped. 
 */
public class L0042_TrappingRainWater {

	public L0042_TrappingRainWater() {
		// TODO Auto-generated constructor stub
	}

    public int trap(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        int lMax = 0;
        int rMax = 0;
        
        while (l <= r) {
        	lMax = Math.max(lMax,  height[l]);
        	rMax = Math.max(rMax,  height[r]);
        	
        	if (lMax < rMax) {
        		max += (lMax - height[l]);
        		l++;
        	}
        	else {
        		max += (rMax - height[r]);
        		r--;
        	}        			
        }
        
        return max;
    }
}
