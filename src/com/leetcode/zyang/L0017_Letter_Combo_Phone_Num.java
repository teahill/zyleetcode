package com.leetcode.zyang;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * 2: abc, 3: def, 4: ghi, 5: jkl, 6: mno, 7: pqrs, 8: tuv, 9: wxyz
 *  
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 * 
 * Show Tags
 * 
 */
public class L0017_Letter_Combo_Phone_Num {

	public L0017_Letter_Combo_Phone_Num() {
		// TODO Auto-generated constructor stub
	}

    public List<String> letterCombinations(String digits) {
    	List<String> list = new LinkedList<String>();
    	
    	if (digits == null || digits.length() == 0)
    		return list;
    	
    	list.add("");
    	
    	HashMap<Integer, String> map = new HashMap<Integer, String>();
    	map.put(2, "abc");
    	map.put(3, "def");
    	map.put(4, "ghi");
    	map.put(5, "jkl");
    	map.put(6, "mno");
    	map.put(7, "pqrs");
    	map.put(8, "tuv");
    	map.put(9, "wxyz");
    	    	
        for (int i = digits.length() - 1; i >= 0 ; i--) {
        	String s = map.get(digits.charAt(i) - '0');
        		
        	List<String> newList = new LinkedList<String>();
        	for (int j = 0; j < s.length(); j++) {
        		for (String ele : list) {       			
        			StringBuilder sb = new StringBuilder(ele);
        			sb.insert(0, s.charAt(j));
        			newList.add(sb.toString());
        		}
        	}
        	list = newList;        	
        }
        
        return list;        
    }
}
