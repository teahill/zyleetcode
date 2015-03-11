package com.leetcode.zyang;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author zyang
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * 1. Each row must have the numbers 1-9 occuring just once.
 * 2. Each column must have the numbers 1-9 occuring just once
 * 3. And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * A partially filled sudoku which is valid. 
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable. 
 * Only the filled cells need to be validated.
 * 
 * Set is slower than map
 * map is slower than just plain char comparison
 * 
 * Show Tags Hash Table
 * 
 */
public class L0036_ValidSudoku {

	public L0036_ValidSudoku() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0036_ValidSudoku validSudoku = new L0036_ValidSudoku();
		
		char[][] in = {{'5','3','.','.','7','.','.','.','.'}, 
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};

		
		System.out.println("input: " + in);
	
		boolean result = validSudoku.isValidSudoku(in);		
		
		System.out.println("output: " + result);
	}

    public boolean isValidSudoku1(char[][] board) {        
    	boolean result = false;
    	
    	if (board == null)
    		return result;    	
    	
    	if (board.length != 9)
    		return result;
    	
    	HashMap<Character, Integer> table = new HashMap<Character, Integer>();  	
    	Character ch;
    	for (int i = 0; i < 9; i++) {
    		if (board[i].length != 9) 
    			return result;
    		
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j]== '.')
    				continue;
    			
    			ch = Character.valueOf(board[i][j]);    			
    			if (isValidChar(ch) && !table.containsKey(ch)){    				
    				table.put(ch, 1);
    			}
    			else 
    				return result;
    		}
    		
    		table.clear();
    	}
    	
    	for (int j = 0; j < 9; j++) {
    		if (board[j].length != 9) 
    			return result;
    		
    		for (int i = 0; i < 9; i++) {
    			if (board[i][j]== '.')
    				continue;
    			
    			ch = Character.valueOf(board[i][j]);
    			if (isValidChar(ch) && !table.containsKey(ch)){    				
    				table.put(ch, 1);
    			}
    			else 
    				return result;
    		}
    		
    		table.clear();
    	}
    	
    	for (int k = 0; k < 9; k=k+3) {
        	for (int l = 0; l < 9; l=l+3) {
    	    	for (int i = 0; i < 3; i++) {   		
    	    		for (int j = 0; j < 3; j++) {
    	    			if (board[i+k][j+l]== '.')
    	    				continue;
    	    			
    	    			ch = Character.valueOf(board[i+k][j+l]);
    	    			if (isValidChar(ch) && !table.containsKey(ch)){    				
    	    				table.put(ch, 1);
    	    			}
    	    			else 
    	    				return result;
    	    		}    		
    	    	}
    	    	table.clear();
        	}
    	}

    	result = true;
    	return result;    	
    }

    public boolean isValidChar(char ch) {
    	return (ch == '1' || ch == '2' || ch == '3' || ch == '4' || 
    			ch == '5' || ch == '6' || ch == '7' || ch == '8' || 
    			ch == '9' || ch == '.');    			
    }
    
    public boolean isValidSudoku(char[][] board) {        
    	boolean result = false;
    	   	
    	if (board == null)
    		return result;    	
    	
    	if (board.length != 9)
    		return result;
    	
    	HashSet<Character> table = new HashSet<Character>();  	
    	Character ch;
    	for (int i = 0; i < 9; i++) {
    		if (board[i].length != 9) 
    			return result;
    		
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j]== '.')
    				continue;
    			
    			ch = Character.valueOf(board[i][j]);    			
    			if (isValidChar(ch) && !table.contains(ch)){    				
    				table.add(ch);
    			}
    			else 
    				return result;
    		}
    		
    		table.clear();
    	}
    	
    	for (int j = 0; j < 9; j++) {
    		if (board[j].length != 9) 
    			return result;
    		
    		for (int i = 0; i < 9; i++) {
    			if (board[i][j]== '.')
    				continue;
    			
    			ch = Character.valueOf(board[i][j]);
    			if (isValidChar(ch) && !table.contains(ch)){    				
    				table.add(ch);
    			}
    			else 
    				return result;
    		}
    		
    		table.clear();
    	}
    	
    	for (int k = 0; k < 9; k=k+3) {
        	for (int l = 0; l < 9; l=l+3) {
    	    	for (int i = 0; i < 3; i++) {   		
    	    		for (int j = 0; j < 3; j++) {
    	    			if (board[i+k][j+l]== '.')
    	    				continue;
    	    			
    	    			ch = Character.valueOf(board[i+k][j+l]);
    	    			if (isValidChar(ch) && !table.contains(ch)){    				
    	    				table.add(ch);
    	    			}
    	    			else 
    	    				return result;
    	    		}    		
    	    	}
    	    	table.clear();
        	}
    	}

    	result = true;
    	return result;    	
    }
}
