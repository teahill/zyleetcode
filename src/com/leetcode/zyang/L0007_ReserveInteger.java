package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 */
public class L0007_ReserveInteger {

	public static void main(String[] args) {

		//int x = -123;
		int x = 2147483646;

		L0007_ReserveInteger reverseInteger = new L0007_ReserveInteger();
		
		int result = reverseInteger.reverse1(x);
		
		System.out.println(x + " ->  " + result);
	}
	
	
	
	L0007_ReserveInteger() {
		
	}
	//243ms
	public int reverse(int x) {
	    
		int sign = ( x > 0 ) ? 1 : -1;
		int y = sign * x;
			
		long result = 0;
		
		while ( y > 0 ) {
			result = result * 10 + y % 10;
			y = y / 10;
		}
		
		if (result > Integer.MAX_VALUE)
			result = 0;
		
		int intResult = (int) result * sign;
		
		return intResult;	
	}
	
	//264ms
	public int reverse1(int x) {
	    
		int sign = ( x > 0 ) ? 1 : -1;
		x = sign * x;
			
		StringBuilder s = new StringBuilder();
		
		while ( x > 0 ) {
			s.append(x % 10);
			x = x / 10;
		}
		
		int result = 0;
		try {
			result = Integer.parseInt(s.toString());
		} catch (NumberFormatException e) {
		}
		
		result = sign * result;
		
		return result;
		
	}
}
