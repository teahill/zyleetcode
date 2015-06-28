package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Sort a linked list using insertion sort.
 */
public class L0147_InsertionSortList {

	public L0147_InsertionSortList() {
		// TODO Auto-generated constructor stub
	}

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
        	return head;
      
        ListNode node = head.next;
        head.next = null;
        while (node != null) {
        	ListNode tmp = node.next;
        	node.next = null;	
        	ListNode innerNode = head;
        	ListNode prevInnerNode = null;
        	while (innerNode != null) {
        		if (node.val < innerNode.val) {
        			if (prevInnerNode == null) {
        				node.next = head;
        				head = node;
        			}
        			else {
        				node.next = innerNode;
        				prevInnerNode.next = node;
        			}
        			
        			break;
        		}
        		else {
        			prevInnerNode = innerNode;
        			innerNode = innerNode.next;
        		}
        			
        	}

        	if (innerNode == null)
        		prevInnerNode.next = node;
        	
        	node = tmp;        	
        }
        
        return head;
    }
}
