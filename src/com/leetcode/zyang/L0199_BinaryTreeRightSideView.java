package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes 
 * you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 * 
 */
public class L0199_BinaryTreeRightSideView {

	public L0199_BinaryTreeRightSideView() {
		// TODO Auto-generated constructor stub
	}

	// Level order traversal
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	
        if (root == null)
        	return list;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue.peek() != null) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = queue.poll();
        		if (node.left != null)
        			queue.add(node.left);
        		
        		if (node.right != null)
        			queue.add(node.right);
        		
        		if (i == size - 1)
        			list.add(node.val);
        	}
        }
        
        return list;
    }    
    
    // DFS solution on Leetcode
}
