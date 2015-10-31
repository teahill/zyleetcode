package com.leetcode.zyang;

/**
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 231 - 1.
 * 
 * For example, 123 -> "One Hundred Twenty Three" 12345 ->
 * "Twelve Thousand Three Hundred Forty Five" 1234567 ->
 * "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class L0273_IntegerToEnglishWords {

	public L0273_IntegerToEnglishWords() {
		// TODO Auto-generated constructor stub
	}

    String[] singles = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[]{"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = new String[] {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
    	if (num == 0)
    		return "Zero";
        
        String words = "";
        int count = 0;
        while (num > 0) {
        	if (num % 1000 != 0) {       	
	        	words = thousands[count] + " " + words;
	        	words = numberToWordsUnderThousand(num % 1000) + " " + words;        	   		
        	}	
        	
        	words.trim();
        	
        	num = num / 1000;  
        	count++;
        }
        
        return words.trim();
    }
    
    public String numberToWordsUnderThousand(int num) {
    	String words = "";
    	
    	if (num / 100 > 0)
    		words = singles[num/100] + " " + "Hundred" + " ";
    	
    	num = num % 100;
    	if (num < 10)
    		words = words + singles[num];    	
    	else if (num > 9 && num < 20)
    		words = words + teens[num - 10];    	
    	else
    		words = words + tens[num/10 - 1] + " " + singles[num % 10];
    	
    	return words.trim();
    }
}
