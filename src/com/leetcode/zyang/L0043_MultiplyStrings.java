package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 */
public class L0043_MultiplyStrings {

	public L0043_MultiplyStrings() {
		// TODO Auto-generated constructor stub
	}

    public String multiply(String num1, String num2) {
    	if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
    		return null;
    	   	
    	if (num1.equals("0") || num2.equals("0"))
    		return "0";    	
    		
    	int len1 = num1.length();
    	int len2 = num2.length();
    	String[] list = new String[len2];
    	
    	for (int i = len2 - 1; i >= 0; i--) 
    		list[i] = multiply(num1, num2.charAt(i), len2 - 1 - i);
    	
    	
		StringBuilder sb = new StringBuilder();
		int carryOver = 0;
		boolean end = true;
    	for (int i = 0; i < len1 + len2; i++) {

    		int sum = carryOver;
    		for (int j = 0; j < len2; j++) {
    			if (i < list[j].length()) {
    				sum = sum + list[j].charAt(list[j].length() -1 - i) - '0';  
    				end = false;
    			}
    		}
    		
    		if (end) 
    			break;
    			
    		sb.insert(0, sum % 10); 
    		carryOver = sum / 10;
    		end = true;
    	}
    	
    	if (carryOver != 0)
    		sb.insert(0, carryOver);
    	
    	StringBuffer sb1 = new StringBuffer();
    	boolean start = false;
    	for (int i = 0; i < sb.length(); i++) {
    		if (sb.charAt(i) != '0') 
    			start = true;
    		
    		if (start)
    			sb1.append(sb.charAt(i));
    	}
    	
    	return sb1.toString();
    }
    
    public String multiply(String num, char ch, int pos) {
    	StringBuilder sb = new StringBuilder();
    	   		
    	while (pos > 0) {
    		sb.insert(0, '0');
    		pos--;
    	}
    		
    	int carryOver = 0;
    	for (int i = num.length() - 1; i >= 0; i--) {
    		int n1 = num.charAt(i) - '0';
    		int n2 = ch - '0';
    		
    		int n3 = (n1 * n2 + carryOver) % 10;
    		carryOver = (n1 * n2 + carryOver) / 10;    
    		
    		sb.insert(0, n3);    		
    	}
    	
    	if (carryOver != 0)
    		sb.insert(0, carryOver);
    		
    	return sb.toString();
    }
}
