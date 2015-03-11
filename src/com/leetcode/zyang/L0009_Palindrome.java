package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * A palindromic number or numeral palindrome is a number that remains the same 
 * when its digits are reversed. Like 16461, for example, it is "symmetrical".
 * 
 */
public class L0009_Palindrome {

	public L0009_Palindrome() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int x = 1001;
		int x = 10;
		
		//int x = 2222222;

		L0009_Palindrome palindrome = new L0009_Palindrome();
		
		boolean result = palindrome.isPalindrome(x);
		
		System.out.println(x + " ->  " + result);
	}
	
    public boolean isPalindrome(int x) { 
        	if (x < 0) 
    		return false;
       	
    	if ( x < 10) 
    		return true;
    	
    	int n = 1, multiplier = 1;   	
    	int remainInt = x; 
    	
    	while (remainInt >= 10){
    		remainInt = remainInt / 10;
    		n++;
    		multiplier = multiplier * 10;
    	}
    	
    	
	  	int lastDigit, firstDigit;
    	for (int i = 0; i < n/2; i++ ) {
		  	lastDigit = x % 10;
		  	firstDigit = x / multiplier;
		  	
		  	if (lastDigit != firstDigit)
		  		return false;		  	
  
		  	x = x % multiplier / 10;
		  	multiplier = multiplier / 100;	
    	}
   	
    	return true;   		    
    }
    
    public boolean isPalindrome3(int x) {
    	boolean isPalin = true;  
 
       	if (x < 0) {
    		isPalin = false;
    		return isPalin;
       	}
       	
    	if ( x < 10) 
    		return isPalin;
    	
    	int remainInt = x; 
    	while (remainInt >= 10) {
    		
    	  	int lastDigit, firstDigit, y;
    	  	
    		//set last digit
    		lastDigit = remainInt % 10;
    		
    		//strip last digit
    		y = remainInt / 10;
    		
    		// find first digit while rebuilding remaining integer after stripping first digit
    		remainInt = 0;
    		int n = 1;
    		while ( y >= 10) {
    			remainInt = (int) ((y % 10) * n + remainInt);
    			y = y / 10;
    			n = n* 10;
    		}
    		
    		firstDigit = y;
    		if (firstDigit != lastDigit) {
        		isPalin = false;
    			break;	
    		}

    	}
    	
    	return isPalin;   		
    }
    
    public boolean isPalindrome2(int x) {
    	boolean isPalin = false;  	
    	long reverseLong = 0;
    	long inLong = (long) x;
 
    	if (x < 0)
    		return isPalin;
    	
    	while (x > 0) {
    		reverseLong = reverseLong * 10 + x % 10;
    		x = x / 10;
     	}
    	
    	if (reverseLong == inLong )
    	    isPalin = true;
    	
    	return isPalin; 
    		
    }
	
    public boolean isPalindrome1(int x) {
    	boolean isPalin = true;
    	
    	StringBuilder s = new StringBuilder();
    	s.append(x);
    	
    	for (int i = 0; i < s.length()/2; i++) {
    		if (s.charAt(i) !=  s.charAt(s.length()-1-i)){
    			isPalin = false;
    			break;
    		}   			
    	}
    	
    	return isPalin;        
    }
}
