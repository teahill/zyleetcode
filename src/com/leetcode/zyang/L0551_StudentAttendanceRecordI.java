package com.leetcode.zyang;

/**
 * 
 * @author zyang
 * 
 *         You are given a string representing an attendance record for a
 *         student. The record only contains the following three characters: 'A'
 *         : Absent. 'L' : Late. 'P' : Present. A student could be rewarded if
 *         his attendance record doesn't contain more than one 'A' (absent) or
 *         more than two continuous 'L' (late).
 * 
 *         You need to return whether the student could be rewarded according to
 *         his attendance record.
 * 
 *         Example 1: Input: "PPALLP" Output: True 
 *         Example 2: Input: "PPALLL" Output: False
 * 
 */
public class L0551_StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if (s == null || s.length() < 1)
        	return false;
        
        int numA = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) - 'A' == 0) 
        		numA++;
        		
        	if (numA > 1)
        		return false;
        	
        	if (s.charAt(i) - 'L' == 0 && i > 1 
        			&& s.charAt(i-1) - 'L' == 0
        			&& s.charAt(i-2) - 'L' == 0) 
        		return false;
        }
        		
        return true;    
    }
}
