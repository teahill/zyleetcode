package com.leetcode.zyang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author zyang
 * 
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 *	
 *	For example:
 *	Given binary tree {3,9,20,#,#,15,7},
 *	    3
 *	   / \
 *	  9  20
 *	    /  \
 *	   15   7
 *	return its bottom-up level order traversal as:
 *	[
 *	  [15,7],
 *	  [9,20],
 *	  [3]
 *	]
 *	confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 * Tree Breadth-first Search
 * 
 */

public class L0107_BinaryTreeLevelOrderTraversalII {

	public L0107_BinaryTreeLevelOrderTraversalII() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		L0107_BinaryTreeLevelOrderTraversalII bTreeLevelTraversal = new L0107_BinaryTreeLevelOrderTraversalII();
		
		List<String> strs = new ArrayList<String>();		
		/*
		strs.add("3");
		strs.add("9");
		strs.add("#");
		strs.add("#");
		strs.add("20");
		strs.add("15");
		strs.add("#");
		strs.add("#");
		strs.add("7");
		strs.add("#");
		strs.add("#");*/
		
		System.out.println("Input = " + strs);
		
		TreeNode root = BinaryTreeSerializer.deserialize(strs);
		
		System.out.println("result = " + BinaryTreeSerializer.serialize(root));
		
		List<List<Integer>> result = bTreeLevelTraversal.levelOrderBottomDFS(root);
		
		System.out.println("result = " + result);
	}

	// BFS, performance about the same as DFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listAll = new LinkedList<List<Integer>>();

        Queue<TreeNode> curLevelQ = new LinkedList<TreeNode>();   
        curLevelQ.offer(root);
        
        while(curLevelQ.peek() != null) {
        	int numNodes = curLevelQ.size();
            List<Integer> list = new ArrayList<Integer>();
            
        	for (int i = 0; i < numNodes; i++) {
	        	TreeNode node = curLevelQ.poll();
	        	list.add(Integer.valueOf(node.val));
	        	
	        	if (node.left != null)
	        		curLevelQ.offer(node.left);
	        	
	        	if (node.right != null)
	        		curLevelQ.offer(node.right);  
        	}	
     		
        	listAll.add(0, list);       		    	
        } 
        
        return listAll;
    }
    
    //DFS
    public List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
    	List<List<Integer>> list = new LinkedList<List<Integer>>();
    	
    	if (root == null)
    		return list;
 
        levelOrderBottomDFSRecursive(root, list, 0);
        
        return list;
    }
    
    public void levelOrderBottomDFSRecursive(TreeNode root, List<List<Integer>> list, int level) {
    	if (root == null)
    		return;
    	
    	if (list.size() -1 < level) {
            List<Integer> subList = new ArrayList<Integer>();
            list.add(0, subList);
    	}
    	
    	list.get(list.size() - 1 - level).add(root.val);
    	levelOrderBottomDFSRecursive(root.left, list, level + 1);
    	levelOrderBottomDFSRecursive(root.right, list, level + 1);
        
        return;
    }
}
