package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 
 * [show hint]
 * 
 * Related problem: Reverse Words in a String II
 * 
 * 
 */
public class L0189_RotateArray {

	public L0189_RotateArray() {
		// TODO Auto-generated constructor stub
	}

    public void rotate(int[] nums, int k) {
    	if (nums.length <= 1 || k == 0)
    		return;
    	
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        
        return;
    }
    
    public void reverse(int[] nums, int s, int e) {
    	int tmp;
    	while ( s < e) {
    		tmp = nums[s];
    		nums[s] = nums[e];
    		nums[e] = tmp;
    		s++;
    		e--;
    	}
    }
    
    public void rotate1(int[] nums, int k) {
    	if (nums.length <= 1 || k == 0 || k > nums.length)
    		return;
    	
        int[] kSteps = new int[k];
        for (int i = 0; i < k; i++) 
        	kSteps[i] = nums[nums.length - k + i];
        
        for (int i = 0; i < nums.length - k; i++)
        	nums[nums.length -1 - i] = nums[nums.length - 1 -k - i];
        
        for (int i = 0; i < k; i++)
        	nums[i] = kSteps[i];
        
        return;
    }
}
