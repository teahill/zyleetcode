package com.leetcode.zyang;

import java.util.HashMap;

/**
 * 
 * @author zyang
 *
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Math String
 *
 * any of the letters representing numbers in the Roman numerical system: 
 * I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000. 
 * In this system, a letter placed after another of greater value adds (thus XVI or xvi is 16), 
 * whereas a letter placed before another of greater value subtracts (thus XC or xc is 90).
 *
 * 1904 is MCMIV
 * 1954 as MCMLIV
 * 1990 as MCMXC
 * 2014 as MMXIV
 * 1 as I
 * 999 as IM
 * 2015 as MMXV
 * 3999 as MMMIM
 * 
 */
public class L0013_RomanToInteger {

	public L0013_RomanToInteger() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String x = "MCMIV";
		//String x = "MCMLIV";	
		//String x = "MCMXC";
		//String x = "MMXIV";
		//String x = "I";
		//String x = "IM";
		//String x = "MMXV";
		//String x = "MMMIM";
		String x = "MMAV";
		
		L0013_RomanToInteger romanToInteger = new L0013_RomanToInteger();
		
		int result = romanToInteger.romanToInt(x);
		
		System.out.println(x + " ->  " + result);
	}

    public int romanToInt(String s) {
    	int result = 0;
    	
    	if (s == null || s == "")
    		return result;    	   	
    	
    	HashMap<String, Integer> romanValueMap = new HashMap<String, Integer>();   	
    	romanValueMap.put("M", new Integer(1000));
    	romanValueMap.put("D", new Integer(500));
       	romanValueMap.put("C", new Integer(100));
       	romanValueMap.put("L", new Integer(50));
       	romanValueMap.put("X", new Integer(10));
       	romanValueMap.put("V", new Integer(5));
       	romanValueMap.put("I", new Integer(1));
       	
       	int prevValue = 0;
       	int value = 0;
       	Integer curValue = null;
       	for (int i = 0; i< s.length(); i++){
       		curValue = romanValueMap.get(String.valueOf(s.charAt(i)));
       		
       		if(curValue == null) {
       			result = 0;
       			break;
       		}
       		
       		value = curValue.intValue();
       		if (prevValue >= value)
       			result = result + value;
       		else
       			result = result + value - 2 * prevValue;
       		
       		prevValue = value;
      	}        
    	return result;
    }
}
