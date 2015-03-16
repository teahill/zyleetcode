package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree, find its maximum depth. The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * 
 *  Tree Depth-first Search
 *  
 */

public class L0104_MaxDepthBinaryTree {

	public L0104_MaxDepthBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0104_MaxDepthBinaryTree maxBTree = new L0104_MaxDepthBinaryTree();
		
		List<String> strs = new ArrayList<String>();		
		strs.add("3");
		strs.add("9");
		strs.add("#");
		strs.add("#");
		strs.add("20");
		strs.add("15");
		strs.add("#");
		strs.add("#");
		strs.add("7");
		strs.add("9");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
		
		int result = maxBTree.maxDepth(root);
		
		System.out.println("result = " + result);
	}

	//DFS
    public int maxDepth(TreeNode root) {
    	int depth = 0;
    	
    	if (root == null)
    		return depth;
    	   	
    	depth = maxDepthRecursive(root, 0);
    	
    	return depth + 1;      
    }
    
    public int maxDepthRecursive(TreeNode root, int depth) {  	
    	if (root == null)
    		return depth;
    	
    	int dLeft = depth;
    	int dRight = depth;
    	
    	if (root.left != null)
    		dLeft = maxDepthRecursive(root.left, depth + 1);
    	
    	if (root.right != null)
    		dRight = maxDepthRecursive(root.right, depth + 1);
	
    	return (dLeft > dRight) ? dLeft : dRight;      
    }
}
