package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 *Implement atoi to convert a string to an integer.
 *Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below 
 *and ask yourself what are the possible input cases.
 *Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 *You are responsible to gather all the input requirements up front.
 *Update (2015-02-10):The signature of the C++ function had been updated. 
 *If you still see your function signature accepts a const char * argument, please click the reload button  
 *to reset your code definition.
 */
public class L0008_StringToInteger {
	
	public static void main(String[] args) {

		//String x = "+-1";
		//String x = "   -2147483648XX";		
		//String x = "   2147483648";
		
		String x = "9223372036854775809";

		L0008_StringToInteger strToInt = new L0008_StringToInteger();
		
		int result = strToInt.atoi(x);
		
		System.out.println(x + " ->  " + result);
	}
	
	
	
	L0008_StringToInteger() {
		
	}
	
	
	public int atoi(String str) {
		int intResult = 0;	    
		long result = 0;
				
		if ((str == null) || (str == ""))
			return intResult;
		
		int sign = 1;	
		boolean start = false;	
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
		
			if (!start && (ch == ' '))
				continue;
				
			else if ( !start && (ch == '-')){
				sign = -1;
			}
			else if (!start && (ch == '+')){
			}
			else if (Character.isDigit(ch)) {
				result = result * 10 + Integer.parseInt(String.valueOf(ch));
				
				if (result - 1 > Integer.MAX_VALUE) 
					break;
			} 
			else {
				break;
				//return intResult;
			}		
			
			if (!start)
				start = true;
		}
		
		result = result * sign;
		
		if (result > Integer.MAX_VALUE) 
			intResult = Integer.MAX_VALUE;
		else if (result < Integer.MIN_VALUE)
			intResult = Integer.MIN_VALUE;
		else		
			intResult = (int)result;
		
		return intResult;
	}
}
