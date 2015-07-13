package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Description:
 * 
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Let's start with a isPrime function. To determine if a number is prime, we need to check 
 * if it is not divisible by any number less than n. The runtime complexity of isPrime function 
 * would be O(n) and hence counting the total prime numbers up to n would be O(n2). Could we do better?
 * 
 * As we know the number must not be divisible by any number > n / 2, we can immediately cut the total iterations 
 * half by dividing only up to n / 2. Could we still do better?
 * 
 * 
 */
public class L0204_CountPrime {

	public L0204_CountPrime() {
		// TODO Auto-generated constructor stub
	}

	
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) 
        	isPrime[i] = true;
        
        for (int i = 2; i * i < n; i++) {
        	if (!isPrime[i])
        		continue;
        	
        	for (int j = i * i; j < n; j = j + i) {
        		isPrime[j] = false;
        	}        		
        }
        
        for (int i = 2; i < n; i++) { 
        	if (isPrime[i])
        		count++;
        }
        
        return count;
    }	
	
	// TLE
    public int countPrimes1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
        	if (isPrime(i))
        		count++;
        }
        
        return count;
    }
    
    private boolean isPrime(int n) {   	
    	for (int i = 2; i * i <= n; i++) {
    		if (n % i == 0)
    			return false;
    	}
    	
    	return true;
    }
}
