package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Hide Tags Array Two Pointers
 *
 */
public class L0027_RemoveElement {

	public L0027_RemoveElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		L0027_RemoveElement removeE = new L0027_RemoveElement();
		
		//int[] in = {1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 20};
		int[] in = {3};
		int el = 3;
		
		System.out.println("input: " + removeE.printArray(in) + "\nElement = " + el);
	
		int result = removeE.removeElement(in, el);		
		
		System.out.println("output: " + result + "\n" + removeE.printArray(in));
	}
	
	public String printArray(int[] in) {
		StringBuilder result = new StringBuilder();
		for (int i : in) 
			result = result.append(i + "->");
		
		return result.toString();

	}

    public int removeElement(int[] A, int elem) {
        int result = 0;
        
        if ((A == null) || (A.length == 0))
        	return result;
        
        int ptr2 = 0;
        for (int i = 0; i < A.length; i++) {
        	if (A[i] != elem) {
        		A[ptr2] = A[i];
        		ptr2++;      		
        	}
        }
        
        result = ptr2;
        return result;
    }
}
