package com.leetcode.zyang;

/**
 * Definition for binary tree
 * 
 */

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }

	TreeNode(TreeNode left, int item, TreeNode right) {
		this.left = left;
		this.right = right;
		this.val = item; 
	}

}
