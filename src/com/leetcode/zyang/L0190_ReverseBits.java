package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * 
 * Related problem: Reverse Integer
 * 
 * 
 */
public class L0190_ReverseBits {

	public L0190_ReverseBits() {
		// TODO Auto-generated constructor stub
	}


    public int reverseBits3(int n) {
        long sum=0;
        for(int i=0;i<32;i++){
           sum+=Math.pow(2,31-i)*(n&1);
            n=n>>1;
        }
       return (int)sum;
    }
    
    public int reverseBits1(int n) {
    	String s = Integer.toUnsignedString(n, 2);
    	
    	long result  = 0;
    	long multiplier = 1;
    	for (int i = 0; i < 32 - s.length(); i++)
    		multiplier *= 2;
    	
    	for (int i = 0; i < s.length(); i++) {   		
    		result = result + Character.digit(s.charAt(i), 2) * multiplier;
    		multiplier *= 2;
    	}
    	
    	System.out.println("output = " + result);	
    	return (int)result;        
    }
    
    //This one does not work
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	String s = Integer.toUnsignedString(n, 2);
    	StringBuilder sb = new StringBuilder(s);
    	
    	for (int i = 0; i < 32 - s.length(); i++)
    		sb.insert(0, '0');
    	
    	String rs = reverseString(sb.toString());
    	
    	long result = (long) Integer.parseUnsignedInt(rs, 2);
    	
    	System.out.println("output = " + result);	
    	return (int)result;        
    }
    
    public String reverseString(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	
    	for (int i = 0; i < sb.length()/2; i++) {
    		char ch = sb.charAt(i);
    		sb.setCharAt(i, sb.charAt(sb.length() - 1 - i));
    		sb.setCharAt(sb.length() - 1 - i, ch);    		
    	}
    	
    	return sb.toString();        
    }
}
