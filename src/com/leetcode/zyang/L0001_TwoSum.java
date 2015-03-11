package com.leetcode.zyang;

import java.util.HashMap;

/**
 * @author zyang
 * Given an array of integers, find two numbers such that they add up to a specific target number. 
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and 
 * index2) are not zero-based. You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 */
public class L0001_TwoSum {
	public int[] twoSum(int[] numbers, int target){
		int[] outNum = new int[2];
		
		outNum[0] = 0;
		outNum[1] = 0;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < numbers.length; i++) 
			map.put(numbers[i],  i+1);
			
		for (int j = 0; j < numbers.length; j++){
			int key = target - numbers[j];
			Integer index = map.get(key);
			if ( index != null && index.intValue() != j + 1) {
				if (index.intValue() < j + 1) {
					outNum[0] = index.intValue();
					outNum[1] = j + 1;
				}
				else {
					outNum[0] = j + 1;
					outNum[1] = index.intValue();
				}
				
			}
		}
			
		return outNum;
		
	}
}