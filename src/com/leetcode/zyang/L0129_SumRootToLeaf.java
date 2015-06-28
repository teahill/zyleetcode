package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 */
public class L0129_SumRootToLeaf {

	public L0129_SumRootToLeaf() {
		// TODO Auto-generated constructor stub
	}

    public int sumNumbers(TreeNode root) {
    	if (root == null)
    		return 0;
    	
    	int sum = sumNumbersInternal(root, 0);
    	
    	return sum;
    }
    
    public int sumNumbersInternal(TreeNode root, int sum) {     	
    	int num = sum * 10 + root.val;
    	if (root.left == null && root.right == null) 
    		return num;
    	
    	int result = 0;
    	if (root.left != null)
    		result += sumNumbersInternal(root.left, num);
    	
    	if (root.right != null)
    		result += sumNumbersInternal(root.right, num);
    		   	    
    	return result;
    }
    
	// recursive
    public int sumNumbers1(TreeNode root) {
    	if (root == null)
    		return 0;
    	
    	List<Integer> list = sumNumbersInternal1(root, 0);
    	
    	int sum = 0;
    	for (Integer elem : list) 
    		sum += elem.intValue();
    	
    	return sum;
    }
    
    public List<Integer> sumNumbersInternal1(TreeNode root, int num) {  
    	List<Integer> newList = new ArrayList<Integer>();
        if (root.left == null && root.right == null) {
        	newList.add(num * 10 + root.val);
        	return newList;
         }
        
        List<Integer> list;
        if (root.left != null) {
	        list = sumNumbersInternal1(root.left, num * 10 + root.val);
	        for (Integer elem : list) 
	        	newList.add(elem);
        }
        
        if (root.right != null) {
	        list = sumNumbersInternal1(root.right, num * 10 + root.val);
	        for (Integer elem : list) 
	        	newList.add(elem);
        }

        return newList;        
    }
}
