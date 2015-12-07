package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given an integer array nums, find the sum of the elements between
 *         indices i and j (i ≤ j), inclusive.
 * 
 *         The update(i, val) function modifies nums by updating the element at
 *         index i to val. Example: Given nums = [1, 3, 5]
 * 
 *         sumRange(0, 2) -> 9 update(1, 2) sumRange(0, 2) -> 8 
 *         
 *         Note: The array is only modifiable by the update function. 
 *         You may assume the number of calls to update and sumRange function is distributed evenly.
 *         
 *         Use Segment Tree to achieve O(logn)
 */

public class L0307_RangeSumQueryMutableFaster {
	
	private int[] nums;
	private TreeNode root;
    public L0307_RangeSumQueryMutableFaster(int[] nums) {
    	if (nums == null || nums.length == 0)
    		return;
    	
    	this.nums = nums;
    	
    	root = buildSegmentTree(0, nums.length - 1);
    }

    private TreeNode buildSegmentTree(int start, int end) {
    	if (start > end)
    		return null;
    	
    	if (start == end) {
    		TreeNode node = new TreeNode(nums[start]);
    		return node;
    	}
    		
    	int mid = start + (end - start) / 2;
    	TreeNode left = buildSegmentTree(start, mid);
    	TreeNode right = buildSegmentTree(mid + 1, end);
    	
    	TreeNode parent = new TreeNode(left.val + right.val);
    	parent.left = left;
    	parent.right = right;
    	
    	return parent;    	
    }
    
    void update(int i, int val) {
    	if (nums == null || nums.length == 0 || i < 0 || i > nums.length - 1)
    		return;
    	
    	int diff = val - nums[i];
    	nums[i] = val;
    	update(i, diff, root, 0, nums.length - 1);
    }
    
    private void update(int i, int diff, TreeNode node, int start, int end) {
    	if ( i < start || i > end)
    		return;
    	
      	node.val += diff;
    	
    	if (start == end)     		
    		return;
    	
    	int mid = start + (end - start) / 2;
    	update(i, diff, node.left, start, mid);
    	update(i, diff, node.right, mid + 1, end);
    	
    	return;
    }

    public int sumRange(int i, int j) {
    	if (nums == null || nums.length == 0)
    		return 0;
    	
    	if (i >= nums.length || j < 0 || j < i)
    		return 0;
    	
    	return sumRange(i, j, root, 0, nums.length - 1);
    }
    
    private int sumRange(int i, int j, TreeNode node, int start, int end) {
    	int sum = 0;
    	if (i >= nums.length || j < 0 || j < i)
    		return sum;
    	
    	if (j < start || i > end)
    		return sum;
    	
    	if (i <= start && j >= end) 
    		sum += node.val;
    	else {
    		int mid = start + (end - start) / 2;
    		
    		sum += sumRange(i, j, node.left, start, mid);
    		sum += sumRange(i, j, node.right, mid + 1, end);    		
    	}

    	return sum;	
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);

