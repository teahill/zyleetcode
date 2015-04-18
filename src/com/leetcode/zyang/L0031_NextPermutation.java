package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * 
 */
public class L0031_NextPermutation {

	public L0031_NextPermutation() {
		// TODO Auto-generated constructor stub
	}

    public void nextPermutation(int[] num) {
        if (num.length == 0 || num.length == 1)
        	return;
        
        // Find turning point for numbers increasing backwards and decreasing
        int tp = num.length - 1;
        while (tp > 0 && num[tp] <= num[tp - 1]) 
        	tp--;
        
        // find the num that is bigger than at tp - 1
        if (tp != 0) {
            int sp = num.length - 1;
        	for (int i = tp + 1; i < num.length; i++) {
        		if (num[tp - 1] >= num[i]) {
        			sp = i - 1;
        			break;
        		}
        	}
        	
            // Swap num at postion tp-1, sp
        	swap(num, sp, tp - 1);
        }
        
        // Sort num from tp to num.length -1 by reversing/swapping
        for (int j = 0; j < (num.length - tp) / 2; j++) 
        	swap(num, num.length - 1 - j, tp + j);

        return;
    }
    
    public void swap(int[] num, int p1, int p2) {
        int tmp = num[p1];
        num[p1] = num[p2];
        num[p2] = tmp;
        
        return;
    }
}
