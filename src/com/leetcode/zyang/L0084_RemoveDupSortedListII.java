package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,G
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * 
 */

public class L0084_RemoveDupSortedListII {

	public L0084_RemoveDupSortedListII() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0084_RemoveDupSortedListII removeDupSOrtedList = new L0084_RemoveDupSortedListII();
		
		//int[] x = {1,1,2};
		//int[] x = {1,1,2,3,3};
		//int[] x = {1,1};
		//int[] x = {1,2,3,3,4,4, 5};
		int[] x = {1,1,1,2,3};
		
		ListNode l1 = Util.createList(x);
		
		System.out.println("input: l1 = " + Util.printList(l1));
	
		ListNode result = removeDupSOrtedList.deleteDuplicates(l1);		
		
		System.out.println("output: " + Util.printList(result));
	}

    public ListNode deleteDuplicates(ListNode head) {
    
        if (head == null || head.next == null)
        	return head;
        
        ListNode ptr1 = head.next;
        ListNode ptr2 = head;
        ListNode ptr2Prev = null;   
        boolean toDelete = false;
        
        while (ptr1 != null) {
        	if (ptr1.val == ptr2.val) {
        		ptr2.next = ptr1.next;
        		ptr1 = ptr1.next;
        		toDelete = true;
        	}
        	else {
        		if (toDelete) {
   			
        			ptr2 = ptr1;
        			
        			if (ptr2Prev == null) 
        				head = ptr2; 
        			else 
        				ptr2Prev.next = ptr2;
        			
        			ptr1 = ptr1.next;
        			toDelete = false;
        		}
        		else {
        			ptr1 = ptr1.next;
        			ptr2Prev = ptr2;
        			ptr2 = ptr2.next;        		
        		}
        	}
        }
        
        if (toDelete) {
			if (ptr2Prev == null) 
				head = ptr2.next; 
			else
				ptr2Prev.next = null;
        }
        
    	return head;  
    }
}
