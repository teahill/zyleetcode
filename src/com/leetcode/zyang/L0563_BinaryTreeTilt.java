package com.leetcode.zyang;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author zyang
 * 
 *         Given a binary tree, return the tilt of the whole tree.
 * 
 *         The tilt of a tree node is defined as the absolute difference between
 *         the sum of all left subtree node values and the sum of all right
 *         subtree node values. Null node has tilt 0.
 * 
 *         The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * 
 *         Example: 
 *         Input: 
 *         	1 
 *         / \ 
 *         2  3 
 *         
 *         Output: 1 
 *         Explanation: Tilt of node 2 : 0; Tilt of node 3 : 0 Tilt of node 1 : |2-3| = 1 
 *         Tilt of binary tree : 0 + 0 + 1 = 1 Note:
 * 
 *         The sum of node values in any subtree won't exceed the range of
 *         32-bit integer. All the tilt values won't exceed the range of 32-bit
 *         integer.
 */
public class L0563_BinaryTreeTilt {
	Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
	int total = 0;
	
	//11ms, 37%
    public int findTilt(TreeNode root) {
    	if (root == null)
    		return 0;

    	findSum(root);
    	
		/**
    	System.out.println("node = " + root.val + ", leftTile = " + leftTilt
    		 + ", rightTilt = " + rightTilt 
    		 + ", currentTilt = " + currentTilt
    		 + ", total = " + total);
		 */
    	
    	return total;
    }
    
    private int findSum(TreeNode node) {
    	if (node == null)
    		return 0;    	
    	
    	int sum = node.val;
    	int leftSum = findSum(node.left);
    	int rightSum = findSum(node.right);
    	sum += (leftSum + rightSum);
    	
    	total += Math.abs(leftSum - rightSum);
    	
    	return sum;
    }
    
	// 24ms, 16%
    public int findTilt1(TreeNode root) {
    	if (root == null)
    		return 0;

    	int currentTilt = Math.abs(findSum1(root.left) - findSum1(root.right));
    	total += currentTilt;
    		   	
		findTilt1(root.left);
		findTilt1(root.right);	
		/**
    	System.out.println("node = " + root.val + ", leftTile = " + leftTilt
    		 + ", rightTilt = " + rightTilt 
    		 + ", currentTilt = " + currentTilt
    		 + ", total = " + total);
		 */
    	
    	return total;
    }
    
    private int findSum1(TreeNode node) {
    	if (node == null)
    		return 0;
    	
    	if (map.containsKey(node))
    		return map.get(node);
    	
    	int sum = node.val;
    	sum+= findSum1(node.left);
    	sum+= findSum1(node.right);
    	
    	map.put(node,  sum);
    	return sum;
    }
}
