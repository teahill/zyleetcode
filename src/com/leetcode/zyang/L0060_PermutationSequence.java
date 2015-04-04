package com.leetcode.zyang;

import java.util.LinkedList;

/**
 * 
 * @author zyang
 * 
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class L0060_PermutationSequence {

	public L0060_PermutationSequence() {
		// TODO Auto-generated constructor stub
	}
	
    public String getPermutation(int n, int k) {
    	if (n == 0 || k == 0)
    		return "";
    	
    	int[] factorial = factorial(n);
    	
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        for (int i = 0; i < n; i++) 
        	list.add(i + 1);        	
        
        int remainder = k - 1;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	int pos = remainder / factorial[n-1-i];
        	sb.append(list.get(pos));
        	remainder = remainder % factorial[n-1-i];
        	list.remove(pos);
        }
        
        return sb.toString();        
    }
    
    int[] factorial(int n) {    	
    	int[] factorial = new int[n + 1];     	
      	factorial[0] = 1;
      	
       	if (n == 0)
    		return factorial;
    	
    	for (int i = 1; i < n + 1; i++) 
    		factorial[i] = factorial[i - 1] * i; 
    	
    	return factorial;
    }  
}
