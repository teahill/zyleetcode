package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class L0075_SortColor {

	public L0075_SortColor() {
		// TODO Auto-generated constructor stub
	}

	
    public void sortColors(int[] A) {
    	int n = A.length -1;
    	int low = 0;
    	int high = n;
    	int j = 0;
    	
    	while (j <= high) {
    		if (A[j] == 0) {
    			A[j] = A[low];
    			A[low] = 0;
    			low++;
    			j++;    			
    		}
    		else if (A[j] == 2) {
    			A[j] = A[high];
    			A[high] = 2;
    			high--;    			
    		}
    		else 
    			j++; 		    		
    	}    	       
    }
    
    public void sortColors1(int[] A) {
    	int[] count = new int[3];
    	
    	for (int i = 0; i < A.length; i++) 
    			count[A[i]]++;
    	
		int start = 0;
    	for (int i = 0; i < 3; i++) {
    		for (int j = start; j < start + count[i]; j++)
    			A[j] = i;
    		start = start + count[i];
    	}        
    }
}
