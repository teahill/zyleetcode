package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         Given an array of numbers nums, in which exactly two elements appear
 *         only once and all the other elements appear exactly twice. Find the
 *         two elements that appear only once.
 * 
 *         For example:
 * 
 *         Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 *         Note: The order of the result is not important. So in the above
 *         example, [5, 3] is also correct. Your algorithm should run in linear
 *         runtime complexity. Could you implement it using only constant space
 *         complexity?
 */
public class L0260_SingleNumberIII {

	public L0260_SingleNumberIII() {
		// TODO Auto-generated constructor stub
	}

	
	/*
	 * 
	 * From leetcode: https://leetcode.com/discuss/52351/accepted-java-space-easy-solution-with-detail-explanations
	 * 
	 * Once again, we need to use XOR to solve this problem. But this time, we
	 * need to do it in two passes:
	 * 
	 * In the first pass, we XOR all elements in the array, and get the XOR of
	 * the two numbers we need to find. Note that since the two numbers are
	 * distinct, so there must be a set bit (that is, the bit with value '1') in
	 * the XOR result. Find out an arbitrary set bit (for example, the rightmost
	 * set bit).
	 * 
	 * In the second pass, we divide all numbers into two groups, one with the
	 * aforementioned bit set, another with the aforementinoed bit unset. Two
	 * different numbers we need to find must fall into thte two distrinct
	 * groups. XOR numbers in each group, we can find a number in either group.
	 * 
	 * A Corner Case:
	 * 
	 * When diff == numeric_limits<int>::min(), -diff is also
	 * numeric_limits<int>::min(). Therefore, the value of diff after executing
	 * diff &= -diff is still numeric_limits<int>::min(). The answer is still
	 * correct.
	 */
    public int[] singleNumber(int[] nums) {
      int[] single = {0, 0};
            
      // Get the xor of the two single numbers
      int xor = 0;
      for (int num : nums) 
    	  xor ^= num;
      
      // Find the last set bit
      xor &= -xor;
      
      // divide the group into two using the set bit. THe duplicate numbers will be in the same group
      // The two singles will be separated into different group because the bit in the position are opposite
      // Like single number problem, xor each group will yield the single number
      for (int num : nums) {
    	  if ((xor & num) == 0)
    		  single[0] ^= num;
    	  else
    		  single[1] ^= num;
      }
      
      return single;
    }
}
