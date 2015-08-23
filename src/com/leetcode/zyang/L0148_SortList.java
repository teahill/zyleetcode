package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * 
 */
public class L0148_SortList {

	public L0148_SortList() {
		// TODO Auto-generated constructor stub
	}

	// Use merge sort, O(nlogn) time, O(1) space, top down recursive
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
        	return head;
        
        // Use two pointers to find mid point
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null) {
        	slow =slow.next;
        	fast = fast.next.next;        	
        }
        
        ListNode h2 = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(h2);
        
        ListNode newHead = mergeList(l1, l2);     
        
        return newHead;
    }
    
    // merge the two sorted lists
    private ListNode mergeList(ListNode l1, ListNode l2) {
    	if (l1 == null)
    		return l2;
    	
    	if (l2 == null)
    		return l1;    	

    	ListNode head = (l1.val > l2.val) ? l2 : l1;
    	ListNode curNode = head;
    	if (l1.val > l2.val) 
    		l2 = l2.next;
    	else 
    		l1 = l1.next;

    	while (l1 != null && l2 != null) {
    		if (l1.val <= l2.val) {
    			curNode.next = l1;
	    		l1 = l1.next;	
    		}    		
    		else {
    			curNode.next = l2;
    			l2 = l2.next;	    		
    		}
    		
    		curNode = curNode.next;
    	}
    	
    	if (l1 == null)
    		curNode.next = l2;
    	else 
    		curNode.next = l1;
    	
    	return head;
    }
}
