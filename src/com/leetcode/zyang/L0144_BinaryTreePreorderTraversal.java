package com.leetcode.zyang;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author zyang
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class L0144_BinaryTreePreorderTraversal {

	public L0144_BinaryTreePreorderTraversal() {
		// TODO Auto-generated constructor stub
	}

	// recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        
        if (root == null)
        	return list;
        
        preorderTraversalRecursive(root, list);
        
        return list;        
    }
    
    public void preorderTraversalRecursive(TreeNode root, List<Integer> list) {    	
        if (root == null)
        	return;
        
        list.add(root.val);        
        preorderTraversalRecursive(root.left, list);
        preorderTraversalRecursive(root.right, list);
        
        return;
    }
    
    // iterative
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if (root == null)
        	return list;
        
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
        	while (cur != null) {
	        	list.add(cur.val);
	        	
	        	if (cur.right != null)
	        		stack.push(cur.right);
	        	
	        	cur = cur.left;
        	}
        	
        	if (!stack.isEmpty())
        		cur = stack.pop();        	
        }
        
        return list;
    }
}
