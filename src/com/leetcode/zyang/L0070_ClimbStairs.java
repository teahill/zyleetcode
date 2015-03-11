package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * You are climbing a stair case. It takes n steps to reach to the top. 
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * 
 *  Dynamic Programming
 */
public class L0070_ClimbStairs {

	public L0070_ClimbStairs() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		
		//int n = 10;

		L0070_ClimbStairs climbStairs = new L0070_ClimbStairs();
		
		int result = climbStairs.climbStairs(n);
		
		System.out.println(n + " ->  " + result);
	}
	
    public int climbStairs(int n) {
    	if (n == 0)
    		return 0;
    	
    	if (n == 1)
    		return 1;
    	
    	if (n == 2)
    		return 2;

    	int tmp = 0;
    	int count1 = 1;
    	int count2 = 2;
    	
    	for (int i = 3; i < n + 1; i++ ) {
    		tmp = count2;
    		count2 = count1 + count2;  
    		count1 = tmp;
    	}
    	
    	return count2;          
    }

    public int climbStairs1(int n) {
    	if (n == 0)
    		return 0;
    	
    	if (n == 1)
    		return 1;
    	
    	if (n == 2)
    		return 2;

    	int[] count = new int[n+1];
    	count[0] = 0;
    	count[1] = 1;
    	count[2] = 2;
    	
    	for (int i = 3; i < n + 1; i++ ) {   	   		
    		count[i] = count[i-1] + count[i-2];   		
    	}
    	
    	return count[n];          
    }
    
    public int climbStairs2(int n) {
    	if (n == 0)
    		return 0;
    	
    	if (n == 1)
    		return 1;
    	
    	if (n == 2)
    		return 2;
    	
    	int count = 0;
    	if (n > 2) {
    		count = climbStairs(n-1) + climbStairs(n-2);   		
    	}
    	
    	return count;          
    }
}
