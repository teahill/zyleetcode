package com.leetcode.zyang;

import java.util.Arrays;

/**
 * 
 * @author zyang
 * 
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class L0135_Candy {

	public L0135_Candy() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Here I provide my solution for your refering. Same as you, time complexity is exactly O(N) not only the 
	 * average time cost, and O(N) space needed.

		I also go thru the ratings array two times, from left to right and from right to left.

		Here are several steps of my algorithm:

		Assume candies[i] means count of candies give to child i.

		From left to right, to make all candies satisfy the condition if ratings[i] > ratings[i - 1] 
		then candies[i] > candies[i - 1], just ignore the right neighbor as this moment. 
		We can assume leftCandies[i] is a solution which is satisfied.

		From right to left, almost like step 1, get a solution rightCandies[i] which just satisfy the condition 
		if ratings[i] > ratings[i + 1] then candies[i] > candies[i + 1]

		For now, we have leftCandies[i] and rightCandies[i], so how can we satisfy the real condition in the problem? 
		Just make candies[i] equals the maximum between leftCanides[i] and rightCandies[i]

		Here are something to notice:

		Set all leftCandies[i] rightCandies[i] to 1 at the beginning of going thru, 
		since each child need at least one candy.
		When you implement the algorithm, you do not need the real array leftCandies rightCandies, 
		it just help to explain my thought. So there are only a candies[i] needed. However, it is O(N) space complexity.
		Here is a sample:

		ratings: [1,5,3,1]
		in step 1, go from left to right, you can get leftCandies [1,2,1,1]
		in step 2, go from right to left, you can get rightCandies [1,3,2,1]
		in step 3, you can get the real candies [1,3,2,1], just sum it then get the answer. 
	 */
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
        	return 0;
        
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        
        for (int i = 1; i < n; i++) {
        	if (ratings[i - 1] < ratings[i])
        		candy[i] = candy[i - 1] + 1;
        }
        
        for (int i = n - 2; i >= 0; i--) {
        	if (ratings[i] > ratings[i + 1])
        		candy[i] = Math.max(candy[i], candy[i + 1] + 1);
        }
        
        int count = 0;
        for (int i = n - 1; i >= 0; i--) 
        	count += candy[i];
        
        return count;
    }
}
