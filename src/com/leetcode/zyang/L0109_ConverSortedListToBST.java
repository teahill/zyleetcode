package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 */
public class L0109_ConverSortedListToBST {

	public L0109_ConverSortedListToBST() {
		// TODO Auto-generated constructor stub
	}

    public TreeNode sortedListToBST(ListNode head) {
    	if (head == null)
    		return null;
    	
    	if (head.next == null) {
    		TreeNode root = new TreeNode(head.val);
    		return root;
    	}
    	
    	ListNode fast = head.next;
    	ListNode slow = head;
    	while (fast.next != null && fast.next.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	
    	TreeNode node = new TreeNode(slow.next.val);   	
    	node.right = sortedListToBST(slow.next.next);
    	
    	slow.next = null;
    	node.left = sortedListToBST(head);
    	
    	return node;    	
    }
}
