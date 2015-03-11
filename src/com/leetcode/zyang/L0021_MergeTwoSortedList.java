package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 */

public class L0021_MergeTwoSortedList {

	public L0021_MergeTwoSortedList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0021_MergeTwoSortedList mergeList = new L0021_MergeTwoSortedList();
		
		//int len1 = 3;
		//int len2 = 3;	
		
		//ListNode l1 = Util.createList(len1, -4, 1);
		//ListNode l2 = Util.createList(len2, -2, 2);
		
		int[] x = {-10,-9,-6,-4,1,9,9};
		int[] y = {-5,-3,0,7,8,8};
		
		//int[] x = {1};
		//int[] y = {0};
		
		ListNode l1 = Util.createList(x);
		ListNode l2 = Util.createList(y);
		
		System.out.println("input: l1 = " + Util.printList(l1));
		System.out.println("input: l2 = " + Util.printList(l2));
	
		ListNode result = mergeList.mergeTwoLists(l1, l2);		
		
		System.out.println("output: " + Util.printList(result));
	}

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    	if (l1 == null)
    		return l2;
    	
    	if (l2 == null)
    		return l1;

    	ListNode head, other;

    	head = (l1.val <= l2.val) ? l1 : l2;
    	other = (l1.val > l2.val) ? l1 : l2;       

    	ListNode ptr1 =  head;
    	ListNode ptr2 = other;
    	ListNode tmpNext1 = null, tmpNext2 = null;
    	while (ptr1 != null && ptr2 != null) { 
    		if (ptr1.val <= ptr2.val) {
    			
    			if (ptr1.next == null) {
    				tmpNext1 = ptr1.next;
    				ptr1.next = ptr2;
    				ptr1 = tmpNext1;
    			} 
    			else if (ptr1.next.val <= ptr2.val)
    				ptr1 = ptr1.next;
    			else if (ptr2.next == null) {
    				ptr2.next = ptr1.next;
    				ptr1.next = ptr2;
    				ptr2 = null;
    			}
    			else if (ptr1.next.val <= ptr2.next.val) {   				
    				tmpNext2 = ptr2.next;
    				ptr2.next = ptr1.next;
    				ptr1.next = ptr2;
    				ptr1 = ptr2.next;
    				ptr2 = tmpNext2;
    				
    			} 
    			else if (ptr1.next.val > ptr2.next.val) {
    				tmpNext2 = ptr2.next;
    				while (tmpNext2.next != null && tmpNext2.next.val < ptr1.next.val) {
    					tmpNext2 = tmpNext2.next;
    				}
    				
    				tmpNext1 = tmpNext2.next;
    				tmpNext2.next = ptr1.next;
    				ptr1.next = ptr2;
    				ptr1 = tmpNext2.next;
    				ptr2 = tmpNext1;
    				
    			}    					
    		}
    	}
    	
    	return head;
    }
    
    //recursive, simple but slower
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null)
    		return l2;
    	
    	if (l2 == null)
    		return l1;
    	
    	ListNode head;
    	
    	if (l1.val <= l2.val) {
    		head = l1;
    		head.next = mergeTwoLists(l1.next, l2);
    	}
    	else {
    		head = l2;
    		head.next = mergeTwoLists(l1, l2.next);
    	}
    	
    	return head;
    }
}
