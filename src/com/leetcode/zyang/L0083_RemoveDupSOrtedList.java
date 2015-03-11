package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * Show Tags
 */

public class L0083_RemoveDupSOrtedList {

	public L0083_RemoveDupSOrtedList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0083_RemoveDupSOrtedList removeDupSOrtedList = new L0083_RemoveDupSOrtedList();
		
		//int[] x = {1,1,2};
		//int[] x = {1,1,2,3,3};
		int[] x = {1,1};
		
		ListNode l1 = Util.createList(x);
		
		System.out.println("input: l1 = " + Util.printList(l1));
	
		ListNode result = removeDupSOrtedList.deleteDuplicates(l1);		
		
		System.out.println("output: " + Util.printList(result));
	}

    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        
        if (head == null || head.next == null)
        	return result;
        
        ListNode ptr1 = head.next;
        ListNode ptr2 = head;
        
        while (ptr1 != null) {
        	if (ptr1.val == ptr2.val) {
        		ptr2.next = ptr1.next;
        		ptr1 = ptr1.next;
        	}
        	else {
        		ptr1 = ptr1.next;
        		ptr2 = ptr2.next;
        	}
        }
        return result;
    }
}
