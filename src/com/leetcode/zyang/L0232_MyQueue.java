package com.leetcode.zyang;

import java.util.Stack;

public class L0232_MyQueue {
	Stack<Integer> input;
	Stack<Integer> output;
	
	public L0232_MyQueue() {
		// TODO Auto-generated constructor stub
		input = new Stack<Integer>();
		output = new Stack<Integer>();
	}
	
    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
                
        return;
    }

    // Removes the element from in front of queue.
    public void pop() {
    	peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
    	if (output.empty()) {
            while (!input.empty()) {
            	int num = input.peek();
            	input.pop();
            	output.push(num);
            }
    	}
    	
    	return output.peek();     
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.empty() && output.empty();
    }
}
