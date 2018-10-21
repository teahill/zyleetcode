package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author zyang
 * 
 * Invert a binary tree.
 * 
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 
 * 
 */
public class L0226_InvertBinaryTree {

	public L0226_InvertBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	//The question is all about switching left and right nodes
	
	// DFS, iterative
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
        	return null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null) {
        	if (node.right != null)
        		stack.push(node.right);
        	
        	TreeNode left = node.left;
        	node.left = node.right;
        	node.right = left;

        	if (left == null && !stack.isEmpty())
        		node = stack.pop();
        	else
        		node = left;
        }
        
        return root;
    }
    
	// BFS
    public TreeNode invertTree3(TreeNode root) {
        if (root == null)
        	return null;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.peek() != null) {
        	TreeNode node = queue.poll();
        	TreeNode tmp = node.left;
        	node.left = node.right;
        	node.right = tmp;

        	if (node.left != null)
        		queue.offer(node.left);

        	if (node.right != null)
        		queue.offer(node.right);
        }
        
        return root;
    }
    
	// recursive
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
        	return null;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.right = invertTree(left);
        root.left = invertTree(right);        
        
        return root;
    }
    
	// this solution assume the problem is about mirror image, but it is not what the question is asking
    public TreeNode invertTree1(TreeNode root) {
        if (root == null)
        	return null;
        
        invertTreeInternal(root.left, root.right);
        
        return root;
    }
    
    // recursive
    private void invertTreeInternal(TreeNode left, TreeNode right) {
        if (left == null || right == null)
        	return;
        
        invertTreeInternal(left.left, right.right);
        invertTreeInternal(left.right, right.left);
        
        //switch left and right node values
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        
        return;
    }
}
