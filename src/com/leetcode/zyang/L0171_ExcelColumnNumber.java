package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 * 
 * 
 * 
 */
public class L0171_ExcelColumnNumber {

	public L0171_ExcelColumnNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0171_ExcelColumnNumber excelColumnNumber = new L0171_ExcelColumnNumber();
		
		String title = "AC";

		int n = excelColumnNumber.titleToNumber(title);
		
		System.out.println("Title = " + title + ", n = " + n);
	}

    public int titleToNumber(String s) {
    	if (s == null || s == "")
    		return 0;
    	
    	int n = 0;
    	for (int i = 0; i < s.length(); i++) 
    		n = n *26 + (s.charAt(i) - 'A') + 1;
    	
    	return n;        
    }
}
