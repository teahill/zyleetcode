package com.leetcode.zyang;

import java.util.HashMap;

/**
 * 
 * @author zyang
 * 
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Symbols are placed from left to right in order of value, starting with the largest. 
 * However, in a few specific cases,[2] to avoid four characters being repeated in succession 
 * (such as IIII or XXXX) these can be reduced using subtractive notation as follows:
 * 
 * the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
 * X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
 * C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern[5]
 * 
 * An example using the above rules would be 1904: this is composed of 1 (one thousand), 
 * 9 (nine hundreds), 0 (zero tens), and 4 (four units). 
 * To write the Roman numeral, each of the non-zero digits should be treated separately. 
 * Thus 1,000 = M, 900 = CM, and 4 = IV. Therefore, 1904 is MCMIV.
 * 
 */
public class L0012_IntegerToRoman {

	public L0012_IntegerToRoman() {
		// TODO Auto-generated constructor stub
	}

    public String intToRoman(int num) {        
	
	    String[][] table = new String[][] {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
	            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
	            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
	            {"", "M", "MM", "MMM"}
	           };
	    
	    int div = 10;
	    StringBuilder sb = new StringBuilder();
	    
	    for (int i = 0; i < 4; i++) {
	    	int index = num % div;
	    	sb.insert(0, table[i][index]);
	    	num /= 10;    	
	    }
	    
	    return sb.toString();
    }
    
    
    public String intToRoman1(int num) {        
    	HashMap<Integer, String> romanValueMap = new HashMap<Integer, String>();   	
    	romanValueMap.put(new Integer(1000), "M");
    	romanValueMap.put(new Integer(500), "D");
       	romanValueMap.put(new Integer(100), "C");
       	romanValueMap.put(new Integer(50), "L");
       	romanValueMap.put(new Integer(10), "X");
       	romanValueMap.put(new Integer(5), "V");
       	romanValueMap.put(new Integer(1), "I");
       	
       	StringBuilder sb = new StringBuilder();
       	int div = num / 1000;
       	
       	if ( div!= 0) {
       		for (int i = 0; i < div; i++)
       			sb = sb.append("M");
       	}
       	
       	num = num % 1000;
       	if (num >= 900) {
       		sb.append("CM");
       		num = num - 900;
       	}
       	else if (num >= 500) {
       		sb.append("D");
       		num = num - 500;
       	}

   		if (num >= 400) {
   			sb.append("CD");
   			num = num - 400;
   		}
   		else {
   			div = num / 100;
   			
   			for (int i = 0; i < div; i++) {
   				sb.append('C');
   				num = num - 100;
   			}
   		}
   		
   		if (num >= 90) {
   			sb.append("XC");
       		num = num - 90;
   		}
   		else if (num >= 50) {
   			sb.append("L");
       		num = num - 50;
   		}
   		
   		if (num >= 40) {
   			sb.append("XL");
       		num = num - 40;
   		} 
   		else {
   			div = num / 10;
   			
   			for (int i = 0; i < div; i++) {
   				sb.append("X");
   				num = num - 10;
   			}
   		}
   		
   		if (num >= 9) 
   			sb.append("IX");   		
   		else if (num >= 5) {
   			sb.append("V");
   			num = num - 5;
   		} 
   		
   		if (num >= 4)
   			sb.append("IV"); 
   		else {
   			for (int i = 0; i < num; i++) 
   				sb.append("I");
   		}
   		
   		return sb.toString();     	
    }
}
