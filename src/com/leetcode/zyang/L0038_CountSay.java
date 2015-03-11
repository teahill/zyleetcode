package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * 
 * Show Tags String
 * 
 */
public class L0038_CountSay {

	public L0038_CountSay() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 1;
		
		//int x = 2222222;

		L0038_CountSay countSay = new L0038_CountSay();
		
		String result = countSay.countAndSay(x);
		
		System.out.println(x + " ->  " + result);
	}

    public String countAndSay(int n) {
        String result = "";
        
        String in = "1";
        String out = in;
        
        if (n == 0)
        	return result;
        
        for (int i = 0; i < n -1; i++) {
        	out = count(out);
        }
        
        return out;
    }
    
    public String count(String in) {   
    	StringBuilder out = new StringBuilder();
     	char ch = in.charAt(0);
     	char c;
    	int count = 1;
    	
    	if (in == null || in.length() == 0)
    		return out.toString();
    	
    	if (in.length() == 1) {
    		out.append('1');
    		out.append(ch);
    		return out.toString(); 
    	}
    	
    	for (int i = 1; i < in.length(); i++) {
    		if (in.charAt(i) != ch) {
    			c = Character.forDigit(count, 10);
    			out.append(c);
    			out.append(ch);
    			ch = in.charAt(i);
    			count = 1;    			
    		}
    		else 
    			count++;
    	}
    	
    	if (out.length() == 0 || out.charAt(out.length()-1) != ch) {
    		c = Character.forDigit(count, 10);
    		out.append(c);
			out.append(ch);
    	}
    	
    	return out.toString();
    }
}
