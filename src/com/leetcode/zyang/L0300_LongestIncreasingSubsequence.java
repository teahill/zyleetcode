package com.leetcode.zyang;

import java.util.Arrays;

/**
 * 
 * @author zyang
 * 
 *         Given an unsorted array of integers, find the length of longest
 *         increasing subsequence.
 * 
 *         For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest
 *         increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 *         Note that there may be more than one LIS combination, it is only
 *         necessary for you to return the length.
 * 
 *         Your algorithm should run in O(n2) complexity.
 * 
 *         Follow up: Could you improve it to O(n log n) time complexity?
 *         
 *         Patience Sorting nlogn -
 *         http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 *         
 *         Longest common subsequence -
 *         https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 *         
 *         
 *         http://stackoverflow.com/questions/2631726/how-to-determine-the-longest-increasing-subsequence-using-dynamic-programming
 *         
 */
public class L0300_LongestIncreasingSubsequence {

	public L0300_LongestIncreasingSubsequence() {
		// TODO Auto-generated constructor stub
	}

	// O(nlogn)
	public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
        	return 0;
        
        int[] activeList = new int[nums.length];
        int end = 0;
        for (int x : nums) {
        	int i = Arrays.binarySearch(activeList, 0, end, x);
        	
        	if (i < 0) 
        		i = -i-1;
        	
        	activeList[i] = x;
        	
        	if (i >= end)
        		end = i + 1;        	
        }
        
        return end;
	}
	
	// O(n^2)
	public int lengthOfLISDP(int[] nums) {
        if (nums == null || nums.length == 0)
        	return 0;
        
        int[] seq = new int[nums.length];
        Arrays.fill(seq, 0);
        seq[0] = 1;
        for (int i = 1; i < nums.length; i++) {
        	int max = 1;
        	for (int j = i - 1; j >= 0; j--) {
        		if (nums[i] > nums[j])
        			max = Math.max(seq[j] + 1, max);
        	}
        	
        	seq[i] = max;
        }
        
        int max = seq[0];
        for (int i = 1; i < nums.length; i++) 
        	max = Math.max(max, seq[i]);
        
        return max;        	
    }
}
