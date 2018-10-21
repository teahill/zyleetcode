package com.leetcode.zyang;

import java.util.HashMap;

/**
 * 
 * @author zyang
 * 
 *         You are given coins of different denominations and a total amount of
 *         money amount. Write a function to compute the fewest number of coins
 *         that you need to make up that amount. If that amount of money cannot
 *         be made up by any combination of the coins, return -1.
 * 
 *         Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 * 
 *         Example 2: coins = [2], amount = 3 return -1.
 * 
 *         Note: You may assume that you have an infinite number of each kind of
 *         coin.
 */
public class L0322_CoinChange {
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
    public int coinChange(int[] coins, int amount) {
    	if (coins == null || coins.length < 1)
    		return -1;
    	
    	map.put(Integer.valueOf(0), Integer.valueOf(0));
    	
        return coinChangeDP(coins, amount);
    }
    
    private int coinChangeDP(int[] coins, int amount) {
        if (map.get(Integer.valueOf(amount)) != null)
        	return map.get(Integer.valueOf(amount));
        	
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
        	if (coins[i] > amount)
        		continue;
        	
        	int num = coinChangeDP(coins, amount - coins[i]);
        	if (num == -1)
        		continue;
        	
        	min = Math.min(min, num + 1);
        }
        
        int count = (min == Integer.MAX_VALUE) ? -1 : min;
        map.put(Integer.valueOf(amount), count);
        
        return count;
    }
}
