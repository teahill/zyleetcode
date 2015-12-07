package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Say you have an array for which the ith element is the price of a
 *         given stock on day i.
 * 
 *         Design an algorithm to find the maximum profit. You may complete as
 *         many transactions as you like (ie, buy one and sell one share of the
 *         stock multiple times) with the following restrictions:
 * 
 *         You may not engage in multiple transactions at the same time (ie, you
 *         must sell the stock before you buy again). After you sell your stock,
 *         you cannot buy stock on next day. (ie, cooldown 1 day) Example:
 * 
 *         prices = [1, 2, 3, 0, 2] maxProfit = 3 transactions = [buy, sell,
 *         cooldown, buy, sell]
 * 
 *         Awesome leetcode solution:
 *         https://leetcode.com/discuss/71391/easiest-
 *         java-solution-with-explanations
 * 
 *         1. Define States
 * 
 *         To represent the decision at index i:
 * 
 *         buy[i]: Max profit till index i. The series of transaction is ending
 *         with a buy. sell[i]: Max profit till index i. The series of
 *         transaction is ending with a sell. To clarify:
 * 
 *         Till index i, the buy / sell action must happen and must be the last
 *         action. It may not happen at index i. It may happen at i - 1, i - 2,
 *         ... 0. In the end n - 1, return sell[n - 1]. Apparently we cannot
 *         finally end up with a buy. In that case, we would rather take a rest
 *         at n - 1. For special case no transaction at all, classify it as
 *         sell[i], so that in the end, we can still return sell[n - 1]. Thanks @kennethliaoke
 *         @anshu2. 
 *         
 *         2. Define Recursion
 * 
 *         buy[i]: To make a decision whether to buy at i, we either take a
 *         rest, by just using the old decision at i - 1, or sell at/before i -
 *         2, then buy at i, We cannot sell at i - 1, then buy at i, because of
 *         cooldown. sell[i]: To make a decision whether to sell at i, we either
 *         take a rest, by just using the old decision at i - 1, or buy
 *         at/before i - 1, then sell at i. So we get the following formula:
 * 
 *         buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]); sell[i] =
 *         Math.max(sell[i - 1], buy[i - 1] + prices[i]); 
 *         
 *         3. Optimize to O(1) Space
 * 
 *         DP solution only depending on i - 1 and i - 2 can be optimized using
 *         O(1) space.
 * 
 *         Let b2, b1, b0 represent buy[i - 2], buy[i - 1], buy[i] Let s2, s1,
 *         s0 represent sell[i - 2], sell[i - 1], sell[i] Then arrays turn into
 *         Fibonacci like recursion:
 * 
 *         b0 = Math.max(b1, s2 - prices[i]); s0 = Math.max(s1, b1 + prices[i]);
 *         
 *         4. Write Code in 5 Minutes
 * 
 *         First we define the initial states at i = 0:
 * 
 *         We can buy. The max profit at i = 0 ending with a buy is -prices[0].
 *         We cannot sell. The max profit at i = 0 ending with a sell is 0.
 */
public class L0309_BestTimeBuySellStockCooldown {
	
	
	/*
	 * buy[i] = max(buy[i-1], sell[i-2] - p[i]);
	 * sell[i] = max(sell[i-1], buy[i-1] + p[i]);
	 * 
	 * i=1	i=0			i=-1
	 * b	bp=-p[0]	
	 * s	sp=0		spp=0
	 */
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
        	return 0;
        
        int n = prices.length;
        int b = -prices[0], bp = b;
        int s = 0, sp = 0, spp=0;
        
        for (int i = 1; i < n; i++) {
        	b = Math.max(bp, spp - prices[i]);
        	s = Math.max(sp,  bp + prices[i]);
        	
        	bp = b;
        	spp = sp;
        	sp = s;
        }
        
        return s;
	}
	
	// TLE
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2)
        	return 0;
        
        int n = prices.length;
        int[] dp = new int[n];
        dp[1] = Math.max(0, prices[1] - prices[0]);
        
        if (n == 2)
        	return dp[1];
        
        dp[2] = Math.max(dp[1], prices[2] - Math.min(prices[1], prices[0]));

        for (int i = 3; i < n; i++) {
        	dp[i] = Math.max(dp[i], dp[i-1]);
        	dp[i] = Math.max(dp[i], dp[i-2]);
        	for (int ii = 0; ii <= i-3; ii++) {
        		int localMin = prices[ii+2];
	        	for (int j = ii+3; j <= i-1; j++)    
	        		localMin = Math.min(localMin, prices[j]);
	        	
	        	dp[i] = Math.max(dp[i],  dp[ii] + prices[i] - localMin);	        	
        	}
        }
        
        return dp[n-1];
    }
}
