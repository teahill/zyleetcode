package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Reverse a singly linked list.
 */
public class L0206_ReverseLinkedList {

	public L0206_ReverseLinkedList() {
		// TODO Auto-generated constructor stub
	}

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        
        ListNode node = head;
        ListNode next = node.next;
        head.next = null;
        
        ListNode tmp = next.next;        
        while (next != null) {        	
        	next.next = node;
        	node = next;
        	next = tmp;
        	
        	if (tmp != null)
        		tmp = tmp.next;
        }
        
        return node;
    }
    
    
    // from leetcode, cleaner
    public ListNode reverseList1(ListNode head) {
	    ListNode newHead = null;
	    while(head != null){
	        ListNode next = head.next;
	        head.next = newHead;
	        newHead = head;
	        head = next;
	    }
	    return newHead;
    }
}
