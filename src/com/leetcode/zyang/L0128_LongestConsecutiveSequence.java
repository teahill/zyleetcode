package com.leetcode.zyang;

import java.util.HashMap;

/**
 * 
 * @author zyang
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
Your algorithm should run in O(n) complexity.
 */
public class L0128_LongestConsecutiveSequence {

	public L0128_LongestConsecutiveSequence() {
		// TODO Auto-generated constructor stub
	}

	// Use HashMap
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
        	return 0;
        
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();      
        for (int n : nums) {
        	// Duplicate
        	if (map.containsKey(n))
        		continue;
        	
        	int start = n;
        	int end = n;
        	int seq = 0;
        	if (map.containsKey(n - 1)) {
        		seq = map.get(n - 1);
        		start = n - seq;
        	}
        		
        	if (map.containsKey(n + 1)) {
        		seq = map.get(n + 1);
        		end = n + seq;
        	}
        	
        	seq = end - start + 1;
        	map.put(n, seq);
        	map.put(start, seq);
        	map.put(end, seq);
        	max = Math.max(max, seq);
        }
        
        return max;
    }  
    
    // Try to use set
}
