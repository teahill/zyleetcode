package com.leetcode.zyang;
/**
 * 
 * @author zyang
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * linked list, two pointers
 * 
 */
public class L0019_RemoveNode {

	public L0019_RemoveNode() {
		// TODO Auto-generated constructor stub		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		L0019_RemoveNode removeNode = new L0019_RemoveNode();
		
		ListNode head = removeNode.new ListNode(1);
		ListNode node = head;
		ListNode prevNode = head;
		
		int l = 5;
		int n = 5;	
		
		for (int i = 1; i < l; i++) {
			node = removeNode.new ListNode(i+1);
			prevNode.next = node;
			prevNode = node;			
		}
		
		System.out.println("input: " + removeNode.printList(head));
	
		ListNode result = removeNode.removeNthFromEnd(head, n);		
		
		System.out.println("output: " + removeNode.printList(result));
	}
	
	public String printList(ListNode head) {
		String in = "";
		ListNode node = head;
		
		while (node != null) {
			in = in + node.val + " -> ";	
			node = node.next;
		}
		
		return in;
	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }
	 
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode firstPointer = head;
    	ListNode secondPointer = head;
    	ListNode prevNode = null;
    	
    	int pos = 1;
    	
    	if (head == null || n == 0)
    		return head;
    	
    	if (firstPointer.next == null)
    		return null;
    	
    	while (firstPointer.next != null) {
    		if (pos < n) {
    			pos++;
    			firstPointer = firstPointer.next;
    		}
    		else {
    			firstPointer = firstPointer.next;
    			prevNode = secondPointer;
    			secondPointer = secondPointer.next;    			
    		}    		   		
    	}
    	
    	// remove node
    	if (prevNode == null && pos == n)  
    		head = secondPointer.next;    	
    	else if (prevNode != null)
    		prevNode.next = secondPointer.next;
    	
        return head;
    }
	
}
