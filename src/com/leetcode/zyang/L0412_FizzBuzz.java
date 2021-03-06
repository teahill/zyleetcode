package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 *         Write a program that outputs the string representation of numbers
 *         from 1 to n.
 * 
 *         But for multiples of three it should output “Fizz” instead of the
 *         number and for the multiples of five output “Buzz”. For numbers which
 *         are multiples of both three and five output “FizzBuzz”.
 * 
 *         Example:
 * 
 *         n = 15,
 * 
 *         Return: [ "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz",
 *         "Buzz", "11", "Fizz", "13", "14", "FizzBuzz" ]
 * 
 */
public class L0412_FizzBuzz {
	// you can also use additional Fizz and Buss counter instead of %
	//4ms, 47%
    public List<String> fizzBuzz(int n) {
    	List<String> list = new ArrayList<String>();
    	
    	for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
			fizz++;
			buzz++;
    		if (fizz == 3 && buzz == 5) {
    			list.add("FizzBuzz");
    			fizz = 0;
    			buzz = 0;
    		}
    		else if (buzz == 5) {
    			list.add("Buzz");
    			buzz = 0;
    		}
    		else if (fizz == 3) {
    			list.add("Fizz");
    			fizz = 0;
    		}
    		else 
    			list.add(String.valueOf(i));
    	}
    	
    	return list;       
    }
    
    public List<String> fizzBuzz1(int n) {
    	List<String> list = new ArrayList<String>();
    	
    	for (int i = 1; i <= n; i++) {
    		if (i%15 == 0)
    			list.add("FizzBuzz");
    		else if (i%5 == 0)
    			list.add("Buzz");
    		else if (i%3 == 0)
    			list.add("Fizz");
    		else
    			list.add(String.valueOf(i));
    	}
    	
    	return list;       
    }
}
