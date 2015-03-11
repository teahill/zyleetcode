package com.leetcode.zyang;

/**
 * 
 * @author zyang
 *
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Update (2014-11-02): The signature of the function had been updated to return the index instead of the pointer. 
 * If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
 * Hide Tags Two Pointers String
 *
 */
public class L0028_ImplementStrStr {

	public L0028_ImplementStrStr() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		L0028_ImplementStrStr impStrStr = new L0028_ImplementStrStr();
		
		//String hay = "abcdefg";
		//String needle = "cdefgh";
		
		String hay = "mississippi";
		String needle = "issip";
		
		System.out.println("input: hay= " + hay + "; needle = " + needle);
	
		int result = impStrStr.strStr(hay, needle);		
		
		System.out.println("output: " + result );
	}

    public int strStr(String haystack, String needle) {
        int result = -1;
        int lHay = haystack.length();
        int lNeedle = needle.length();
        	
        if (haystack == null || needle == null) 
        	return result;
        
        if (needle == "") 
        	return 0;
        
        if (lHay < lNeedle)
        	return result;
        	
        int p1 = 0, p2 = 0;
        for (; p1 < lHay; p1++) {
        	if (p1 + lNeedle > lHay)
        		break;
        		
        	for(; p2 < lNeedle; p2++) {
        		if ( p1 + p2 < lHay && haystack.charAt(p1 + p2) != needle.charAt(p2)) {
    	     		break;
        		}
        	}
        	
        	if (p2 == lNeedle) {
        		result = p1;
        		break;
        	}
        	else
        		p2 = 0;
        }    
        return result;      
    }
}

