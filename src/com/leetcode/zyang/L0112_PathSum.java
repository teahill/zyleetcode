package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * 
 */
public class L0112_PathSum {

	public L0112_PathSum() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0112_PathSum pathSum = new L0112_PathSum();
		
		List<String> strs = new ArrayList<String>();		
		strs.add("5");
		strs.add("4");
		strs.add("11");
		strs.add("7");
		strs.add("#");
		strs.add("#");
		strs.add("2");
		strs.add("#");
		strs.add("#");
		strs.add("#");
		strs.add("8");
		strs.add("13");
		strs.add("#");
		strs.add("#");
		strs.add("4");
		strs.add("#");
		strs.add("1");
		strs.add("#");
		strs.add("#");
		
		int sum = 22;
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
		
		boolean result = pathSum.hasPathSum(root, sum);
		
		System.out.println("result = " + result);
	}

    public boolean hasPathSum(TreeNode root, int sum) {      
    	if (root == null)
    		if (sum == 0)
    			return true;
    		else 
    			return false;
    	
    	int remainder = sum - root.val;
    	
    	if (remainder < 0)
    		return false;
    	else 
    		return (hasPathSum(root.left, remainder) || hasPathSum(root.right, remainder));            	
    }    
}
