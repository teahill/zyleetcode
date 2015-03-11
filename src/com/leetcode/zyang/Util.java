package com.leetcode.zyang;

import com.leetcode.zyang.ListNode;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}
	
	public static String printList(ListNode head) {
		String in = "";
		ListNode node = head;
		
		while (node != null) {
			in = in + node.val + " -> ";	
			node = node.next;
		}
		
		return in;
	}
	
	public static ListNode createList(int len, int multiplier, int offset) {
		if (len ==0)
			return null;
		
		ListNode head = new ListNode(offset);
		ListNode node = head;
		ListNode prevNode = head;

		if (len == 1)
			return head;
		
		for (int i = 1; i < len; i++) {
			node = new ListNode(i * multiplier + offset);
			prevNode.next = node;
			prevNode = node;			
		}
		
		return head;
	}
	
	public static ListNode createList(int[] in) {
		if (in == null || in.length == 0)
			return null;
		
		ListNode head = new ListNode(in[0]);
		
		if (in.length == 1)
			return head;
		
		ListNode node = null, prevNode = head;
		
		for (int i = 1; i < in.length; i++) {
			node = new ListNode(in[i]);
			prevNode.next = node;
			prevNode = node;
		}
		
		return head;
	}
	
	public static String printArray(int[] in) {
		String result = "{";
		
		for (int i = 0; i < in.length; i++) {
			result = result + in[i] + ",";
		}
		
		result = result  + "}";
		
		return result;
	}
	
	public static TreeNode createTree(int n) {
		if (n == 0)
			return null;
		
		TreeNode tree = new TreeNode(2*n+1);
		
		if (n == 1) 
			return tree;
		
		if (n == 2) {
			TreeNode nodeLeft = new TreeNode(2*n-1);
			TreeNode nodeRight = new TreeNode(2*n);
			tree.left = nodeLeft;
			tree.right = nodeRight;
		}
			
		for (int i = n-1; i > -1; i--) {
			tree.left = createTree(i-1);
			tree.right = createTree(i);
		}
		return tree;		
	}
}
