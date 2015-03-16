package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as 
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * Tree Depth-first Search
 * 
 * Given binary tree {3,9,20,#,#,15,7},
 *	    3
 *	   / \
 *	  9  20
 *	    /  \
 *	   15   7
 *         /
 *        9
 */
public class L0110_BalancedBinaryTree {

	public L0110_BalancedBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		L0110_BalancedBinaryTree balanceBTree = new L0110_BalancedBinaryTree();
		
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
		//strs.add("9");
		//strs.add("#");
		strs.add("#");
		strs.add("#");
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
		
		boolean result = balanceBTree.isBalanced(root);
		
		System.out.println("result = " + result);

	}
	  
    public boolean isBalanced(TreeNode root) {
    	if (root == null)
    		return true;
    	
    	Pair pair = balanceRecursive(root, 0);
    	
    	return pair.isBalanced;        
    }
           
    public Pair balanceRecursive(TreeNode root, int depth) {  	
    	Pair pair = new Pair(true, depth);
    	
    	if (root == null)
    		return pair;
    	
    	Pair pairL = new Pair(true, depth);    	
    	Pair pairR = new Pair(true, depth);
    	
    	if (root.left != null)
    		pairL = balanceRecursive(root.left, depth + 1);
    	
    	if (root.right != null)
    		pairR = balanceRecursive(root.right, depth + 1);
    	
    	int diff = (pairL.depth - pairR.depth > 0) ? (pairL.depth - pairR.depth) : (pairR.depth - pairL.depth);
    	
    	pair.isBalanced = pairL.isBalanced && pairR.isBalanced && diff <= 1;	
    	pair.depth = (pairL.depth > pairR.depth) ? pairL.depth : pairR.depth;  
    	
    	return pair;
    }
    
    private class Pair {
    	boolean isBalanced;
    	int depth;
    	   	
    	Pair(boolean isBalanced, int depth){
    		this.isBalanced = isBalanced;
    		this.depth = depth; 		
    	}
    }
}
