package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zyang
 *
 * Given a feature phone with only number pad, find all possible letter combinations when a series of numbers are pressed
 * 
 * 1: abc, 2: def, 3: ghi, 4: jkl, 5: mno, 6: pqr, 7: stu, 8: vwx, 9: yz
 * 
 * When 1 consecutive "3" is pressed, it means "g"
 * When 2 consecutive "3" is pressed, it could be "gg" or "h"
 * When 3 consecutive "3" is pressed, it could be "ggg", "gh", "hg", "i"
 * 
 */
public class FeaturePhoneMap {
	Map<Integer, String> map = new HashMap<Integer, String>();
	
	public List<String> combo(int[] nums) {
		List<String> list = new ArrayList<String>();
		list.add("");
		
		if (nums == null || nums.length < 1)
			return list;
		
		int prev = nums[0];
		int count = 1;
		List<String> segments;
		for (int i= 1; i < nums.length; i++) {
			if (nums[i] != prev) {
				segments = getSegments(prev, count);
				list = merge(list, segments);
				
				prev = nums[i];
				count = 1;
			}
			else 
				count++;				
		}	
		
		segments = getSegments(prev, count);
		list = merge(list, segments);
		
		return list;
	}
	
	private List<String> getSegments(int prev, int count) {
		List<String> segments = new ArrayList<String>();
		
		String single = map.get(prev);		
		if (count == 1) 
			segments.add(single);
		else if (count == 2) {
			segments.add(single + single);
			int two = prev * 10 + prev;
			segments.add(map.get(two));
		}
		else if (count == 3) {
			segments.add(single + single + single);
			int two = prev * 10 + prev;
			segments.add(map.get(two) + single);
			segments.add(single + map.get(two));
			int three = prev * 100 + prev * 10 + prev;
			segments.add(map.get(three));
		}
			
		return segments;
	}
	
	private List<String> merge(List<String> list, List<String> segments) {
		List<String> newList = new ArrayList<String>();
		
		for (String s : list) 
			for (String seg : segments)
				newList.add(s + seg);
		
		return newList;
	}

	FeaturePhoneMap() {
		map.put(1, "a");
		map.put(11, "b");
		map.put(111, "c");
		map.put(2, "d");
		map.put(22, "e");
		map.put(222, "f");
		map.put(3, "g");
		map.put(33, "h");
		map.put(333, "i");
		map.put(4, "j");
		map.put(44, "k");
		map.put(444, "l");
		map.put(5, "m");
		map.put(55, "n");
		map.put(555, "o");
		map.put(6, "p");
		map.put(66, "q");
		map.put(666, "r");
		map.put(7, "s");
		map.put(77, "t");
		map.put(777, "u");
		map.put(8, "v");
		map.put(88, "w");
		map.put(888, "x");
		map.put(9, "y");
		map.put(99, "z");		
	}
}
