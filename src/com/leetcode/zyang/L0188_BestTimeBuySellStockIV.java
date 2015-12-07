package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 */
public class L0188_BestTimeBuySellStockIV {

	public L0188_BestTimeBuySellStockIV() {
		// TODO Auto-generated constructor stub
	}

    public int maxProfit(int k, int[] prices) {
    	if (prices == null || prices.length < 2)
    		return 0;
    	
    	int n = prices.length;
    	// if k exceeds the max number of trades, then go for max profit w/o limit. Helps with performance
    	if (k >= n / 2)
    		return maxProfitNoLimit(prices);
    	
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
    
    private int maxProfitNoLimit(int[] prices) {
    	if (prices == null || prices.length < 2)
    		return 0;
    	
    	int max = 0;
    	for (int i = 1; i < prices.length; i++) {
    		if (prices[i] > prices[i - 1]) 
    			max += (prices[i] - prices[i - 1]);
    	}
    	
    	return max;
    }
}
