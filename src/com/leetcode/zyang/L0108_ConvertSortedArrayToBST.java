package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class L0108_ConvertSortedArrayToBST {

	public L0108_ConvertSortedArrayToBST() {
		// TODO Auto-generated constructor stub
	}

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
        	return null;
        
        int len = nums.length;
        
        TreeNode root = sortedArrayToBSTInternal(nums, 0, len - 1);
        
        return root;
    }
    
    private TreeNode sortedArrayToBSTInternal(int[] nums, int start, int end) {
    	if (start > end)
    		return null;
    	
    	int index = (start + end) / 2;
    	
    	TreeNode node = new TreeNode(nums[index]);
    	
    	node.left = sortedArrayToBSTInternal(nums, start, index - 1);
    	node.right = sortedArrayToBSTInternal(nums, index + 1, end);
    	
    	return node;
    }
}
