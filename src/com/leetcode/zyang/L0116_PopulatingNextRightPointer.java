package com.leetcode.zyang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree
 * 
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 */
public class L0116_PopulatingNextRightPointer {

	public L0116_PopulatingNextRightPointer() {
		// TODO Auto-generated constructor stub
	}

    public void connect(TreeLinkNode root) {
        if (root == null)
        	return;
        
        TreeLinkNode node = root;
        while(node.left != null) {
        	TreeLinkNode hNode = node;
        	while (hNode != null) {
        		hNode.left.next = hNode.right;
	        	if (hNode.next != null)
	        		hNode.right.next = hNode.next.left;
	        	else 
	        		hNode.right.next = null;
	        	
	        	hNode = hNode.next;
        	}
        	
        	node = node.left;
        }
    }
	
	// Used extra space, not meeting requirement
    public void connect1(TreeLinkNode root) {
        if (root == null)
        	return;
        
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (queue.peek() != null) {
            int size = queue.size();
            TreeLinkNode prevNode = null;
            for (int i = 0; i < size; i++) {
            	TreeLinkNode node = queue.poll();
            	
            	if (prevNode != null) 
            		prevNode.next = node;
            		
            	prevNode = node;
            	
            	// end
            	if (i == size -1)
            		node.next = null;
            	
            	queue.add(node.left);
            	queue.add(node.right);
            }            
        }        
    }
}
