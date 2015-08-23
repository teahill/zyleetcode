package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 */
public class L0056_MergeIntervals {

	public L0056_MergeIntervals() {
		// TODO Auto-generated constructor stub
	}

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1)
        	return intervals;
        /**
        Comparator<Interval> comp = new Comparator<Interval>() {
        	//@Override
        	public int compare(Interval i1, Interval i2) {
        		return i1.start - i2.start;
        	}        			
        };
        */
        
        Collections.sort(intervals, new Comparator<Interval>() {
        	public int compare(Interval i1, Interval i2) {
        		return i1.start - i2.start;
        	}        			
        });
        
        List<Interval> list = new ArrayList<Interval>();
        Interval cur = intervals.get(0);
        for (Interval interval : intervals) {
        	if (cur.end >= interval.start) 
        		cur.end = Math.max(cur.end, interval.end);
        	else {
        		list.add(cur);
        		cur = interval;
        	}
        }
        
        // add last set
		list.add(cur);
		
		return list;
    }
}
