package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 *        1
 *       / \
 *      2   3
 *      
 * Return 6.
 */
public class L0124_BinaryTreeMaxPathSum {

	public L0124_BinaryTreeMaxPathSum() {
		// TODO Auto-generated constructor stub
	}

	int maxSum = Integer.MIN_VALUE;
	
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        
        return maxSum;
        
    }
    
    private int maxPathDown(TreeNode node) {    	
    	if (node == null)
    		return 0;
    	
    	int left = Integer.max(0, maxPathDown(node.left));
    	int right = Integer.max(0, maxPathDown(node.right));
    	
    	maxSum = Math.max(maxSum,  left + right + node.val);
    	
    	return Math.max(left,  right) + node.val;
    	
    }
}
