package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * Given a sorted array, remove the duplicates in place such that each element appear only once 
 * and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * array, two pointers
 */

public class L0026_RemoveDupFromSortArray {

	public L0026_RemoveDupFromSortArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		L0026_RemoveDupFromSortArray removeDup = new L0026_RemoveDupFromSortArray();
		
		int[] in = {1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 20};
		
		System.out.println("input: " + in);
	
		int result = removeDup.removeDuplicates(in);		
		
		System.out.println("output: " + result);
	}

    public int removeDuplicates(int[] A) {
        int result = 0;
        
        if (A == null || A.length == 0)
        		return result;
        
        if (A.length == 1)
        	return 1;
        
        int ptr2 = 0;
        for (int ptr1 = 1; ptr1 < A.length; ptr1++) {
        	if (A[ptr1] != A[ptr2]) 
        		A[++ptr2] = A[ptr1];
        }
        
        result = ptr2 + 1;
        
        return result;
    }    
}
