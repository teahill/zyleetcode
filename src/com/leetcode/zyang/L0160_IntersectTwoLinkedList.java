package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 */
public class L0160_IntersectTwoLinkedList {

	public L0160_IntersectTwoLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0160_IntersectTwoLinkedList twoLL = new L0160_IntersectTwoLinkedList();
		
		int[] x = {1, 2, 3};
		int[] y = {4, 5};
		int[] z = {7, 8, 9};
		
		//int[] x = {1};
		//int[] y = {0};
		
		ListNode l1 = Util.createList(x);
		ListNode l2 = Util.createList(y);
		ListNode l3 = Util.createList(z);	
		l1 = Util.mergeList(l1, l3);
		l2 = Util.mergeList(l2, l3);
		
		System.out.println("input: l1 = " + Util.printList(l1));
		System.out.println("input: l2 = " + Util.printList(l2));
		
		ListNode sharedNode = twoLL.getIntersectionNode(l1, l2);
		System.out.println("shared node = " + sharedNode.val);
		
		System.out.println("out: l1 = " + Util.printList(l1));
		System.out.println("out: l2 = " + Util.printList(l2));
		
		
	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
        	return null;
        
        if (headA == headB)
        	return headA;
        
         int sizeA = size(headA);
         int sizeB = size(headB);
         int diff = 0;
         ListNode list1 = headA, list2 = headB;
         
         if (sizeA > sizeB) 
        	 diff = sizeA - sizeB;
         else if (sizeA < sizeB) {
        	 diff = sizeB - sizeA;
        	 list1 = headB;
        	 list2 = headA;
         }
         
         for (int i = 0; i < diff; i++) 
        	 list1 = list1.next;
         
         while (list1 != list2) {
        	 list1 = list1.next;
        	 list2 = list2.next;
         }
                 
        return list1;        
    }
    
    public int size(ListNode root) {
    	int size = 0;
    	
    	ListNode node = root;
    	while (node != null) {
    		size++;
    		node = node.next;
    	}
    	
    	return size;
    }

}
