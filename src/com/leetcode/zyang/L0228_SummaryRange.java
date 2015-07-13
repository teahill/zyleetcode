package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 */
public class L0228_SummaryRange {

	public L0228_SummaryRange() {
		// TODO Auto-generated constructor stub
	}

    public List<String> summaryRanges(int[] nums) {
    	List<String> list = new ArrayList<String>();
    	
        if (nums == null || nums.length == 0)
        	return list;
        
        int len = nums.length;
        StringBuilder sb = new StringBuilder();    
        for (int i = 0; i < len; i++) {         	
        	if (sb.length() == 0) {
        		sb.append(nums[i]);        		
        		if ((i == len -1) || (nums[i+1] != 1 + nums[i])) {
	        		list.add(sb.toString());
	        		sb.delete(0, sb.length());
	        	}  
        	}
        	else {
	        	if ((i == len -1) || (nums[i+1] != 1 + nums[i])) {
	        		sb.append("->");
	        		sb.append(nums[i]);
	        		list.add(sb.toString());
	        		sb.delete(0, sb.length());
	        	}  
        	}

        }
		
		return list;
    }
}
