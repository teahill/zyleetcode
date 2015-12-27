package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         There are n bulbs that are initially off. You first turn on all the
 *         bulbs. Then, you turn off every second bulb. On the third round, you
 *         toggle every third bulb (turning on if it's off or turning off if
 *         it's on). For the nth round, you only toggle the last bulb. Find how
 *         many bulbs are on after n rounds.
 * 
 *         Example:
 * 
 *         Given n = 3.
 * 
 *         At first, the three bulbs are [off, off, off]. After first round, the
 *         three bulbs are [on, on, on]. After second round, the three bulbs are
 *         [on, off, on]. After third round, the three bulbs are [on, off, off].
 * 
 *         So you should return 1, because there is only one bulb is on.
 */

/*
 * on/off are paired up by all divisors of n, except the perfect squares, which will be left on
 */
public class L0319_BulbSwitcher {
	public int bulbSwitch(int n) {
        if (n <= 0)
        	return 0;
        
        return (int)Math.sqrt(n);
	}
	
    public int bulbSwitch1(int n) {
        if (n <= 0)
        	return 0;
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
        	int root = (int)Math.sqrt(i);
        	
        	if (root * root == i)
        		count++;
        }
        
        return count;
    }
}
