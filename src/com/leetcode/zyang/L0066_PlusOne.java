package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * 
 */
public class L0066_PlusOne {

	public L0066_PlusOne() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0066_PlusOne plusOne = new L0066_PlusOne();

		int[] x = {9};

		System.out.println(Util.printArray(x));
		
		int[] result = plusOne.plusOne(x);

		System.out.println(Util.printArray(result));
	}

	public int[] plusOne(int[] digits) {
		if (digits.length == 0) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
			return digits;    		 
		}

		int carryOver = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + carryOver;
			digits[i] = sum % 10;
			carryOver = sum / 10;  
			
			if (carryOver == 0)
				break;
		}

		if (carryOver == 1) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}

		return digits;        
	}
}
