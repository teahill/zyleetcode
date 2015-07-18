package com.leetcode.zyang;

import java.util.List;

import com.leetcode.zyang.ListNode;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}
	
	public static String printList(ListNode head) {
		String in = "";
		ListNode node = head;
		
		while (node != null) {
			in = in + node.val + " -> ";	
			node = node.next;
		}
		
		return in;
	}
	
	public static String printCyclicList(ListNode head, int k) {
		String in = "";
		ListNode node = head;
		
		int n = 1;
		while (n < 10) {			
			in = in + node.val + " -> ";	
			node = node.next;
			n++;			
		}
		
		return in;
	}
	
	public static ListNode createList(int len, int multiplier, int offset) {
		if (len ==0)
			return null;
		
		ListNode head = new ListNode(offset);
		ListNode node = head;
		ListNode prevNode = head;

		if (len == 1)
			return head;
		
		for (int i = 1; i < len; i++) {
			node = new ListNode(i * multiplier + offset);
			prevNode.next = node;
			prevNode = node;			
		}
		
		return head;
	}
	
	public static ListNode createList(int[] in) {
		if (in == null || in.length == 0)
			return null;
		
		ListNode head = new ListNode(in[0]);
		
		if (in.length == 1)
			return head;
		
		ListNode node = null, prevNode = head;
		
		for (int i = 1; i < in.length; i++) {
			node = new ListNode(in[i]);
			prevNode.next = node;
			prevNode = node;
		}
		
		return head;
	}
	
	public static ListNode createCyclicList(int[] in, int k) {
		if (in == null || in.length == 0)
			return null;
		
		if (k > in.length)
			return null;
		
		ListNode head = new ListNode(in[0]);
		
		if (in.length == 1)
			return head;
		
		ListNode node = null, prevNode = head, kthNode = head;
		
		for (int i = 1; i < in.length; i++) {
			node = new ListNode(in[i]);
			prevNode.next = node;
			prevNode = node;
			
			if (i == k)
				kthNode = node;				
		}
		
		//Create cycle
		node.next = kthNode;
		
		return head;
	}
	
	public static ListNode mergeList(ListNode listA, ListNode listB) {
		if (listA == null)
			return listB;
		
		if (listB == null)
			return listA;
		
		ListNode node = listA;
		while (node != null && node.next != null) 
				node = node.next;							
		
		node.next = listB;
		
		return listA;
	}
	
	public static String printArray(int[] in) {
		String result = "{";
		
		for (int i = 0; i < in.length; i++) {
			result = result + in[i] + ",";
		}
		
		result = result  + "}";
		
		return result;
	}
	
	public static String printStringArray(String[] in) {
		String result = "{";
		
		for (int i = 0; i < in.length; i++) {
			result = result + in[i] + ",";
		}
		
		result = result  + "}";
		
		return result;
	}
	
	public static String printMatrix(int[][] m) {
		String result = "{";
		
		for (int i = 0; i < m.length; i++) {
			result = result + "{";
			for (int j = 0; j < m[0].length; j++) {
				result = result + m[i][j] + ",";
			}
			result = result + "}";
		}
		
		result = result  + "}";
		
		return result;
	}
	
	public static String printCharMatrix(char[][] m) {
		String result = "{";
		
		for (int i = 0; i < m.length; i++) {
			result = result + "{";
			for (int j = 0; j < m[0].length; j++) {
				result = result + m[i][j] + ",";
			}
			result = result + "}";
		}
		
		result = result  + "}";
		
		return result;
	}
	
    public static String printList(List<List<Integer>> allList) {
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < allList.size(); i++) {
    		sb = sb.append("{");
    		List<Integer> list = allList.get(i);
    		for (int j = 0; j < list.size(); j++) {
    			sb = sb.append(list.get(j).intValue());
    			sb.append(",");
    		}
    		sb = sb.append("}");
    	}
    	
    	return sb.toString();
    }

    public static String printListString(List<List<String>> allList) {
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < allList.size(); i++) {
    		sb = sb.append("{");
    		List<String> list = allList.get(i);
    		for (int j = 0; j < list.size(); j++) {
    			sb = sb.append(list.get(j));
    			sb.append(",");
    		}
    		sb = sb.append("}");
    	}
    	
    	return sb.toString();
    }
    
    public static String printListStringArray(List<String[]> list) {
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < list.size(); i++) {
    		String[] strs = list.get(i);
    		
    		sb = sb.append("{");
    		for (int j = 0; j < strs.length; j++) {
    			sb = sb.append(strs[j]);
    			sb.append(",");
    		}
    		sb = sb.append("}");
    	}
    	
    	return sb.toString();
    }
    
	public static RandomListNode createListRandom(int[] in) {
		if (in == null || in.length == 0)
			return null;
		
		RandomListNode head = new RandomListNode(in[0]);
		
		if (in.length == 1)
			return head;
		
		RandomListNode node = null, prevNode = head;
		
		for (int i = 1; i < in.length; i++) {
			node = new RandomListNode(in[i]);
			prevNode.next = node;
			prevNode = node;
		}
		
		return head;
	}
	
	public static void connectListRandom(RandomListNode head, int m, int n) {
		RandomListNode node = head;
		RandomListNode nodeM = null; 
		RandomListNode nodeN = null; 
		while (node != null && (nodeM == null || nodeN == null)) {
			if (node.label == m) 
				nodeM = node;
			if (node.label == n) 
				nodeN = node;
			
			node = node.next;
		}
		
		if ((nodeM != null) && (nodeN != null))
			nodeM.random = nodeN;
		
		return;
	}
	
	public static String printListRandom(RandomListNode head) {
		String in = "";
		RandomListNode node = head;
		
		while (node != null) {
			in = in + "(" + node.label + ", ";
			
			if (node.random == null)
				in = in + " null ) -> ";	
			else 
				in = in + node.random.label + " ) -> ";
			
			node = node.next;
		}
		
		return in;
	}
}
