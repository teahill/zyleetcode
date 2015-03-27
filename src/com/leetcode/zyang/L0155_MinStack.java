package com.leetcode.zyang;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @author zyang
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * push(512),push(-1024),push(-1024),push(512),pop,getMin,pop,getMin,pop,getMin
 */
public class L0155_MinStack {

	public L0155_MinStack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0155_MinStack newStack = new L0155_MinStack();
		
		newStack.push(512);
		newStack.push(-1024);
		newStack.push(-1024);
		newStack.push(512);		
		System.out.println(newStack.toString());
		
		newStack.pop();
		int i1 = newStack.getMin();
		newStack.pop();
		int i2 = newStack.getMin();		
		newStack.pop();
		int i3 = newStack.getMin();		
		
		System.out.println("result = " + i1 + "," + i2 + "," + i3);
	}
	
	Deque<Integer> stack = new LinkedList<Integer>();
	Deque<Integer> minStack = new LinkedList<Integer>();
		
    public void push(int x) {
    	stack.push(x);
    	if (minStack.isEmpty() || minStack.peek() >= x)
    		minStack.push(x);        
    }

    public void pop() {
        Integer x = stack.pop();
                
        if (x != null && minStack.peek() != null && x.intValue() == minStack.peek().intValue())
        	minStack.pop();
        
    }

    public int top() {
        return stack.peek();   
    }

    public int getMin() {
       	return minStack.peek();
    }
    
    /**
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	
    	Integer x = minStack.getFirst();
    	while (x != null)
       		s.append(x); 	    	
    }
    */
}
