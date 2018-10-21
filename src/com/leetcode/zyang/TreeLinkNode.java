package com.leetcode.zyang;

/**
 * Definition for binary tree with next pointer.
 */

public class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }

	TreeLinkNode(TreeLinkNode left, int item, TreeLinkNode right) {
		this.left = left;
		this.right = right;
		this.val = item; 
	}
}

