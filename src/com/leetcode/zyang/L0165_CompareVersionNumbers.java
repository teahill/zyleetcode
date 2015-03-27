package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 */
public class L0165_CompareVersionNumbers {

	public L0165_CompareVersionNumbers() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0165_CompareVersionNumbers versionNumber = new L0165_CompareVersionNumbers();
		
		/*
		String v1 = "0.1";
		String v2 = "0.0.1";
		*/
		
		String v1 = "2";
		String v2 = "1.1";
		
		/*
		 String v1 = "0.1";
		 String v2 = "1.2";
		 */
		int result = versionNumber.compareVersion(v1, v2);
		
		System.out.println(v1 + " , " + v2 + " ->  " + result);
	}
	
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null || version1 == "" || version2 == "")
        	return 0;
        
        String[] vSplit1 = version1.split("\\.");;
        String[] vSplit2 = version2.split("\\.");;     
        
        int vLen1 = vSplit1.length;
        int vLen2 = vSplit2.length;
        int len = (vLen1 >= vLen2) ? vLen1 : vLen2;
        
        for (int i = 0; i < len; i++) {
        	int v1 = 0;
        	int v2 = 0;
        	
        	if (i < vLen1)
	        	v1 = Integer.valueOf(vSplit1[i]);
        	
        	if (i < vLen2)
        		v2 = Integer.valueOf(vSplit2[i]);
        	
        	if (v1 > v2)
        		return 1;
        	else if (v1 < v2)
        		return -1;
        	else
        		continue;
        }
        return 0;
     }
}
