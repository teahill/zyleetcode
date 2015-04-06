package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Longest Palindromic Substring
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 * 
 */
public class L0005_LongestPalindromeSubstring {

	public L0005_LongestPalindromeSubstring() {
		// TODO Auto-generated constructor stub
	}

	// time saving
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;

		String result = null;
		int len = 0, maxLen = 0;
		int leftPos = 0, rightPos = 0;
		for (int i = 0; i < s.length(); i++) {
			//odd case
			len = expand(s, i, i);			
			if (len > maxLen) {
				maxLen = len;
				leftPos = i - maxLen / 2;
				rightPos = i + maxLen / 2;
			}
			
			//even case
			len = expand(s, i, i + 1);
			if (len > maxLen) {
				maxLen = len;
				leftPos = i - maxLen / 2 + 1;
				rightPos = i + maxLen / 2;
			}
		}

		result = s.substring(leftPos, rightPos + 1);
		
		return result;
	}
	
	public int expand(String s, int left, int right) {
		int len = 0;
		while (left >= 0 && right <= s.length() -1) {
			if (s.charAt(left) == s.charAt(right)) {
				len = right - left + 1;
				left--;
				right++;
			}
			else
				break;
		}
		
		return len;		
	}
	
	// Time limit exceeded
	public String longestPalindrome1(String s) {
		if (s == null || s.length() == 0)
			return s;

		String result = null;
		boolean found = true;
		for (int len = s.length(); len > 0; len--) {
			for (int i = 0; i < s.length() - len + 1; i++) {
				for (int j = 0; j < len/2; j++) {
					if (s.charAt(i + j) != s.charAt(len + i -1 -j)) {
						found = false;
						break;
					}
					else
						found = true;
				}

				if (found) {
					result = s.substring(i, i + len);
					return result;
				}    		 
			}
		}

		return result;
	}
}
