package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums 
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class L0080_RemoveDupSortedArrayII {

	public L0080_RemoveDupSortedArrayII() {
		// TODO Auto-generated constructor stub
	}

    public int removeDuplicates(int[] nums) {
        if (nums == null)
        	return 0;
        
        int n = nums.length;
        if (n == 0 || n == 1)
        	return n;
        
        int dupCount = 1;
        int ptr2 = 0;
        for (int ptr1 = 1; ptr1 < n; ptr1++) {
        	if (nums[ptr1] != nums[ptr2]) {
        		nums[++ptr2] = nums[ptr1];
        		dupCount = 1;
        	}
        	else {
        		if( dupCount < 2) {
        			nums[++ptr2] = nums[ptr1];
        			dupCount++;
        		}
        	}
        }
        
        return ptr2 + 1;
    }    
}
