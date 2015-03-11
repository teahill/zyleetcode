package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 */
public class L0014_LongestCommonPrefix {

	public L0014_LongestCommonPrefix() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String[] x = {"abc"};
		String[] x = {"abc", "acd"};
		//String[] x = {"abc", "bcd"};
		//String[] x = {"aa", "a"};
		
		L0014_LongestCommonPrefix longestCommonPrefix = new L0014_LongestCommonPrefix();
		
		String result = longestCommonPrefix.longestCommonPrefix(x);
		
		System.out.println(x + " ->  " + result);
	}

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        StringBuilder resString = new StringBuilder();
        
        if (strs == null || strs.length == 0)
        	return result;
        
        if (strs.length == 1)
        	return strs[0];
        
        char ch;
        boolean isCommon = true;
        
        for (int i = 0; i < strs[0].length(); i++) {
        	ch = strs[0].charAt(i);
        	for (int j = 1; j < strs.length; j++) {
        		if (i >= strs[j].length() || ch != strs[j].charAt(i)) {
        			isCommon = false;
        			break;
        		}        			
        	}
        	
        	if (isCommon)
        		resString.append(ch);
        	else 
        		break;
        }
        
        result = resString.toString();
        
    	return result;
    }
}
