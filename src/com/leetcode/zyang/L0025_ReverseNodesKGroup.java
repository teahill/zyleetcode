package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * 
 */
public class L0025_ReverseNodesKGroup {

	public L0025_ReverseNodesKGroup() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0025_ReverseNodesKGroup reverseKGroup = new L0025_ReverseNodesKGroup();
		
		int k = 3;
		int[] x = {1, 2, 3, 4, 5, 6, 7, 8};
		//int[] x = {1,2};	
		//int[] x = {1,2, 3};	
		
		ListNode list = Util.createList(x);
		
		System.out.println("input: list = " + Util.printList(list));
	
		ListNode result = reverseKGroup.reverseKGroup(list, k);		
		
		System.out.println("output: " + Util.printList(result));
	}

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
        	return head;
        
        ListNode prevNode = null;
        ListNode firstNode = head;
        ListNode lastNode = head;
        ListNode nextNode = head;
        
        while (firstNode != null) {
	        int count = 1;       
	        while (count < k && lastNode != null) {
	        	lastNode = lastNode.next;
	        	count++;
	        }
	        
	        if (count == k && lastNode != null) {	
	        	nextNode = lastNode.next;
	        	lastNode.next = null;
	        	
	        	Pair pair = reverseList(firstNode);
	        	firstNode = pair.firstNode;
	        	lastNode = pair.lastNode;
	        	
	        	if (prevNode == null) 
	        		head = firstNode;
	        	else 
	        		prevNode.next = firstNode;
	        	
	        	prevNode = lastNode;
	        	
	        	firstNode = nextNode;
	        	lastNode = nextNode;
	        }
	        else if (prevNode != null) {
	        	prevNode.next = firstNode;
	        	break;
	        }
	        else
	        	break;
        }

    	return head;
    }
    
	public static Pair reverseList(ListNode head) {
		if (head == null || head.next == null)
			return new Pair(head, head);
		
		ListNode p1 = head;
		ListNode p2 = head.next;
		ListNode next = p2.next;
		
		p1.next = null;
		ListNode lastNode = p1;
		
		while (p2 != null) {
			p2.next = p1;
			p1 = p2;
			p2 = next;
			
			if (next != null)
				next = next.next;
		}
		
		head = p1;
		
		return new Pair(p1, lastNode);		
	}
	
    public static class Pair {
    	ListNode firstNode;
    	ListNode lastNode;
    	
    	Pair(ListNode firstNode, ListNode lastNode) {
    		this.firstNode = firstNode;
    		this.lastNode = lastNode;
    	}
    }
}
