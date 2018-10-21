package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author zyang
 * 
 *         Suppose you have a random list of people standing in a queue. Each
 *         person is described by a pair of integers (h, k), where h is the
 *         height of the person and k is the number of people in front of this
 *         person who have a height greater than or equal to h. Write an
 *         algorithm to reconstruct the queue.
 * 
 *         Note: The number of people is less than 1,100.
 * 
 *         Example
 * 
 *         Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 *         Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class L0406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
        	return new int[0][0];
        
        Arrays.sort(people, new Comparator<int[]>() 
        		{ public int compare(int[] a, int[] b) 
        			{
	        			if (a[0] == b[0])
	        				return a[1] - b[1];
	        			return b[0] - a[0];
        			}
        		});
        
        ArrayList<int[]> list = new ArrayList<int[]>();
        
        for (int[] element : people) 
        	list.add(element[1], new int[] {element[0], element[1]});
        
        int[][] result = new int[people.length][];
        int i = 0;
        for (int[] element : list) 
        	result[i++] = new int[] {element[0], element[1]};

        return result;      
    }
}
