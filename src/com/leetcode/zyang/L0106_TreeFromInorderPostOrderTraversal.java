package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 */
public class L0106_TreeFromInorderPostOrderTraversal {

	public L0106_TreeFromInorderPostOrderTraversal() {
		// TODO Auto-generated constructor stub
	}

	
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0 || postorder.length != inorder.length)
        	return null;
        
         return buildTreeInternal(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1); 
    }
    
	// Recursive
    public TreeNode buildTreeInternal(int[] inorder, int[] postorder, int inStart, int inEnd, 
    									int postStart, int postEnd) {        
        
    	if (postStart > postEnd || inStart > inEnd)
    		return null;
    	
        TreeNode node = new TreeNode(postorder[postEnd]);
        
    	int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
        	if (inorder[i] == postorder[postEnd])         		
        		index = i;
        }
        
       	node.left = buildTreeInternal(inorder, postorder, inStart, index - 1, postStart, postStart + index - inStart - 1);       
       	node.right = buildTreeInternal(inorder, postorder, index + 1, inEnd, postStart + index - inStart, postEnd - 1);
        
        return node;
    }   
    
    // Iterative from Leetcode
}
