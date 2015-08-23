package com.leetcode.zyang;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author zyang
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class L0023_MergeKSortedList {

	public L0023_MergeKSortedList() {
		// TODO Auto-generated constructor stub
	}

	// Use priority queue, O(nklogk), 348ms
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
        	return null;
        
        if (lists.length == 1)
        	return lists[0];
        
        Queue<ListNode> queue = new PriorityQueue<ListNode>(
        		new Comparator<ListNode>() {        			
        			public int compare(ListNode n1, ListNode n2) {
        				return (n1.val - n2.val);
        			}
        		});

        for (ListNode node : lists) 
        	if (node != null)
        		queue.offer(node);
        
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (queue.peek() != null) {
        	node.next = queue.poll();
        	node = node.next;
        	
        	if (node.next != null)
        		queue.offer(node.next);
        }
        
        return head.next;
    }
    
	// Divide and conquer; O(klogn); 388ms
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0)
        	return null;
        
        if (lists.length == 1)
        	return lists[0];
        
        int n = lists.length;
        while (n > 1) {
	        for (int i = 0; i < n / 2; i++) 
	        	lists[i] = mergeTwoLists(lists[i], lists[n - 1 - i]);
	        	
	        if (n % 2 != 0)
	        	n = n / 2 + 1;
	        else 
	        	n = n / 2;
        }
        
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null) 
    		return l2;
    	
    	if (l2 == null)
    		return l1;

    	// Very useful trick not to worry about checking head null
    	ListNode head = new ListNode(0);
    	ListNode node = head;    		
    	while (true) {
    		if (l1 == null) {
    			node.next = l2;
    			break;
    		}
    		else if (l2 == null){
    			node.next = l1;
    			break;
    		}
    		else if (l1.val < l2.val) {
    			node.next = l1;
    			node = node.next;
    			l1 = l1.next;
    		}
    		else {
    			node.next = l2;
    			node = node.next;
    			l2 = l2.next;
    		}
    	}
    	
    	return head.next;
    }    
}
