package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 
 * 
 */
public class L0096_UniqueBinarySearchTree {

	public L0096_UniqueBinarySearchTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;

		L0096_UniqueBinarySearchTree uniqueBST = new L0096_UniqueBinarySearchTree();
		
		int result = uniqueBST.numTreesDyn(n);
		
		System.out.println(n + " ->  " + result);
	}
	
	// Recursive
    public int numTrees(int n) {
    	int num = 0;
    	
    	if (n == 0 || n == 1)
    		return 1;
    	
    	for (int i = 1; i <= n; i++) 
    		num = num + numTrees(i - 1) * numTrees(n-i);
    	       	
    	return num;       
    }
    
    // Dynamic programming
    public int numTreesDyn(int n) {   	
    	if (n == 0 || n == 1)
    		return 1;
    	
    	int[] num = new int[n+1];
    	
    	num[0] = 1;
    	num[1] = 1; 	
    	
    	for (int i = 2; i <= n; i++) {
        	int tmp = 0;
    		for (int j = 1; j <= i/2; j++)  		
    			tmp = tmp + 2 * num[j - 1] * num[i - j];
    		
    		 if (i % 2 == 1)
    			 tmp = tmp + num[i/2] * num[i/2];
    		 
    		 num[i] = tmp;
    	}
    	
    	return num[n];       
    }
}
