package com.leetcode.zyang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author zyang
 * 
 * http://algs4.cs.princeton.edu/34hash/SeparateChainingLiteHashST.java.html
 * 
 * http://algs4.cs.princeton.edu/34hash/
 * 
 */
public class MyHashMap<K, V> {

	private int capacity;
	private int size;
	private Node[] array;
	
	private static class Node {
		Object key;
		Object value;
		Node next;
		
		public Node(Object key, Object value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public MyHashMap(int capacity) {
		this.capacity = capacity;
		this.size = 0;	
		array = new Node[capacity];
	}
	
	public void put(K key, V value) {
		if (key == null)
			return;
		
		if (value == null) {
			delete(key);
			return;
		}
		
		int index = hash(key);
		Node node = array[index];
		if (node != null) {
			if (node.key.equals(key)) {
				node.value = value;
				return;
			}
			
			node = node.next;
		}
		
		array[index] = new Node(key, value, array[index]);
		size++;
	}
	
	private int hash(K key) {
		if (key == null)
			return -1;
		
		return (key.hashCode() & 0x7fffffff %capacity);
	}
	
	public V get(K key) {
		if (key == null)
			return null;
		
		int index = hash(key);
		Node node = array[index];
		while (node != null) {
			if (node.key.equals(key))
				return (V)node.value;
			
			node = node.next;
		}
		
		return null;
	}
	
	public boolean contains(K key) {
		return (get(key) != null) ? true : false;
	}
	
	public void delete (K key) {
		
	}
	
	public int size() {
		return size;
	}
	
	public Iterable<K> keys() {
		Queue<K> queue = new LinkedList<K>();
		
		for (int i = 0; i < capacity; i++) {
			Node node = array[i];
			while (node != null) {
				queue.offer((K)node.key);
				node = node.next;
			}				
		}
		
		return queue;
	}
	
	public static void main(String[] args) {
		MyHashMap<String, Integer> map = new MyHashMap<String, Integer>(100);
		
		map.put("abc", 1);
		map.put("def", 2);
		map.put("eft", 3);
		
		for (String s : map.keys())
			System.out.print(s + "\n");
	}
}
