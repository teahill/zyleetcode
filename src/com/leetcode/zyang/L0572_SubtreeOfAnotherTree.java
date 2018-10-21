package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 */
public class L0572_SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null)
        	return false;
        
        TreeNode node = s;
        if (sameTree(node, t))
        	return true;
        
        if (isSubtree(s.left, t))
        	return true;
        
        if (isSubtree(s.right, t))
        	return true;
        
        return false;
    }
    
    private boolean sameTree(TreeNode s, TreeNode t) {
    	if (s == null && t == null)
    		return true;
    	
    	if ((s == null && t != null)) || (s != null && t == null))
return
    	if (s.val != t.val)
    		return false;
    	
    	if 
    }
}
