package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 */
public class L0061_RotateList {

	public L0061_RotateList() {
		// TODO Auto-generated constructor stub
	}

    public ListNode rotateRight(ListNode head, int k) {        
    	if (k == 0)
    		return head;
    	
    	if (head == null || head.next == null)
    		return head;

        ListNode p1 = head, p2 = head; 
        int n = 0;
        while (p1.next != null && n < k) {
        	p1 = p1.next;
        	n++;        	
        }
        
        if (n < k) {
        	k = k % (n + 1);
        	return rotateRight(head, k);
        }        	
        
        while (p1.next != null) {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        
        p1.next = head;
        head = p2.next;
        p2.next = null;
                	
    	return head;
    }
}
