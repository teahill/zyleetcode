package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class L0072_EditDistance {

	public L0072_EditDistance() {
		// TODO Auto-generated constructor stub
	}

	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null)
			return 0;
		
        int m = word1.length();
        int n = word2.length();        
        if (m == 0)
        	return n;
        if (n == 0)
        	return m;
        
        // Distance matrix. Initialize
        int D[][] = new int[m + 1][];        
        for (int i = 0; i < m + 1; i++) {
        	D[i] = new int[n + 1];
        	D[i][0] = i;
        }
        	
        for (int j = 0; j < n + 1; j++) 
        	D[0][j] = j;
        
        for (int i = 1; i < m + 1; i++) {
        	for (int j = 1; j < n + 1; j++) {
        		D[i][j] = Math.min(D[i-1][j] + 1, D[i][j-1] + 1);
        		
        		if (word1.charAt(i - 1) != word2.charAt(j - 1))
        			D[i][j] = Math.min(D[i][j], D[i-1][j-1] + 1);
        		else
        			D[i][j] = Math.min(D[i][j], D[i-1][j-1]);
        	}
        }
        
        return D[m][n];
    }
}
