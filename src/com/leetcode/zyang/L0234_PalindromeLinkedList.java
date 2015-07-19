package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class L0234_PalindromeLinkedList {

	public L0234_PalindromeLinkedList() {
		// TODO Auto-generated constructor stub
	}

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
        	return true;
        
        if (head.next.next == null)
        	return head.val == head.next.val;
        
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
       	ListNode mid = (fast == null) ? slow : slow.next;       	
       	//System.out.println(Util.printList(mid));       	
       	ListNode secondHead = reverse(mid);       	
       	ListNode n1 = head;
       	ListNode n2 = secondHead;
       	//System.out.println(Util.printList(n1));
       	//System.out.println(Util.printList(n2));
       	while (n2 != null) {
       		if (n1.val != n2.val) {
       			reverse(secondHead);
       			return false;
       		}
       		n1 = n1.next;
       		n2 = n2.next;
       	}
       	
       	reverse(secondHead);
       	
       	return true;
    }
    
    private ListNode reverse(ListNode head) {
    	ListNode node = head;
    	ListNode prev = null;
    	while (node != null && node.next != null) {
    		ListNode nextNode = node.next;
    		node.next = prev;
    		prev = node;
    		node = nextNode;
    	}
    	
    	node.next = prev;
    	
    	return node;
    }
}
