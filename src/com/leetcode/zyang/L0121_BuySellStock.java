package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share 
 * of the stock), design an algorithm to find the maximum profit.
 * 
 */
public class L0121_BuySellStock {

	public L0121_BuySellStock() {
		// TODO Auto-generated constructor stub
	}

    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length <= 1)
    		return 0;
    	
        int profitMax = 0, min = prices[0], max = prices[0];
        
        for (int i = 1; i < prices.length; i++) {       	
        	if (prices[i] < min) {
        		min = prices[i];
        		max = prices[i];
        	}
        	else if (prices[i] > max) {
        		max = prices[i];
        		profitMax = Math.max(profitMax, max - min);
        	}
        }
    	
        return profitMax;    	
    }
}
