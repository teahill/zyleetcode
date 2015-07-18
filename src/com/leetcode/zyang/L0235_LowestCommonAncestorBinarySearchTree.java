package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v 
 * and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
 * since a node can be a descendant of itself according to the LCA definition.
 */
public class L0235_LowestCommonAncestorBinarySearchTree {

	public L0235_LowestCommonAncestorBinarySearchTree() {
		// TODO Auto-generated constructor stub
	}

	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
        	return null;
        
        TreeNode lca = root;
        
        if (p == root)
        	return p;
        
        if (q == root)
        	return q;
        
        if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val))
        	return root;       	
        	
        
        if (p.val < root.val && q.val < root.val)
        	root = root.left;       
        else 
        	root = root.right;
        	
        lca = lowestCommonAncestor(root, p, q);
        
        return lca;
    }
}
