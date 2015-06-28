package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *     
 */
public class L0117_PopulatingNextRightPointerII {

	public L0117_PopulatingNextRightPointerII() {
		// TODO Auto-generated constructor stub
	}

    public void connect(TreeLinkNode root) {
        if (root == null)
        	return;
        
        TreeLinkNode node = root;
        while(node != null) {
        	TreeLinkNode hNode = node;
        	
        	// reset next line beginning node
        	node = null;
        	// init connecting node
        	TreeLinkNode prevNode = null;
        	while (hNode != null) {
        		if (hNode.left != null) {
        			if (prevNode == null)
        				prevNode = hNode.left;
        			else {
        				prevNode.next = hNode.left;      
        				prevNode = prevNode.next;
        			}
        			
        			if (node == null) 
        				node = hNode.left;
        		}
        		
        		if (hNode.right != null) {
        			if (prevNode == null)
        				prevNode = hNode.right;
        			else {
        				prevNode.next = hNode.right;  
        				prevNode = prevNode.next;
        			}
        			
        			if (node == null) 
        				node = hNode.right;
        		}
	        	
	        	hNode = hNode.next;
        	}
        }
    }
}
