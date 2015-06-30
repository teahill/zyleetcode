package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class L0203_RemoveLLElement {

	public L0203_RemoveLLElement() {
		// TODO Auto-generated constructor stub
	}

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
        	return head;
               
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
        	if (node.val == val) {
        		if (prev == null) 
        			head = node.next;
        		else 
	        		prev.next = node.next;
        	}
        	else {
        		if (prev == null) {
        			head = node;
        			prev = node;
        		}
        		else 
		        	prev = node;
        	}
        	
        	node = node.next;
        }
        	
        return head;
    }
}
