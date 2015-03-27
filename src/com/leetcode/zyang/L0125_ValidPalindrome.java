package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 */
public class L0125_ValidPalindrome {

	public L0125_ValidPalindrome() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0125_ValidPalindrome validPalindrome = new L0125_ValidPalindrome();
		
		//String x = "A man, a plan, a canal: Panama";
		//String x = "race a car";
		String x = "abcdedcba";
		
		boolean result = validPalindrome.isPalindrome(x);
		
		System.out.println(x + " ->  " + result); 
	}

    public boolean isPalindrome(String s) {
    	if (s == null || s == "")
    		return true;
    	
    	int size = s.length();
    	int i = 0;
    	int j = size -1;
    	while (i < j) {
        	char c1 = Character.toLowerCase(s.charAt(i));
        	char c2 = Character.toLowerCase(s.charAt(j));
        	
        	if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)) {
        		if (c1 != c2)
        			return false;
        		
        		i++;
        		j--;
        	}
        		
        	if (!Character.isLetterOrDigit(c1)) 
        		i++;        	
        	
    		if (!Character.isLetterOrDigit(c2))
    			j--;    			
    	}
    	
    	return true;    	
    }
}
