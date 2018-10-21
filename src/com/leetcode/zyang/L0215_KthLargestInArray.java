package com.leetcode.zyang;

import java.util.PriorityQueue;

/**
 * 
 * @author zyang
 * 
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * 
 */
public class L0215_KthLargestInArray {

	public L0215_KthLargestInArray() {
		// TODO Auto-generated constructor stub
	}

	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        
        for(int num : nums) {
        	queue.add(num);
        	
        	if (queue.size() > k) 
        		queue.poll();
        }
        	
        return queue.poll();
    }
}
