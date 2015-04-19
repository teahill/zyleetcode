package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
public class L0141_LinkedListCycle {

	public L0141_LinkedListCycle() {
		// TODO Auto-generated constructor stub
	}

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
        	return false;
        
        ListNode pFast = head.next.next, pSlow = head;
        while (true) {
     		if (pFast == null || pFast.next == null)
        		return false;
        	else if (pFast == pSlow)
        		return true;     
    		
    		pFast = pFast.next.next;
    		pSlow = pSlow.next; 
        }        	
    }
}
