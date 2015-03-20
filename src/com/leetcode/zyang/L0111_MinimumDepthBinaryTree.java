package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Show Tags
 * 
 * 
 */
public class L0111_MinimumDepthBinaryTree {

	public L0111_MinimumDepthBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0111_MinimumDepthBinaryTree minBTree = new L0111_MinimumDepthBinaryTree();
		
		List<String> strs = new ArrayList<String>();		
		strs.add("3");
		strs.add("9");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		/*
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
		*/
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
		
		int result = minBTree.minDepth(root);
		
		System.out.println("result = " + result);

	}

   public int minDepth(TreeNode root) {
    	if (root == null)
    		return 0;
    	
    	int minDepth = minDepthRecursive(root, 0);
    	
    	return minDepth + 1;
        
    }
    
   public int minDepthRecursive(TreeNode node, int depth) {
    	int minDepth = depth;
    	int depthL = depth;
    	int depthR = depth;
    	
    	if (node == null)
    		return minDepth;
    	
    	if (node.left != null && node.right != null) {
    		depthL = minDepthRecursive(node.left, depth + 1);
    		depthR = minDepthRecursive(node.right, depth + 1);
    		
    		minDepth = (depthL < depthR) ? depthL : depthR;
    	} 
    	else if (node.left != null && node.right == null) 
    		minDepth = minDepthRecursive(node.left, depth + 1);
    	else if (node.left == null && node.right != null) 
    		minDepth = minDepthRecursive(node.right, depth + 1);
    	   	
    	return minDepth;           
    }
}
