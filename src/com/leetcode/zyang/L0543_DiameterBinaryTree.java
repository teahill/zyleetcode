package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given a binary tree, you need to compute the length of the diameter
 *         of the tree. The diameter of a binary tree is the length of the
 *         longest path between any two nodes in a tree. This path may or may
 *         not pass through the root.
 * 
 *         Example: Given a binary tree 
 *         		 1 
 *         		/ \ 
 *        	   2   3 
 *         	  / \ 
 *           4   5 
 *           
 *           Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *           
 *           Note: The length of path between two nodes is represented by the number of edges between them.
 *           
 */
public class L0543_DiameterBinaryTree {
	int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
    	maxPath(root);
    	
    	return max;        
    }
    
    public int maxPath(TreeNode node) {
        if (node == null)
        	return 0;
        
        int lDepth = maxPath(node.left);
        int rDepth = maxPath(node.right);
        
        max = Math.max(max,lDepth + rDepth);        
        
        return Math.max(lDepth, rDepth) + 1;
    }
}
