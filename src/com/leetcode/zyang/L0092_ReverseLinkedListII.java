package com.leetcode.zyang;


/**
 * 
 * @author zyang
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
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
public class L0092_ReverseLinkedListII {

	public L0092_ReverseLinkedListII() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0092_ReverseLinkedListII reverseLL = new L0092_ReverseLinkedListII();

		
		int[] x = {1, 2, 3, 4, 5, 6, 7, 8};	
		int m = 1;
		int n = 4;
		 

		/**
		int[] x = {1, 2, 3, 4};	
		int m = 1;
		int n = 4;
		*/

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

		ListNode pn = head.next;
		ListNode pn2 = head.next;

		int count = 1;
		while (p1 != null) {
			if (count == m-1) {
				pm1 = p1;
				pm = p1.next;
			}

			if (count == n) {
				pn = p1;
				pn2 = pn.next;

				break;
			}
			p1 = p1.next;
			count++;
		}

		// termindate the list that needs to be reversed
		pn.next = null;

		Pair pair = reverseList(pm);
		if (pm1 == null)
			head = pair.firstNode;
		else
			pm1.next = pair.firstNode;

		pair.lastNode.next = pn2;	

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
