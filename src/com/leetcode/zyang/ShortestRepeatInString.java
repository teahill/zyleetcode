package com.leetcode.zyang;

public class ShortestRepeatInString {

	public ShortestRepeatInString() {
		// TODO Auto-generated constructor stub
	}

	
	public String getShortestRepeat(String str) {
		if (str == null || str.length() <= 1)
			return str;
		
		int len = str.length();
		
		// Optimize
		int delta = 1;
		if (len % 2 != 0)
			delta = 2;
		
		// Start with shortest of length 1
		int n = 1;
		while (n <= len / 2) { // stop at half length
			if (len % n != 0) { // optimize
				n += delta;
				continue;
			}
			
			String token = str.substring(0, n);
			boolean found = isRepeat(str, token);
			if (found)
				return token;
			
			n += delta;
		}
		
		return str;
	}
	
	// Check if the string is the repeat of token
	private boolean isRepeat(String s, String token) {
		int len = token.length();
		for (int i = 0; i < s.length() ; i = i + len) {
			String sub = s.substring(i, i + len);
			if (!sub.equals(token))
				return false;
		}
		
		return true;
	}
}
