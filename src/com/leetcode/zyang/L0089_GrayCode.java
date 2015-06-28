package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 * 
 */
public class L0089_GrayCode {

	public L0089_GrayCode() {
		// TODO Auto-generated constructor stub
	}

    public List<Integer> grayCode(int n) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	list.add(0);
    	
    	if (n == 0)
    		return list;
    	
    	list.add(1);
    	
    	if (n == 1)
    		return list;
    	
    	for (int i = 1; i < n; i++) {
    		int size = list.size();
    		for (int j = size - 1; j >= 0; j--) {
    			int num = list.get(j);
    			num += 1 << i;
    			list.add(num);
    		}
    	}
    	
    	return list;       
    }   
}
