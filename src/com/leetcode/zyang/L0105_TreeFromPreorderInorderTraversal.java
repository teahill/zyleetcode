package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 */
public class L0105_TreeFromPreorderInorderTraversal {

	public L0105_TreeFromPreorderInorderTraversal() {
		// TODO Auto-generated constructor stub
	}

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length)
        	return null;
        
         return buildTreeInternal(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1); 
    }
    
	// Recursive
    public TreeNode buildTreeInternal(int[] preorder, int[] inorder, int preStart, int preEnd, 
    									int inStart, int inEnd) {        
        
    	if (preStart > preEnd || inStart > inEnd)
    		return null;
    	
        TreeNode node = new TreeNode(preorder[preStart]);
        
    	int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
        	if (inorder[i] == preorder[preStart])         		
        		index = i;
        }

        node.left = buildTreeInternal(preorder, inorder, preStart + 1, preStart + index - inStart, 
        								inStart, index - 1); 
        
        node.right = buildTreeInternal(preorder, inorder, preStart + index - inStart + 1, preEnd, 
										index + 1, inEnd);
        
        return node;
    }   
    
    // iterative solution, Leetcode
    
}
