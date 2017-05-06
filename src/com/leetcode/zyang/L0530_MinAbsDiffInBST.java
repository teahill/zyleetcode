package com.leetcode.zyang;

import java.util.Stack;
import java.util.TreeSet;

/**
 * 
 * @author zyang
 * 
 *         Given a binary search tree with non-negative values, find the minimum
 *         absolute difference between values of any two nodes.
 * 
 *         Example:
 * 
 *         Input:
 * 
 *         1 
 *          \ 
 *           3 
 *          / 
 *         2
 * 
 *         Output: 1
 * 
 *         Explanation: The minimum absolute difference is 1, which is the
 *         difference between 2 and 1 (or between 2 and 3). Note: There are at
 *         least two nodes in this BST.
 */
public class L0530_MinAbsDiffInBST {
	// Use TreeSet for a generalized tree, not Binary Search Tree
	// 46ms, 6%
	TreeSet<Integer> set = new TreeSet<Integer>();
   	int min = Integer.MAX_VALUE;

   	public int getMinimumDifference(TreeNode root) {
    	if (root == null)
    		return min;    	

    	Integer floor = set.floor(root.val);
    	if (floor != null)
    		min = Math.min(min, Math.abs(root.val - floor));

    	Integer ceil = set.ceiling(root.val);
    	if (ceil != null)
    		min = Math.min(min, Math.abs(root.val - ceil));
    	
    	set.add(root.val);
    	
    	getMinimumDifference(root.left);
    	getMinimumDifference(root.right);
    	
    	return min;
    }
    
	//19ms, 48%
    public int getMinimumDifference1(TreeNode root) {
    	int min = Integer.MAX_VALUE;
    	
    	// Inorder traverse
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode node = root;
    	TreeNode prev = null;
    	while (node != null || !stack.isEmpty()) {
    		while (node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    		    		
    		node = stack.pop();
    		if (prev != null) 
    			min = Math.min(min, Math.abs(node.val - prev.val));
    		
    		prev = node;
    		node = node.right;
    	}
    	
    	return min;
    }
}
