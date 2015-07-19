package com.leetcode.zyang;

import java.util.Stack;

/**
 * 
 * @author zyang
 * 
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, 
 * and is empty operations are valid.
 * 
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a stack.
 * 
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class MyQueue {

	Stack<Integer> stack;
	
	public MyQueue() {
		// TODO Auto-generated constructor stub
		stack = new Stack<Integer>();
	}
	
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> tmp = new Stack<Integer>();
        
        while (!stack.empty()) {
        	int num = stack.peek();
        	stack.pop();
        	tmp.push(num);
        }
        
        stack.push(x);
        
        while (!tmp.empty()) {
        	int num = tmp.peek();
        	tmp.pop();
        	stack.push(num);
        }
        
        return;
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}
