package com.leetcode.zyang;

/**
 * @author zyang
 * 
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class L0275_HIndexII {

	public L0275_HIndexII() {
		// TODO Auto-generated constructor stub
	}

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
        	return 0;
        
        int n = citations.length;
        int low = 0, high = n -1;
        while (low <= high) {
        	int mid = low + (high - low) / 2;
        	if (citations[mid] == n - mid)
        		return n - mid;
        	else if (citations[mid] > n - mid)
        		high = mid - 1;
        	else
        		low = mid + 1;
        }
               
        return n - low;
    }
}
