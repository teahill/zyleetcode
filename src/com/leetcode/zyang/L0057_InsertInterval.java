package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 */
public class L0057_InsertInterval {

	public L0057_InsertInterval() {
		// TODO Auto-generated constructor stub
	}

	// Leetcode solution
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	if (newInterval == null)
    		return intervals;
    	
    	List<Interval> list = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
        	list.add(newInterval);
        	return list;
        }
        
        for (Interval inv : intervals) {
        	if (newInterval == null || newInterval.start > inv.end)
        		list.add(inv);
        	else if (newInterval.end < inv.start) {
        		list.add(newInterval);
        		list.add(inv);
        		newInterval = null;
        	}
        	else {
        		newInterval.start = Math.min(newInterval.start, inv.start);
        		newInterval.end = Math.max(newInterval.end, inv.end);
        	}
        }
        
    	if (newInterval != null)
    		list.add(newInterval);
        
        return list;
    }
    
    // Works, but too complicated
    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
    	if (newInterval == null)
    		return intervals;
    	
    	List<Interval> list = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
        	list.add(newInterval);
        	return list;
        }

        boolean doneStart = false;
        boolean doneEnd = false;     
        int start = newInterval.start;
        for (Interval inv : intervals) {
        	if (doneStart && doneEnd)
        		list.add(inv);        	
        	else if (!doneStart ) {
        		// No insert yet
        		if (inv.end < newInterval.start) {
        			list.add(inv);
        			continue;
        		}
	        	
        		//Identity start point
        		if (inv.start <= newInterval.start && newInterval.start <= inv.end) 
	        		start = inv.start;
	        	else if (newInterval.start < inv.start) 
	        		start = newInterval.start;	        		
        		doneStart = true;
        		
        		// Check if the end is also in this interval or right before the interval
        		if (newInterval.end > inv.end)
        			continue;
        		else if (newInterval.end < inv.start) {
        			list.add(new Interval(start, newInterval.end));
        			list.add(inv);
        		}
        		else 
        			list.add(new Interval(start, inv.end));
        		doneEnd = true;
        	}
        	else if (doneStart) {
        		if (newInterval.end > inv.end)
        			continue;
        		else if (newInterval.end < inv.start) {
        			// complete the start, end node
        			list.add(new Interval(start, newInterval.end));
        			// put the current node as well
        			list.add(inv);
        		}
        		else 
        			list.add(new Interval(start, inv.end));
        		doneEnd = true;        		
        	}
        }
        
        if (!doneStart && !doneEnd)
        	list.add(newInterval);
        
        if (doneStart && !doneEnd)
        	list.add(new Interval(start, newInterval.end));
        
        return list;
    }
}
