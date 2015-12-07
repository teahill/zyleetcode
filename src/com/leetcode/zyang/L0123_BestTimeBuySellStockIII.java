package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Say you have an array for which the ith element is the price of a
 *         given stock on day i.
 * 
 *         Design an algorithm to find the maximum profit. You may complete at
 *         most two transactions.
 * 
 *         Note: You may not engage in multiple transactions at the same time
 *         (ie, you must sell the stock before you buy again).
 */
public class L0123_BestTimeBuySellStockIII {

    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length < 2)
    		return 0;
    	
    	int n = prices.length;
    	int k = 2;
    	// define matrix to track max profit for i transactions, l days of trade
    	// dp[i][l] = max(dp[i][l-1], max(dp[i-1][j] + prices[l] - prices[j])); i from 0 to k, total k+1
    	// dp[i][l] = max(dp[i][l-1], prices[l] + max(dp[i-1][j] - prices[j])); j from 0 to l-1, total l
    	// use localMax to track max(dp[i-1][j] - prices[j])    	
    	int[][] dp = new int[k+1][n];
    	for (int i = 1; i <= k; i++) {
    		int localMax = dp[i-1][0] - prices[0];
    		for (int l = 1; l < n; l++) {
        		dp[i][l] = Math.max(dp[i][l-1], prices[l] + localMax);
    			localMax = Math.max(localMax, dp[i-1][l] - prices[l]);    			
    		}    		
    	}

    	return dp[k][n - 1];
    }

    
	// conceptually works, but TLE
    public int maxProfit1(int[] prices) {
    	int maxProfit = 0;
        if (prices == null || prices.length < 2)
        	return maxProfit;
        
        for (int i = 1; i < prices.length - 2; i++) {
        	maxProfit = Math.max(maxProfit, 
        			maxProfitSingle(prices, 0, i) +	maxProfitSingle(prices, i + 1, prices.length - 1));
        }

        return maxProfit;
    }
    
    private int maxProfitSingle(int[] prices, int start, int end) {
    	if (start < 0 || end > prices.length - 1 || start > end - 1)
    		return 0;
    	
    	int min = prices[start], maxProfit = 0;
    	for (int i = start + 1; i <= end; i++) {
    		if (prices[i] > min)
    			maxProfit = Math.max(maxProfit, prices[i] - min);

    		min = Math.min(min, prices[i]);    		
    	}
    	
    	return maxProfit;
    }
}
