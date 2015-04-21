package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
public class L0142_LinkedListCycleII {

	public L0142_LinkedListCycleII() {
		// TODO Auto-generated constructor stub
	}

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
        	return null;
        
        // find the first overlap if cyclic
        ListNode pFast = head, pSlow = head;
        while (true) {
    		pFast = pFast.next.next;
    		pSlow = pSlow.next; 
    		
     		if (pFast == null || pFast.next == null)
        		return null;       		
        	else if (pFast == pSlow) 
       			break;   
    	} 
        
        // reset one node back to head; move at the same page; 
        // the two nodes shall meet again at the node where the cycle begins 
        pFast = head;
        while (true) {
        	if (pFast == pSlow) 
        		return pFast;
        	
        	pFast = pFast.next;
        	pSlow = pSlow.next;
        }        
    }
    
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null)
        	return null;
        
        ListNode pFast = head.next.next, pSlow = head, p3 = head;
        while (true) {
     		if (pFast == null || pFast.next == null)
        		return null;
     		else if (pFast == p3)
     			return p3;
        	else if (pFast == pSlow) {
       			p3 = p3.next;
        	}   
    		
    		pFast = pFast.next.next;
    		pSlow = pSlow.next; 
        }        	
    }
}
