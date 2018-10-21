package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 */
public class L0229_MajorityElementII {

	public L0229_MajorityElementII() {
		// TODO Auto-generated constructor stub
	}

    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> list = new ArrayList<Integer>();
    	
        if (nums == null || nums.length == 0)
        	return list;
        
        int num1 = 0, num2 = 1;
        int count1 = 0, count2 = 0;        
        int n = nums.length;
        int min = n/3;      
        for (int i = 0; i < n; i++) {
        	if (nums[i] == num1)
        		count1++;
        	else if (nums[i] == num2)
        		count2++;
        	else if (count1 == 0) {
        		num1 = nums[i];
        		count1++;
        	}
        	else if (count2 == 0) {
        		num2 = nums[i];
        		count2++;
        	}
        	else {
        		count1--;
        		count2--;
        	}
        }
        
        count1 = 0; count2 = 0;
        for (int i = 0; i < n; i++) {
        	if (nums[i] == num1)
        		count1++;
        	
        	if (nums[i] == num2)
        		count2++;
        }
        
        if (count1 > min)
        	list.add(num1);
        
        if (count2 > min)
        	list.add(num2);
        
        return list;
    }
    
	//O(n lg n)
    public List<Integer> majorityElement1(int[] nums) {
    	List<Integer> list = new ArrayList<Integer>();
    	
        if (nums == null || nums.length == 0)
        	return list;
        
        Arrays.sort(nums);
        
        int n = nums.length;
        int min = n/3;
        int count = 1;       
        for (int i = 1; i < n; i++) {
        	if (nums[i] == nums[i - 1])
        		count++;
        	else {
        		if (count > min) 
        			list.add(nums[i - 1]);
        			
        		count = 1;
        	}        	
        }
        
        if (count > min)
        	list.add(nums[n - 1]);
        
        return list;
    }
}
