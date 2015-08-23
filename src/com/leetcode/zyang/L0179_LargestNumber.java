package com.leetcode.zyang;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author zyang
 * 
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 */
public class L0179_LargestNumber {

	public L0179_LargestNumber() {
		// TODO Auto-generated constructor stub
	}

	// Use a new comparator to sort the numbers
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
        	return "";
        
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) 
        	array[i] = String.valueOf(nums[i]);
        
        Comparator<String> comp = new Comparator<String>() {
        	public int compare(String s1, String s2) {
        		return (s2 + s1).compareTo(s1 + s2);
        	}
        };
        
        Arrays.sort(array, comp);
        if (array[0].charAt(0) == '0')
        	return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++)
        	sb.append(array[i]);
        
        return sb.toString();        
    }    
}
