package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *    1
 *   / \
 *  2   2
 *   \   \
 *   3    3
 *   
 *   Note:
 *   
 *   Bonus points if you could solve it both recursively and iteratively.
 *   confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 *  Tree Depth-first Search
 */

public class L0101_SymmetricTree {

	public L0101_SymmetricTree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L0101_SymmetricTree symmetricBTree = new L0101_SymmetricTree();
		
		List<String> strs = new ArrayList<String>();		
		strs.add("1");
		strs.add("2");
		strs.add("3");
		strs.add("#");
		strs.add("#");
		strs.add("4");
		strs.add("#");
		strs.add("#");
		strs.add("2");
		strs.add("4");
		strs.add("#");
		strs.add("#");
		strs.add("3");
		strs.add("#");
		strs.add("#");
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
		
		boolean result = symmetricBTree.isSymmetric(root);
		
		System.out.println("result = " + result);
	}

    public boolean isSymmetric(TreeNode root) {
    	if (root == null)
    		return true;
    	
    	return isSymmetricRecursive(root.left, root.right);
        
    }	
    
    public boolean isSymmetricRecursive(TreeNode left, TreeNode right) {
    	if (left == null && right == null)
    		return true;
    	else if (left != null && right != null && left.val == right.val) 
    	   	return isSymmetricRecursive(left.left, right.right) && isSymmetricRecursive(left.right, right.left);
    	else
    		return false;       
    }	
}
