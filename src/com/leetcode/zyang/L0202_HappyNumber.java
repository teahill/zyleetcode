package com.leetcode.zyang;

import java.util.HashSet;

/**
 * 
 * @author zyang
 * 
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 */
public class L0202_HappyNumber {

	public L0202_HappyNumber() {
		// TODO Auto-generated constructor stub
	}

    public boolean isHappy(int n) {
    	HashSet<Integer> set = new HashSet<Integer>();

    	while (true) {
        	int number = 0;
    		int digit = 0;
    		int div = 10;
        	while (n != 0) {
        		digit = n % div;
        		number += digit * digit;
        		n = n / 10;
        	}
        	
        	if (number == 1)
        		return true;
        	else {
        		if (set.contains(number))
        			return false;
        		else {
        			set.add(number);
        			n = number;
        		}
        	}
        }
    }	
}
