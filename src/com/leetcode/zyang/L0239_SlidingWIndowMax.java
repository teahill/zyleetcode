package com.leetcode.zyang;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * 
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position Max 
 * --------------- ----- 
 * [1 3 -1] -3 5 3 6 7 3 
 * 1 [3 -1 -3] 5 3 6 7 3 
 * 1 3 [-1 -3 5] 3 6 7 5 
 * 1 3 -1 [-3 5 3] 6 7 5 
 * 1 3 -1 -3 [5 3 6] 7 6 
 * 1 3 -1 -3 5 [3 6 7] 7 
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for
 * non-empty array.
 * 
 */
public class L0239_SlidingWIndowMax {

	public L0239_SlidingWIndowMax() {
		// TODO Auto-generated constructor stub
	}

	// Use Deque
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
        	return new int[] {};
        
        Deque<Integer> queue = new ArrayDeque<Integer>();
        
        int max = nums[0];
        // if sliding window is shorter than the array, just get max from the array and return
        if (k >= nums.length) {
        	for (int i = 0; i < nums.length; i++)
        		max = Math.max(max, nums[i]);

        	return new int[] {max};
        }
        	
        // Go through the array
    	int[] result = new int[nums.length - k + 1];
    	for (int i = 0; i < nums.length; i++) {
    		// remove num out of window
    		while (queue.peekFirst() != null && queue.peekFirst() <= i - k)
    			queue.pollFirst();
    		
    		// remove smaller nums, as they won't be useful now that a bigger num is in
    		while (queue.peekLast() != null && nums[queue.peekLast()] <= nums[i])
    			queue.pollLast();
    		
    		// add the new element position to last
    		queue.offerLast(i);
    		
    		if (i + 1 - k >= 0)
    			result[i+1-k] = nums[queue.peekFirst()];
    	}
    	
    	return result;
    }
    
	// Use priority queue, TLE
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
        	return new int[] {0};
        
        // use max heap to get the max from the sliding window
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() 
        		{
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return -(o1.intValue() - o2.intValue());
					}
        		});
        
        // if sliding window is shorter than the array, just get max from the array and return
        if (k > nums.length) {
        	for (int i = 0; i < nums.length; i++)
        		queue.offer(nums[i]);

        	return new int[] {queue.peek()};
        }
        	
    	int[] result = new int[nums.length - k + 1];
        // put the first sliding window on heap
        for (int i = 0; i < k; i++)
        	queue.offer(nums[i]);
        
        // sliding window to pop out the early num and add new one, Priority queue will always give you the max the max one
        int start = 0, end = k;
        while (end < nums.length && queue.peek() != null) {
        	result[start] = queue.peek();
        	
        	if (queue.contains(nums[start]))
        		queue.remove(nums[start]);
        	queue.offer(end);
        	
        	start++;
        	end++;
        }
        
        // add the last one
        result[start] = queue.peek();        
        return result;
    }
}
