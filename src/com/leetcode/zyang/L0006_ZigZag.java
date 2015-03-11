package com.leetcode.zyang;

import java.util.ArrayList;

/**
 * @author zyang
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 	P   A   H   N
 * 	A P L S I I G
 * 	Y   I   R
 * 	And then read line by line: "PAHNAPLSIIGYIR"
 * 	Write the code that will take a string and make this conversion given a number of rows:
 * 	string convert(string text, int nRows);
 * 	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 */
public class L0006_ZigZag {
	
	public static void main(String[] args) {
		/*
		String inStr = "PAYPALISHIRING";
		int nRows = 3;
		*/
		

		String inStr = "AB";
		int nRows = 1;

		
		System.out.println(inStr + " " + nRows);
		
		/**
		if (args.length != 2) {
				System.err.print("There must be two arguments! " + args.length);
				System.exit(1);
		}
		
		int nRows = 0;
		try {
			nRows = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.err.print("Second argument must be positive integer greater than zero! " + args[1]);
			System.exit(1);
		}
		
		if (nRows == 0){
			System.err.print("Second argument must be positive integer greater than zero! " + args[1]);
			System.exit(1);
		}
		*/
		
		L0006_ZigZag zigZag = new L0006_ZigZag();
		
		String result = zigZag.convert(inStr, nRows);
		
		System.out.println(inStr + "   " + result);
	}
	
	
	
	L0006_ZigZag() {
		
	}
	
	public String convert(String s, int nRows) {
		if (nRows == 1)
			return s;
		
		ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
		for (int i=0; i<nRows; i++){
			StringBuilder line = new StringBuilder();
			list.add(line);
		}
		
		int prevRowPos = 0, rowPos = 0;
		for (int i=0; i<s.length(); i++){
			// fill the list
			list.get(rowPos).append(s.charAt(i));	
			
			// advance rowPos
			if (i == 0){
				if (s.length() != 1)
					rowPos++;
				continue;				
			}
			
			if (rowPos + 1 == nRows) {
				rowPos--;
				prevRowPos++;
			}
			else if (rowPos + 1 < nRows) {
				if (rowPos > prevRowPos){
					rowPos++;
					prevRowPos++;
				}
				else {
					if (rowPos > 0) {
						rowPos--;
						prevRowPos--;
					}
					else if (rowPos == 0){
						rowPos++;
						prevRowPos--;
					}				
				}				
			}
		}
		
		/*
		 * Combine all lists
		 */
		StringBuilder result = new StringBuilder();
		for (int k=0; k<nRows; k++){
			result = result.append(list.get(k));
			
		}
        return result.toString();
        
    }
}
