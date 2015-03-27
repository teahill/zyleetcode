package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * 
 */
public class L0119_PascalTriangleII {

	public L0119_PascalTriangleII() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0119_PascalTriangleII pascalTriangle = new L0119_PascalTriangleII();

		int rowIndex = 3;

		System.out.println("Input = " + rowIndex);

		List<Integer> List = pascalTriangle.getRow(rowIndex);

		System.out.println("result = " + List);
	}

    public List<Integer> getRow(int rowIndex) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	list.add(1);
    	
    	int prevJ, curJ;
    	for (int i = 1; i < rowIndex + 1; i++) {
    		prevJ = 1;
    		for (int j = 1; j < i; j++) {
    			curJ = list.get(j);    			
    			list.set(j, prevJ + list.get(j));
    			prevJ = curJ;
    		}
    	
    		list.add(1);
    	}
        
    	return list;
    }
}
