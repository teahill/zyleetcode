package com.leetcode.zyang;

import java.util.Iterator;

/**
 * 
 * @author zyang
 * 
 * Leetcode 284
 * 
 *         Given an Iterator class interface with methods: next() and hasNext(),
 *         design and implement a PeekingIterator that support the peek()
 *         operation -- it essentially peek() at the element that will be
 *         returned by the next call to next().
 * 
 *         Here is an example. Assume that the iterator is initialized to the
 *         beginning of the list: [1, 2, 3].
 * 
 *         Call next() gets you 1, the first element in the list.
 * 
 *         Now you call peek() and it returns 2, the next element. Calling
 *         next() after that still return 2.
 * 
 *         You call next() the final time and it returns 3, the last element.
 *         Calling hasNext() after that should return false.
 */
//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

	private Iterator<Integer> iter;
	private Integer next;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
		if (iter.hasNext())
			next = iter.next();
		else 
			next = null;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
		Integer result = next;
		if (iter.hasNext())
			next = iter.next();
		else 
			next = null;

		return result;
	}

	public boolean hasNext() {
	    return (next == null) ? false : true;
	}
}
