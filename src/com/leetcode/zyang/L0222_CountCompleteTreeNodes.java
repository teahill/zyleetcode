package com.leetcode.zyang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author zyang
 * 
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, 
 * is completely filled, and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class L0222_CountCompleteTreeNodes {

	public L0222_CountCompleteTreeNodes() {
		// TODO Auto-generated constructor stub
	}

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		int count = 0;
		int lHeight = findHeight(root.left);
		int rHeight = findHeight(root.right);

		if (lHeight == rHeight) {
			count = (int)Math.pow(2, lHeight + 1) + countNodes(root.right);
			return count;
		}
		else {
			count = (int)Math.pow(2, rHeight + 1) + countNodes(root.left);
		}
		
		return count;
	}
	
	private int findHeight(TreeNode node) {
		if (node == null)
			return -1;

		int level = 0;
		while (node.left != null) {
			node = node.left;
			level++;
		}

		return level;
	}


	// Level order traversal, TLE
	public int countNodes1(TreeNode root) {
		if (root == null)
			return 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int count = 0;
		while (queue.peek() != null) {
			int size = queue.size();
			count += size;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null)
					queue.add(node.left);

				if (node.right != null)
					queue.add(node.right);
			}
		}        

		return count;
	}
}
