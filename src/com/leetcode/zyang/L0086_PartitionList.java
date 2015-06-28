package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 */
public class L0086_PartitionList {

	public L0086_PartitionList() {
		// TODO Auto-generated constructor stub
	}

	public ListNode partition(ListNode head, int x) {
		ListNode ps = null, pb = null;
		ListNode psHead = null, pbHead = null;

		if (head == null || head.next == null)
			return head;
		
		while (head != null) {
			if (head.val < x) {
				if (psHead == null) {
					psHead = head;
					ps = head;
				}
				else {
					ps.next = head;
					ps = ps.next;
				}
			}
			else {
				if (pbHead == null) {
					pbHead = head;
					pb = head;
				}
				else {
					pb.next = head;
					pb = pb.next;
				}
			}
			
			head = head.next;
		}
		
		if (pb != null)
			pb.next = null;
		
		if (ps != null)
			ps.next = pbHead;
		
		if (psHead == null)
			return pbHead;
		
		return psHead;
		
	}
	
	// initial impl, buggy
	public ListNode partition1(ListNode head, int x) {
		ListNode p1 = head, p2 = head;

		if (head == null || head.next == null)
			return head;

		if (p1.val < x)
			p1 = p1.next;

		while ((p1 != null) && (p1.val < x)) {
			p1 = p1.next;
			p2 = p2.next;
		}

		if (p1 == null)	
			return head;
		 
		while(p1.next != null) {
			while ((p1.next != null) && (p1.next.val >= x))  
				p1 = p1.next;
	
			if (p1.next == null)	
				return head;
	
			if (p1 == head) {
				ListNode tmp = p1.next;
				p1.next = p1.next.next;
				tmp.next = p2;
		
				p2 = tmp;
				head = p2;
				
			}
			else {	
				ListNode tmp = p1.next;
				p1.next = p1.next.next;
				tmp.next = p2.next;
				p2.next = tmp;
		
				p2 = p2.next;
			}
		}
		
		return head;
	}
}
