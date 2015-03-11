package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * Note: You may assume that A has enough space (size that is greater or equal to m + n) 
 * to hold additional elements from B. The number of elements initialized 
 * in A and B are m and n respectively.
 * 
 */

public class L0088_MergeSortedArray {

	public L0088_MergeSortedArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0088_MergeSortedArray mergeList = new L0088_MergeSortedArray();
		
		int[] l1 = {1, 3,  20, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] l2 = {2, 6, 8, 23};
		int m = 3;
		int n = 4;
		
		//int[] l1 = new int[4];		
		//int[] l2 = {1};
		//int m = 0;
		//int n = 1;
		
		System.out.println("input: l1 = " + Util.printArray(l1) + " l2 = " + Util.printArray(l2));
	
		mergeList.merge(l1, m, l2, n);		
		
		System.out.println("output: " + Util.printArray(l1));
	}

    public void merge(int A[], int m, int B[], int n) {
    	if ( n == 0)
    		return; 
    		
    	int ptr1 = m -1;
    	int ptr2 = n - 1;
    	
    	for (int i = m+n-1; i > -1; i--) {
    		if (ptr1 < 0 && ptr2 < 0) 
    			return;
    		else if (ptr1 >= 0 && ptr2 >=0) {
	    		if (A[ptr1] >= B[ptr2]) {
	    			A[i] =  A[ptr1];
	    			ptr1--;
	    		}
	    		else {
	        		A[i] =  B[ptr2];
	        		ptr2--;
	    		}
    		}
     		else if (ptr1 >= 0 && ptr2 < 0) {
    			A[i] =  A[ptr1];
    			ptr1--;
    		}
    		else {
        		A[i] =  B[ptr2];
        		ptr2--;
    		}
    	}
    }
}
