package com.leetcode.zyang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 
 * 
 */
public class L0016_3Sum_Closest {

	public L0016_3Sum_Closest() {
		// TODO Auto-generated constructor stub
	}

	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		
		int result = num[0] + num[1] + num[num.length - 1];
		for (int i = 0; i < num.length - 2; i ++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			
			int low = i + 1;
			int high = num.length - 1;
			while (low < high) {
				int sum = num[i] + num[low] + num[high];
				if (target == sum) 	
					return sum;
				
				if (Math.abs(target - sum) < Math.abs(target - result)) 
					result = sum;	
				
				if (target > sum)
					low++;
				else 
					high--;	
			}
		}
			
		return result;
	}
}
