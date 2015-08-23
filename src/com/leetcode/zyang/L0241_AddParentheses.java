package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * 
 * Example 1
 * Input: "2-1-1".
 * 
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * Example 2
 * Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34
 * (2*((3-4)*5)) = -10
 * ((2*3)-(4*5)) = -14
 * (((2*3)-4)*5) = 10
 * ((2*(3-4))*5) = -10
 * 
 * Output: [-34, -14, -10, -10, 10]
 */
public class L0241_AddParentheses {

	public L0241_AddParentheses() {
		// TODO Auto-generated constructor stub
	}

	HashMap<String, List<Integer>> map;
	
    public List<Integer> diffWaysToCompute(String input) {
    	if (map == null)
    		map = new HashMap<String, List<Integer>>();
    	
    	if (map.containsKey(input))
    		return map.get(input);
    	
    	List<Integer> list = new ArrayList<Integer>();
        if (input == null)
        	return list;        

        for (int i = 0; i < input.length(); i++) {
        	if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
        		List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
        		List<Integer> list2 = diffWaysToCompute(input.substring(i + 1));
        		
        		for (Integer i1 : list1) {
        			for (Integer i2 : list2) {
        				int res = 0;
        				switch(input.charAt(i)) {
        					case '+':
        						res = i1 + i2;
        						break;
        					case '-':
        						res = i1 - i2;
        						break;
        					case '*':
        						res = i1 * i2;
        						break;
        						
        				}
        				list.add(res);
        			}
        		}        		
        	}
        }
        
        if (list.size() == 0)
        	list.add(Integer.valueOf(input));
        
        map.put(input, list);
        
        return list;
    }
}
