package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, 
 * only nodes itself can be changed.
 * 
 * 
 */
public class L0024_SwapNodesInPairs {

	public L0024_SwapNodesInPairs() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		L0024_SwapNodesInPairs swapNodes = new L0024_SwapNodesInPairs();
		
		int[] x = {-10,-9,-6,-4,1,9,9};
		//int[] x = {-5,-3,0,7,8,8};		
		
		ListNode list = Util.createList(x);
		
		System.out.println("input: list = " + Util.printList(list));
	
		ListNode result = swapNodes.swapPairs(list);		
		
		System.out.println("output: " + Util.printList(result));
	}

    public ListNode swapPairs(ListNode head) {
    	if (head == null || head.next == null)
    		return head;
    	
    	ListNode p1 = head.next;
    	ListNode p2 = head;    	
    	ListNode prev = null;
    	ListNode next = p1.next;
    	
    	while (p2 != null) {
    		if (p1 != null) {
    			if (prev == null)
    				head = p1;
    			else 
    				prev.next = p1;
    			
    			p1.next = p2;
    			p2.next = next;
    			
    			prev = p2;
    			p2 = next;   			
    			if (next != null) {
    				p1 = next.next;
    				if (p1 != null)
    					next = p1.next;
    			}
    			else
    				p1 = null;    			    			
    		}
    		else
    			break;
    	} 
    	
    	return head;
    }
}
