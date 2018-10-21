package com.leetcode.zyang;

import java.util.Stack;

/**
 * 
 * @author zyang
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized 
 * with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
 * where h is the height of the tree.
 * 
 */
public class L0173_BinarySearchTreeIterator {
	
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
	public L0173_BinarySearchTreeIterator() {
		// TODO Auto-generated constructor stub
	}

    public L0173_BinarySearchTreeIterator(TreeNode root) {       	
        TreeNode node = root;
        while (node != null) {
        	stack.push(node);
        	node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            TreeNode tmp = node.right;
            while (tmp != null) {
            	stack.push(tmp);
            	tmp = tmp.left;
            }
        }
            
        return node.val;
    }
    
    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */
}
