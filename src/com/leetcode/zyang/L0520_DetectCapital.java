package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given a word, you need to judge whether the usage of capitals in it
 *         is right or not.
 * 
 *         We define the usage of capitals in a word to be right when one of the
 *         following cases holds:
 * 
 *         1. All letters in this word are capitals, like "USA". 
 *         2. All letters in this word are not capitals, like "leetcode". 
 *         3. Only the first letter in this word is capital if it has more than one letter, like "Google".
 *         
 *         Otherwise, we define that this word doesn't use capitals in a right way. 
 *         
 *         Example 1: Input: "USA" Output: True 
 *         Example 2: Input: "FlaG" Output: False 
 *         
 *         Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class L0520_DetectCapital {
	//34ms, 55%
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() < 2)
        	return true;
        
        return (word.toUpperCase().equals(word) 
        		|| word.substring(1).toLowerCase().equals(word.substring(1)));
    }
    
    //31ms, 74%
    public boolean detectCapitalUse1(String word) {
        if (word == null || word.length() < 2)
        	return true;
        
        char[] ch = word.toCharArray();
        int count = 0;
        for (int i = 0; i < ch.length; i++) 
        	if (ch[i] <= 'Z')
        		count++;
        
        return (count == 0 || count == ch.length || (count == 1 && ch[0] <='Z'));
    }
    
    public boolean detectCapitalUse3(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
    
    public boolean detectCapitalUse4(String word) {
        if (word == null || word.length() < 2)
        	return true;
        
        char[] ch = word.toCharArray();
        boolean isFirstCapital = false;
        boolean isSecondCapital = false;
        if (ch[0] <= 'Z' && ch[0] >= 'A') 
        	isFirstCapital = true;
        
        if (ch[1] <= 'Z' && ch[0] >= 'A') 
        	isSecondCapital = true;
        
        for (int i = 1; i < ch.length; i++) {
        	if (!isFirstCapital && ch[i] <= 'Z' && ch[i] >= 'A')
        		return false;
        	else if (isFirstCapital && isSecondCapital && ch[i] < 'A')
        		return false;
        	else if (isFirstCapital && !isSecondCapital && ch[i] > 'A')
        		return false;
        }
        
        return true;
    }
}
