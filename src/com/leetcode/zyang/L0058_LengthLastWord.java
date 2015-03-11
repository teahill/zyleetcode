package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of 
 * last word in the string. If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * 
 */
public class L0058_LengthLastWord {

	public L0058_LengthLastWord() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String x = "    Hello    World      ";
		String x = "H ";

		
		L0058_LengthLastWord lengthLastWord = new L0058_LengthLastWord();
		
		int result = lengthLastWord.lengthOfLastWord(x);
		
		System.out.println(x + " ->  " + result);
	}

    public int lengthOfLastWord(String s) {
    	int count = 0, prevCount = 0;
    	
    	if (s == null || s.length() == 0)
    		return count;
    	
 
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) != ' ')
    			count++;
    		else {
    			if (count != 0)
    				prevCount = count;
    			count = 0;
    		}
    	}
    	
    	if (count == 0)
    		count = prevCount;
    	
    	return count;        
    }
}
