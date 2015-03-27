package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		/**
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
		 */

		strs.add("-2");
		strs.add("#");
		strs.add("-3");
		strs.add("#");
		strs.add("#");	

		int sum = -5;

		System.out.println("Input = " + strs);

		TreeNode root = BinaryTreeSerializer.deserialize(strs);

		System.out.println("result = " + BinaryTreeSerializer.serialize(root));

		boolean result = pathSum.hasPathSum(root, sum);

		System.out.println("result = " + result);
	}

	//Recursive o(nlogn)?
	public boolean hasPathSum(TreeNode root, int sum) {      
		if (root == null)
			return false;

		if (sum == root.val && root.left == null && root.right == null)
			return true;

		int remainder = sum - root.val;
		
		boolean left = false;
		boolean right = false;
		if (root.left != null)
			left = hasPathSum(root.left, remainder);
		
		if (root.right != null)
			right = hasPathSum(root.right, remainder);
		
		return (left || right);            	
	}    

	// Iterative o(n)?
	public boolean hasPathSumIterative(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();

        stack.push(root);
        sums.push(sum);
        while(!stack.isEmpty()&&(root!=null)){
            int value = sums.pop();
            TreeNode top = stack.pop();

            if(top.left==null&&top.right==null&&top.val==value){
                return true;
            }
            if(top.right!=null){
                stack.push(top.right);
                sums.push(value-top.val);
            }
            if(top.left!=null){
                stack.push(top.left);
                sums.push(value-top.val);
            }

        }
        return false;
	}
}

