package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 */
public class L0035_SearchInsertPosition {

	public L0035_SearchInsertPosition() {
		// TODO Auto-generated constructor stub
	}

    public int searchInsert(int[] A, int target) {
        if (A.length == 0 || A[0] > target)
        	return 0;
        
        if (A[A.length - 1] < target)
        	return A.length;
        
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
        	int mid = (low + high) / 2;
        	if (A[mid] < target)
        		low = mid + 1;
        	else if (A[mid] > target)
        		high = mid - 1;
        	else 
        		return mid;        			        	
        }

        return low;
    }
    
    public int searchInsert1(int[] A, int target) {
        if (A.length == 0 || A[0] > target)
        	return 0;
        
        if (A[A.length - 1] < target)
        	return A.length;
        
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
        	int mid = (low + high) / 2;
        	if (A[mid] < target)
        		low = mid + 1;
        	else if (A[mid] > target)
        		high = mid - 1;
        	else 
        		return mid;        			        	
        }
        
        if (A[low] < target)
        	return low + 1;
        else
        	return low;
    }    
}
