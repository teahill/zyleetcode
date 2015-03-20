package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author zyang
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 */
public class L0103_BinaryZigZagLevelOrderTraversal {

	public L0103_BinaryZigZagLevelOrderTraversal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0103_BinaryZigZagLevelOrderTraversal bTreeLevelTraversal = new L0103_BinaryZigZagLevelOrderTraversal();
		
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
		strs.add("#");
		strs.add("#");
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
		
		List<List<Integer>> result = bTreeLevelTraversal.zigzagLevelOrder(root);
		
		System.out.println("final result = " + result);

	}
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> finalList = new LinkedList<List<Integer>>();
    	
    	if (root == null)
    		return finalList;
    	
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	
    	boolean forwardDir = true;
    	
    	while(q.peek() != null) {
    		LinkedList<Integer> list = new LinkedList<Integer>();
    		TreeNode node;
    		int num = q.size();
    		for (int i = 0; i < num; i++) {
    			node = q.poll();
    			if (node.left != null)
    				q.offer(node.left);
    			if (node.right != null)
    				q.offer(node.right);
    			list.add(node.val);
    		}
    		
    		if (!forwardDir)
    			Collections.reverse(list);		
    		
    		finalList.add(list);
    		forwardDir = forwardDir ? false : true;
    	}
    	
    	return finalList;    
    }

}
