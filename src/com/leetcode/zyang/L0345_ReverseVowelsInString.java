package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Write a function that takes a string as input and reverse only the
 *         vowels of a string.
 * 
 *         Example 1: Given s = "hello", return "holle".
 * 
 *         Example 2: Given s = "leetcode", return "leotcede".
 * 
 *         Note: The vowels does not include the letter "y".
 */
public class L0345_ReverseVowelsInString {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0)
        	return s;
        
        StringBuilder sb = new StringBuilder(s);
        int start = 0;
        int end = sb.length() -1;
        
        while (start < end) {
        	while (start < end && !isVowel(sb.charAt(start)))
        		start++;
        	while (start < end && !isVowel(sb.charAt(end)))
        		end--;
        	
        	if (start >= end)
        		break;
        	
        	char tmp = sb.charAt(start);
        	sb.setCharAt(start, sb.charAt(end));
        	sb.setCharAt(end, tmp);     
        	start++;
        	end--;
        }
        
        return sb.toString();
    }
    
    private boolean isVowel(char c) {
    	return (c == 'a' || c == 'o' || c == 'i' || c == 'u' || c == 'e'
    			|| c == 'A' || c == 'O' || c == 'E' || c == 'U' || c == 'I');
    }
}
