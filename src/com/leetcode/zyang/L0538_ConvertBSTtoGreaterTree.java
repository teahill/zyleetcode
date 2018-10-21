package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given a Binary Search Tree (BST), convert it to a Greater Tree such
 *         that every key of the original BST is changed to the original key
 *         plus sum of all keys greater than the original key in BST.
 * 
 *         Example:
 * 
 *         Input: The root of a Binary Search Tree like this: 
 *         5 
 *         / \ 
 *         2 13
 * 
 *         Output: The root of a Greater Tree like this: 
 *         18 
 *         / \ 
 *         20 13
 */
public class L0538_ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
    	int val = 0;
        updateBST(root, val);
        
        return root;
    }
    
    private int updateBST(TreeNode node, int val) {
    	int sum = val;
    	
    	if (node == null)
    		return sum;
    	    	
    	int right = updateBST(node.right, val);
    	node.val += right;
    	
    	sum = updateBST(node.left, node.val);
    	
    	return sum;    	
    }
}
