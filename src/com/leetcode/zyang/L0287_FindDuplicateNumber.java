package com.leetcode.zyang;

/**
 * @author zyang
 * 
 *         Given an array nums containing n + 1 integers where each integer is
 *         between 1 and n (inclusive), prove that at least one duplicate number
 *         must exist. Assume that there is only one duplicate number, find the
 *         duplicate one.
 * 
 *         Note: You must not modify the array (assume the array is read only).
 *         You must use only constant, O(1) extra space. Your runtime complexity
 *         should be less than O(n2). There is only one duplicate number in the
 *         array, but it could be repeated more than once.
 */
public class L0287_FindDuplicateNumber {

	public L0287_FindDuplicateNumber() {
		// TODO Auto-generated constructor stub
	}

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
        	return -1;
        
        int n = nums.length -  1;
        int start = 1, end = n;
        while (start < end) {
        	int mid = start + (end - start) / 2;
        	int count = 0; // count number  that is 1 to mid
        	for (int i = 0; i <= n; i++) {
        		if (nums[i] <= mid && nums[i] >= start)
        			count++;
        	}
        	
        	// There is duplication 
        	if (count > mid - start + 1)
        		end = mid;
        	else
        		start = mid + 1;
        }
        
        return start;
    }
    
    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        int slow = n;
        int fast = n;
        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow != fast);
        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }
}
