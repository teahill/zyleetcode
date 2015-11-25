package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 * 
 * 
 */
public class L0029_DivideTwoIntegers {

	public L0029_DivideTwoIntegers() {
		// TODO Auto-generated constructor stub
	}
	
	
	// be very careful with int overflow. use long from get go
    public int divide(int dividend, int divisor) {
    	
    	// Overflow situations
        if (divisor == 0)
        	return Integer.MAX_VALUE;
        
        if (dividend == Integer.MIN_VALUE && divisor == -1)
        	return Integer.MAX_VALUE;
        
        int signDvd = (dividend > 0) ? 1 : -1;
        int signDvs = (divisor > 0) ? 1 : -1;        
        
        // use long 
        long dvd = signDvd * (long)dividend;
        long dvs = signDvs * (long)divisor;      
        int result = 0;
        while (dvd >= dvs) {
        	long sum = dvs;
        	int multiple = 1;
        	while (dvd >= sum + sum) {// sum<<1;
        		sum += sum; // sum << 1;
        		multiple += multiple; // multiple << 1;
        	}
        
        	result += multiple;
        	dvd = dvd - sum;
        }
        
        result = result * signDvd * signDvs;
        
        return result;
    }
}
