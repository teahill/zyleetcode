package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *  Math String
 *  
 *  Note: 
 *  reset carry every loop, so no reuse from 2 loops before
 *  use %, /
 */
public class L0067_AddBinary {

	public L0067_AddBinary() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String x = "11";
		//String y = "1";
		
		//String x = "1";
		//String y = "1";
		
		String x = "1010";
		String y = "1011";
		
		L0067_AddBinary binary = new L0067_AddBinary();
		
		String result = binary.addBinary(x, y);
		
		System.out.println(x + "," + y + " ->  " + result);
	}

    public String addBinary(String a, String b) {
    	StringBuilder result = new StringBuilder();
    	
    	if (a == null)
    		return b;
    	if (b == null)
    		return a;
    	    	
    	int ptra = a.length() - 1;
    	int ptrb = b.length() - 1;   
    	int total = 0;
    	int carry = 0;
    	int digit = 0;
    	
    	while (ptra >= 0 || ptrb >= 0) {
    		if (ptra >= 0) {
    			digit = a.charAt(ptra) == '1' ? 1 : 0;
    			total = total + digit;
    			ptra--;
    		}
    		
    		if (ptrb >= 0) {
    			digit = b.charAt(ptrb) == '1' ? 1 : 0;
    			total = total + digit;
    			ptrb--;
    		}
    		
    		total = total + carry;
		
    		result.insert(0, total % 2);
    		
    		if (total / 2 == 1)
    			carry = 1;
    		else 
    			carry = 0;
    		
    		total = 0;
    	}
    	
    	if (carry == 1)
    		result.insert(0, carry);
    	 
    	return result.toString();
        
    }
}
