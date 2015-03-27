package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 *    
 */
public class L0168_ExcelColumnTitile {

	public L0168_ExcelColumnTitile() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		L0168_ExcelColumnTitile excelColumnTitle = new L0168_ExcelColumnTitile();
		
		int n = 28;
		String title = excelColumnTitle.convertToTitle(n);
		
		System.out.println("n = " + n + ", title = " + title);
		
	}

    public String convertToTitle(int n) {
    	String s = "";
    	
    	if (n <= 0)
    		return s;
    	
    	while (n > 0) {
    		n--;
    		s = (char)(n%26 + 'A') + s;
    		
    		n = n / 26;     		
    	}
        
    	return s;
    }
}
