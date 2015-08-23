package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zyang
 * 
 *         Given a binary tree, return all root-to-leaf paths.
 * 
 *         For example, given the following binary tree:
 * 
 *         1 / \ 2 3 \ 5 All root-to-leaf paths are:
 * 
 *         ["1->2->5", "1->3"]
 */
public class L0257_BinaryTreePath {

	public L0257_BinaryTreePath() {
		// TODO Auto-generated constructor stub
	}

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        
        if (root == null)
        	return list;
        
        if (root.left == null && root.right == null) {
        	list.add(String.valueOf(root.val));
        	return list;        	
        }
        
        if (root.left != null) {
        	List<String> left = binaryTreePaths(root.left);
        	for (String s : left) 
        		list.add(root.val + "->" + s);
        }
        
        if (root.right != null) {
        	List<String> right = binaryTreePaths(root.right);
        	for (String s : right) 
        		list.add(root.val + "->" + s);
        }
        
        return list;
    }
}
