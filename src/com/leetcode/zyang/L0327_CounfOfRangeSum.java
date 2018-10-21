package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given an integer array nums, return the number of range sums that lie
 *         in [lower, upper] inclusive. Range sum S(i, j) is defined as the sum
 *         of the elements in nums between indices i and j (i ≤ j), inclusive.
 * 
 *         Note: A naive algorithm of O(n2) is trivial. You MUST do better than
 *         that.
 * 
 *         Example: Given nums = [-2, 5, -1], lower = -2, upper = 2, Return 3.
 *         The three ranges are : [0, 0], [2, 2], [0, 2] and their respective
 *         sums are: -2, -1, 2.
 *         
 *         https://leetcode.com/discuss/79907/summary-divide-conquer-based-binary-indexed-based-solutions
 *         
 */
public class L0327_CounfOfRangeSum {
	private TreeNode root;
	
    public int countRangeSum(int[] nums, int lower, int upper) {       
    	if (nums == null || nums.length == 0)
    		return 0;
    		
    	buildSegmentTree(nums);
    	
    	return countRangeSum(root, nums, lower, upper, 0, nums.length - 1);
    }

    private void buildSegmentTree(int[] nums) {
    	
    	root = buildSegmentTree(nums, 0, nums.length - 1);
    	
    	return;
    }
    
    private TreeNode buildSegmentTree(int[] nums, int start, int end) {
    	if (start == end) 
    		return new TreeNode(nums[start]); 
    	
    	if (start > end)
    		return null;
    	
    	int mid = start + (end - start) / 2;
    	TreeNode left = buildSegmentTree(nums, start, mid);
    	TreeNode right = buildSegmentTree(nums, mid + 1, end);
    	TreeNode node = new TreeNode(left.val + right.val);
    	node.left = left;
    	node.right = right;
    	   	
    	return node;
    }
    
    private int countRangeSum(TreeNode node, int[] nums, int lower, int upper, int start, int end) {
    	int count = 0;
    	
    	if (start > end)
    		return count;
    	
    	if (start == end) {
    		if (lower <= nums[start] && nums[start] <= upper)
    			count++;
    		
    		return count;
    	}
    		
    	// Divide and conquer, count left and right
    	int mid = start + (end - start) / 2;
    	count += countRangeSum(node.left, nums, lower, upper, start, mid);
    	
    	count += countRangeSum(node.right, nums, lower, upper, mid + 1, end);
       
    	// Count combined
    	TreeNode left = node.left;
    	while (left != null) {
    		// reset right side node
        	TreeNode right = node.right;  		
    		while (right != null) {
    			int sum = left.val + right.val;
    			// move to the next left most node
    			if (lower <= sum && sum <= upper)
    				count++;
    			
    			right = right.left;
    		}
    		
    		// move to the next right most node
    		left = left.right;
    	}
    	        
    	return count;
    }
}
