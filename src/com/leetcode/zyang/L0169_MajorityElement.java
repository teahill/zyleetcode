package com.leetcode.zyang;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * @author zyang
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * 
 */
public class L0169_MajorityElement {

	public L0169_MajorityElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		L0169_MajorityElement majorElement = new L0169_MajorityElement();
		
		int[] x = {1, 2, 2, 2, 3, 3, 4, 2, 2};
		
		int result = majorElement.majorityElement(x);
		
		System.out.println("input = " + Util.printArray(x) + ", output = " + result);
	}

    public int majorityElement2(int[] num) {
    	Arrays.sort(num);
    	
    	return num[num.length/2];
    
    }
    
    public int majorityElement1(int[] num) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
        for (int i = 0; i < num.length; i++) {
        	Integer key = Integer.valueOf(num[i]);
        	Integer value = map.get(key);
        	if (value != null) {
        		if (value.intValue() + 1 > num.length / 2)
        			return num[i];
        		map.put(key, value.intValue() + 1);       		
        	}
        	else {
        		map.put(key, 1);    
        		if (num.length == 1)
        			return num[i];
        	}
        }        
        return 0;        
    }
    
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
}
