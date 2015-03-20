package com.leetcode.zyang;

public class ReverseLinkedList {

	public ReverseLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ReverseLinkedList reverseList = new ReverseLinkedList();
		
		int[] x = {-10,-9,-6,-4,1,9,9};
		//int[] x = {-5,-3};		
		
		ListNode list = Util.createList(x);
		
		System.out.println("input: list = " + Util.printList(list));
	
		Pair result = ReverseLinkedList.reverseList(list);		
		
		System.out.println("output: " + Util.printList(result.firstNode) + "\nlast node: " + result.lastNode.val);
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
}


