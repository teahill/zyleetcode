package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/**
 * 
 * @author zyang
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class L0145_BinaryTreePostorderTraversal {

	public L0145_BinaryTreePostorderTraversal() {
		// TODO Auto-generated constructor stub
	}

	// Iterative - from leetcode
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (root == null)
        	return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
        	TreeNode curr = stack.peek();
        	// Traverse down
        	if (prev == null || curr == prev.left || curr == prev.right) {
        		if (curr.left != null) 
        			stack.push(curr.left);
        		else if (curr.right != null)
        			stack.push(curr.right);
        		else {
        			list.add(curr.val); 
        			stack.pop();
        		}
        	}
        	// traverse up
        	else if (curr.left == prev) {
        		if (curr.right != null) 
        			stack.push(curr.right);
        		else {
        			list.add(curr.val);
        			stack.pop();
        		}
        	}
        	
        	else if (curr.right == prev) {
        		list.add(curr.val);
        		stack.pop();
        	}
        	
        	prev = curr;
        }
               
        return list;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (root == null)
        	return list;

        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null) {
        	if (node.left != null)
        		stack.push(node.left);
        	
        	list.add(0, node.val);        	
        	node = node.right;
        	
        	if (node == null && !stack.isEmpty())
        		node = stack.pop();
        }
               
        return list;
    }
    
	// Recursive
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (root == null)
        	return list;
        
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        
        return list;
    }
}
