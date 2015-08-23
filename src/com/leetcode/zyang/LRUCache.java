package com.leetcode.zyang;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author zyang
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 * 
 */

/** 
 * Use HashMap and double linked list
 * 
 * 
 *
 */
public class LRUCache {
	private int capacity;
	private Map<Integer, DoubleLL> map;
	private DoubleLL head;
	private DoubleLL tail;
	
	private LinkedHashMap<Integer, Integer> mapLinked;
	
	// Use LinkedHashMap, default in insert order
    public LRUCache(int capacity) {
		this.capacity = capacity;
		this.mapLinked = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
    	if (!mapLinked.containsKey(key))
    		return -1;
    	
    	Integer value = mapLinked.get(key);
    	mapLinked.remove(key);
    	mapLinked.put(key, value);
    	
    	return value;
    }
    
    public void set(int key, int value) {
    	if (mapLinked.containsKey(key)) {
    		mapLinked.remove(key);
    		mapLinked.put(key, value);
    	}
    	else {
    		if (mapLinked.size() == this.capacity) 
    			// because of insert order, the first node is the oldest one
    			mapLinked.remove(mapLinked.keySet().iterator().next());
    		
    		mapLinked.put(key, value);
    	}
    }
    

    public LRUCache(int capacity, int count) {
		this.capacity = capacity;
		map = new HashMap<Integer, DoubleLL>();
		head = new DoubleLL(0, 0);
		tail = new DoubleLL(0, 0);
		
		head.prev = null;
		head.next = tail;
		tail.prev = head;
		tail.next = null;
    }
    
    public int get1(int key) {
        if (!map.containsKey(key))
        	return -1;
        
        DoubleLL node = map.get(key);
        remove(node);
        insertHead(node);
        
        return node.value;        
    }
    
    public void set1(int key, int value) {
        if (map.containsKey(key)) {
        	DoubleLL node = map.get(key);
        	node.value = value;
        	
        	remove(node);
        	insertHead(node);        			
        }
        else {
        	if (map.size() == this.capacity) {
        		map.remove(tail.prev.key);
        		remove(tail.prev);
          	}
        	
        	DoubleLL node = new DoubleLL(key, value);
        	insertHead(node);
        	map.put(key, node);
        }        
    }

    private void remove(DoubleLL node) {
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    }
    
    private void insertHead(DoubleLL node) {
    	node.prev = head;
    	node.next = head.next;
    	
    	head.next.prev = node;
    	head.next = node;
    }
   
    class DoubleLL {
    	DoubleLL prev;
    	DoubleLL next;
    	
    	int key;
    	int value;
    	
    	DoubleLL(int key, int value) {
    		this.key = key;
    		this.value = value;
    	}
    }
}
