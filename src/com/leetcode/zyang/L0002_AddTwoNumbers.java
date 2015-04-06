package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 */
public class L0002_AddTwoNumbers {

	public L0002_AddTwoNumbers() {
		// TODO Auto-generated constructor stub
	}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
        	return null;
        
        int i1 = 0, i2 = 0, carryOver = 0, sum = 0;
        
        ListNode prevNode = null, head = null;
        
        while (l1 != null || l2 != null) {
        	
       		i1 = (l1 == null) ? 0 : l1.val;
        	
        	i2 = (l2 == null) ? 0 : l2.val;
        	
        	sum= (i1 + i2 + carryOver) % 10;
        	carryOver = (i1 + i2 + carryOver) / 10;
        	
        	ListNode node = new ListNode(sum);
        	if (head == null) {
        		head = node;
        		prevNode = node;
        	}
        	else {
        		prevNode.next = node;
        		prevNode = node;
        	}   
        	
       		l1 = (l1 != null) ? l1.next : l1;
       		l2 = (l2 != null) ? l2.next : l2;
        }
        
        if (carryOver > 0) {
        	ListNode node = new ListNode(carryOver);
        	prevNode.next = node;
        }
        
        return head;        	
    }
}
