package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         You are playing the following Bulls and Cows game with your friend:
 *         You write a 4-digit secret number and ask your friend to guess it.
 *         Each time your friend guesses a number, you give a hint. The hint
 *         tells your friend how many digits are in the correct positions
 *         (called "bulls") and how many digits are in the wrong positions
 *         (called "cows"). Your friend will use those hints to find out the
 *         secret number.
 * 
 *         For example:
 * 
 *         Secret number: "1807" Friend's guess: "7810" Hint: 1 bull and 3 cows.
 *         (The bull is 8, the cows are 0, 1 and 7.) Write a function to return
 *         a hint according to the secret number and friend's guess, use A to
 *         indicate the bulls and B to indicate the cows. In the above example,
 *         your function should return "1A3B".
 * 
 *         Please note that both secret number and friend's guess may contain
 *         duplicate digits, for example:
 * 
 *         Secret number: "1123" Friend's guess: "0111" In this case, the 1st 1
 *         in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your
 *         function should return "1A1B". You may assume that the secret number
 *         and your friend's guess only contain digits, and their lengths are
 *         always equal.
 */
public class L299_BullsCows {

	public L299_BullsCows() {
		// TODO Auto-generated constructor stub
	}

    public String getHint(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length())
        	return null;
        
        int[] count = new int[10];
        int A = 0, B = 0;        
        for (int i = 0; i < secret.length(); i++) {
        	if (secret.charAt(i) == guess.charAt(i)) {
        		A++;       	
        		continue;
        	}

			if (count[guess.charAt(i) - '0'] > 0)  
				B++;
			
			if (count[secret.charAt(i) - '0'] < 0) 
				B++;

			count[secret.charAt(i) - '0']++;
			count[guess.charAt(i) - '0']--;
        }
        
        return A + "A" + B + "B";
    }	
    
    // one pass
    public String getHint2(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length())
        	return null;
        
        int[] countSecret = new int[10];
        int[] countGuess = new int[10];
        int A = 0, B = 0;        
        for (int i = 0; i < secret.length(); i++) {
        	boolean matchS = false, matchG = false;
        	if (secret.charAt(i) == guess.charAt(i)) {
        		A++;       	
        		continue;
        	}

			if (countSecret[guess.charAt(i) - '0'] > 0) {
				countSecret[guess.charAt(i) - '0']--;
				B++;
				matchG = true;
			}

			if (countGuess[secret.charAt(i) - '0'] > 0) {
				countGuess[secret.charAt(i) - '0']--;
				B++;
				matchS = true;
			}

			if (!matchS)
				countSecret[secret.charAt(i) - '0']++;

			if (!matchG)
				countGuess[guess.charAt(i) - '0']++;

        }
        
        String result = A + "A" + B + "B";
        
        return result;
    }	
    
    // multiple passes
    public String getHint1(String secret, String guess) {
        if (secret == null || guess == null || secret.length() != guess.length())
        	return null;
        
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) 
        	count[secret.charAt(i) - '0']++;

        int A = 0;
        for (int i = 0; i < secret.length(); i++) {
        	if (secret.charAt(i) == guess.charAt(i)) {
        		count[secret.charAt(i) - '0']--;
        		A++;
        	}
        }
        
        int B = 0;
        for (int i = 0; i < secret.length(); i++) {
        	if (secret.charAt(i) != guess.charAt(i) && count[guess.charAt(i) - '0'] > 0) {
        		count[guess.charAt(i) - '0']--;
        		B++;
        	}
        }
        
        String result = A + "A" + B + "B";
        
        return result;
    }	
}
