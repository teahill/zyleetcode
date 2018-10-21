package com.leetcode.zyang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author zyang
 * 
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, 
 * peek/pop from front, size, and is empty operations are valid.
 * 
 * Depending on your language, queue may not be supported natively. 
 * You may simulate a queue by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a queue.
 * 
 * You may assume that all operations are valid (for example, 
 * no pop or top operations will be called on an empty stack).
 * 
 * Update (2015-06-11):
 * The class name of the Java function had been updated to MyStack instead of Stack.
 */
public class MyStack {

	private Queue<Integer> queue = new LinkedList<Integer>();;
	
	public MyStack() {
		// TODO Auto-generated constructor stub
	}

	
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> tmpQueue = new LinkedList<Integer>();
        
        int size = queue.size();
        int val = 0;
        for(int i = 0; i < size - 1; i++) {   
        	val = queue.remove();
        	tmpQueue.add(val);
        }
        val = queue.remove();
        queue = tmpQueue;
        
        return;
    }

    // Get the top element.
    public int top() {
        Queue<Integer> tmpQueue = new LinkedList<Integer>();
        
        int size = queue.size();
        int val = 0;
        for(int i = 0; i < size; i++) {   
        	val = queue.remove();
        	tmpQueue.add(val);
        }
        queue = tmpQueue;
        
        return val;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
