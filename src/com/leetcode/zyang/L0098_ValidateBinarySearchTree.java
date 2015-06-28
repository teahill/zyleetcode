package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class L0098_ValidateBinarySearchTree {

	public L0098_ValidateBinarySearchTree() {
		// TODO Auto-generated constructor stub
	}

    public boolean isValidBST(TreeNode root) {
        long minValue = Long.MIN_VALUE;
        long maxValue = Long.MAX_VALUE;
        
        boolean isValid = isValidBSTInternal(root, minValue, maxValue);        
       
        return isValid;    
    }

	private boolean isValidBSTInternal(TreeNode root, long minValue, long maxValue) {       
        if (root == null)
        	return true;
        
        if (root.val >=  maxValue || root.val <= minValue)
        	return false;
        
        boolean isValid = isValidBSTInternal(root.left, minValue, root.val) && isValidBSTInternal(root.right, root.val, maxValue);
        
       	return isValid;
	}
}
