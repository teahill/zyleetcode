package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 */
public class L0034_SearchForRange {

	public L0034_SearchForRange() {
		// TODO Auto-generated constructor stub
	}

    public int[] searchRange(int[] A, int target) {
    	int[] result= new int[2];
    	result[0] = -1;
    	result[1] = -1;
    	
        if (A.length == 0 || A[0] > target || A[A.length - 1] < target) 
        	return result;
        
        int low = 0;
        int high = A.length - 1;
        
        //Find left boundary
        while (low < high) {
        	int mid = (low + high) / 2;
        	if (A[mid] < target)
        		low = mid + 1;
        	else 
        		high = mid;
        }
        
        if (A[low] != target)
        	return result;
        else
        	result[0] = low;
        	
        
        //Find right boundery; no need to set the low to 0
        high = A.length - 1;
        while (low < high) {
        	int mid = (low + high + 1) / 2;
        	if (A[mid] > target)
        		high = mid - 1;
        	else 
        		low = mid;
        }
        result[1] = low;
        return result;
    }
	
    public int[] searchRange1(int[] A, int target) {
        if (A.length == 0 || A[0] > target || A[A.length - 1] < target)
        	return new int[] {-1, -1};
        
        
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
        	int mid = (low + high) / 2;
        	if (A[mid] < target)
        		low = mid + 1;
        	else if (A[mid] > target)
        		high = mid - 1;
        	else {
        		int begin = mid, end = mid;
        		while (begin > 0) {
        			if ( A[begin - 1] == target) 
        				begin--;
        			else
        				break;        				
        		}
        		
        		while (end < A.length - 1) {
        			if ( A[end + 1] == target) 
        				end++;
        			else
        				break;        				
        		}
        		
        		return new int[] {begin, end};        			
        	}        	
        }
        
        return new int[] {-1, -1};
    }
}
