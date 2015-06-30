package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) 
 * of the characters without disturbing the relative positions of the remaining characters. 
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 */
public class L0115_DistinctSubsequence {

	public L0115_DistinctSubsequence() {
		// TODO Auto-generated constructor stub
	}

    public int numDistinct(String s, String t) {
        if (s == null || t == null)
        	return 0;
        
        int sl = s.length();
        int tl = t.length();
        if (sl < tl)
        	return 0;
        
        int[] prev = new int[sl + 1];
        int[] cur = new int[sl + 1];
        for (int i = 0; i <=sl; i++) 
        	prev[i] = 1;       
        
        cur[0] = 0;
        for (int i = 1; i <= tl; i++) {
        	for (int j = 1; j <= sl; j++) 
        		cur[j] = cur[j - 1] + ((s.charAt(j - 1) == t.charAt(i - 1)) ? prev[j-1] : 0);
        	
        	// Swap cur to prev, reset cur
        	for (int j = 0; j <= sl; j++) {
        		prev[j] = cur[j];
        		cur[j] = 0;
        	}
        }
        
        return prev[sl];
    }
}
