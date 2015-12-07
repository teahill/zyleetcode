package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Additive number is a string whose digits can form additive sequence.
 * 
 *         A valid additive sequence should contain at least three numbers.
 *         Except for the first two numbers, each subsequent number in the
 *         sequence must be the sum of the preceding two.
 * 
 *         For example: "112358" is an additive number because the digits can
 *         form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 
 *         1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8 "199100199" is also an
 *         additive number, the additive sequence is: 1, 99, 100, 199. 1 + 99 =
 *         100, 99 + 100 = 199 Note: Numbers in the additive sequence cannot
 *         have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 *         Given a string containing only digits '0'-'9', write a function to
 *         determine if it's an additive number.
 */
public class L0306_AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        boolean isAdditive = false;
        
        if (num == null || num.length() < 3)
        	return isAdditive;
        
        long firstNum, secondNum;
        for (int i = 1; i < num.length() - 1; i++) {
        	// make sure the second number does not start with zero
        	if (num.charAt(0) == '0' && i > 1)
        		continue;
        	
        	firstNum = Long.valueOf(num.substring(0, i));
        	// try second number
        	for (int j = i + 1; j < num.length(); j++) {
        		if (num.charAt(i) == '0' && j > i + 1)
        			continue;
        		
        		secondNum = Long.valueOf(num.substring(i, j));

        		// check if this is additive combo
        		isAdditive = isAdditive(firstNum, secondNum, num.substring(j));
        		
        		if (isAdditive)
        			return isAdditive;
        	}
        }
        
        return isAdditive;
    }
    
    private boolean isAdditive(long firstNum, long secondNum, String str) {
    	boolean isAdditive = false;
    	
    	if (str == null || str.length() == 0)
    		return isAdditive;
    	
    	long expectedNum = firstNum + secondNum;    	
    	String expectedStr = String.valueOf(expectedNum);  
    	
    	if (expectedStr.length() > str.length() || !str.startsWith(expectedStr)) 
    		return false;
    	
    	if (expectedStr.length() == str.length())
    		return true;
    			
    	firstNum = secondNum;
    	secondNum = expectedNum;      	
    	return isAdditive(firstNum, secondNum, str.substring(expectedStr.length()));    	
    }
}
