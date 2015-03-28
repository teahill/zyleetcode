package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * You wish to color a map with not more than four colors: red, yellow, green, blue
 * Adjacent countries must be in different colors
 * You don’t have enough information to choose colors
 * Each choice leads to another set of choices 
 * One or more sequences of choices may (or may not) lead to a solution
 * Many coloring problems can be solved with backtracking
 * 
 * The Four Color Theorem states that any map on a 
 * plane can be colored with no more than four colors, 
 * so that no two countries with a common border are the same color
 * 
 * For most maps, finding a legal coloring is easy
 * For some maps, it can be fairly difficult to find a legal coloring
 * We will develop a complete Java program to solve this problem 
 * 
 * Backtracking is really quite simple--we “explore” each node, as follows:
 * To “explore” node N:
 * 1. If N is a goal node, return “success”
 * 2. If N is a leaf node, return “failure”
 * 3. For each child C of N,
 *   3.1. Explore C
 *   3.1.1. If C was successful, return “success”
 * 4. Return “failure”
 * 
 */
public class Four_Color_Map {
	public static final int COLOR_NONE = 0;
	public static final int COLOR_RED = 1;
	public static final int COLOR_YELLOW = 2;
	public static final int COLOR_GREEN = 3;
	public static final int COLOR_BLUE = 4;
	
	int[] countryColor = new int[] {COLOR_NONE, COLOR_NONE, COLOR_NONE, 
		COLOR_NONE, COLOR_NONE, COLOR_NONE, COLOR_NONE};
	
	int[][] map;
	
	public Four_Color_Map() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Four_Color_Map colorMap = new Four_Color_Map();
		
		colorMap.createMap();	
	
		boolean isSuccess = colorMap.exploreMap(0, COLOR_RED);
		
		System.out.println(isSuccess);
		colorMap.printMap();
	}

	public boolean exploreMap(int country, int color) {
		if (country >= countryColor.length)
			return true;
		
		if (!okColor(country, color))
			return false;
		
		countryColor[country] = color;
		for (int c = COLOR_RED; c <= COLOR_BLUE; c++) {
			boolean isSuccess = exploreMap(country + 1, c);	
			if (isSuccess)
				return true;
		}
		
		return false;	
	}
	
	public boolean okColor(int country, int color) {
		for (int j = 0; j < map[country].length; j++) {
			int adjCountry = map[country][j];
			if (countryColor[adjCountry] == color)
				return false;
		}
		
		return true;
	}
	
	public void createMap() {
		map = new int[7][];
		map[0] = new int[] {1, 4, 2, 5};
		map[1] = new int[] {0, 4, 6, 5};
		map[2] = new int[] {0, 4, 3, 6, 5};
		map[3] = new int[] {2, 4, 6};
		map[4] = new int[] {0, 1, 6, 3, 2};
		map[5] = new int[] {2, 6, 1, 0};
		map[6] = new int[] {2, 3, 4, 1, 5};
	}
	
	void printMap() {
	       for (int i = 0; i < countryColor.length; i++) {
	           System.out.print("map[" + i + "] is ");
	           switch (countryColor[i]) {
	               case COLOR_NONE:    System.out.println("none");   break;
	               case COLOR_RED:       System.out.println("red");     break;
	               case COLOR_YELLOW: System.out.println("yellow"); break;
	               case COLOR_GREEN:   System.out.println("green");  break;
	               case COLOR_BLUE:     System.out.println("blue");     break;
	           }
	      }
	}

}


	
	
	
	
	