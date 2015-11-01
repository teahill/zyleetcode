package com.leetcode.zyang;

import java.util.Arrays;

/**
 * @author zyang
 * 
 *         Given an array of citations (each citation is a non-negative integer)
 *         of a researcher, write a function to compute the researcher's
 *         h-index.
 * 
 *         According to the definition of h-index on Wikipedia:
 *         "A scientist has index h if h of his/her N papers have at least h citations each, 
 *         and the other N − h papers have no more than h citations each."
 * 
 *         For example, given citations = [3, 0, 6, 1, 5], which means the
 *         researcher has 5 papers in total and each of them had received 3, 0,
 *         6, 1, 5 citations respectively. Since the researcher has 3 papers
 *         with at least 3 citations each and the remaining two with no more
 *         than 3 citations each, his h-index is 3.
 * 
 *         Note: If there are several possible values for h, the maximum one is
 *         taken as the h-index.
 */
public class L0274_HIndex {

	public L0274_HIndex() {
		// TODO Auto-generated constructor stub
	}

	// 0(n), extra space
	public int hIndex(int[] citations) {
        if (citations == null)
        	return 0;
        
        int n = citations.length;
        int[] hIndex = new int[n];
        Arrays.fill(hIndex, 0);
        for (int i = 0; i < n; i++) {
        	if (citations[i] >= n)
        		hIndex[ n - 1]++;
        	else if (citations[i] > 0)
        		hIndex[citations[i] - 1]++;
        }
        
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
        	count += hIndex[i];
        	if ( count >= i + 1) 
        		return i + 1;
        }
       	        
        return 0;
    }
	
	// O(nlogn)
    public int hIndex1(int[] citations) {
    	int hIndex = 0;
        if (citations == null)
        	return hIndex;
        
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
        	if (citations[i] >= n - i) {
        		hIndex = n - i;
        		break;
        	}
        }
        
        return hIndex;
    }
}
