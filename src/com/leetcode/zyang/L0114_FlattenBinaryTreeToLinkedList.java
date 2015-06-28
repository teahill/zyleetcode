package com.leetcode.zyang;

import java.util.Stack;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 */
public class L0114_FlattenBinaryTreeToLinkedList {

	public L0114_FlattenBinaryTreeToLinkedList() {
		// TODO Auto-generated constructor stub
	}

	// iterative - NOT WORKING
    public void flatten1(TreeNode root) {
    	if (root == null)
    		return;
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode tmp = root;
    	while (root != null || !stack.isEmpty()) {
    		if (root != null) {
    			if (root.right != null)
    				stack.push(root.right);
    			
    			if (root.left != null) {
    				root.right = root.left;
    				root.left = null; 
    				root = root.right;
    			}
    			else {
    				if (!stack.isEmpty())
    					tmp = stack.pop(); 
    				else 
    					tmp = null;
    				
    				root.left = tmp;
    				root = tmp;
    			}
    		}
    		/*
    		else {
    			if (!stack.isEmpty())
    				root = stack.pop();  
    			else
    				root = null;
    		}
    		*/
    	}
    	
    	return;
    }	
    
    // recursive
    public void flatten(TreeNode root) {
    	if (root == null)
    		return;
    	
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	
    	flatten(left);
    	flatten(right);
    	
    	if (left == null)
    		return;
    	    	
    	root.right = left;
    	root.left = null;
    	
    	if (right == null)
    		return;
    	
    	while (left != null && left.right != null) 
    		left = left.right;
    	
    	left.right = right;
    	
    	return;    	
    }
}
