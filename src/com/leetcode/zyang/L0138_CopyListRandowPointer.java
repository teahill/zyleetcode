package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 */


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class L0138_CopyListRandowPointer {

	public L0138_CopyListRandowPointer() {
		// TODO Auto-generated constructor stub
	}

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
        	return head;
    	
        RandomListNode node = head;
        RandomListNode newHead = null;
        RandomListNode prevNewNode = null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        HashMap<RandomListNode, List<RandomListNode>> mapR = new HashMap<RandomListNode, List<RandomListNode>>();
        while (node != null) {
        	// Copy new node
        	RandomListNode newNode = new RandomListNode(node.label);
        	if (newHead == null)
        		newHead = newNode;
        	
        	// Update the old to new node mapping
        	map.put(node,  newNode);
        	
        	// Link to prev node
        	if (prevNewNode != null)
        		prevNewNode.next = newNode;        	
        	prevNewNode = newNode;
        	
        	// Set random node
        	if (node.random != null) {
        		RandomListNode newRandom = map.get(node.random);
        		if (newRandom == null) {
        			List<RandomListNode> list = mapR.get(node.random);
        			if (list == null) 
        				list = new ArrayList<RandomListNode>();
        			list.add(node);
        			mapR.put(node.random, list);        			
        		}
        		else 
        			newNode.random = newRandom;        	
        	}
        	
        	// Update all previous nodes that linked to this node
        	List<RandomListNode> list = mapR.get(node);
        	if (list != null) {
        		int size = list.size();
        		RandomListNode needUpdateNode;
        		RandomListNode newUpdateNode;
        		for (int i = 0; i < size; i++) {
        			needUpdateNode= list.get(i);
        			newUpdateNode = map.get(needUpdateNode);
        			newUpdateNode.random = newNode;
        		}
        		
        		mapR.remove(node);
        	}

        	// Move forward
        	node = node.next;
        }
        
        return newHead;
    }
    
    // Leetcode not using HashMap, but alter the original list and do 3 passes
    // new node follow the old node immediately
    // when done, reset back
    
}
