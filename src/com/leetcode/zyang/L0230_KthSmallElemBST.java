package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
 * How would you optimize the kthSmallest routine?
 * 
 */
public class L0230_KthSmallElemBST {

	public L0230_KthSmallElemBST() {
		// TODO Auto-generated constructor stub
	}

	private int pos = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
        	return 0;
        
        TreeNode node = null;
        if (root != null)
        	node = kthSmallestInternal(root, k);  
        
        if (node != null)
        	return node.val;
        
        return 0;
    }
    
    private TreeNode kthSmallestInternal(TreeNode root, int k) {
    	TreeNode node = null;
    	
    	if (root.left != null) {
    		node = kthSmallestInternal(root.left, k);
    		if (node != null)
    			return node;
    	}

    	pos++;
    	if (pos == k)
    		return root;

    	if (root.right != null) 
    		node = kthSmallestInternal(root.right, k);    		
    	
    	return node;
    }   
}
