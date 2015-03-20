package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Swap a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 */
public class ReverseLinkedListII {

	public ReverseLinkedListII() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedListII reverseLL = new ReverseLinkedListII();

		/**
		int[] x = {1, 2, 3, 4, 5, 6, 7, 8};	
		int m = 6;
		int n = 8;
		*/
		
		int[] x = {1, 2, 3, 4};	
		int m = 1;
		int n = 4;

		ListNode list = Util.createList(x);

		System.out.println("input: list = " + Util.printList(list));

		ListNode result = reverseLL.reverseBetween(list, m, n);		

		System.out.println("output: " + Util.printList(result));
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n || m < 1 || n < 2)
			return head;

		ListNode p1 = head;

		ListNode pm1 = null; // node before m
		ListNode pm = head;
		ListNode pm2 = head.next; // node after m

		ListNode pn1 = head;
		ListNode pn = head.next;
		ListNode pn2 = head.next;

		int count = 1;
		while (p1 != null) {
			if (count == m-1) {
				pm1 = p1;
				pm = p1.next;
				if (pm != null)
					pm2 = pm.next;
			}

			if (count == n-1) {
				pn1 = p1;
				pn = p1.next;
				if (pn != null)
					pn2 = pn.next;

				break;
			}
			p1 = p1.next;
			count++;
		}

		if (pm1 == null)
			head = pn;
		else
			pm1.next = pn;

		if (m == n-1)   		
			pn.next = pm;
		else {    		
			pn.next = pm2;
			pn1.next = pm;
		}
		
		pm.next = pn2;  

		return head;
	}
}
