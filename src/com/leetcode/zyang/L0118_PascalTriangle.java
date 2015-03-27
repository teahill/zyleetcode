package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class L0118_PascalTriangle {

	public L0118_PascalTriangle() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0118_PascalTriangle pascalTriangle = new L0118_PascalTriangle();

		int numRows = 5;

		System.out.println("Input = " + numRows);

		List<List<Integer>> allList = pascalTriangle.generate(numRows);

		System.out.println("result = " + allList);
	}

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allList = new ArrayList<List<Integer>>();
        
        if (numRows == 0)
        	return allList;
        
        ArrayList<Integer> list = new ArrayList<Integer>();       
        list.add(1);
        allList.add(list);
        
        if (numRows == 1)
        	return allList;
        
        ArrayList<Integer> prevList = list;
        
        for (int i = 1; i < numRows; i++) {       
            list = new ArrayList<Integer>();
            
            list.add(prevList.get(0));     
            
            for (int j = 0; j < prevList.size() - 1; j++) 
            	list.add(prevList.get(j) + prevList.get(j + 1));
            
            list.add(prevList.get(prevList.size() - 1));
            
            allList.add(list);
            prevList = list;
        }       
        
        return allList;
    }
}
